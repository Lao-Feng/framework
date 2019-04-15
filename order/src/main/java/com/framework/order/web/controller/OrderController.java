package com.framework.order.web.controller;

import com.framework.order.web.adapter.OrderAdapter;
import com.framework.order.web.req.OrderQueryRequest;
import com.framework.order.web.resp.OrderDetailResponse;
import com.framework.order.web.resp.OrderQueryResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * @Author: FengJie
 * @Date: 2019/4/10 18:06
 * @Description: web 端订单接口
 */
@Api(description = "WEB - 订单接口")
@RestController
@RequestMapping("/w/api/order/")
public class OrderController {

    @Autowired
    private OrderAdapter adapter;

    @GetMapping("1/get/{id}")
    @ApiOperation(value = "查询订单")
    @ApiResponse(code = 200, message = "OK", response = OrderDetailResponse.class)
    public OrderDetailResponse get(@PathVariable @NotNull(message = "订单号不能为空") Long id) {
        return adapter.get(id);
    }

    @PostMapping("1/query")
    @ApiOperation(value = "分页查询订单")
    @ApiParam(name = "req", required = true)
    @ApiResponse(code = 200, message = "OK", response = OrderQueryResponse.class)
    public OrderQueryResponse query(@RequestBody @Valid OrderQueryRequest req) {
        return adapter.query(req);
    }

}
