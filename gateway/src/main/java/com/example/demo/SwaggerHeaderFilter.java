package com.example.demo;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class SwaggerHeaderFilter implements GlobalFilter, Ordered {
    private static final String HEADER_NAME = "X-Forwarded-Prefix";
    public static final String API_URI = "/v2/api-docs";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
//        if(path.contains(API_URI)){
//            String basePath = path.substring(0, path.lastIndexOf(API_URI));
//            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
//            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
//            return chain.filter(newExchange);
//        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
