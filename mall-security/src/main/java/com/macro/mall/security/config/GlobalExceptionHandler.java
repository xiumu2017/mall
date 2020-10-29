package com.macro.mall.security.config;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.exception.ApiException;
import com.macro.mall.common.exception.ParamValidateFailException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author macro
 * @date 2020/2/27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ParamValidateFailException.class)
    @ResponseBody
    public CommonResult handleParamValidateFail(ParamValidateFailException exception) {
        return CommonResult.validateFailed(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UsernameNotFoundException.class)
    public CommonResult handleUsernameNotFoundException(UsernameNotFoundException exception) {
        return CommonResult.unauthorized(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult handleValidException(MethodArgumentNotValidException e) {
        return CommonResult.validateFailed(getMsg(e.getBindingResult()));
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public CommonResult handleValidException(BindException e) {
        return CommonResult.validateFailed(getMsg(e.getBindingResult()));
    }

    private String getMsg(BindingResult bindingResult) {
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return message;
    }
}
