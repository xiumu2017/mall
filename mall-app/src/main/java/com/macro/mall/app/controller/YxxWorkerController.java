package com.macro.mall.app.controller;

import com.macro.mall.app.domain.AppWorkerInfo;
import com.macro.mall.app.service.impl.YxxWorkerService;
import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * 会员登录注册管理Controller
 *
 * @author macro
 * @date 2018/8/3
 */
@Api(tags = "1.登录注册管理")
@RestController
@RequestMapping("/sso")
@Slf4j
public class YxxWorkerController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private final YxxWorkerService workerService;

    public YxxWorkerController(YxxWorkerService workerService) {
        this.workerService = workerService;
    }

    @ApiOperation("注册")
    @PostMapping(value = "/register")
    public CommonResult register(@RequestParam(required = false) String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode,
                                 @RequestParam(required = false) String invitationCode) {
        workerService.register(password, telephone, authCode, invitationCode);
        return CommonResult.success(null, "注册成功");
    }

    @ApiOperation("手机号登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String phone,
                              @RequestParam String password) {
        String token = workerService.login(phone, password);
        if (token == null) {
            return CommonResult.validateFailed("手机号或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取维修工信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResult<AppWorkerInfo> info(@ApiIgnore Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        AppWorkerInfo member = workerService.getWorkerInfo();
        return CommonResult.success(member);
    }

    @ApiOperation("接单开关切换")
    @PostMapping("/order/switch")
    @ApiImplicitParams({@ApiImplicitParam(name = "status", value = "开关：1接单0不接单")})
    public CommonResult changeRegion(Principal principal, Integer status) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        workerService.orderSwitch(status);
        return CommonResult.success("");
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    public CommonResult getAuthCode(@RequestParam String telephone) {
        String authCode = workerService.generateAuthCode(telephone);
        return CommonResult.success(authCode, "获取验证码成功");
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public CommonResult updatePassword(
            @ApiIgnore Principal principal,
            @RequestParam String password,
            @RequestParam String oldPass) {
        if (principal == null) {
            return CommonResult.forbidden(null);
        }
        workerService.updatePassword(password, oldPass);
        return CommonResult.success(null, "密码修改成功");
    }

    @ApiOperation("忘记密码")
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public CommonResult resetPassword(@RequestParam String telephone,
                                      @RequestParam String password,
                                      @RequestParam String authCode) {
        workerService.resetPass(telephone, password, authCode);
        return CommonResult.success(null, "密码修改成功");
    }


    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = workerService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
}
