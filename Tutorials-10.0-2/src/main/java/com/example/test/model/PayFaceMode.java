package com.example.test.model;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class PayFaceMode implements IPay{

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    public boolean security(String uId) {
        logger.info("人脸支付，风控校验脸部识别");
        return true;
    }

}