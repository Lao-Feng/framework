package com.framework.order.dao.repo;

import com.framework.basic.enumeration.ResultStatus;
import com.framework.basic.util.CheckUtils;
import com.framework.order.dao.entity.OrderEntity;
import com.framework.order.dao.mapper.OrderMapper;
import com.framework.order.dao.param.OrderQueryParam;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 订单持久化层
 *
 * @Author: FengJie
 * @Date: 2019/4/11 18:02
 */
@Repository
public class OrderRepoRepository {

    @Autowired
    private OrderMapper mapper;

    public OrderEntity get(Long id) {
        val entity = mapper.get(id);
        return CheckUtils.checkEntity(entity, ResultStatus.FAIL_DATA_ACCESS);
    }

    public Page<OrderEntity> query(OrderQueryParam param) {
        return PageHelper.startPage(param.getPageNum(), param.getPageSize()).doSelectPage(() -> mapper.query(param));
    }
}
