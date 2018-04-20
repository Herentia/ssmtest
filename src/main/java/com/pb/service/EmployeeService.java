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
	 * �����л���̬�л����ڶ������ݿ�
	 */
	@DeclareAnnotation("dataSource2")
	public User getUserByData2() {
		return empmapper.getUserByData2();
	}
	
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
	
	//��ѯѡ��Ա����Ϣ
	public Employee getEmpById(Integer empId) {
		return empmapper.selectByPrimaryKey(empId);
	}

	/**
	 * ����Ա����Ϣ
	 * @param employee ��Ҫ����Ա������
	 */
	public void updateEmp(Employee employee) {
		empmapper.updateByPrimaryKeySelective(employee);//����������ѡ��ĸ���
	}
	
	/**
	 * ɾ�������û�
	 * @param id
	 */
	public void delEmp(Integer id) {
		empmapper.deleteByPrimaryKey(id);
	}

	/**
	 * ɾ������û�
	 * @param ids
	 */
	public void delBatch(List<Integer> ids) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(ids);
		empmapper.deleteByExample(example);
	}
	
}
