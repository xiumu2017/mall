package com.macro.mall.dao;

import com.macro.mall.domain.OrderItemInfo;
import com.macro.mall.domain.OrderQuery;
import com.macro.mall.domain.YxxOrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 *
 * @author Paradise
 * @date 2020-10-10
 */
public interface YxxOrderCommonDao {

    /**
     * 查询订单列表
     *
     * @param memberId 会员ID
     * @param array    状态数组
     * @return 订单信息
     */
    List<YxxOrderInfo> queryList(@Param("memberId") Long memberId, @Param("array") Integer[] array);

    /**
     * 查询
     *
     * @param query 查询参数
     * @return 订单列表
     */
    List<YxxOrderInfo> queryListByOrderQuery(@Param("query") OrderQuery query);

    /**
     * 查询订单信息
     *
     * @param id 订单id
     * @return 订单信息
     */
    YxxOrderInfo queryInfoById(@Param("id") Long id);

    /**
     * 维修工查询订单
     *
     * @param workerId 维修工ID
     * @param status   订单状态
     * @return 订单列表
     */
    List<YxxOrderInfo> queryInfoByWorkerId(@Param("workerId") Long workerId, @Param("status") Integer status);

    /**
     * 维修工查询抢单订单
     *
     * @param ids    id列表
     * @param status 状态
     * @return 订单列表
     */
    List<YxxOrderInfo> queryRushOrders(@Param("ids") List<Long> ids, @Param("status") Integer status);

    /**
     * 查询子订单信息
     *
     * @param orderId 订单ID
     * @return 子订单信息
     */
    List<OrderItemInfo> queryOrderItemList(@Param("orderId") Long orderId);

    /**
     * 更新服务品类评价标签数量
     *
     * @param productId 服务品类ID
     * @param label     标签名称
     * @return update res
     */
    int updateProductCommentLabel(@Param("productId") Long productId, @Param("label") String label);

    /**
     * 更新抢单数量 + 1
     *
     * @param workerId 维修工ID
     * @return res
     */
    int updateWorkerOrderRushCount(Long workerId);

    /**
     * 更新抢单询价数量 + 1
     *
     * @param workerId 维修工ID
     * @return res
     */
    int updateWorkerOrderRushBargainCount(Long workerId);

    /**
     * 更新系统分派订单数量 +1
     *
     * @param workerId 维修工ID
     * @return res
     */
    int updateWorkerOrderDistributeCount(Long workerId);

    /**
     * 更新指派订单数量 +1
     *
     * @param workerId 维修工ID
     * @return res
     */
    int updateWorkerOrderAssignCount(Long workerId);
}
