package com.framework.order.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo
 *
 * @author: FengJie
 * @date: 2019/5/10 0:12
 */
@RestController
public class Demo {

    @GetMapping("test")
    public String test() {
        System.out.println("test");
        return "test";
    }
}
