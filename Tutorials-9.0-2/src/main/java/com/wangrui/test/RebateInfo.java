package com.wangrui.test;

/**
 * @author wangrui
 * @date 2022/11/8
 * @Description  适配器类  三种MQ到时候转化成这个适配器  相同意思的字段对应
 */
public class RebateInfo {

    private String userId;
    private String bizId;
    private String bizTime;
    private String desc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getBizTime() {
        return bizTime;
    }

    public void setBizTime(String bizTime) {
        this.bizTime = bizTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
