package com.example.mebatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 触发管理类
 */
public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     *
     * @param proxy
     * @param method 被代理类的那个方法
     * @param args 被代理类的那个方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /**
         * 反射获取
         */
        String mapperInterface = method.getDeclaringClass().getName();
        String name = method.getName();
        String sql = mapperInterface + "." + name;

        return sqlSession.selectOne(sql, args[0]);

    }
}
