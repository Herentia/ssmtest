package com.pb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.bean.Employee;
import com.pb.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper empmapper;
	
	/**
	 * 查询所有员工信息
	 * @return
	 */
	public List<Employee> getAll() {
		return empmapper.selectByExampleWithDept(null);
	} 

}
