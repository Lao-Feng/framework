package com.framework.core.enums;

import com.framework.core.base.ResultCode;
import lombok.AllArgsConstructor;

/**
 * 通用的响应码,如需扩展,或者从新实现/继承{@link ResultCode}接口
 *
 * @Author: FengJie
 * @Date: 2019/4/29 9:59
 */
@AllArgsConstructor
public enum BaseResultCode implements ResultCode {

    /**
     * 异常信息
     */

    FAILED(-1, "操作失败"),
    SUCCESS(0, "操作成功"),
    NO_DATA(1, "没有数据"),
    /**
     * 内部异常
     */
    SYS_ERROR(2, "系统异常"),
    RESUBMIT(100, "重复提交"),
    PARAMS_ERROR(101, "请求参数错误"),
    /**
     * 请求模式异常
     */
    METHOD_ERROR(102, "请求模式异常，不支持的请求模式"),
    /**
     * 网络异常
     */
    NETWORK_ERROR(103, "网络异常");

    private Integer code;
    private String msg;

    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }
}
