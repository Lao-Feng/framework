package com.framework.order.server.resp;

import com.framework.basic.base.BasePageResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 订单查询响应参数
 *
 * @Author: FengJie
 * @Date: 2019/4/12 9:16
 */
@Data
@Builder
@ApiModel(value = "订单查询响应")
@EqualsAndHashCode(callSuper = true)
public class OrderQueryResponse extends BasePageResponse {

    @ApiModelProperty(value = "订单列表", required = true)
    private List<OrderQueryData> data;

    @Data
    @Builder
    public static class OrderQueryData {

        @ApiModelProperty(value = "订单id", required = true, example = "12345678")
        private Long id;
    }
}
