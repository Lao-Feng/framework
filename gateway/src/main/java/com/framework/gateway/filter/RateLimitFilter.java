package com.framework.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.core.Ordered;

/**
 * 自定义限流接口
 *
 * @author: FengJie
 * @date: 2019/5/22 22:56
 */
public interface RateLimitFilter extends GatewayFilter, Ordered {
}
