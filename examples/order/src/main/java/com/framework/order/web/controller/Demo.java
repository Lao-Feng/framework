package com.framework.order.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * demo
 *
 * @author: FengJie
 * @date: 2019/5/10 0:12
 */
@Controller
public class Demo {

    @RequestMapping("test")
    public void test() {
        System.out.println("test");
    }
}
