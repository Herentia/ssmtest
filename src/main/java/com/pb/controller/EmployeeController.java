package com.pb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pb.bean.Employee;
import com.pb.bean.Msg;
import com.pb.dao.EmployeeMapper;
import com.pb.service.EmployeeService;

/***
 * ����Ա��crud����
 * @author haohan
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	/**
	 * ����json��
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value="pn", defaultValue="1") Integer pn) {
		//����pageHelper��ҳ���,����ҳ���ÿҳ�ļ�¼����
		PageHelper.startPage(pn, 5);
		//startPage��������Ĳ�ѯ����һ����ҳ��ѯ
		List<Employee> emps = empService.getAll();
		//��ѯ�󽫽����PageInfo���а�װ,�ڶ�������Ϊ��Ҫ������ʾ��ҳ��
		//��PageInfo����ҳ�棬�����װ�˷�ҳ��ϸ��Ϣ
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * ��ѯ������Ϣ
	 * @return
	 */
//	@RequestMapping("/emps")
	public String emps(@RequestParam(value="pn", defaultValue="1") Integer pn, Model model) {
		//����pageHelper��ҳ���,����ҳ���ÿҳ�ļ�¼����
		PageHelper.startPage(pn, 5);
		//startPage��������Ĳ�ѯ����һ����ҳ��ѯ
		List<Employee> emps = empService.getAll();
		//��ѯ�󽫽����PageInfo���а�װ,�ڶ�������Ϊ��Ҫ������ʾ��ҳ��
		//��PageInfo����ҳ�棬�����װ�˷�ҳ��ϸ��Ϣ
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);
		return "list";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(Employee employee) {
		empService.saveEmp(employee);
		return Msg.success();
	}

}
