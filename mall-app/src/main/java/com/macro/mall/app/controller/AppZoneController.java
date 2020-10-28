package com.macro.mall.app.controller;

import com.macro.mall.app.domain.AppZoneApply;
import com.macro.mall.app.service.impl.YxxWorkerService;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.domain.AppZoneInfo;
import com.macro.mall.domain.ZoneSkilledProductInfo;
import com.macro.mall.domain.ZoneWorkerInfo;
import com.macro.mall.example.YxxRegionExample;
import com.macro.mall.mapper.YxxRegionMapper;
import com.macro.mall.model.YxxRegion;
import com.macro.mall.model.YxxWorker;
import com.macro.mall.model.YxxZone;
import com.macro.mall.model.YxxZoneApply;
import com.macro.mall.service.CommonZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Paradise
 */
@Api(tags = "区域服务中心相关接口")
@RestController
@RequestMapping("/zone")
public class AppZoneController {
    private final CommonZoneService commonZoneService;
    private final YxxWorkerService workerService;
    private final YxxRegionMapper regionMapper;

    public AppZoneController(CommonZoneService commonZoneService,
                             YxxWorkerService workerService, YxxRegionMapper regionMapper) {
        this.commonZoneService = commonZoneService;
        this.workerService = workerService;
        this.regionMapper = regionMapper;
    }

    @ApiOperation("查询区域服务中心列表")
    @GetMapping("/list")
    public CommonResult<List<YxxZone>> queryZoneList(@RequestParam(required = false) Long regionId) {
        return CommonResult.success(commonZoneService.queryZoneList(regionId));
    }

    @ApiOperation("查询区域服务中心擅长品类列表")
    @GetMapping("/skilled-product/list")
    public CommonResult<List<ZoneSkilledProductInfo>> querySkilledProInfoList(@RequestParam Long zoneId) {
        return CommonResult.success(commonZoneService.querySkilledProInfoList(zoneId));
    }

    @ApiOperation("申请加入或者创建区域服务中心")
    @PostMapping("/apply")
    public CommonResult createZoneApply(@RequestBody @Validated AppZoneApply zoneApply) {
        YxxZoneApply apply = YxxZoneApply.builder().applyContent(zoneApply.getContent())
                .zoneId(zoneApply.getZoneId()).build();
        int x = commonZoneService.zoneApply(apply, workerService.getCurrentWorker());
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("查询个人申请记录")
    @GetMapping("/apply/list")
    public CommonResult<List<YxxZoneApply>> queryZoneApplyList() {
        List<YxxZoneApply> applyList = commonZoneService.queryZoneApplyList(workerService.getCurrentWorker().getId());
        return CommonResult.success(applyList);
    }

    @ApiOperation("查询区域服务中心人员列表")
    @GetMapping("/worker/list")
    public CommonResult<CommonPage<ZoneWorkerInfo>> queryZoneWorkerList(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        YxxWorker worker = workerService.getCurrentWorker();
        List<ZoneWorkerInfo> workerInfoList = commonZoneService.zoneWorkerInfoList(keyword, worker.getZoneId(), pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(workerInfoList));
    }

    @ApiOperation("查询区域服务中心信息")
    @GetMapping("info")
    public CommonResult<AppZoneInfo> queryZoneWorkerList() {
        YxxWorker worker = workerService.getCurrentWorker();
        return CommonResult.success(commonZoneService.zoneInfo(worker));
    }

    @ApiOperation("查询地域列表")
    @GetMapping("/region/ist")
    public CommonResult<List<YxxRegion>> queryRegionList() {
        List<YxxRegion> regions = regionMapper.selectByExample(new YxxRegionExample().createCriteria().andEnableEqualTo(1).example());
        return CommonResult.success(regions);
    }

    @ApiOperation("管理员查询加入区域申请记录")
    @GetMapping("/apply/join/list")
    public CommonResult<List<YxxZoneApply>> queryZoneApplyList(@RequestParam Integer status) {
        YxxWorker worker = workerService.getCurrentWorker();
        Long zoneId = worker.getZoneId();
        YxxZone zone = commonZoneService.zoneInfo(worker);
        if (zone.getManagerWorker().equals(worker.getId())) {
            return CommonResult.success(null);
        }
        List<YxxZoneApply> applyList = commonZoneService.queryZoneApplyListByZoneId(zoneId, status);
        return CommonResult.success(applyList);
    }

    @ApiOperation("管理员审批加入区域申请")
    @ApiImplicitParam(name = "status", value = "审批结果：1通过2拒绝")
    @PostMapping("/apply/deal")
    public CommonResult dealApply(@RequestParam Integer status,
                                  @RequestParam Long applyId,
                                  @RequestParam(required = false) String remark) {
        int x = commonZoneService.zoneApplyAudit(applyId, null, status, remark);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

}
