package com.wangrui.test.agent;

import java.lang.annotation.*;

/**
 * @author wangrui
 * @date 2022/12/4
 * @Description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {
    String value() default "";  // sql语句
}
