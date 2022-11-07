package com.wangrui;

import com.wangrui.test.design.CacheService;
import com.wangrui.test.design.CacheServiceImpl;
import org.junit.Test;

/**
 * @author wangrui
 * @date 2022/11/5
 * @Description
 */
public class Apitest {

    @Test
    public void test_CacheService() {
        CacheService cacheService = new CacheServiceImpl();
        cacheService.set("user_name_01", "小傅哥", 2);
        String val01 = cacheService.get("user_name_01",2);
        System.out.println(val01);
    }

}
