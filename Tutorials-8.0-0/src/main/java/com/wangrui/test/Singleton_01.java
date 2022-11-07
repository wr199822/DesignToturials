package com.wangrui.test;

/**
 * @author wangrui
 * @description
 * @date 2022年11月07日 10:30
 */
public class Singleton_01 {
    private static Singleton_01 instance;

    private Singleton_01(){

    }

    public static Singleton_01 getInstance(){
        if (null != instance) return instance;
        instance = new Singleton_01();
        return instance;
    }
}
