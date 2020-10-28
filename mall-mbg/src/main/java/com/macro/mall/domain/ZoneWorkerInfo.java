package com.macro.mall.domain;

import com.macro.mall.model.YxxWorker;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel("区域中心维修工信息")
public class ZoneWorkerInfo extends YxxWorker {
    @ApiModelProperty("是否管理员")
    private Integer isAdmin;
    @ApiModelProperty("加入时间")
    private Date joinTime;
}
