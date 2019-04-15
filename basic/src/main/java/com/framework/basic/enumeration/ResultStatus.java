package com.framework.basic.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 16:51
 * @Description: 响应码
 */
@Getter
@AllArgsConstructor
public enum ResultStatus {
    /**
     * 通用响应状态
     */
    SUCCESS(200, "成功"),
    FAIL_CHECK_USERNAME(110101, "用户名不存在"),
    FAIL_CHECK_PASSWORD(110102, "用户名或密码错误"),
    FAIL_CHECK_SESSION(110103, "用户登录已过期"),
    FAIL_CHECK_PERMISSION(110104, "用户操作已被禁止"),
    FAIL_CHECK_ARGUMENT(110105, "参数错误"),
    FAIL_CHECK_SIGNATURE(110106, "数据签名校验失败"),
    FAIL_DATA_ACCESS(110201, "数据不存在或无法访问"),
    FAIL_DATA_VALIDATE(110202, "数据验证错误"),
    FAIL_DATA_OPERATE(110203, "数据操作错误"),
    FAIL_UNKNOWN(999999, "服务器繁忙");

    private Integer resultCode;
    private String resultMsg;
}
