package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.YxxZone;
import com.macro.mall.service.CommonZoneService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Paradise
 */
@RestController
@RequestMapping("/zone")
@AllArgsConstructor
public class AdminZoneController {

    private final CommonZoneService commonZoneService;

    @ApiOperation("分页查询-区域服务中心")
    @GetMapping("/page")
    public CommonResult<CommonPage<YxxZone>> queryPage(Long zoneId) {
        List<YxxZone> zoneList = commonZoneService.queryZoneList(zoneId);
        return CommonResult.success(CommonPage.restPage(zoneList));
    }
}
