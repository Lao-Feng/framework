package com.framework.basic.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基础响应实体
 *
 * @Author: FengJie
 * @Date: 2019/4/12 9:23
 */
@Data
public class BaseResponseData {

    @ApiModelProperty(value = "创建用户id", required = true, example = "12345678")
    private Long createBy;

    @ApiModelProperty(value = "修改用户id", required = true, example = "12345678")
    private Long updateBy;

    @ApiModelProperty(value = "创建时间", required = true, example = "2019-4-12 9:25:00")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间", required = true, example = "2019-4-12 9:25:00")
    private LocalDateTime updateTime;

    @SuppressWarnings("unchecked")
    public <T extends BaseResponseData> T withCreateBy(Long id) {
        setCreateBy(id);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseResponseData> T withUpdateBy(Long id) {
        setUpdateBy(id);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseResponseData> T withCreateTime(LocalDateTime createTime) {
        setCreateTime(createTime);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseResponseData> T withUpdateTime(LocalDateTime updateTime) {
        setUpdateTime(updateTime);
        return (T) this;
    }
}
