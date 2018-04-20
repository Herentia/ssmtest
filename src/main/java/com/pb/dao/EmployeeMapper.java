package com.pb.dao;

import com.pb.bean.Employee;
import com.pb.bean.EmployeeExample;
import com.pb.bean.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.DeclareAnnotation;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer empId);
    //查询员工时连带部门信息一起查出
    List<Employee> selectByExampleWithDept(EmployeeExample example);
    Employee selectByPrimaryKeyWithDept(Integer empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    //
    //测试切换数据库
    User getUserByData2();
}