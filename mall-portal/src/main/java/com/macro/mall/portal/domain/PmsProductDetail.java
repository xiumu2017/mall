package com.macro.mall.portal.domain;

import com.macro.mall.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 前台商品详情
 *
 * @author macro
 * @date 2020/4/6
 */
@Getter
@Setter
public class PmsProductDetail {
    @ApiModelProperty("品类信息")
    private PmsProduct product;

    @ApiModelProperty("规格信息")
    private List<PmsProductSku> skuStockList;

    @ApiModelProperty("可用优惠券")
    private List<SmsCoupon> couponList;

    @ApiModelProperty("垚修修服务评价标签")
    private List<YxxProductCommentLabel> commentLabelList;

    @ApiModelProperty("垚修修品类QA列表")
    private List<YxxHomeQa> qaList;
}
