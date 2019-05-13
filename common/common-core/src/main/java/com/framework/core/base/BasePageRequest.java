package com.framework.core.base;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:22
 * @Description: 基础分页请求参数
 */
@Data
public class BasePageRequest {

    @NotNull(message = "当前页数不能为空")
    @Min(value = 1, message = "当前页数必须不小于1")
    private Integer pageNum;

    @NotNull(message = "每页记录数不能为空")
    @Min(value = 1, message = "每页记录数必须不小于1")
    private Integer pageSize;

    public static BasePageRequest of() {
        return new BasePageRequest();
    }

    @SuppressWarnings("unchecked")
    public <T extends BasePageRequest> T withPageNum(Integer pageNum) {
        setPageNum(pageNum);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BasePageRequest> T withPageSize(Integer pageSize) {
        setPageSize(pageSize);
        return (T) this;
    }
}
