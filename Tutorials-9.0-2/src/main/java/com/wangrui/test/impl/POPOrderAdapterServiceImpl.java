package com.wangrui.test.impl;

import com.wangrui.test.OrderAdapterService;
import com.wangrui.test.service.POPOrderServise;

/**
 * @author wangrui
 * @date 2022/11/8
 * @Description
 */
public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderServise popOrderService = new POPOrderServise();

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
