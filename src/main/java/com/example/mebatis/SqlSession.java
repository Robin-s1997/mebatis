package com.example.mebatis;

import com.example.mebatis.common.Configuration;
import com.mysql.cj.util.StringUtils;

/**
 * 给用户操作的
 */
public class SqlSession {
    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }


    /**
     * 获取代理类
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz, this);
    }


    /**
     * @param statementId 通过id拿到sql语句
     * @param Param       参数
     * @param <T>         可以返回任意类型
     * @return
     */
    public <T> T selectOne(String statementId, Object Param) {
        String sql = Configuration.sqlMapper.getString(statementId);
        if (!StringUtils.isNullOrEmpty(sql)) {
            //调用executor执行查询sql的
            return executor.query(sql, Param);
        }
        return null;

    }
}
