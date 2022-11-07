package com.wangrui.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangrui
 * @description CAS「AtomicReference」(线程安全)
 * @date 2022年11月07日 14:00
 */
public class Singleton_06 {

    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<Singleton_06>();

    private Singleton_06(){

    }

    public static final Singleton_06 getInstance(){
        for (; ; ){
            Singleton_06 instance = INSTANCE.get();
            if (null != instance) return instance;
            INSTANCE.compareAndSet(null,new Singleton_06());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton_06.getInstance());
        System.out.println(Singleton_06.getInstance());
    }



}
