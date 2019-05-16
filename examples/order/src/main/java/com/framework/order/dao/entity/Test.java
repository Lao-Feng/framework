package com.framework.order.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * TODO
 *
 * @Author: FengJie
 * @Date: 2019/5/16 14:27
 */
@Data
public class Test {
    @TableId
    private Integer id;
    private String userName;
}
