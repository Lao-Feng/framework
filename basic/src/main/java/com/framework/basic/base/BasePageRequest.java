package com.framework.basic.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:22
 * @Description: 基础分页请求参数
 */
@Data
@ApiModel(description = "基础分页参数")
public class BasePageRequest {

    @NotNull(message = "当前页数不能为空")
    @Min(value = 1, message = "当前页数必须不小于1")
    @ApiModelProperty(value = "当前页数", required = true, example = "1")
    private Integer pageNum;

    @NotNull(message = "每页记录数不能为空")
    @Min(value = 1, message = "每页记录数必须不小于1")
    @ApiModelProperty(value = "每页记录数", required = true, example = "10")
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
