package com.macro.mall.schedule;

import com.macro.mall.common.constant.RedisKeyConstant;
import com.macro.mall.common.service.RedisService;
import com.macro.mall.service.impl.YxxOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.macro.mall.common.constant.RedisKeyConstant.ORDER_WORKER_EXPIRE;

/**
 * 派单逻辑
 *
 * @author Paradise
 */
@Slf4j
@Component
@Profile({"test", "dev"})
public class Distributor {

    private final RedisService redisService;
    private final YxxOrderService orderService;

    public Distributor(RedisService redisService, YxxOrderService orderService) {
        this.redisService = redisService;
        this.orderService = orderService;
    }
    // 计数器
    // 订单队列 - 待派发订单
    // 订单对应可选维修工列表 - 排序
    // 使用 Redis 来实现


    /**
     * 定时任务 - 查询并push订单到派单队列
     */
    @Scheduled(fixedRate = 10_000)
    public void pushQueue() {
        orderService.pushQueue();
    }

    /**
     * 定时任务 - 派单
     */
    @Scheduled(fixedRate = 30_000)
    public void distribute() {
        log.debug("派单中...");
        long size = redisService.lSize(RedisKeyConstant.ORDER_QUEUE);
        // 派单队列不为空
        if (size > 0) {
            log.info("开始派单");
            orderService.distribute();
        }
    }

    /**
     * 定时任务 - 订单超时检测
     */
    @Scheduled(fixedRate = 20_000)
    public void overTime() {
        long size = redisService.lSize(RedisKeyConstant.ORDER_WAIT_QUEUE);
        // 队列不为空
        if (size > 0) {
            log.info("接单超时检测...");
            List<Object> objectList = redisService.lRange(RedisKeyConstant.ORDER_WAIT_QUEUE, 0, -1);
            for (Object obj : objectList) {
                Long orderId = Long.parseLong(String.valueOf(obj));
                Object object = redisService.get(ORDER_WORKER_EXPIRE + orderId);
                if (object == null) {
                    // 超时
                    orderService.distributeAgain(orderId);
                }
            }
        }
    }

}
