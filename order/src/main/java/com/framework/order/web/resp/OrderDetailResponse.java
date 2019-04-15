package com.framework.order.web.resp;

import com.framework.basic.base.BaseResponse;
import com.framework.basic.base.BaseResponseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 获取订单详情响应
 *
 * @Author: FengJie
 * @Date: 2019/4/12 10:07
 */

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "订单详情响应参数")
public class OrderDetailResponse extends BaseResponse {

    private OrderDetailData data;

    @Data
    @Builder
    @EqualsAndHashCode(callSuper = true)
    public static class OrderDetailData extends BaseResponseData {

        @ApiModelProperty(value = "订单id", required = true, example = "123456")
        private Long id;
    }
}
