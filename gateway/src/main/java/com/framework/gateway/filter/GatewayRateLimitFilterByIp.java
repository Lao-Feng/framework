//package com.framework.gateway.filter;
//
//import io.github.bucket4j.Bandwidth;
//import io.github.bucket4j.Bucket;
//import io.github.bucket4j.Bucket4j;
//import io.github.bucket4j.Refill;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.time.Duration;
//import java.util.Map;
//import java.util.Objects;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * 根据ip限流
// *
// * @author FengJie
// */
//@Slf4j
//public class GatewayRateLimitFilterByIp implements RateLimitFilter {
//    /**
//     * 单机网关限流用一个ConcurrentHashMap来存储 bucket，
//     * 如果是分布式集群限流的话，可以采用 Redis等分布式解决方案
//     */
//    private static final Map<String, Bucket> LOCAL_CACHE = new ConcurrentHashMap<>();
//    /**
//     * 桶的最大容量，即能装载 Token 的最大数量
//     */
//    private int capacity;
//    /**
//     * 每次 Token 补充量
//     */
//    private int refillTokens;
//    /**
//     * 补充 Token 的时间间隔
//     */
//    private Duration refillDuration;
//
//    private Bucket createNewBucket() {
//        Refill refill = Refill.of(refillTokens, refillDuration);
//        Bandwidth limit = Bandwidth.classic(capacity, refill);
//        return Bucket4j.builder().addLimit(limit).build();
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String ip = Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress();
//        Bucket bucket = LOCAL_CACHE.computeIfAbsent(ip, k -> createNewBucket());
//        log.debug("IP:{} ,令牌通可用的Token数量:{} ", ip, bucket.getAvailableTokens());
//        if (bucket.tryConsume(1)) {
//            return chain.filter(exchange);
//        }
//        //当可用的令牌书为0是，进行限流返回429状态码
//        exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
//        return exchange.getResponse().setComplete();
//    }
//
//    @Override
//    public int getOrder() {
//        return -1000;
//    }
//}
