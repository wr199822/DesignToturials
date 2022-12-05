package com.wangrui.test;

import com.alibaba.fastjson.JSON;
import com.wangrui.test.mq.Create_account;

/**
 * @author wangrui
 * @date 2022/11/8
 * @Description    这个例子就是每次都自己处理返回的数据
 */
public class create_accountMqService {

    public void onMessage(String message){
        Create_account mq = JSON.parseObject(message, Create_account.class);

        mq.getNumber();
        mq.getAccountDate();

        // ...处理自己的业务
    }
}
