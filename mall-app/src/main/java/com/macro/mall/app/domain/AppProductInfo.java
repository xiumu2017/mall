package com.macro.mall.app.domain;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.YxxHomeCost;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("App服务品类信息")
public class AppProductInfo extends PmsProduct {
    /**
     * 公共费用列表
     */
    @ApiModelProperty("公共费用列表")
    private List<YxxHomeCost> commonCostList;
}
