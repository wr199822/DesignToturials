package com.wangrui.test;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author wangrui
 * @date 2022/11/8
 * @Description
 */
public class MQAdapter {

    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    public static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        //RebateInfo 和MQ消息是一致的  就是统一MQ的消息接收格式  然后不同类型的MQ消息 对于这个固定格式就适配一下 有就使用 没有就为空
        //建造者模式是那部分代码是根据功能来适配 即使名字不一样功能一样也能适配
        for (String key : link.keySet()) {
            //拿到对象的属性值
            Object val = obj.get(link.get(key));
            //"set"+key.substring(0,1).toUpperCase()+key.substring(1) 这个就是凑setUid  String.class参数类型   invoke（执行对象,赋的值）;
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }

}
