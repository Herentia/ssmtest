package com.pb.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pb.bean.Department;
import com.pb.dao.DepartmentMapper;

/**
 * ����dao�㹤��
 * @author haohan
 * @ContextConfiguration ָ��spring�����ļ���λ��
 * @RunWith junitע�⣬���е�Ԫ����ʱ���ĸ���Ԫ��������
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Test
	public void testCrud() {
		System.out.println(departmentMapper);
		
		//���뼸������
		departmentMapper.insertSelective(null);
	}

}
