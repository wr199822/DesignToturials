package com.wangrui.test;

import com.alibaba.fastjson.JSON;
import com.wangrui.test.annotation.DoDoor;
import com.wangrui.test.config.StarterService;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wangrui
 * @description
 * @date 2022年11月23日 11:37
 */
//Aspect 就是切面 表示的是在哪里 织入的什么功能
@Aspect
@Component
public class DoJoinPoint {
    private Logger logger = LoggerFactory.getLogger(DoJoinPoint.class);

    @Autowired
    private StarterService starterService;

    //Pointcut 和 around 联合使用  相当于用在了 使用了DoDoor注解的地方
    @Pointcut("@annotation(com.wangrui.test.annotation.DoDoor)")
    public void aopPoint(){

    }

    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint jp) throws Throwable {
        //获取内容
        Method method = getMethod(jp);
        //这个方法就是拿到方法前面的注释
        DoDoor door = method.getAnnotation(DoDoor.class);
        //获取字段值   如果是多个值  应该如何取出自己想要得值
        String keyValue = getFiledValue(door.key(),jp.getArgs());
        logger.info("itstack door handler method：{} value：{}", method.getName(), keyValue);
        if (null == keyValue||"".equals(keyValue)) return jp.proceed();
        //配置内容  在白名单 或者key值为空就放行 执行目标方法 如果不在白名单中就返回错误信息
        String[] split = starterService.split(",");
        //白名单过滤
        for (String str : split){
            if (keyValue.equals(str)){
                return jp.proceed();
            }
        }

        return  returnObject(door,method);

    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return getClass(jp).getMethod(methodSignature.getName(),methodSignature.getParameterTypes());

    }

    private Class<? extends Object> getClass(JoinPoint jp) throws NoSuchMethodException {
        return jp.getTarget().getClass();
    }

    //返回对象
    private Object returnObject(DoDoor doGate, Method method) throws IllegalAccessException, InstantiationException {
        Class<?> returnType = method.getReturnType();
        String returnJson = doGate.returnJson();
        if ("".equals(returnJson)) {
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }


    //获取属性值
    private String getFiledValue(String filed, Object[] args) {
        String filedValue = null;
        for (Object arg : args) {
            try {

                //这里刚好是一个值  如果是多个值应该如何判断呢
                //如果是对象参数 应该可以把这个object转为具体的对象 然后通过get来调用
                //如果是多个参数  应该就要规定参数的传进来的顺序 在根据顺序来拿到目标值  也可以根据instanceof来稍微判断一下是什么类型
                if (null == filedValue || "".equals(filedValue)) {
                    if (arg instanceof Integer){
                        System.out.println("123");
                    }
                    filedValue = BeanUtils.getProperty(arg, filed);
                } else {
                    break;
                }
            } catch (Exception e) {
                if (args.length == 1) {
                    return args[0].toString();
                }
            }
        }
        return filedValue;
    }



}
