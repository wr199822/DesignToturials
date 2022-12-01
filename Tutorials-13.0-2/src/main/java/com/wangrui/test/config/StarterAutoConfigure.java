package com.wangrui.test.config;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangrui
 * @description  这个类的作用是把starterService 注入到bean容器中
 * @date 2022年11月23日 11:19
 */
@Configuration
@ConditionalOnClass(StarterService.class)   //这个注解作用就是只有当starterService在包路径下时才会把 StarterAutoConfigure注册到bean容器  这个是为了starter注入准备的
@EnableConfigurationProperties(StarterServiceProperties.class)  //这个注解的作用是：使 使用 @ConfigurationProperties 注解的类生效。 确保配置文件中的属性注入成功了  https://www.jianshu.com/p/7f54da1cb2eb
public class StarterAutoConfigure {


    //https://developer.aliyun.com/article/912763 讲解了ConfigurationProperties作用

    @Autowired
    private StarterServiceProperties properties;

    //通过ConditionalOnClass注解 让这个当做starter中间件被引用时才会注入spring容器
    @Bean
    @ConditionalOnMissingBean  //这个注解就是确保你的bean在容器中是单例的  容器中只能出现这一个bean
    @ConditionalOnProperty(prefix = "itstack.door", value = "enabled", havingValue = "true")  //这个注解的作用是  当配置信息的  ennabled是true的时候 就生成这个starterService  bean
    StarterService starterService(){
        return new StarterService(properties.getUserStr());
    }

}
