package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
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

    /**
     * 查询所有的用户信息为map集合
     * 若查询的数据有多条时，并且要将每条数据转换为map集合，此时有2种解决方案：第1种方式，用得比较多。
     * 1.将mapper接口方法的返回值设置为泛型是map的list集合
     * list<Map<String, Object>> getAllUserToMap();
     * 结果：[{password=123, gender=男, id=1, age=23, email=123456@qq.com, username=root}, {password=123456, gender=女, id=2, age=33, email=123456@qq.com, username=admin}]
     * 2.可以将每条数据转换的map集合放在一个大的map种，但是必须要通过@MapKey注解，将查询的某个字段的值作为大的map的键。
     * @MapKey("id")
     * Map<String, Object> getAllUserToMap();
     * 结果：{1={password=123, gender=男, id=1, age=23, email=123456@qq.com, username=root}, 2={password=123456, gender=女, id=2, age=33, email=123456@qq.com, username=admin}}
     */

    // List<Map<String, Object>> getAllUserToMap();

    @MapKey("id")
    Map<String, Object> getAllUserToMap();

}
