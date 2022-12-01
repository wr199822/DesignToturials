package com.wangrui.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangrui
 * @description
 * @date 2022年11月23日 11:19
 */
@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {

    //这个是配置文件中的那个配置的名称
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
