package com.wangrui.test.design.workshop.impl;

import com.wangrui.test.design.workshop.ICacheAdapter;


import java.util.concurrent.TimeUnit;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @date 2022/3/17
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class EGMCacheAdapter implements ICacheAdapter {

    //这是在适配两个接口的方法名称差异  就是继承相同接口 然后再这个接口中调用不同redis对象相同功能的方法
    private EGM egm = new EGM();

    public String get(String key) {
        return egm.gain(key);
    }

    public void set(String key, String value) {
        egm.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        egm.delete(key);
    }

}