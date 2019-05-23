package com.framework.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * 根据CPU的使用情况限流1
 * <p>
 * 这里是通过sigar脚本获取CPU的信息,这个方式优于{@link GatewayRateLimitFilterByCpu}
 * 在使用该方式的时候,需要注意拷贝 dll 文件到java/bin目录下
 * <p>
 * 步骤
 * 1. 下载jar(主要是使用里面的 .dll)
 * 2. 解压jar,根据不同的操作系统将文件拷贝到对应的目录,如下
 * windows: https://blog.csdn.net/xueba8/article/details/78884989
 * linux: https://blog.csdn.net/hackxiaoF/article/details/46969737
 *
 * @author: FengJie
 **/
@Slf4j
@Component
public class GatewayRateLimitFilterByCpu1 implements RateLimitFilter {
    /**
     * cpu最大使用量
     */
    @Value("${cpu.maxUsage:0.8D} ")
    private Double maxUsage;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取CPU使用情况
        Sigar sigar = new Sigar();
        try {
            //使用率
            double usageRate = Arrays.stream(sigar.getCpuPercList())
                    .mapToDouble(CpuPerc::getCombined).average()
                    .orElse(0);

            //判断是否限流
            if (usageRate > maxUsage) {
                exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                return exchange.getResponse().setComplete();
            }
        } catch (SigarException e) {
            log.error("获取CPU资源信息失败,", e);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
