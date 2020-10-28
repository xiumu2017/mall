package com.macro.mall.domain;

import com.macro.mall.model.YxxZone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Paradise
 */
@ApiModel("区域信息")
@EqualsAndHashCode(callSuper = true)
@Data
public class AppZoneInfo extends YxxZone {

    @ApiModelProperty("擅长品类列表")
    private List<ZoneSkilledProductInfo> skilledProductInfoList;

    @ApiModelProperty("当前维修工是否管理员")
    private Integer isAdmin;
}
