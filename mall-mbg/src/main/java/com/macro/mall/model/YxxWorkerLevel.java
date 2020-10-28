package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class YxxWorkerLevel implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Integer id;

    @ApiModelProperty(value="会员等级名称")
    private String name;

    @ApiModelProperty(value="是否启用")
    private Integer enable;

    @ApiModelProperty(value="按月价格")
    private BigDecimal priceMonth;

    @ApiModelProperty(value="连续包月价格")
    private BigDecimal priceMonthly;

    @ApiModelProperty(value="年费价格")
    private BigDecimal priceYear;

    @ApiModelProperty(value="是否删除")
    private Integer deleted;

    @ApiModelProperty(value="订单指派数量")
    private Integer orderAssignAmount;

    @ApiModelProperty(value="订单自动派单数量")
    private Integer orderDistributeAmount;

    @ApiModelProperty(value="抢单数量-一口价")
    private Integer orderRushAmount;

    @ApiModelProperty(value="抢单数量-询价")
    private Integer orderRushAmountBargain;

    @ApiModelProperty(value="抽成抵扣")
    private BigDecimal cutDiscount;

    @ApiModelProperty(value="备注")
    private String remark;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    @ApiModelProperty(value="创建人")
    private Long createBy;

    @ApiModelProperty(value="最近更新人")
    private Long updateBy;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "INTEGER", false),
        name("name", "name", "VARCHAR", true),
        enable("enable", "enable", "INTEGER", true),
        priceMonth("price_month", "priceMonth", "DECIMAL", false),
        priceMonthly("price_monthly", "priceMonthly", "DECIMAL", false),
        priceYear("price_year", "priceYear", "DECIMAL", false),
        deleted("deleted", "deleted", "INTEGER", false),
        orderAssignAmount("order_assign_amount", "orderAssignAmount", "INTEGER", false),
        orderDistributeAmount("order_distribute_amount", "orderDistributeAmount", "INTEGER", false),
        orderRushAmount("order_rush_amount", "orderRushAmount", "INTEGER", false),
        orderRushAmountBargain("order_rush_amount_bargain", "orderRushAmountBargain", "INTEGER", false),
        cutDiscount("cut_discount", "cutDiscount", "DECIMAL", false),
        remark("remark", "remark", "VARCHAR", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        createBy("create_by", "createBy", "BIGINT", false),
        updateBy("update_by", "updateBy", "BIGINT", false);

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