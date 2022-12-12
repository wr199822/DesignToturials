package com.example.test.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayCypher implements IPay{

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    public boolean security(String uId) {
        logger.info("密码支付，风控校验环境安全");
        return true;
    }

}