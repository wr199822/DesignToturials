package com.example.test.channel;

import com.example.test.model.IPay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    protected IPay payMode;

    //这就是桥接模式的核心   这种形参是接口  实际传递具体实现类的方法就是依赖倒置原则
    public Pay(IPay payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}