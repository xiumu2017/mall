package com.macro.mall.common.service.impl;

import com.macro.mall.common.constant.OrderType;
import com.macro.mall.common.constant.RedisKeyConstant;
import com.macro.mall.common.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.macro.mall.common.constant.RedisKeyConstant.*;

/**
 * 派单逻辑
 *
 * @author Paradise
 */
@Slf4j
@Component
public class DistributorService {

    private static final int MAX_COUNTER = 7;
    private final RedisService redisService;

    public DistributorService(RedisService redisService) {
        this.redisService = redisService;
    }
    // 计数器
    // 订单队列 - 待派发订单
    // 订单对应可选维修工列表 - 排序
    // 使用 Redis 来实现

    /**
     * 用户下单 - 添加到派单队列
     *
     * @param orderId 订单信息
     */
    public OrderType addToQueue(Long orderId) {
        this.counterIncr();
        int c = getCounterValue();
        if (c == MAX_COUNTER) {
            // 进入抢单队列
            redisService.lPush(ORDER_RUSH_QUEUE, orderId);
            return OrderType.SYSTEM_RUSH;
        } else {
            redisService.lPush(ORDER_QUEUE, orderId);
            return OrderType.SYSTEM_DISTRIBUTE;
        }
    }

    /**
     * 用户取消 - 从队列移除
     *
     * @param orderId 订单ID
     */
    public void removeFromQueue(Long orderId) {
        // 从队列中删除
        redisService.lRemove(ORDER_QUEUE, 1, orderId);
        // 删除维修工排序队列
        redisService.del(ORDER_WORKER_QUEUE + orderId);
        // 删除超时timer
        redisService.del(ORDER_WORKER_EXPIRE + orderId);
        // 删除超时等待队列
        redisService.lRemove(ORDER_WAIT_QUEUE, 1, orderId);
        // 删除抢单队列
        redisService.lRemove(ORDER_RUSH_QUEUE, 1, orderId);
    }

    /**
     * 计数器 + 1
     */
    private void counterIncr() {
        int value = getCounterValue();
        if (value > MAX_COUNTER) {
            redisService.set(ORDER_COUNTER, 0);
        } else {
            redisService.incr(ORDER_COUNTER, 1);
        }
    }

    public int getCounterValue() {
        if (redisService.get(ORDER_COUNTER) == null) {
            redisService.set(ORDER_COUNTER, 0);
        }
        return (int) redisService.get(ORDER_COUNTER);
    }

    public Long popOrderId() {
        Object obj = redisService.lrPop(ORDER_QUEUE);
        if (obj != null) {
            return Long.parseLong(String.valueOf(obj));
        }
        return null;
    }

    public void initWorkerQueue(Long orderId, List<Long> workerIds) {
        redisService.lPushAll(ORDER_WORKER_QUEUE + orderId, workerIds.toArray(new Object[0]));
    }

    private void delWorkerQueue(Long orderId) {
        redisService.del(ORDER_WORKER_QUEUE + orderId);
    }

    /**
     * 根据订单ID Pop 维修工
     *
     * @param orderId 订单ID
     * @return 维修工ID
     */
    public Long popWorkerId(Long orderId) {
        Object obj = redisService.llPop(ORDER_WORKER_QUEUE + orderId);
        if (obj != null) {
            return Long.parseLong(String.valueOf(obj));
        }
        return null;
    }

    /**
     * 设置订单超时 - 用于分配完成之后
     *
     * @param orderId  订单ID
     * @param workerId 维修工ID
     * @param time     超时时间 单位：秒
     */
    private void setOrderWorkerTimer(Long orderId, Long workerId, long time) {
        redisService.set(ORDER_WORKER_EXPIRE + orderId, workerId, time);
    }

    private void delOrderWorkerTimer(Long orderId) {
        redisService.del(ORDER_WORKER_EXPIRE + orderId);
    }

    /**
     * 添加到超时等待队列
     *
     * @param orderId 订单ID
     */
    public void addToWaitQueue(Long orderId, Long workerId, long time) {
        redisService.lPush(ORDER_WAIT_QUEUE, orderId);
        this.setOrderWorkerTimer(orderId, workerId, time);
    }

    /**
     * 从超时等待队列移除 - 用户接单成功
     *
     * @param orderId 订单ID
     */
    public void removeFromWaitQueue(Long orderId) {
        redisService.lRemove(ORDER_WAIT_QUEUE, 1, orderId);
        this.delOrderWorkerTimer(orderId);
        // 移除维修工序列
        this.delWorkerQueue(orderId);
    }

    /**
     * 维修工拒绝接单
     */
    public void refuse(Long orderId) {
        // 直接设置 timer 超时
        this.delOrderWorkerTimer(orderId);
    }

    /**
     * 抢单成功
     *
     * @param orderId 订单ID
     */
    public void rushSuccess(Long orderId) {
        redisService.lRemove(ORDER_RUSH_QUEUE, 1, orderId);
    }

    /**
     * 查询抢单队列中的订单ID
     *
     * @return 订单ID
     */
    public List<Long> getRushOrderIds() {
        // redis 查询rush订单列表
        List<Object> objectList = redisService.lRange(RedisKeyConstant.ORDER_RUSH_QUEUE, 0, -1);
        return getLongs(objectList);
    }

    /**
     * 查询派单队列中的订单ID
     *
     * @return 订单ID
     */
    public List<Long> getOrderIds() {
        // redis 查询rush订单列表
        List<Object> objectList = redisService.lRange(ORDER_QUEUE, 0, -1);
        return getLongs(objectList);
    }

    public List<Long> getWorkerIds(Long orderId) {
        List<Object> objectList = redisService.lRange(ORDER_WORKER_QUEUE + orderId, 0, -1);
        return getLongs(objectList);
    }

    private List<Long> getLongs(List<Object> objectList) {
        if (objectList.isEmpty()) {
            return new ArrayList<>();
        }
        List<Long> ids = new ArrayList<>();
        objectList.forEach(o -> ids.add(Long.parseLong(String.valueOf(o))));
        return ids;
    }
}
