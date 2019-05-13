package com.framework.core.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:03
 * @Description: 基础响应实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;
    @Deprecated
    private String message;
    private T data;

}
