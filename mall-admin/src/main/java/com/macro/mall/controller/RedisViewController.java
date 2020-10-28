package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.service.RedisService;
import com.macro.mall.common.service.impl.DistributorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Paradise
 */
@Api(tags = "Redis调试器")
@RequestMapping("/redis")
@RestController
public class RedisViewController {
    private final DistributorService distributorService;
    private final RedisService redisService;

    public RedisViewController(DistributorService distributorService, RedisService redisService) {
        this.distributorService = distributorService;
        this.redisService = redisService;
    }

    @ApiOperation("查询抢单队列")
    @GetMapping("/rush/ids")
    public CommonResult<List<Long>> getRushOrderIds() {
        return CommonResult.success(distributorService.getRushOrderIds());
    }

    @ApiOperation("查询派单队列")
    @GetMapping("/ids")
    public CommonResult<List<Long>> getOrderIds() {
        return CommonResult.success(distributorService.getOrderIds());
    }

    @ApiOperation("查询订单计数器")
    @GetMapping("/getCounterValue")
    public CommonResult<Integer> getCounterValue() {
        return CommonResult.success(distributorService.getCounterValue());
    }

    @ApiOperation("查询维修工数组")
    @GetMapping("/getWorkers")
    public CommonResult<List<Long>> getWorkers(Long orderId) {
        return CommonResult.success(distributorService.getWorkerIds(orderId));
    }
}
