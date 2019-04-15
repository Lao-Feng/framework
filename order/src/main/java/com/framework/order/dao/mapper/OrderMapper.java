package com.framework.order.dao.mapper;

import com.framework.order.dao.entity.OrderEntity;
import com.framework.order.dao.param.OrderQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单查询接口
 *
 * @Author: FengJie
 * @Date: 2019/4/11 18:04
 */
public interface OrderMapper {

    /**
     * 查询订单详情
     *
     * @param id 参数参数
     * @return 订单详情
     */
    OrderEntity get(@Param("id") Long id);


    /**
     * 查询订单类别
     *
     * @param param 查询参数
     * @return 订单列表
     */
    List<OrderEntity> query(OrderQueryParam param);
}
