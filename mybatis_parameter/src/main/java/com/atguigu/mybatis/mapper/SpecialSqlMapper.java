package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSqlMapper {

    /**
     * 使用模糊进行查询
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批量删除
     */
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * 动态设置表名，查询用户信息
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 添加用户信息，并获取自增的主键。
     */
    void insertUser(User user);
}
