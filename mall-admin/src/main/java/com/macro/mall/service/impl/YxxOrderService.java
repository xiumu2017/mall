package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.constant.OrderType;
import com.macro.mall.common.service.impl.DistributorService;
import com.macro.mall.common.utils.DistanceUtil;
import com.macro.mall.dao.YxxOrderDao;
import com.macro.mall.domain.WorkerDistance;
import com.macro.mall.dto.YxxOrderQueryParam;
import com.macro.mall.enums.OrderStatus;
import com.macro.mall.example.YxxOrderExample;
import com.macro.mall.example.YxxWorkerExample;
import com.macro.mall.mapper.YxxOrderMapper;
import com.macro.mall.mapper.YxxOrderStatusRecordMapper;
import com.macro.mall.mapper.YxxWorkerMapper;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxOrderStatusRecord;
import com.macro.mall.model.YxxWorker;
import com.macro.mall.service.YxxOrderCommonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单管理Service实现类
 *
 * @author Paradise
 * @date 2020-10-10
 */
@Slf4j
@Service
@AllArgsConstructor
public class YxxOrderService {
    private final YxxOrderMapper orderMapper;
    private final YxxOrderStatusRecordMapper statusRecordMapper;
    private final YxxOrderDao yxxOrderDao;
    private final YxxWorkerMapper workerMapper;
    private final DistributorService distributorService;
    private final YxxOrderCommonService orderCommonService;

    public List<YxxOrder> list(YxxOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return yxxOrderDao.getList(queryParam);
    }

    public int delete(List<Long> ids) {
        YxxOrderExample example = new YxxOrderExample();
        example.createCriteria().andIdIn(ids);
        return orderMapper.deleteByExample(example);
    }


    /**
     * 查询维修工ID列表
     *
     * @param orderId 订单ID
     * @return 加权排序后的维修工列表
     */
    private List<Long> getSortedWorkerIds(Long orderId) {
        // TODO 根据订单品类 关联擅长 查询 符合条件的全部维修工 - 已排序
        YxxOrder order = orderMapper.selectByPrimaryKey(orderId);
        List<WorkerDistance> list = new ArrayList<>();
        // 查询核心会员
        List<YxxWorker> workers = workerMapper.selectByExample(new YxxWorkerExample()
                .createCriteria().andStatusEqualTo(1).andLevelIdEqualTo(3)
                .example());
        workers.forEach(worker -> list.add(new WorkerDistance(worker.getId(), worker.getLocation(),
                DistanceUtil.getDistance(worker.getLocation(), order.getLocation()))));
        // 排序
        list.sort(WorkerDistance::compareTo);
        // 查询精英会员
        List<YxxWorker> workers2 = workerMapper.selectByExample(new YxxWorkerExample()
                .createCriteria().andStatusEqualTo(1).andLevelIdEqualTo(2)
                .example());
        List<WorkerDistance> list2 = new ArrayList<>();
        workers2.forEach(worker -> list2.add(new WorkerDistance(worker.getId(), worker.getLocation(),
                DistanceUtil.getDistance(worker.getLocation(), order.getLocation()))));
        list2.sort(WorkerDistance::compareTo);
        // 合并
        list.addAll(list2);
        return list.stream().map(WorkerDistance::getId).collect(Collectors.toList());
    }

    /**
     * 自动派单
     */
    @Transactional(rollbackFor = Exception.class)
    public void distribute() {
        Long orderId = distributorService.popOrderId();
        if (orderId != null) {
            List<Long> workerIds = getSortedWorkerIds(orderId);
            log.info("订单ID:{} 维修工列表：{}", orderId, workerIds);
            if (!workerIds.isEmpty()) {
                distributorService.initWorkerQueue(orderId, workerIds);
                // 派发订单
                YxxOrder order = orderMapper.selectByPrimaryKey(orderId);
                // 先判断订单状态
                if (order.getOrderStatus() != OrderStatus.DISTRIBUTING.val()) {
                    distributorService.removeFromQueue(orderId);
                } else {
                    distributeToWorker(order);
                }
            } else {
                // 没有可用的维修工处理
                log.info("没有可用的维修工处理...改为手动指派单：{}", orderId);
                this.updateOrderToManual(orderId);
            }
            // 递归处理
            distribute();
        }
    }

    private void distributeToWorker(YxxOrder order) {
        Long workerId = distributorService.popWorkerId(order.getId());
        if (workerId != null) {
            boolean checkResult = orderCommonService.check(order, workerId);
            if (!checkResult) {
                distributeToWorker(order);
            }
            record(order, OrderStatus.DISTRIBUTED, "已派单-待接单");
            order.setWorkerId(workerId);
            order.setOrderStatus(OrderStatus.DISTRIBUTED.val());
            orderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.workerId, YxxOrder.Column.orderStatus);
            // 添加到超时等待队列 并设置超时
            distributorService.addToWaitQueue(order.getId(), workerId, 10 * 60);
        }

    }

    /**
     * 自动派单
     */
    @Transactional(rollbackFor = Exception.class)
    public void distributeAgain(Long orderId) {
        Long workerId = distributorService.popWorkerId(orderId);
        if (workerId != null) {
            YxxOrder order = orderMapper.selectByPrimaryKey(orderId);
            // 先判断订单状态
            if (order.getOrderStatus() != OrderStatus.DISTRIBUTING.val()) {
                distributorService.removeFromQueue(orderId);
            } else {
                distributeToWorker(order);
            }
        } else {
            // 没有可用的维修工处理
            log.info("没有可用的维修工处理...");
            this.updateOrderToManual(orderId);
        }
    }

    /**
     * 更改订单类型为 人工处理
     *
     * @param orderId 订单ID
     */
    private void updateOrderToManual(Long orderId) {
        // 从队列移除
        distributorService.removeFromQueue(orderId);
        YxxOrder order = YxxOrder.builder().id(orderId).orderType(OrderType.MANUAL_DISTRIBUTE.val()).updateTime(new Date()).build();
        orderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.updateTime, YxxOrder.Column.orderType);
    }

    private void record(YxxOrder order, OrderStatus status, String remark) {
        statusRecordMapper.insert(orderBuilder(order.getId(), order.getOrderStatus(), status, remark));
    }

    private void batchRecord(List<Long> ids, OrderStatus status, String remark) {
        List<YxxOrderStatusRecord> recordList = new ArrayList<>();
        ids.forEach(id -> {
            recordList.add(orderBuilder(id, OrderStatus.CREATED.val(), status, remark));
        });
        statusRecordMapper.batchInsert(recordList);
    }

    private YxxOrderStatusRecord orderBuilder(Long orderId, int os, OrderStatus status, String remark) {
        return YxxOrderStatusRecord.builder()
                .remark(remark)
                .orderId(orderId)
                .originStatus(os)
                .currentStatus(status.val())
                .createTime(new Date())
                .build();
    }

    /**
     * 查询新创建的订单 - push 到派单队列
     */
    public void pushQueue() {
        List<YxxOrder> orderList = orderMapper.selectByExample(new YxxOrderExample().createCriteria()
                .andOrderStatusEqualTo(OrderStatus.CREATED.val()).example());
        if (!orderList.isEmpty()) {
            log.info(" push 到派单队列：{}", orderList);
            List<Long> ids = new ArrayList<>();
            orderList.forEach(order -> {
                OrderType orderType = distributorService.addToQueue(order.getId());
                order.setOrderStatus(OrderStatus.DISTRIBUTING.val());
                order.setUpdateTime(new Date());
                order.setOrderType(orderType.val());
                // 更新状态和订单类型
                orderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.updateTime, YxxOrder.Column.orderStatus, YxxOrder.Column.orderType);
                ids.add(order.getId());
            });
            this.batchRecord(ids, OrderStatus.DISTRIBUTING, "批量更新订单状态为派单中");
        }
    }
}
