package com.macro.mall.common.constant;

/**
 * @author Paradise
 */
public class RedisKeyConstant {
    /**
     * 派单队列
     */
    public static final String ORDER_QUEUE = "ORDER_QUEUE";
    /**
     * 待接单队列 - 用于超时判断
     */
    public static final String ORDER_WAIT_QUEUE = "ORDER_WAIT_QUEUE";
    /**
     * 订单循环计数器
     */
    public static final String ORDER_COUNTER = "ORDER_COUNTER";
    /**
     * 订单-维修工有序队列
     */
    public static final String ORDER_WORKER_QUEUE = "ORDER_WORKER_QUEUE:";
    /**
     * 抢单队列
     */
    public static final String ORDER_RUSH_QUEUE = "ORDER_RUSH_QUEUE";
    /**
     * 派单过期时效
     */
    public static final String ORDER_WORKER_EXPIRE = "ORDER_WORKER_EXPIRE:";
}
