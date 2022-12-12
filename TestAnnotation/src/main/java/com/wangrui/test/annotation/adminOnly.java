package com.wangrui.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangrui
 * @date 2022/11/23
 * @Description  切面  使用了此注解的方法或者类就会被增强
 */
@Retention(RetentionPolicy.RUNTIME)  //运行的生命周期在
@Target(ElementType.METHOD)  //运用在方法上
public @interface adminOnly {
}
