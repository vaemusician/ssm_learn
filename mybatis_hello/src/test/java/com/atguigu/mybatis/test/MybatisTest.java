package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取Sql的会话对象SqlSession(不会自动提交事务)，是MyBatis提供的操作数据库的对象。
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Sql的会话对象SqlSession(会自动提交事务)，是MyBatis提供的操作数据库的对象。
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法实现添加用户信息的功能
        int result = mapper.insertUser();
        //提供sql以及唯一标识找到sql并执行，唯一标识是namespace.sqlId。
        //int result = sqlSession.insert("com.atguigu.mybatis.mapper.UserMapper.insertUser");
        System.out.println("结果："+result);
        //提交事务
        // sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
        //0309今晚学习
    }

    @Test
    public void testDelete() throws IOException {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();

    }

    @Test
    public void testGetUserById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        for (User s:list){
            System.out.println(s);
        }
    }
}
