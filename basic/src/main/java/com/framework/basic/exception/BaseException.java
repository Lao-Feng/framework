package com.framework.basic.exception;

import com.framework.basic.enumeration.ResultStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 16:46
 * @Description: 基础异常类
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class BaseException extends RuntimeException {

    private Integer errorCode;
    private String errorMsg;

    public static BaseException of(ResultStatus error) {
        return of(error.getResultCode(), error.getResultMsg());
    }

    public static void sneakyThrows(ResultStatus error) {
        throw of(error.getResultCode(), error.getResultMsg());
    }

    public static void sneakyThrows(Integer errorCode, String errorMsg) {
        throw of(errorCode, errorMsg);
    }
}
