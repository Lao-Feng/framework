package com.framework.redis.config;

import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Redis 序列化接口
 * 提供了两种实现序列化方式,可以基于本接口扩展更多的序列化方式
 * 使用方式如{@link RedisSerializerAutoConfiguration}
 *
 * @Author: FengJie
 * @Date: 2019/5/8 15:22
 */
public interface RedisSerialization<T> extends RedisSerializer<T> {
}
