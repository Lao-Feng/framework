package com.framework.gateway.filter;

import lombok.AllArgsConstructor;

/**
 * 限流的策略模式
 *
 * @author: FengJie
 * @date: 2019/6/5 22:21
 */
@AllArgsConstructor
public class RateLimitFilterStrategy {
    private RateLimitFilter rateLimitFilter;

    public RateLimitFilterStrategy() {
        this.rateLimitFilter = new GatewayRateLimitFilterByCpu1();
    }

    public RateLimitFilter get() {

        return rateLimitFilter;
    }

    public static void main(String[] args) {
    }
}
