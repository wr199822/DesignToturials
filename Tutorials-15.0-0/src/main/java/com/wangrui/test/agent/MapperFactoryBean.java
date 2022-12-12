package com.wangrui.test.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wangrui
 * @date 2022/12/4
 * @Description  代理对象
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Logger logger  = LoggerFactory.getLogger(MapperFactoryBean.class);

    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        //这是匿名内部类的写法 应该这个handler只用这一次所以这样使用更加的简洁 这个应该是匿名内部类和lambert表达式合并的写法
        InvocationHandler handler = (proxy, method, args) -> {
            //得到方法中使用的注解
            Select select = method.getAnnotation(Select.class);
            //模拟 拿到sql语句处理流程
            logger.info("SQL：{}", select.value().replace("#{uId}", args[0].toString()));
            //返回结果
            return args[0] + ",小傅哥,bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！";
        };
        //返回的是被代理的对象
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface},handler);

    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
