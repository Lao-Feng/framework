package com.framework.core.base;


import com.framework.core.enums.BaseResultCode;

/**
 * 响应工具
 *
 * @Author: FengJie
 * @Date: 2019/4/29 14:15
 */
public class Results {

    public static Result success() {
        return success(null);
    }

    public static <T> Result success(T data) {
        return Result.builder()
                .code(BaseResultCode.SUCCESS.code())
                .message(BaseResultCode.SUCCESS.msg())
                .data(data)
                .build();
    }

    public static Result fail(ResultCode status) {
        return Result.builder()
                .code(status.code())
                .message(status.msg())
                .build();
    }

    public static Result fail(Throwable error) {
        return Result.builder()
                .code(BaseResultCode.FAILED.code())
                .message(error.getMessage())
                .build();
    }

    public static Result fail(Integer code, String resultMsg) {
        return Result.builder()
                .code(code)
                .message(resultMsg)
                .build();
    }
}
