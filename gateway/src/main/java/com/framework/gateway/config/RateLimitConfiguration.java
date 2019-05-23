package com.framework.gateway.config;

import com.framework.gateway.filter.GatewayRateLimitFilterByCpu1;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 限流默认配置
 *
 * @author: FengJie
 * @date: 2019/5/23 0:26
 */
@Configuration
public class RateLimitConfiguration {

    @Autowired
    GatewayRateLimitFilterByCpu1 rateLimit;

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/order/**")
                        .filters(f -> f.filter(rateLimit))
                        .uri("lb://order")
                        .id("rateLimit_CPU1")
                ).build();
    }
}
