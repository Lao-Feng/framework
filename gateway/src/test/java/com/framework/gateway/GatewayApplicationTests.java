package com.framework.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayApplicationTests {
    @Value("${cpu.maxUsage:0.8D} ")
    private Double maxUsage;
    @Test
    public void contextLoads() {
        System.out.println(maxUsage);
    }

}
