package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     *若sql语句查询的结果为多条时，一定不能以实体类类型作为方法的返回值，否则会抛出异常：TooManyResultsException。
     *若sql语句查询的结果为1条时，此时可以使用实体类类型或list集合类型作为方法的返回值。
     *
     */

    // 根据ID查询用户
    User getUserById(@Param("id") Integer id);

    // 查询所有的用户
    List<User> getAllUser();

    // 查询用户数
    Integer getCountUser();

    // 根据ID查询用户信息为map集合
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

}
