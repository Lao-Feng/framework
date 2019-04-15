package com.framework.order.dao.param;

import com.framework.basic.base.BaseQueryParam;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单操作参数
 *
 * @Author: FengJie
 * @Date: 2019/4/11 18:04
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class OrderQueryParam extends BaseQueryParam {

    private Long id;
}



