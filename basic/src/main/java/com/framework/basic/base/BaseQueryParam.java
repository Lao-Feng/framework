package com.framework.basic.base;

import lombok.Data;

/**
 * 基础的分页查询参数
 *
 * @Author: FengJie
 * @Date: 2019/4/12 9:33
 */
@Data
public class BaseQueryParam {

    private Integer pageNum;
    private Integer pageSize;

    @SuppressWarnings("unchecked")
    public <T extends BaseQueryParam> T withPageNum(Integer pageNum) {
        setPageNum(pageNum);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseQueryParam> T withPageSize(Integer pageSize) {
        setPageSize(pageSize);
        return (T) this;
    }
}
