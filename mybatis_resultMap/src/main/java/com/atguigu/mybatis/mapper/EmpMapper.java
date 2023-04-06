package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    Emp getEmpByEmpId(@Param("EmpId") Integer EmpId);

}
