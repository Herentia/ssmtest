package com.pb.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.pb.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml", "classpath:springmvc-config.xml"})
public class MVCTest {
	
	//传入mvc的ioc
	@Autowired
	private WebApplicationContext context;
	
	//虚拟mvc请求
	MockMvc mockmvc;
	
	@Before
	public void initMokcMvc() {
		mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPageHelper() throws Exception {
		MvcResult mr = mockmvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
		
		//请求成功后可以获取pageInfo进行验证
		MockHttpServletRequest mhsr = mr.getRequest();
		PageInfo pageInfo = (PageInfo) mhsr.getAttribute("pageInfo");
		System.out.println("当前页码" + pageInfo.getPageNum());
		System.out.println("总页码" + pageInfo.getPages());
		System.out.println("总记录数" + pageInfo.getTotal());
		
		//员工数据
		List<Employee> list = pageInfo.getList();
		for (Employee employee : list) {
			System.out.println("ID:" + employee.getdId() + "===>>" + employee.getEmpName());
		}
	}

}
