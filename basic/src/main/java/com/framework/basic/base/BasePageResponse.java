package com.framework.basic.base;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:25
 * @Description: 基础分页响应参数
 */
@Data
@ApiModel("基础分页响应参数")
public class BasePageResponse extends BaseResponse {
    @ApiModelProperty(value = "当前页数", required = true, example = "1")
    private Integer pageNum;

    @ApiModelProperty(value = "每页记录数", required = true, example = "10")
    private Integer pageSize;

    @ApiModelProperty(value = "记录总数", required = true, example = "100")
    private Long total;

    public static BasePageResponse of() {
        return new BasePageResponse();
    }

    @SuppressWarnings("unchecked")
    public <T extends BasePageResponse, K> T withPage(Page<K> page) {
        setPageNum(page.getPageNum());
        setPageSize(page.getPageSize());
        setTotal(page.getTotal());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BasePageResponse> T withPageNum(Integer pageNum) {
        setPageNum(pageNum);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BasePageResponse> T withPageSize(Integer pageSize) {
        setPageSize(pageSize);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BasePageResponse> T withTotal(Long total) {
        setTotal(total);
        return (T) this;
    }
}
