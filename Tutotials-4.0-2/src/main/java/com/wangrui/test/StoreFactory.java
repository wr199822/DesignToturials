package com.wangrui.test;

import com.wangrui.test.store.ICommodity;
import com.wangrui.test.store.impl.CardCommodityService;
import com.wangrui.test.store.impl.CouponCommodityService;
import com.wangrui.test.store.impl.GoodsCommodityService;

/**
 * @author wangrui
 * @description   工厂方法设计模式
 * @date 2022年11月04日 15:05
 */
public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }

}
