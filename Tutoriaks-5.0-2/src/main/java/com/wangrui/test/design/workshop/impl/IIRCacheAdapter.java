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
public class IIRCacheAdapter implements ICacheAdapter {

    private IIR iir = new IIR();

    //这是在适配两个接口的方法名称差异  就是继承相同接口 然后再这个接口中调用不同redis对象相同功能的方法
    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }

}