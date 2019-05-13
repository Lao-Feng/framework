package com.framework.redis.config;//package com.framework.redis.config;

import lombok.val;
import lombok.var;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * Redis 缓存序列号配置
 *
 * @Author: FengJie
 * @Date: 2019/5/7 23:19
 */
@Configuration
@EnableCaching
public class RedisSerializerAutoConfiguration extends CachingConfigurerSupport {

    /**
     * 初始化Redis的默认序列化方式,默认使用{@link KryoRedisSerializer},因为体积更小,速度更快
     * 可以使用{@link FastJsonRedisSerializer}或者扩展更多的序列化
     */
    @Bean
    @SuppressWarnings("unchecked")
    @ConditionalOnMissingBean(
            type = "com.framework.redis.config.RedisSerialization")
    public RedisCacheConfiguration redisCacheConfiguration() {
        var configuration = RedisCacheConfiguration.defaultCacheConfig();
        //如需使用更过的序列化,只需要在这里设置即可
        val pair = RedisSerializationContext.SerializationPair.fromSerializer(
                new KryoRedisSerializer(Object.class));
        configuration.serializeValuesWith(pair);
        return configuration;
    }
}
