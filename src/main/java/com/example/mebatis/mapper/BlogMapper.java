package com.example.mebatis.mapper;

import com.example.mebatis.entity.Blog;

/**
 * 通过接口 + 方法名找到sql语句
 */
public interface BlogMapper {
    public Blog selectOneById (Integer bid);
    public Blog selectOneByAuthorId (Integer authorId);
}
