package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 通过分步查询：查询员工以及对应的部门信息的第一步
     * @param EmpID
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

}
