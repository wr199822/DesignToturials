package com.wangrui.test.impl;

import com.wangrui.test.OrderAdapterService;
import com.wangrui.test.service.OrderService;

/**
 * @author wangrui
 * @date 2022/11/8
 * @Description 内部订单，判断首单逻辑
 */
public class InsideOrderServiceImpl implements OrderAdapterService {
    private OrderService orderService = new OrderService();

    //因为两个都实现了 相同的接口 到时候使用的时候就可以像依赖倒置那样使用 在方法中的参数写OrderAdapterService  然后传入具体的实现类 这样就可以利用多态调用自己的isFirst
    // 适配器的体现就是 本来是两个不同的类 但是因为都实现了OrderAdapterService接口 导致 使用的时候可以使用同一个方法名来进行两种逻辑
    //jt808协议那个代码里面 不同的包体的msg不就是适配器嘛
    public  boolean isFirst(String uId){
        return orderService.queryUserOrderCount(uId)<=1;
    }
}
