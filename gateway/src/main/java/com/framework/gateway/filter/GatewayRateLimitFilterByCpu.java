package com.framework.gateway.filter;//package com.framework.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * 根据CPU的使用情况限流
 * <p>
 * 注意,由于CPU限流是依赖SpringBootActuator获取CPU资源的,
 * 但是actuator是对我暴露了查询内部资源的接口的,所以这里注意暴露敏感信息
 *
 * @author: FengJie
 **/
@Slf4j
@Component
public class GatewayRateLimitFilterByCpu implements RateLimitFilter {

    private static final String METRIC_NAME = "system.cpu.usage";
    private static final Double MAX_USAGE = 0.50D;
    @Autowired
    private MetricsEndpoint metricsEndpoint;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取CPU使用情况
        Double systemCpuUsage = metricsEndpoint.metric(METRIC_NAME, null)
                .getMeasurements()
                .stream()
                .filter(Objects::nonNull)
                .findFirst()
                .map(MetricsEndpoint.Sample::getValue)
                .filter(Double::isFinite)
                .orElse(0.0D);

        //判断是否限流
        if (systemCpuUsage > MAX_USAGE) {
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
