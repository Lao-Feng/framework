package com.framework.order;


import com.framework.order.dao.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

    @Autowired
    ProductMapper mapper;

    @Test
    public void contextLoads() {
        List<com.framework.order.dao.entity.Test> tests = mapper.selectList(null);
        System.out.println(tests.toString());

    }

}
