package com.framework.order;


import com.framework.order.service.impl.TestImpl1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableSwagger2
//@EnableFeignClients
//@EnableDiscoveryClient
@ComponentScan(basePackages = "com.framework")
//@MapperScan(basePackages = "com.framework.order.dao.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @ConditionalOnMissingBean(
            type = "com.framework.order.service.api.ITest")
    public TestImpl1 testBean() {
        return new TestImpl1();
    }

}
