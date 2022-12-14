package com.wangrui.test.store.impl;

import com.alibaba.fastjson.JSON;
import com.wangrui.test.card.IQiYiCardService;
import com.wangrui.test.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author wangrui
 * @description 第三方兑换卡 奖品的发放
 * @date 2022年11月04日 15:07
 */
public class CardCommodityService implements ICommodity {
    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        iQiYiCardService.grantToken(queryUserMobile(uId),bizId);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }


    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
