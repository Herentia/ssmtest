package com.pb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.bean.Employee;
import com.pb.bean.EmployeeExample;
import com.pb.bean.EmployeeExample.Criteria;
import com.pb.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper empmapper;
	
	/**
	 * ��ѯ����Ա����Ϣ
	 * @return
	 */
	public List<Employee> getAll() {
		return empmapper.selectByExampleWithDept(null);
	}
	
	//��֤Ա���Ƿ����
	public boolean checkUser(String empName) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = empmapper.countByExample(example);
		return count == 0;
	}
	
	//����Ա��
	public void saveEmp(Employee emp) {
		empmapper.insertSelective(emp);
	}
	
}
