package com.wangrui.test.design.factory;

import com.wangrui.test.design.workshop.ICacheAdapter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxyFactory {

    //这一步就是抽象工厂的关键   getProxy  得到不同的redis的实例
    public static <T> T getProxy(Class<T> cacheClazz, Class<? extends ICacheAdapter> cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter.newInstance());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{cacheClazz}, handler);
    }

}