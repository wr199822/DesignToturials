package com.wangrui.test;

import org.apache.ibatis.annotations.Select;

/**
 * @author wangrui
 * @date 2022/12/4
 * @Description
 */
public interface  IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String id);
}
