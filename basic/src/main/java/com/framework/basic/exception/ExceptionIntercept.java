package com.framework.basic.exception;

import com.framework.basic.base.BaseResponse;
import com.framework.basic.enumeration.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:00
 * @Description: 全局异常处理拦截器
 */
@Slf4j
@ControllerAdvice
public class ExceptionIntercept {

    @ResponseBody
    @ExceptionHandler
    public BaseResponse handleException(Throwable e) {
        log.error("handle request error,error info: ", e);

        if (e instanceof BaseException) {
            return handleBaseException(e);
        } else if (e instanceof MethodArgumentNotValidException) {
            return handleArgumentException(e);
        } else if (e instanceof HttpMessageConversionException) {
            return handleConversionException(e);
        } else {
            return handleUnknownException();
        }
    }

    private BaseResponse handleBaseException(Throwable e) {
        val baseEx = (BaseException) e;
        return BaseResponse.of()
                .withResultCode(baseEx.getErrorCode())
                .withResultMsg(baseEx.getErrorMsg());
    }

    private BaseResponse handleArgumentException(Throwable e) {
        val argumentEx = (MethodArgumentNotValidException) e;
        val error = argumentEx.getBindingResult().getAllErrors().get(0);
        return BaseResponse.of()
                .withResultCode(ResultStatus.FAIL_CHECK_ARGUMENT.getResultCode())
                .withResultMsg(error.getDefaultMessage());
    }

    private BaseResponse handleConversionException(Throwable e) {
        return BaseResponse.of().withResultStatus(ResultStatus.FAIL_DATA_VALIDATE);
    }

    private BaseResponse handleUnknownException() {
        return BaseResponse.of().withResultStatus(ResultStatus.FAIL_UNKNOWN);
    }
}
