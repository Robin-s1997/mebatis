package com.example.mebatis.common;

import com.example.mebatis.MapperProxy;
import com.example.mebatis.SqlSession;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * 配置类
 */
public class Configuration {

    public final static ResourceBundle sqlMapper;

    static {
        sqlMapper = ResourceBundle.getBundle("mesql");
    }


    public <T> T getMapper(Class<T> clazz, SqlSession sqlSession) {
        // 1：类加载器:2：被代理类实现的接口、3：实现了 InvocationHandler 的触发管理类
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new MapperProxy(sqlSession));

    }
}
