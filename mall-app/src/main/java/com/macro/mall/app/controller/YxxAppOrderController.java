package com.macro.mall.app.controller;

import com.macro.mall.app.domain.OrderPrice;
import com.macro.mall.app.service.impl.YxxAppOrderService;
import com.macro.mall.app.service.impl.YxxWorkerService;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.domain.OrderQuery;
import com.macro.mall.domain.YxxOrderDetail;
import com.macro.mall.domain.YxxOrderInfo;
import com.macro.mall.enums.OrderStatusUtil;
import com.macro.mall.model.YxxRepairRecord;
import com.macro.mall.model.YxxWorker;
import com.macro.mall.service.YxxOrderCommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 订单管理Controller
 *
 * @author macro
 * @date 2018/8/30
 */
@RestController
@Api(tags = "2.订单相关")
@RequestMapping("/order")
public class YxxAppOrderController {
    private final YxxAppOrderService yxxAppOrderService;
    private final YxxOrderCommonService orderCommonService;
    private final YxxWorkerService workerService;

    public YxxAppOrderController(YxxAppOrderService yxxAppOrderService,
                                 YxxOrderCommonService orderCommonService, YxxWorkerService workerService) {
        this.yxxAppOrderService = yxxAppOrderService;
        this.orderCommonService = orderCommonService;
        this.workerService = workerService;
    }

    @ApiOperation("查询 - 分页获取订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "订单状态：1-进行中 2-历史订单", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "orderType", value = "订单类型：1-专享 2-指派", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "isBargain", value = "是否询价：0-一口价 1-询价 ", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "year", value = "年", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "month", value = "月 ", paramType = "query", dataType = "int"),
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<YxxOrderInfo>> list(@RequestParam(required = false) Integer status,
                                                       @RequestParam(required = false) Integer orderType,
                                                       @RequestParam(required = false) Integer isBargain,
                                                       @RequestParam(required = false) Integer year,
                                                       @RequestParam(required = false) Integer month,
                                                       @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                       @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        OrderQuery query = OrderQuery.builder().isBargain(isBargain).array(OrderStatusUtil.getStatusArray(status))
                .startTime(getDate(year, month, 1)).endTime(getDate(year, month, 0)).workerId(workerService.getCurrentWorker().getId())
                .orderType(orderType).build();
        CommonPage<YxxOrderInfo> orderInfoCommonPage = orderCommonService.pageQueryInfo(query, pageNum, pageSize);
        // 进行中 历史订单
        // 全部/专享/一口价/询价/指派 年月
        return CommonResult.success(orderInfoCommonPage);
    }

    private Date getDate(Integer year, Integer month, int type) {
        if (year == null || month == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        if (type == 1) {
            calendar.set(Calendar.MONTH, month - 1);
        } else {
            calendar.set(Calendar.MONTH, month);
        }
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    @ApiOperation("查询 - 获取订单详情")
    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    public CommonResult<YxxOrderDetail> detail(@PathVariable Long orderId) {
        YxxOrderDetail orderDetail = orderCommonService.detail(orderId);
        return CommonResult.success(orderDetail);
    }

    @ApiOperation("查询 - 系统分派订单")
    @GetMapping("/distribute/list")
    public CommonResult<List<YxxOrderInfo>> queryDistributeOrder() {
        YxxWorker worker = workerService.getCurrentWorker();
        return CommonResult.success(orderCommonService.queryDistributeOrder(worker));
    }

    @ApiOperation("查询 - 分页查询抢单大厅订单")
    @GetMapping("/rush/list")
    public CommonResult<CommonPage<YxxOrderInfo>> queryRushOrder(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(required = false, defaultValue = "5") Integer pageSize) {

        List<YxxOrderInfo> orderList = orderCommonService.queryRushOrders(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("订单流程 - 确认接单")
    @PostMapping(value = "/accept")
    public CommonResult accept(Long orderId) {
        int x = yxxAppOrderService.accept(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 拒绝接单")
    @PostMapping(value = "/refuse")
    public CommonResult refuse(Long orderId) {
        int x = yxxAppOrderService.refuse(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 抢单")
    @PostMapping(value = "/rush")
    public CommonResult rush(Long orderId) {
        int x = yxxAppOrderService.rush(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("抢单失败");
    }

    @ApiOperation("订单流程 - 出发")
    @PostMapping(value = "/set-off")
    public CommonResult setOff(Long orderId) {
        int x = yxxAppOrderService.setOff(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 已到达")
    @PostMapping(value = "/arrive")
    public CommonResult arrive(Long orderId) {
        int x = yxxAppOrderService.arrive(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 提交报价")
    @PostMapping(value = "/price")
    public CommonResult price(@RequestBody OrderPrice orderPrice) {
        int x = yxxAppOrderService.confirmPrice(orderPrice);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("维修工单 - 提交")
    @PostMapping(value = "/repair-record/create")
    public CommonResult repairCreate(@RequestBody YxxRepairRecord repairRecord) {
        int x = yxxAppOrderService.repairRecordCreate(repairRecord);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("维修工单 - 查询")
    @GetMapping(value = "/repair-record/query")
    public CommonResult<YxxRepairRecord> repairRecordQuery(Long orderId) {
        return CommonResult.success(yxxAppOrderService.repairRecordQuery(orderId));
    }

    @ApiIgnore
    @ApiOperation("维修工单 - 更新")
    @PostMapping(value = "/repair-record/update")
    public CommonResult repairRecordUpdate(@RequestBody YxxRepairRecord repairRecord) {
        int x = yxxAppOrderService.repairRecordUpdate(repairRecord);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiIgnore
    @ApiOperation("维修工单 - 删除")
    @PostMapping(value = "/repair-record/delete")
    public CommonResult repairRecordDelete(Long id) {
        int x = yxxAppOrderService.repairRecordDelete(id);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 维修完成")
    @PostMapping(value = "/repair/finish")
    public CommonResult repairFinish(Long orderId) {
        int x = yxxAppOrderService.repairFinish(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 订单暂缓")
    @PostMapping(value = "/pause")
    public CommonResult pause(@RequestParam Long orderId, String reason) {
        Integer count = yxxAppOrderService.pause(orderId);
        return CommonResult.success(count);
    }

}
