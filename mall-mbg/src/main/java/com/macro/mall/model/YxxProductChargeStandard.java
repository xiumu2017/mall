package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * 垚修修服务收费标准
 *
 * @author Paradise
 */
@ApiModel(value = "垚修修服务收费标准")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YxxProductChargeStandard implements Serializable {
    @ApiModelProperty(value = "自增主键", hidden = true)
    private Long id;

    @ApiModelProperty(value = "收费标准名称")
    @NotEmpty(message = "收费标准名称不能为空")
    private String name;

    @ApiModelProperty(value = "是否启用：1->启用 0->禁用")
    private Integer enable;

    @ApiModelProperty(value = "是否删除：1->是 0->否", hidden = true)
    private Integer deleted;

    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @ApiModelProperty(value = "收费标准内容")
    private String contentJson;

    private static final long serialVersionUID = 1L;

    public enum Column {
        /**
         *
         */
        id("id", "id", "BIGINT", false),
        name("name", "name", "VARCHAR", true),
        enable("enable", "enable", "INTEGER", true),
        deleted("deleted", "deleted", "INTEGER", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        contentJson("content_json", "contentJson", "LONGVARCHAR", false);

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

        public static Column[] excludes(Column... excludes) {
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
                return BEGINNING_DELIMITER + this.column + ENDING_DELIMITER;
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}