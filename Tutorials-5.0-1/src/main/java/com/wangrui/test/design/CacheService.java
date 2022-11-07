package com.wangrui.test.design;

import java.util.concurrent.TimeUnit;

/**
 * @author wangrui
 * @date 2022/11/5
 * @Description  抽象工厂设计模式
 */
public interface CacheService {


    String get(final String key, int redisType);

    void set(String key, String value, int redisType);

    void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType);

    void del(String key, int redisType);
}
