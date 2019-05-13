package com.framework.core.exception;

import com.framework.core.base.ResultCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 基础异常类
 * 所有的异常信息全部继承该类,实现异常统一管理
 *
 * @Author: FengJie
 * @Date: 2019/4/10 16:46
 */
@Getter
@NoArgsConstructor
public class ServiceException extends RuntimeException {

    private Integer errorCode;
    private String errorMsg;

    public ServiceException(String message) {
        super(message);
        errorMsg = message;
    }

    public ServiceException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ServiceException(ResultCode error) {
        errorCode = error.code();
        errorMsg = error.msg();
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
