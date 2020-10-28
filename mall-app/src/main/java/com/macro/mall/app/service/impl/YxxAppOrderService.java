package com.macro.mall.app.service.impl;

import com.macro.mall.app.domain.OrderPrice;
import com.macro.mall.common.service.impl.DistributorService;
import com.macro.mall.enums.OrderStatus;
import com.macro.mall.example.YxxRepairRecordExample;
import com.macro.mall.mapper.YxxOrderMapper;
import com.macro.mall.mapper.YxxOrderStatusRecordMapper;
import com.macro.mall.mapper.YxxRepairRecordMapper;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxOrderStatusRecord;
import com.macro.mall.model.YxxRepairRecord;
import com.macro.mall.model.YxxWorker;
import com.macro.mall.service.YxxOrderCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Paradise
 */
@Slf4j
@Service
public class YxxAppOrderService {

    private final YxxOrderMapper yxxOrderMapper;
    private final YxxWorkerService workerService;
    private final YxxOrderStatusRecordMapper orderStatusRecordMapper;
    private final YxxRepairRecordMapper repairRecordMapper;
    private final DistributorService distributorService;
    private final YxxOrderCommonService orderCommonService;

    public YxxAppOrderService(YxxOrderMapper yxxOrderMapper,
                              YxxWorkerService workerService, YxxOrderStatusRecordMapper orderStatusRecordMapper,
                              YxxRepairRecordMapper repairRecordMapper, DistributorService distributorService,
                              YxxOrderCommonService orderCommonService) {
        this.yxxOrderMapper = yxxOrderMapper;
        this.workerService = workerService;
        this.orderStatusRecordMapper = orderStatusRecordMapper;
        this.repairRecordMapper = repairRecordMapper;
        this.distributorService = distributorService;
        this.orderCommonService = orderCommonService;
    }

    private int updateOrderStatus(Long orderId, OrderStatus status) {
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new RuntimeException("OrderId not Exist");
        }
        // 保存状态变更记录
        insertStatusRecord(orderId, order.getOrderStatus(), status);
        // 更新订单状态
        order = YxxOrder.builder().id(orderId).orderStatus(status.val()).build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus);
    }

    private void insertStatusRecord(Long orderId, Integer originStatus, OrderStatus status) {
        // 保存状态变更记录
        orderStatusRecordMapper.insert(
                YxxOrderStatusRecord.builder()
                        .orderId(orderId).originStatus(originStatus)
                        .currentStatus(status.val())
                        .createTime(new Date())
                        .build());
    }

    public int confirmPrice(OrderPrice orderPrice) {
        // 保存报价信息 - 更新订单offerPrice
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderPrice.getOrderId());
        if (order == null) {
            throw new RuntimeException("OrderId not Exist");
        }
        // 判断订单状态
        // 保存状态变更记录
        insertStatusRecord(orderPrice.getOrderId(), order.getOrderStatus(), OrderStatus.OFFERED);
        // 更新订单状态
        order = YxxOrder.builder().id(orderPrice.getOrderId()).orderStatus(OrderStatus.OFFERED.val())
                .offerPrice(orderPrice.getPrice()).priceJson(orderPrice.getPriceJson()).updateTime(new Date())
                .build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus,
                YxxOrder.Column.offerPrice, YxxOrder.Column.priceJson, YxxOrder.Column.updateTime);
    }

    /**
     * 确认接单
     *
     * @param orderId 订单ID
     * @return 状态更新结果
     */
    @Transactional(rollbackFor = Exception.class)
    public int accept(Long orderId) {
        YxxWorker worker = workerService.getCurrentWorker();
        // 抢单，首先判断订单状态 需要加锁
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order.getOrderStatus() != OrderStatus.DISTRIBUTED.val()) {
            return 0;
        }
        // 判断维修工每日抢单数量是否超限
        boolean result = orderCommonService.check(order, worker);
        if (!result) {
            return 0;
        }
        distributorService.removeFromWaitQueue(orderId);
        log.info("维修工{}接收订单：{}", worker.getId(), orderId);
        // 记录派单数量
        orderCommonService.updateWorkerOrderCount(worker.getId(), order);
        // 保存状态变更记录
        insertStatusRecord(orderId, order.getOrderStatus(), OrderStatus.RECEIVED);
        // 更新订单状态
        order = YxxOrder.builder().id(orderId).orderStatus(OrderStatus.RECEIVED.val()).workerId(worker.getId()).build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus, YxxOrder.Column.workerId);
    }

    /**
     * 抢单
     *
     * @param orderId 订单ID
     * @return 状态更新结果
     */
    @Transactional(rollbackFor = Exception.class)
    public int rush(Long orderId) {
        YxxWorker worker = workerService.getCurrentWorker();
        // 抢单，首先判断订单状态 需要加锁
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order.getOrderStatus() != OrderStatus.DISTRIBUTING.val()) {
            return 0;
        }
        // 判断维修工每日抢单数量是否超限
        boolean result = orderCommonService.check(order, worker);
        if (!result) {
            return 0;
        }
        log.info("维修工：{} 抢单成功：订单ID{}", worker.getId(), orderId);
        // 保存状态变更记录
        insertStatusRecord(orderId, order.getOrderStatus(), OrderStatus.RECEIVED);
        // 记录派单数量
        orderCommonService.updateWorkerOrderCount(worker.getId(), order);
        // 更新订单状态
        order = YxxOrder.builder().id(orderId).orderStatus(OrderStatus.RECEIVED.val()).workerId(worker.getId()).build();
        int x = yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus, YxxOrder.Column.workerId);
        if (x == 1) {
            distributorService.rushSuccess(orderId);
        }
        return x;
    }

    public int setOff(Long orderId) {
        // 判断订单状态
        return updateOrderStatus(orderId, OrderStatus.SET_OFF);
    }

    public int arrive(Long orderId) {
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order != null) {
            // 判断订单类型
            if (order.getIsBargain() != 1) {
                return updateOrderStatus(orderId, OrderStatus.OFFER_CONFIRMED);
            }
        }
        return updateOrderStatus(orderId, OrderStatus.ARRIVED);
    }

    public int repairFinish(Long orderId) {
        return updateOrderStatus(orderId, OrderStatus.REPAIRED);
    }

    public Integer pause(Long orderId) {
        // 判断订单状态 - 不能是已完成、已支付、维修结束的
        return updateOrderStatus(orderId, OrderStatus.PAUSED);
    }

    public int repairRecordCreate(YxxRepairRecord repairRecord) {
        // 删除原有工单
        repairRecordMapper.deleteByExample(new YxxRepairRecordExample().createCriteria()
                .andOrderIdEqualTo(repairRecord.getOrderId()).example());
        YxxWorker worker = workerService.getCurrentWorker();
        repairRecord.setWorkerId(worker.getId());
        return repairRecordMapper.insert(repairRecord);
    }

    public YxxRepairRecord repairRecordQuery(Long orderId) {
        return repairRecordMapper.selectOneByExample(new YxxRepairRecordExample().createCriteria()
                .andOrderIdEqualTo(orderId).example());
    }

    public int repairRecordUpdate(YxxRepairRecord repairRecord) {
        return repairRecordMapper.updateByPrimaryKeySelective(repairRecord);
    }

    public int repairRecordDelete(Long id) {
        return repairRecordMapper.deleteByPrimaryKey(id);
    }

    public int refuse(Long orderId) {
        distributorService.refuse(orderId);
        // workerId 置为空
        return yxxOrderMapper.updateByPrimaryKeySelective(
                YxxOrder.builder().id(orderId).workerId(null).orderStatus(OrderStatus.DISTRIBUTING.val()).updateTime(new Date()).build(),
                YxxOrder.Column.workerId, YxxOrder.Column.orderStatus, YxxOrder.Column.updateTime);
    }
}
