package com.macro.mall.service;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.constant.OrderType;
import com.macro.mall.common.service.impl.DistributorService;
import com.macro.mall.dao.YxxOrderCommonDao;
import com.macro.mall.domain.OrderQuery;
import com.macro.mall.domain.YxxOrderDetail;
import com.macro.mall.domain.YxxOrderInfo;
import com.macro.mall.domain.YxxOrderStatusRecordInfo;
import com.macro.mall.enums.OrderStatusUtil;
import com.macro.mall.example.YxxOrderStatusRecordExample;
import com.macro.mall.example.YxxRepairRecordExample;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.macro.mall.enums.OrderStatus.*;

/**
 * @author Paradise
 */
@Service
@AllArgsConstructor
public class YxxOrderCommonService {

    private final YxxMemberMapper memberMapper;
    private final YxxRepairRecordMapper repairRecordMapper;
    private final YxxOrderStatusRecordMapper orderStatusRecordMapper;
    private final DistributorService distributorService;
    private final YxxOrderCommonDao orderCommonDao;
    private final YxxWorkerMapper workerMapper;
    private final YxxOrderMapper orderMapper;
    private final YxxWorkerLevelMapper workerLevelMapper;
    private final YxxWorkerOrderCountMapper workerOrderCountMapper;
    private final PmsProductMapper productMapper;

    private YxxWorkerOrderCount countByWorkerId(Long workerId) {
        return workerOrderCountMapper.selectByPrimaryKey(workerId);
    }

    private YxxWorkerLevel getLevel(Integer levelId) {
        return workerLevelMapper.selectByPrimaryKey(levelId);
    }

    public boolean check(YxxOrder order, Long workerId) {
        return this.check(order, workerMapper.selectByPrimaryKey(workerId));
    }

    public boolean check(YxxOrder order, YxxWorker worker) {
        YxxWorkerLevel workerLevel = this.getLevel(worker.getLevelId());
        YxxWorkerOrderCount count = this.countByWorkerId(worker.getId());
        // 判断订单类型
        if (order.getOrderType() == OrderType.SYSTEM_DISTRIBUTE.val()) {
            // 系统分配订单
            return workerLevel.getOrderDistributeAmount() >= count.getDistributeAmount() + 1;
        }
        if (order.getOrderType() == OrderType.SYSTEM_RUSH.val()) {
            return workerLevel.getOrderRushAmount() >= count.getRushAmount() + 1;
        }
        if (order.getOrderType() == OrderType.MANUAL_DISTRIBUTE.val()) {
            return workerLevel.getOrderAssignAmount() >= count.getAssignAmount() + 1;
        }
        return true;
    }

    public YxxOrderDetail detail(Long orderId) {
        YxxOrderDetail detail = new YxxOrderDetail();
        // 订单信息
        YxxOrderInfo orderInfo = orderCommonDao.queryInfoById(orderId);
        orderInfo.setOrderStatusName(OrderStatusUtil.getStatusName(orderInfo.getOrderStatus()));
        detail.setYxxOrder(orderInfo);
        // 子订单信息
        detail.setItemList(orderCommonDao.queryOrderItemList(orderId));
        // 维修工单信息
        detail.setRepairRecord(repairRecordMapper.selectOneByExample(new YxxRepairRecordExample().createCriteria()
                .andOrderIdEqualTo(orderId).example()));
        // 订单状态变更记录
        List<YxxOrderStatusRecord> recordList = orderStatusRecordMapper.selectByExample(new YxxOrderStatusRecordExample()
                .createCriteria().andOrderIdEqualTo(orderId).example().orderBy(YxxOrderStatusRecord.Column.createTime.desc()));
        List<YxxOrderStatusRecordInfo> recordInfoList = new ArrayList<>();
        for (YxxOrderStatusRecord record : recordList) {
            recordInfoList.add(new YxxOrderStatusRecordInfo(record));
        }
        detail.setOrderStatusRecordList(recordInfoList);
        detail.setMember(memberMapper.selectByPrimaryKey(orderInfo.getMemberId()));
        detail.setWorker(workerMapper.selectByPrimaryKey(orderInfo.getWorkerId()));
        PmsProduct product = productMapper.selectByPrimaryKeySelective(orderInfo.getProductId(),
                PmsProduct.Column.excludes(PmsProduct.Column.detailHtml));
        detail.setProduct(product);
        return detail;
    }

    public CommonPage<YxxOrderInfo> pageQueryInfo(Integer status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<YxxOrderInfo> orderInfoList = orderCommonDao.queryList(null, getOrderStatusArray(status));
        return CommonPage.restPage(orderInfoList);
    }

    /**
     * 后台管理分页查询
     *
     * @param query    查询参数 {@link OrderQuery}
     * @param pageNum  分页参数
     * @param pageSize 分页参数
     * @return {@link YxxOrderInfo}
     */
    public CommonPage<YxxOrderInfo> pageQueryInfo(OrderQuery query, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<YxxOrderInfo> orderInfoList = orderCommonDao.queryListByOrderQuery(query);
        this.dealStatusDesc(orderInfoList);
        return CommonPage.restPage(orderInfoList);
    }

    /**
     * // 处理状态名称
     *
     * @param orderInfoList 订单列表
     */
    private void dealStatusDesc(List<YxxOrderInfo> orderInfoList) {
        if (!orderInfoList.isEmpty()) {
            orderInfoList.forEach(yxxOrderInfo -> yxxOrderInfo.setOrderStatusName(
                    OrderStatusUtil.getStatusName(yxxOrderInfo.getOrderStatus())));
        }
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

    /**
     * 维修工查询指派订单列表
     *
     * @param worker 维修工
     * @return 订单列表
     */
    public List<YxxOrderInfo> queryDistributeOrder(YxxWorker worker) {
        List<YxxOrderInfo> orderInfoList = orderCommonDao.queryInfoByWorkerId(worker.getId(), DISTRIBUTED.val());
        this.dealStatusDesc(orderInfoList);
        return orderInfoList;
    }

    public List<YxxOrderInfo> queryRushOrders(Integer pageNum, Integer pageSize) {
        List<Long> ids = distributorService.getRushOrderIds();
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        PageHelper.startPage(pageNum, pageSize);
        List<YxxOrderInfo> orderInfoList = orderCommonDao.queryRushOrders(ids, DISTRIBUTED.val());
        this.dealStatusDesc(orderInfoList);
        return orderInfoList;
    }

    /**
     * 手动指派订单
     *
     * @param orderId  订单ID
     * @param workerId 维修工ID
     */
    public int distribute(Long orderId, Long workerId) {
        YxxOrder order = orderMapper.selectByPrimaryKey(orderId);
        // 判断订单类型
        if (order.getOrderType() != OrderType.MANUAL_DISTRIBUTE.val()) {
            return 0;
        }
        // 判断订单状态
        if (DISTRIBUTING.val() != order.getOrderStatus()) {
            return 0;
        }
        // 判断维修工每日抢单数量是否超限
        boolean result = check(order, workerId);
        if (!result) {
            return 0;
        }
        // 判断数量
        orderStatusRecordMapper.insert(YxxOrderStatusRecord.builder()
                .createTime(new Date()).remark("管理员手动指派订单").orderId(orderId)
                .originStatus(DISTRIBUTING.val()).currentStatus(RECEIVED.val())
                .build());
        // 更新订单状态
        return orderMapper.updateByPrimaryKeySelective(YxxOrder.builder()
                .id(orderId).updateTime(new Date()).orderStatus(RECEIVED.val()).workerId(workerId)
                .build());

    }
}
