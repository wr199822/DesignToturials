package com.wangrui.test.store;

import java.util.Map;

/**
 * @author wangrui
 * @description
 * @date 2022年11月04日 15:06
 */
public interface ICommodity {
    void sendCommodity(String uId,String commodityId,String bizId, Map<String, String> extMap) throws Exception;
}
