package com.wangrui.test;

import org.junit.Test;

public class ApiTest {

    @Test
    public void test_LoginSsoDecorator() {
        //装饰器 就是把需要扩展的类传进来 然后调用他的方法 然后在他方法的结果上面进行自己逻辑的扩展 而不是直接继承原来的类重写原来的类
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }

}