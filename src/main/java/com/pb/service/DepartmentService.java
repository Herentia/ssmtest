package com.pb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.bean.Department;
import com.pb.dao.DepartmentMapper;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;

	//��ȡ���в�����Ϣ
	public List<Department> getDepts() {
		List<Department> depts = departmentMapper.selectByExample(null);
		return depts;
	}
	
	
	

}
