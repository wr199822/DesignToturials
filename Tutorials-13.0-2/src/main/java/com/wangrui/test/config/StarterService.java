package com.wangrui.test.config;

import org.springframework.util.StringUtils;

/**
 * @author wangrui
 * @description  中间件的意思 应该是 其他项目要用直接打成pom包引入的意思吧
 * @date 2022年11月23日 11:19
 */
public class StarterService {

    private String userStr;

    public StarterService(String userStr){
        this.userStr = userStr;
    }

    public String[] split(String separatorChar){
        return StringUtils.split(this.userStr,separatorChar);
    }
}
