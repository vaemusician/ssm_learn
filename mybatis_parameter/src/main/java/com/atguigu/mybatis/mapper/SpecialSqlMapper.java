package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSqlMapper {

    /**
     * 使用模糊进行查询
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

}
