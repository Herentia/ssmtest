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
 * 测试dao层工作
 * @author haohan
 * @ContextConfiguration 指定spring配置文件的位置
 * @RunWith junit注解，运行单元测试时用哪个单元测试运行
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Test
	public void testCrud() {
		System.out.println(departmentMapper);
		
		//插入几个部门
		departmentMapper.insertSelective(null);
	}

}
