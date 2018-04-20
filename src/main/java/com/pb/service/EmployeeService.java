package com.pb.service;

import java.util.List;

import org.aspectj.lang.annotation.DeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.bean.Employee;
import com.pb.bean.EmployeeExample;
import com.pb.bean.EmployeeExample.Criteria;
import com.pb.bean.User;
import com.pb.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper empmapper;
	
	/**
	 * 测试切换动态切换到第二个数据库
	 */
	@DeclareAnnotation("dataSource2")
	public User getUserByData2() {
		return empmapper.getUserByData2();
	}
	
	/**
	 * 查询所有员工信息
	 * @return
	 */
	public List<Employee> getAll() {
		return empmapper.selectByExampleWithDept(null);
	}
	
	//验证员工是否可用
	public boolean checkUser(String empName) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = empmapper.countByExample(example);
		return count == 0;
	}
	
	//保存员工
	public void saveEmp(Employee emp) {
		empmapper.insertSelective(emp);
	}
	
	//查询选中员工信息
	public Employee getEmpById(Integer empId) {
		return empmapper.selectByPrimaryKey(empId);
	}

	/**
	 * 更新员工信息
	 * @param employee 需要更的员工对象
	 */
	public void updateEmp(Employee employee) {
		empmapper.updateByPrimaryKeySelective(employee);//按照主键有选择的更新
	}
	
	/**
	 * 删除单个用户
	 * @param id
	 */
	public void delEmp(Integer id) {
		empmapper.deleteByPrimaryKey(id);
	}

	/**
	 * 删除多个用户
	 * @param ids
	 */
	public void delBatch(List<Integer> ids) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(ids);
		empmapper.deleteByExample(example);
	}
	
}
