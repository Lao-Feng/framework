package com.framework.redis.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获取所有KEY
     *
     * @param pattern
     * @return
     */
    public Collection<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除缓存
     *
     * @param key
     */
    public void delete(Collection<String> key) {
        redisTemplate.delete(key);
    }

    /**
     * 模糊删除
     *
     * @param prex 前匹配
     */
    public void deleteByPrex(String prex) {
        Set<String> keys = redisTemplate.keys(prex + "*");

        if (keys != null && keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 获取缓存值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取缓存值
     *
     * @param <T>
     * @param key
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        String value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            return null;
        }
        return JSON.parseObject(value, clazz);
    }

    /**
     * 添加缓存
     *
     * @param key
     * @param obj
     */
    public void set(String key, Object obj) {
        if (obj == null) {
            return;
        }
        String value = obj instanceof String ? (String) obj : JSON.toJSONString(obj);
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 添加缓存
     *
     * @param key
     * @param obj
     * @param timeout
     * @param unit
     */
    public void set(String key, Object obj, Long timeout, TimeUnit unit) {
        if (obj == null) {
            return;
        }
        String value = obj instanceof String ? (String) obj : JSON.toJSONString(obj);
        if (timeout != null) {
            redisTemplate.opsForValue().set(key, value, timeout, unit);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * 描述: 指定缓存的剩余时间，秒
     * 参数 ：@param key
     * 参数 ：@param timeout
     * 参数 ：@return
     * 返回结果： boolean
     * 作者： 余里
     * 时间： 2017年8月2日 上午11:37:23
     *
     * @throws
     * @version V1.0
     */
    public boolean expire(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }


}

