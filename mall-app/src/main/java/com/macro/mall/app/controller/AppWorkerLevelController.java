package com.macro.mall.app.controller;

import com.macro.mall.app.service.impl.YxxWorkerService;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.YxxWorker;
import com.macro.mall.model.YxxWorkerLevel;
import com.macro.mall.model.YxxWorkerOrderCount;
import com.macro.mall.service.YxxOrderCommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Paradise
 */
@Api(tags = "会员等级相关接口")
@RestController
@RequestMapping("/level")
@AllArgsConstructor
public class AppWorkerLevelController {
    private final YxxOrderCommonService orderCommonService;
    private final YxxWorkerService workerService;

    @ApiOperation("查询全部会员等级列表")
    @GetMapping("/list")
    public CommonResult<List<YxxWorkerLevel>> queryLevelList() {
        return CommonResult.success(orderCommonService.getLevelList());
    }


    @ApiOperation("查询当前会员等级属性")
    @GetMapping("/current")
    public CommonResult<YxxWorkerLevel> queryLevel() {
        YxxWorker worker = workerService.getCurrentWorker();
        return CommonResult.success(orderCommonService.getLevel(worker.getLevelId()));
    }

    @ApiOperation("查询消耗订单数量")
    @GetMapping("/order/count")
    public CommonResult<YxxWorkerOrderCount> queryCostOrderCount() {
        return CommonResult.success(orderCommonService.countByWorkerId(workerService.getCurrentWorker().getId()));
    }
}
