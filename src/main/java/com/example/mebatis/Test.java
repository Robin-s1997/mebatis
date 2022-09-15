package com.example.mebatis;

import com.example.mebatis.common.Configuration;
import com.example.mebatis.entity.Blog;
import com.example.mebatis.mapper.BlogMapper;

public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration(), new Executor());
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//        Blog blog = mapper.selectOneById(1);

        Blog blog = mapper.selectOneByAuthorId(1001);

        System.out.println(blog);

    }
}
