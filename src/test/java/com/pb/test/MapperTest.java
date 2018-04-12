package com.pb.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pb.bean.Department;
import com.pb.bean.Employee;
import com.pb.dao.DepartmentMapper;
import com.pb.dao.EmployeeMapper;

/**
 * ����dao�㹤��
 * @author haohan
 * @ContextConfiguration ָ��spring�����ļ���λ�ã��Զ�����ioc����
 * @RunWith junitע�⣬���е�Ԫ����ʱ���ĸ���Ԫ��������
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private SqlSession sqlsession;
	
	@Test
	public void testCrud() {
		System.out.println(departmentMapper);
		
		//���뼸������
//		departmentMapper.insertSelective(new Department(null, "���貿"));
//		departmentMapper.insertSelective(new Department(null, "���貿"));
		
		//����Ա��
//		employeeMapper.insertSelective(new Employee(null, "jay", "M", "jay@163.com", 3));
		
		//��������Ա��
		EmployeeMapper  empmapper = sqlsession.getMapper(EmployeeMapper.class);
		for(int i = 0; i < 500; i++) {
			String name = UUID.randomUUID().toString().substring(0, 5) + i;
			empmapper.insertSelective(new Employee(null, name, "M", name + "@163.com", 4));
		}
		
	}

}
