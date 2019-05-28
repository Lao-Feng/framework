//package com.framework.gateway.config;
//
//import com.framework.gateway.filter.GatewayRateLimitFilterByCpu1;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * 限流默认配置
// *
// * @author: FengJie
// * @date: 2019/5/23 0:26
// */
////@Configuration
//public class RateLimitConfiguration {
//
//    @Autowired
//    GatewayRateLimitFilterByCpu1 rateLimit;
//
//    //@Bean
//    //public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//    //    return builder.routes()
//    //            .route(r -> r.path("/order/**")
//    //                    .filters(f -> f.filter(rateLimit))
//    //                    .uri("lb://order")
//    //                    .id("rateLimit_CPU1")
//    //            ).build();
//    //}
//    //@Bean
//    //public RouteLocator customerRouteLocator1(RouteLocatorBuilder builder) {
//    //    return builder.routes()
//    //            .route(r -> r.path("/order/**")
//    //                    .filters(f -> f.filter(rateLimit))
//    //                    .uri("")
//    //            ).build();
//    //}
//}
