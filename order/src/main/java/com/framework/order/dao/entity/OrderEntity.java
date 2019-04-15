package com.framework.order.dao.entity;


import com.framework.basic.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 订单实体对象
 *
 * @Author: FengJie
 * @Date: 2019/4/11 18:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderEntity extends BaseEntity {

    private Long id;
}
