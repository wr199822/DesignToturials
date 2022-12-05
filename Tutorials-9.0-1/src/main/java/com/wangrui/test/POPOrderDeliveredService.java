package com.wangrui.test;

import com.alibaba.fastjson.JSON;
import com.wangrui.test.mq.POPOrderDelivered;

/**
 * @author wangrui
 * @date 2022/11/8
 * @Description
 */
public class POPOrderDeliveredService {

    public void onMessage(String message){
        POPOrderDelivered mq = JSON.parseObject(message,POPOrderDelivered.class);

        mq.getuId();
        mq.getOrderId();
        mq.getOrderTime();


        //..处理自己的业务


    }
}
