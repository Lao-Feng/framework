package com.framework.core.base;

/**
 * 基本的响应状态
 * 每个业务模块可以实现该接口,同时也可以继承该接口来扩展
 *
 * @author 冯杰
 */
public interface ResultCode {

    /**
     * 唯一码
     *
     * @return 返回唯一码
     */
    Integer code();

    /**
     * 消息
     *
     * @return 返回消息
     */
    String msg();
}
