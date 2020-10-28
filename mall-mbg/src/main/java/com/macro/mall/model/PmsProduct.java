package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 *
 * @author Paradise
 */
@ApiModel(value="")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsProduct implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="商品分类ID")
    private Long productCategoryId;

    @ApiModelProperty(value="商品名称")
    private String name;

    @ApiModelProperty(value="商品小图")
    private String pic;

    @ApiModelProperty(value="货号")
    private String productSn;

    @ApiModelProperty(value="删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;

    @ApiModelProperty(value="上架状态：0->下架；1->上架")
    private Integer publishStatus;

    @ApiModelProperty(value="推荐状态；0->不推荐；1->推荐")
    private Integer recommendStatus;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="副标题")
    private String subTitle;

    @ApiModelProperty(value="搜索关键词")
    private String keywords;

    @ApiModelProperty(value="详情页标题")
    private String detailTitle;

    @ApiModelProperty(value="商品分类名称")
    private String productCategoryName;

    @ApiModelProperty(value="地域ID")
    private Long regionId;

    @ApiModelProperty(value="地域名称")
    private String region;

    @ApiModelProperty(value="是否询价：0->一口价；1-> 询价")
    private Integer isBargain;

    @ApiModelProperty(value="收费标准ID")
    private Long chargeStandardId;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    @ApiModelProperty(value="公共费用ID（多个逗号隔开）")
    private String commonCost;

    @ApiModelProperty(value="商品描述")
    private String description;

    @ApiModelProperty(value="画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;

    @ApiModelProperty(value="详情页文本描述")
    private String detailDesc;

    @ApiModelProperty(value="产品详情网页内容")
    private String detailHtml;

    @ApiModelProperty(value="询价商品收费标准")
    private String chargeStandardJson;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        productCategoryId("product_category_id", "productCategoryId", "BIGINT", false),
        name("name", "name", "VARCHAR", true),
        pic("pic", "pic", "VARCHAR", false),
        productSn("product_sn", "productSn", "VARCHAR", false),
        deleteStatus("delete_status", "deleteStatus", "INTEGER", false),
        publishStatus("publish_status", "publishStatus", "INTEGER", false),
        recommendStatus("recommend_status", "recommendStatus", "INTEGER", false),
        sort("sort", "sort", "INTEGER", false),
        subTitle("sub_title", "subTitle", "VARCHAR", false),
        keywords("keywords", "keywords", "VARCHAR", false),
        detailTitle("detail_title", "detailTitle", "VARCHAR", false),
        productCategoryName("product_category_name", "productCategoryName", "VARCHAR", false),
        regionId("region_id", "regionId", "BIGINT", false),
        region("region", "region", "VARCHAR", false),
        isBargain("is_bargain", "isBargain", "INTEGER", false),
        chargeStandardId("charge_standard_id", "chargeStandardId", "BIGINT", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        commonCost("common_cost", "commonCost", "VARCHAR", false),
        description("description", "description", "LONGVARCHAR", false),
        albumPics("album_pics", "albumPics", "LONGVARCHAR", false),
        detailDesc("detail_desc", "detailDesc", "LONGVARCHAR", false),
        detailHtml("detail_html", "detailHtml", "LONGVARCHAR", false),
        chargeStandardJson("charge_standard_json", "chargeStandardJson", "LONGVARCHAR", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}