package com.store.storeend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @className: RedisUtil
 * @description:
 * @author: 15506
 * @date: 2024/2/12 20:28
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    // 写入缓存
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 写入缓存，并设置过期时间
    public void set(String key, Object value, long timeoutSeconds) {
        redisTemplate.opsForValue().set(key, value, timeoutSeconds, TimeUnit.SECONDS);
    }

    // 读取缓存
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 删除缓存
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // 写入 List 类型的缓存
    public void lSet(String key, List<Object> values) {
        redisTemplate.opsForList().leftPushAll(key, values);
    }

    // 读取 List 类型的缓存
    public List<Object> lGet(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    // 写入 Set 类型的缓存
    public void sSet(String key, Set<Object> values) {
        redisTemplate.opsForSet().add(key, values.toArray());
    }

    // 读取 Set 类型的缓存
    public Set<Object> sGet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    // 写入 Hash 类型的缓存
    public void hSet(String key, Map<String, Object> values) {
        redisTemplate.opsForHash().putAll(key, values);
    }

    // 读取 Hash 类型的缓存
    public Map<Object, Object> hGet(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    // 添加 ZSet 类型的缓存
    public void zSet(String key, Set<ZSetOperations.TypedTuple<Object>> values) {
        redisTemplate.opsForZSet().add(key, values);
    }

    // 读取 ZSet 类型的缓存
    public Set<Object> zGet(String key) {
        return redisTemplate.opsForZSet().range(key, 0, -1);
    }
}
