package com.macro.mall.app.domain;

import com.macro.mall.model.YxxWorker;
import com.macro.mall.model.YxxWorkerLevel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("维修工信息")
public class AppWorkerInfo extends YxxWorker {
    @ApiModelProperty("维修工会员等级信息")
    private YxxWorkerLevel workerLevel;
}
