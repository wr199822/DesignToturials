package com.wangrui.test.application;

import java.util.concurrent.TimeUnit;

/**
 * @author wangrui
 * @date 2022/11/5
 * @Description  抽象工厂设计模式
 */
public interface CacheService {


    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
