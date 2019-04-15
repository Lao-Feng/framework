package com.framework.basic.base;

import com.framework.basic.enumeration.ResultStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:03
 * @Description: 基础响应实体
 */
@Data
@ApiModel("基础响应实体")
public class BaseResponse {

    @ApiModelProperty(value = "响应码", required = true, example = "200")
    private Integer resultCode;

    @ApiModelProperty(value = "响应消息", required = true, example = "成功")
    private String resultMsg;

    public static BaseResponse of() {
        return new BaseResponse();
    }

    public <T extends BaseResponse> T withResultSuccess() {
        return withResultStatus(ResultStatus.SUCCESS);
    }

    public <T extends BaseResponse> T withResultStatus(ResultStatus status) {
        return withResultCode(status.getResultCode()).withResultMsg(status.getResultMsg());
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseResponse> T withResultCode(Integer resultCode) {
        setResultCode(resultCode);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseResponse> T withResultMsg(String resultMsg) {
        setResultMsg(resultMsg);
        return (T) this;
    }
}
