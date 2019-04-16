package com.framework.order.web.adapter;

import com.framework.order.dao.entity.OrderEntity;
import com.framework.order.dao.param.OrderParam;
import com.framework.order.service.api.IOrderService;
import com.framework.order.web.req.OrderQueryRequest;
import com.framework.order.web.resp.OrderDetailResponse;
import com.framework.order.web.resp.OrderQueryResponse;
import com.github.pagehelper.Page;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * 订单业务适配层
 *
 * @Author: FengJie
 * @Date: 2019/4/12 9:04
 */
@Component
public class OrderAdapter {

    @Autowired
    private IOrderService service;

    public OrderDetailResponse get(Long id) {
        return buildOrderDetail(service.get(id));
    }

    public OrderQueryResponse query(OrderQueryRequest request) {
        Page<OrderEntity> page = service.query(buildOrderParam(request));
        return buildOrderQueryResponse(page);
    }

    private OrderDetailResponse buildOrderDetail(OrderEntity entity) {
        return OrderDetailResponse.builder().data(
                OrderDetailResponse.OrderDetailData.builder()
                        .id(entity.getId())
                        .build()
                        .withCreateBy(entity.getCreateBy())
                        .withUpdateBy(entity.getUpdateBy())
                        .withCreateTime(entity.getCreateTime())
                        .withUpdateTime(entity.getUpdateTime()))
                .build()
                .withResultSuccess();
    }

    private OrderParam buildOrderParam(OrderQueryRequest request) {
        var param = OrderParam.builder()
                .pageNum(request.getPageNum())
                .pageSize(request.getPageSize())
                .build();
        param.setId(request.getId());
        return param;
    }

    private OrderQueryResponse buildOrderQueryResponse(Page<OrderEntity> page) {
        val data = page.stream()
                .map(entity ->
                        OrderQueryResponse.OrderQueryData.builder()
                                .id(entity.getId())
                                .build())
                .collect(Collectors.toList());
        return OrderQueryResponse.builder()
                .data(data)
                .build()
                .withPage(page)
                .withResultSuccess();
    }
}
