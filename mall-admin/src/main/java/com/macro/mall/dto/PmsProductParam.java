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
//    @ApiModelProperty("商品阶梯价格设置")
//    private List<PmsProductLadder> productLadderList;

//    @ApiModelProperty("商品满减价格设置")
//    private List<PmsProductFullReduction> productFullReductionList;

//    @ApiModelProperty("商品会员价格设置")
//    private List<PmsMemberPrice> memberPriceList;

//    @ApiModelProperty("商品的sku库存信息")
//    private List<PmsSkuStock> skuStockList;

    @ApiModelProperty("商品的SKU规格信息")
    private List<PmsProductSku> productSkuList;

//    @ApiModelProperty("商品参数及自定义规格属性")
//    private List<PmsProductAttributeValue> productAttributeValueList;

//    @ApiModelProperty("专题和商品关系")
//    private List<CmsSubjectProductRelation> subjectProductRelationList;

//    @ApiModelProperty("优选专区和商品的关系")
//    private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;
}
