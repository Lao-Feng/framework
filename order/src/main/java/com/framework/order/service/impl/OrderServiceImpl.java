package com.framework.order.service.impl;

import com.framework.order.dao.entity.OrderEntity;
import com.framework.order.dao.param.OrderParam;
import com.framework.order.dao.repo.OrderRepoRepository;
import com.framework.order.service.api.IOrderService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单业务接口实现类
 *
 * @Author: FengJie
 * @Date: 2019/4/11 17:51
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepoRepository repository;

    @Override
    public OrderEntity get(Long id) {
        return repository.get(id);
    }

    @Override
    public Page<OrderEntity> query(OrderParam param) {
        return repository.query(param);
    }
}
