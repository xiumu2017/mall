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
public class YxxZone implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="中心名称")
    private String name;

    @ApiModelProperty(value="服务范围（地理围栏坐标描述）")
    private String location;

    @ApiModelProperty(value="1启用0禁用")
    private Integer enable;

    @ApiModelProperty(value="状态")
    private Integer status;

    @ApiModelProperty(value="地域ID")
    private Long regionId;

    @ApiModelProperty(value="是否手动指派订单：1是0否")
    private Integer isManual;

    @ApiModelProperty(value="中心抽成比例")
    private BigDecimal cutPercent;

    @ApiModelProperty(value="服务中心所在地址")
    private String address;

    @ApiModelProperty(value="联系方式")
    private String contract;

    @ApiModelProperty(value="图片介绍")
    private String pic;

    @ApiModelProperty(value="介绍信息")
    private String description;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    @ApiModelProperty(value="申请维修工ID")
    private Long applyWorker;

    @ApiModelProperty(value="管理维修工ID")
    private Long managerWorker;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        name("name", "name", "VARCHAR", true),
        location("location", "location", "VARCHAR", true),
        enable("enable", "enable", "INTEGER", true),
        status("status", "status", "INTEGER", true),
        regionId("region_id", "regionId", "BIGINT", false),
        isManual("is_manual", "isManual", "INTEGER", false),
        cutPercent("cut_percent", "cutPercent", "DECIMAL", false),
        address("address", "address", "VARCHAR", false),
        contract("contract", "contract", "VARCHAR", false),
        pic("pic", "pic", "VARCHAR", false),
        description("description", "description", "VARCHAR", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        applyWorker("apply_worker", "applyWorker", "BIGINT", false),
        managerWorker("manager_worker", "managerWorker", "BIGINT", false);

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