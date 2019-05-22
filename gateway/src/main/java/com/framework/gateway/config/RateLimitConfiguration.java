package com.framework.gateway.config;

import com.framework.gateway.filter.GatewayRateLimitFilterByCpu1;
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


    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/rateLimit/")
                        .filters(f -> f.filter(new GatewayRateLimitFilterByCpu1()))
                        .uri("http://localhost:8000/hello/rateLimit")
                        .id("rateLimit_route")
                ).build();
    }
}
