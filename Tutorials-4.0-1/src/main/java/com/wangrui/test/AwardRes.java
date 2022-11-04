package com.wangrui.test;

/**
 * @author wangrui
 * @description 发奖结果反馈对象
 * @date 2022年11月04日 11:13
 */
public class AwardRes {
    private String code; // 编码
    private String info; // 描述

    public AwardRes(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
