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
	
	//����mvc��ioc
	@Autowired
	private WebApplicationContext context;
	
	//����mvc����
	MockMvc mockmvc;
	
	@Before
	public void initMokcMvc() {
		mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPageHelper() throws Exception {
		MvcResult mr = mockmvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
		
		//����ɹ�����Ի�ȡpageInfo������֤
		MockHttpServletRequest mhsr = mr.getRequest();
		PageInfo pageInfo = (PageInfo) mhsr.getAttribute("pageInfo");
		System.out.println("��ǰҳ��" + pageInfo.getPageNum());
		System.out.println("��ҳ��" + pageInfo.getPages());
		System.out.println("�ܼ�¼��" + pageInfo.getTotal());
		
		//Ա������
		List<Employee> list = pageInfo.getList();
		for (Employee employee : list) {
			System.out.println("ID:" + employee.getdId() + "===>>" + employee.getEmpName());
		}
	}

}
