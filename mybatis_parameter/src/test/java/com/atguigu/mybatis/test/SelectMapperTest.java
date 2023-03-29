package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void testGetUserById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User>  list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetCountUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer int_1 = mapper.getCountUser();
        System.out.println(int_1);
    }

    @Test
    public void testGetUserByIdToMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(1);
        // {password=123, gender=男, id=1, age=23, email=123456@qq.com, username=root}
        System.out.println(map);
    }

    @Test
    public void testGetAllUserToMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // List<Map<String, Object>> list = mapper.getAllUserToMap();
        // System.out.println(list);

        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
        // {
        //   1={password=123, gender=男, id=1, age=23, email=123456@qq.com, username=root}
        //  ,2={password=123456, gender=女, id=2, age=33, email=123456@qq.com, username=admin}
        //  }


    }

}
