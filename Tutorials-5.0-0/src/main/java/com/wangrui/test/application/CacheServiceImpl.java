package com.wangrui.test.application;

import com.wangrui.test.redis.RedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author wangrui
 * @date 2022/11/5
 * @Description
 */
public class CacheServiceImpl implements CacheService{

    private RedisUtils redisUtils = new RedisUtils();

    public String get(String key) {
        return redisUtils.get(key);
    }

    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        redisUtils.del(key);
    }

}
