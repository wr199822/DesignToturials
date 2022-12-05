package com.wangrui.test;

import com.alibaba.fastjson.JSON;
import com.wangrui.test.mq.OrderMq;

/**
 * @author wangrui
 * @date 2022/11/8
 * @Description
 */
public class OrderMqService {
    public void onMessage(String message){
        OrderMq mq= JSON.parseObject(message,OrderMq.class);


        mq.getUid();
        mq.getOrderId();
        mq.getCreateOrderTime();


        // 处理自己业务
    }
}
