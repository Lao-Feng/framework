package com.framework.order.dao.entity;

import com.framework.basic.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Fengjie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_order")
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends BaseEntity {

    @Id
    private Long id;
}