package com.macro.mall.app.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 申请区域服务中心
 *
 * @author Paradise
 */
@Data
@ApiModel("申请区域服务中心")
public class AppZoneApply {
    @ApiModelProperty("区域服务中心ID")
    private Long zoneId;

    @ApiModelProperty("申请内容")
    @NotEmpty
    private String content;
}
