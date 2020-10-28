package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.YxxZone;
import com.macro.mall.model.YxxZoneApply;
import com.macro.mall.service.CommonZoneService;
import com.macro.mall.service.impl.AdminZoneService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Paradise
 */
@RestController
@RequestMapping("/zone")
@AllArgsConstructor
public class AdminZoneController {

    private final CommonZoneService commonZoneService;
    private final AdminZoneService adminZoneService;

    @ApiOperation("分页查询-区域服务中心申请列表")
    @GetMapping("/apply/page")
    public CommonResult<CommonPage<YxxZoneApply>> queryPage(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) Long regionId) {
        List<YxxZoneApply> zoneList = commonZoneService.queryZoneApplyListByAdmin(pageNum, pageSize, status, regionId);
        return CommonResult.success(CommonPage.restPage(zoneList));
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

    @ApiOperation("分页查询-区域服务中心")
    @GetMapping("/page")
    public CommonResult<CommonPage<YxxZone>> queryPage(Long zoneId) {
        List<YxxZone> zoneList = commonZoneService.queryZoneList(zoneId);
        return CommonResult.success(CommonPage.restPage(zoneList));
    }

    @ApiOperation("创建")
    @PostMapping("/create")
    public CommonResult createZone() {
        return CommonResult.failed();
    }

    @ApiOperation("更新")
    @PostMapping("/update")
    public CommonResult updateZone() {
        return CommonResult.failed();
    }

    @ApiOperation("启用禁用")
    @PostMapping("/enable/{id}")
    public CommonResult updateZone(@PathVariable Long id) {
        if (adminZoneService.enableSwitch(id) == 1) {
            return CommonResult.success("");
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除")
    @DeleteMapping("/del/{id}")
    public CommonResult delZone(@PathVariable Long id) {
        if (adminZoneService.del(id) == 1) {
            return CommonResult.success("");
        }
        return CommonResult.failed();
    }
}
