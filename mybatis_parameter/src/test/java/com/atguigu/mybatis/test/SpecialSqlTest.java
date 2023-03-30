package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SpecialSqlMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SpecialSqlTest {

    @Test
    public void testGetUserByLike() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserByLike("a");
        list.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        mapper.deleteMoreUser("3,4");
    }

    @Test
    public void testgetUserList() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null,"xiaoming","123456",23,"男","123456@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

}
