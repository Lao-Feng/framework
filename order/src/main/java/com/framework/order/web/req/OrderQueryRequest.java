package com.framework.order.web.req;

import com.framework.basic.base.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单列表查询请求参数
 *
 * @Author: FengJie
 * @Date: 2019/4/12 9:44
 */
@Data
@ApiModel("订单列表查询请求")
@EqualsAndHashCode(callSuper = true)
public class OrderQueryRequest extends BasePageRequest {

    @ApiModelProperty(value = "订单id", example = "12345678")
    private Long id;
}
