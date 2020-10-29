package com.macro.mall.dto;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductSku;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 创建和修改商品时使用的参数
 *
 * @author macro
 * @date 2018/4/26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductParam extends PmsProduct {

    @ApiModelProperty("商品的SKU规格信息")
    private List<PmsProductSku> productSkuList;

    /**
     * QA id 数组
     */
    @ApiModelProperty("QA id 数组")
    private List<Long> qaIds;
}
