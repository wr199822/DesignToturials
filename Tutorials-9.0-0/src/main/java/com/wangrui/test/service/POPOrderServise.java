package com.wangrui.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangrui
 * @description
 * @date 2022年11月08日 14:53
 */
public class POPOrderServise {

    private Logger logger = LoggerFactory.getLogger(POPOrderServise.class);

    public boolean isFirstOrder(String uId) {
        logger.info("POP商家，查询用户的订单是否为首单：{}", uId);
        return true;
    }
}
