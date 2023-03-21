package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

public interface UserMapper {

    /**
     * MyBatis获取参数值的2种方式：#{}和${}
     * #{}的本质是：占位符赋值，${}的本质是：字符串拼接。
     * 1.若mapper接口方法的参数为单个的字面量类型，此时可以通过#{}和${}以任意的内容获取参数值，一定要注意${}的单引号问题。
     * 2.若mapper接口方法的参数为多个的字面量类型，此时MyBatis会将参数放在map集合种，以两种方式存储数据。
     *   以arg0,arg1...为键，以参数为值。
     *   以param1,param2...为键，以参数为值。
     *   因此，只需要通过#{}和${}访问map集合的键，就可以获取对应的值。
     */
    // 根据用户名查询用户信息
    User getUserByUsername(String username);

    // 验证登录
    User checkLogin(String username, String password);

}
