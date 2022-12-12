package com.wangrui.test;

/**
 * @author wangrui
 * @description
 * @date 2022年12月01日 16:48
 */
public class ActivityController {
    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id){
        Activity acticity = ActivityFactory.getActicity(id);
        //模拟从Redis中获取库存变化信息
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        acticity.setStock(stock);
        return acticity;
    }
}
