package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * 垚修修会员信息表
 *
 * @author Paradise
 */
@ApiModel(value="垚修修会员信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YxxMember implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="用户名")
    private String username;

    @ApiModelProperty(value="姓名")
    private String realName;

    @ApiModelProperty(value="性别：1男0女")
    private Integer sex;

    @ApiModelProperty(value="密码")
    private String password;

    @ApiModelProperty(value="手机号码")
    private String phone;

    @ApiModelProperty(value="状态：1->启用 2->禁用")
    private Integer enable;

    @ApiModelProperty(value="头像")
    private String icon;

    @ApiModelProperty(value="生日")
    private Date birthday;

    @ApiModelProperty(value="区域ID")
    private Long regionId;

    @ApiModelProperty(value="地址")
    private String address;

    @ApiModelProperty(value="微信OpenId")
    private String wxOpenId;

    @ApiModelProperty(value="微信UnionId")
    private String wxUnionId;

    @ApiModelProperty(value="上级ID")
    private Long parentId;

    @ApiModelProperty(value="邀请码")
    private String invitationCode;

    @ApiModelProperty(value="注册时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        username("username", "username", "VARCHAR", false),
        realName("real_name", "realName", "VARCHAR", false),
        sex("sex", "sex", "INTEGER", false),
        password("password", "password", "VARCHAR", true),
        phone("phone", "phone", "VARCHAR", false),
        enable("enable", "enable", "INTEGER", true),
        icon("icon", "icon", "VARCHAR", false),
        birthday("birthday", "birthday", "DATE", false),
        regionId("region_id", "regionId", "BIGINT", false),
        address("address", "address", "VARCHAR", false),
        wxOpenId("wx_open_id", "wxOpenId", "VARCHAR", false),
        wxUnionId("wx_union_id", "wxUnionId", "VARCHAR", false),
        parentId("parent_id", "parentId", "BIGINT", false),
        invitationCode("invitation_code", "invitationCode", "VARCHAR", false),
        createTime("create_time", "createTime", "TIMESTAMP", false);

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