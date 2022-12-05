package com.wangrui.test;

import com.example.test.channel.Pay;
import com.example.test.channel.WxPay;
import com.example.test.channel.ZfbPay;
import com.example.test.model.PayFaceMode;
import com.example.test.model.PayFingerprintMode;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author wangrui
 * @date 2022/11/9
 * @Description
 */
public class ApiTest {

    @Test
    public void test_pay(){


        System.out.println("\\r\\n模拟测试场景；微信支付、人脸方式。");
        WxPay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("wangrui123","100000109893",new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));



    }
}
