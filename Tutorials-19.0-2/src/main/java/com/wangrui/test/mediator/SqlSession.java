package com.wangrui.test.mediator;

/**
 * @author wangrui
 * @description 这里定义了对数据库操作的查询接口
 * @date 2022年12月12日 10:54
 */
public interface SqlSession {
    //<T> T 和T的区别：T是Type的首字母缩写；<T> T 表示“返回值”是一个泛型，传入什么类型，就返回什么类型；而单独的“T”表示限制传入的参数类型。
    <T> T selectOne(String statement);

    <T> T selectOne(String statement,Object paramter);

    <T> T selectList(String statement);

    <T> T selectList(String statement,Object paramter);

    void close();


}
