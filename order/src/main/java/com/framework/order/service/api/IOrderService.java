package com.framework.order.service.api;

import com.framework.order.dao.entity.OrderEntity;
import com.framework.order.dao.param.OrderParam;
import com.github.pagehelper.Page;

/**
 * 订单业务接口
 *
 * @Author: FengJie
 * @Date: 2019/4/11 17:47
 */
public interface IOrderService {

    /**
     * 查询订单详情
     *
     * @param id 订单id
     * @return 订单详情
     */
    OrderEntity get(Long id);

    /**
     * 分页查询订单列表
     *
     * @param param 查询条件
     * @return 响应实体
     */
    Page<OrderEntity> query(OrderParam param);
}
