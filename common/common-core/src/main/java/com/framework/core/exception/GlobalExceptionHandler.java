package com.framework.core.exception;

import com.framework.core.base.Result;
import com.framework.core.base.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常捕获处理
 */
@Slf4j
@Component
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ServiceException.class)
    public Result handle(ServiceException e) {
        log.error("发生:[Service异常],异常码:{},异常描述:{},", e.getErrorCode(), e.getErrorMsg(), e);
        return Results.fail(e);
    }
}