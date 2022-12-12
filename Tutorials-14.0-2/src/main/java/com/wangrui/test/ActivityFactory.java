package com.wangrui.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangrui
 * @description
 * @date 2022年12月01日 16:07
 */
public class ActivityFactory {

    //这个就是一个享元模式  就是 把对象存起来 然后在用的地方在把这些对象拿出来
    static Map<Long,Activity> activityMap = new HashMap<Long,Activity>();

    public static Activity getActicity(Long id){
        Activity activity = activityMap.get(id);

        if (null == activity){
            //模拟从实际业务应用从接口中获取活动信息
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("图书嗨乐");
            activity.setDesc("图书优惠券分享激励分享活动第二期");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }
        return activity;
    }

}
