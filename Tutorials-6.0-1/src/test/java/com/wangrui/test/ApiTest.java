package com.wangrui.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author wangrui
 * @date 2022/11/6
 * @Description
 */
public class ApiTest    {
    @Test
    public void test_DecorationPackageController(){
        DecorationPackageController decoration = new DecorationPackageController();

        // 豪华欧式
        System.out.println(decoration.getMatterList(new BigDecimal("132.52"),1));

        // 轻奢田园
        System.out.println(decoration.getMatterList(new BigDecimal("98.25"),2));

        // 现代简约
        System.out.println(decoration.getMatterList(new BigDecimal("85.43"),3));
    }

}
