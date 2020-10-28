package com.macro.mall.domain;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.YxxMember;
import com.macro.mall.model.YxxRepairRecord;
import com.macro.mall.model.YxxWorker;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Paradise
 */
@ApiModel("垚修修订单详情")
@Data
public class YxxOrderDetail {
    /**
     * 订单信息
     */
    @ApiModelProperty("订单信息")
    private YxxOrderInfo yxxOrder;
    /**
     * 子订单信息
     */
    @ApiModelProperty("子订单信息")
    private List<OrderItemInfo> itemList;
    /**
     * 维修工单
     */
    @ApiModelProperty("维修工单")
    private YxxRepairRecord repairRecord;
    /**
     * 订单状态变更列表
     */
    @ApiModelProperty("订单状态变更列表")
    private List<YxxOrderStatusRecordInfo> orderStatusRecordList;

    @ApiModelProperty("维修工信息")
    private YxxWorker worker;

    @ApiModelProperty("用户信息")
    private YxxMember member;

    @ApiModelProperty("服务品类信息")
    private PmsProduct product;

}
