package com.wangrui.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangrui
 * @description 适配器模式  查询用户内部下单数量接口
 * @date 2022年11月08日 14:49
 */
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId){
        logger.info("自营商家，查询用户的订单是否为首单：{}",userId);
        return 10L;
    }
}
