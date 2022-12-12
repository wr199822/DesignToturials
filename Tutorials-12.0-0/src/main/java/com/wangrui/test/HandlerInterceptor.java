package com.wangrui.test;

public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}