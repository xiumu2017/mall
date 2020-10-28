package com.macro.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.service.RedisService;
import com.macro.mall.common.service.impl.DistributorService;
import com.macro.mall.dao.YxxOrderCommonDao;
import com.macro.mall.domain.YxxOrderInfo;
import com.macro.mall.enums.OrderStatus;
import com.macro.mall.enums.OrderStatusUtil;
import com.macro.mall.example.YxxOrderExample;
import com.macro.mall.example.YxxProductCommentLabelExample;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.portal.domain.YxxOrderComment;
import com.macro.mall.portal.domain.YxxOrderParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.macro.mall.enums.OrderStatus.*;

/**
 * @author Paradise
 */
@Service
public class YxxMpOrderService {

    private final RedisService redisService;
    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;
    @Value("${redis.database}")
    private String REDIS_DATABASE;

    private final YxxOrderMapper yxxOrderMapper;
    private final YxxMemberService memberService;
    private final YxxOrderStatusRecordMapper orderStatusRecordMapper;
    private final DistributorService distributorService;
    private final YxxOrderItemMapper orderItemMapper;
    private final PmsProductMapper productMapper;
    private final PmsProductSkuMapper productSkuMapper;
    private final YxxMemberAddressMapper memberAddressMapper;
    private final YxxOrderCommonDao orderCommonDao;
    private final YxxProductCommentMapper commentMapper;
    private final YxxProductCommentLabelMapper commentLabelMapper;

    public YxxMpOrderService(RedisService redisService, YxxOrderMapper yxxOrderMapper,
                             YxxMemberService memberService, YxxOrderItemMapper orderItemMapper,
                             YxxOrderStatusRecordMapper orderStatusRecordMapper, DistributorService distributorService,
                             PmsProductMapper productMapper, PmsProductSkuMapper productSkuMapper,
                             YxxMemberAddressMapper memberAddressMapper, YxxOrderCommonDao orderCommonDao, YxxProductCommentMapper commentMapper, YxxProductCommentLabelMapper commentLabelMapper) {
        this.redisService = redisService;
        this.yxxOrderMapper = yxxOrderMapper;
        this.memberService = memberService;
        this.orderStatusRecordMapper = orderStatusRecordMapper;
        this.distributorService = distributorService;
        this.orderItemMapper = orderItemMapper;
        this.productMapper = productMapper;
        this.productSkuMapper = productSkuMapper;
        this.memberAddressMapper = memberAddressMapper;
        this.orderCommonDao = orderCommonDao;
        this.commentMapper = commentMapper;
        this.commentLabelMapper = commentLabelMapper;
    }

    /**
     * 小程序下单
     *
     * @param orderParam 参数
     * @return 返回结果
     */
    public YxxOrder generateOrder(YxxOrderParam orderParam) {
        boolean hasItem = orderParam.getItemList() != null && !orderParam.getItemList().isEmpty();
        if (!hasItem) {
            YxxOrderItem item = YxxOrderItem.builder().amount(1).productId(orderParam.getProductId())
                    .skuId(orderParam.getSkuId()).build();
            orderParam.setItemList(Collections.singletonList(item));
        }
        YxxMember member = memberService.getCurrentMember();
        YxxMemberAddress address = memberAddressMapper.selectByPrimaryKey(orderParam.getAddressId());
        PmsProduct product = productMapper.selectByPrimaryKey(orderParam.getProductId());
        // 保存订单信息
        YxxOrder order = orderParam.toOrder();
        order.setAddress(address.getRepairAddress());
        order.setDetailAddress(address.getDetailAddress());
        order.setMemberName(address.getName());
        order.setTelNo(address.getPhoneNumber());
        order.setLocation(address.getLocation());
        order.setMemberSex(address.getSex());
        order.setIsBargain(product.getIsBargain());
        order.setOrderSn(generateOrderSn(order));
        order.setMemberId(member.getId());
        order.setOrderStatus(CREATED.val());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setRegionId(member.getRegionId());
        // 一口价订单价格计算
        this.dealBargainOrderPrice(order, orderParam);
        yxxOrderMapper.insertSelective(order);
        if (order.getId() != null) {
            // 保存子订单信息
            orderParam.getItemList().forEach(yxxOrderItem -> yxxOrderItem.setOrderId(order.getId()));
            orderItemMapper.batchInsert(orderParam.getItemList());
        }
        return order;
    }

    private void dealBargainOrderPrice(YxxOrder order, YxxOrderParam orderParam) {
        // 非询价单，计算价格
        if (order.getIsBargain() == 0) {
            BigDecimal price = BigDecimal.ZERO;
            for (YxxOrderItem yxxOrderItem : orderParam.getItemList()) {
                PmsProductSku sku = productSkuMapper.selectByPrimaryKey(yxxOrderItem.getSkuId());
                yxxOrderItem.setPrice(sku.getPrice());
                price = price.add(sku.getPrice().multiply(new BigDecimal(yxxOrderItem.getAmount())));
            }
            order.setOfferPrice(price);
        }
    }

    /**
     * 生成18位订单编号:8位日期 + 2位平台号码 + 2位支付方式 + 6位以上自增id
     */
    private String generateOrderSn(YxxOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ORDER_ID + date;
        Long increment = redisService.incr(key, 1);
        sb.append(date);
        if (order.getIsBargain() == null) {
            order.setIsBargain(1);
        }
        if (order.getIsTransfer() == null) {
            order.setIsTransfer(0);
        }
        sb.append(String.format("%02d", order.getIsBargain()));
        sb.append(String.format("%02d", order.getIsTransfer()));
        String incrementStr = increment.toString();
        int length = 6;
        if (incrementStr.length() <= length) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    public Integer paySuccess(Long orderId) {
        // 支付成功 - 更改状态
        // 更新维修工的余额
        YxxOrder order = YxxOrder.builder().id(orderId).orderStatus(PAYED.val()).build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus);
    }

    public int cancelOrder(Long orderId) {
        distributorService.removeFromQueue(orderId);
        return updateOrderStatus(orderId, FREE_CANCEL);
    }

    public YxxOrder yxxOrder(Long orderId) {
        return yxxOrderMapper.selectByPrimaryKey(orderId);
    }

    public int deleteOrder(Long orderId) {
        // 删除已取消的订单 或者已完成的订单
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        int status = order.getOrderStatus();
        if (status == FREE_CANCEL.val() || status == ARRIVED_CANCEL.val()) {
            return yxxOrderMapper.deleteByPrimaryKey(orderId);
        }
        return 0;
    }

    public int confirmToVisit(Long orderId) {
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        // 判断订单状态
        if (order.getOrderStatus() == RECEIVED.val()) {
            return updateOrderStatus(orderId, WAITED_GET, "用户确认同意上门");
        }
        return 0;
    }

    private int updateOrderStatus(Long orderId, OrderStatus status) {
        return this.updateOrderStatus(orderId, status, "");
    }

    private int updateOrderStatus(Long orderId, OrderStatus status, String remark) {
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new RuntimeException("OrderId not Exist");
        }
        // 保存状态变更记录
        orderStatusRecordMapper.insert(
                YxxOrderStatusRecord.builder()
                        .orderId(orderId).originStatus(order.getOrderStatus())
                        .currentStatus(status.val()).createTime(new Date())
                        .remark(remark).build()
        );

        order = YxxOrder.builder().id(orderId).orderStatus(status.val()).build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus);
    }

    public int confirmPrice(Long orderId) {
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order.getOrderStatus() == OFFERED.val()) {
            return updateOrderStatus(orderId, REPAIRING, "用户确认报价，开始维修");
        }
        return 0;
    }

    public int cancelOrderDisagree(Long orderId) {
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order.getOrderStatus() == OFFERED.val()) {
            return updateOrderStatus(orderId, ARRIVED_CANCEL);
        }
        return 0;
    }

    public CommonPage<YxxOrder> pageQuery(Integer status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        YxxMember currentMember = memberService.getCurrentMember();
        YxxOrderExample orderExample = new YxxOrderExample();
        YxxOrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andMemberIdEqualTo(currentMember.getId());
        if (status != null) {
            criteria.andOrderStatusIn(Arrays.asList(getOrderStatusArray(status)));
        }
        List<YxxOrder> orderList = yxxOrderMapper.selectByExample(orderExample.orderBy(YxxOrder.Column.createTime.desc()));
        return CommonPage.restPage(orderList);
    }

    public CommonPage<YxxOrderInfo> pageQueryInfo(Integer status, Integer pageNum, Integer pageSize) {
        YxxMember currentMember = memberService.getCurrentMember();
        PageHelper.startPage(pageNum, pageSize);
        List<YxxOrderInfo> orderInfoList = orderCommonDao.queryList(currentMember.getId(), getOrderStatusArray(status));
        orderInfoList.forEach(item -> {
            item.setOrderStatusName(OrderStatusUtil.getStatusName(item.getOrderStatus()));
        });
        return CommonPage.restPage(orderInfoList);
    }

    private Integer[] getOrderStatusArray(Integer status) {
        if (status == null) {
            return new Integer[0];
        }
        // 待确认
        if (status == 1) {
            return new Integer[]{CREATED.val(), DISTRIBUTING.val(), DISTRIBUTED.val(), RECEIVED.val()};
        }
        // 进行中
        if (status == 2) {
            return new Integer[]{WAITED_GET.val(), SET_OFF.val(), ARRIVED.val(), OFFERED.val(),
                    OFFER_CONFIRMED.val(), REPAIRED.val(), REPAIRING.val()};
        }
        // 待评价
        if (status == 3) {
            return new Integer[]{PAYED.val()};
        }
        if (status == 4) {
            return new Integer[]{FREE_CANCEL.val(), ARRIVED_CANCEL.val(), CS_CANCEL.val(), COMPLETED.val()};
        }
        return new Integer[0];
    }

    public int commentOrder(Long orderId, YxxOrderComment orderComment) {
        YxxOrderInfo yxxOrderInfo = orderCommonDao.queryInfoById(orderId);
        YxxMember member = memberService.getCurrentMember();
        // 评论信息
        YxxProductComment productComment = YxxProductComment.builder()
                .productId(yxxOrderInfo.getProductId())
                .memberId(yxxOrderInfo.getMemberId())
                .orderId(orderId)
                .skuId(yxxOrderInfo.getSkuId())
                .memberName(yxxOrderInfo.getMemberName())
                .memberIcon(member.getIcon())
                .content(orderComment.getContent())
                .productName(yxxOrderInfo.getProductName())
                .skuName(yxxOrderInfo.getSkuName())
                .createTime(new Date())
                .star(orderComment.getStar())
                .build();
        commentMapper.insert(productComment);
        // 评价标签
        if (!StringUtils.isEmpty(orderComment.getLabels())) {
            String[] labelArr = orderComment.getLabels().split(",");
            for (String label : labelArr) {
                YxxProductCommentLabel commentLabel = commentLabelMapper.selectOneByExample(new YxxProductCommentLabelExample()
                        .createCriteria().andProductIdEqualTo(yxxOrderInfo.getProductId()).andLabelEqualTo(label).example());
                if (commentLabel != null) {
                    orderCommonDao.updateProductCommentLabel(yxxOrderInfo.getProductId(), label);
                } else {
                    commentLabel = YxxProductCommentLabel.builder().label(label).count(1).enable(1).productId(yxxOrderInfo.getProductId()).build();
                    commentLabelMapper.insert(commentLabel);
                }
            }
        }
        return updateOrderStatus(orderId, COMPLETED, "用户已评价订单");
    }
}
