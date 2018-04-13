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
 * 处理员工crud请求
 * @author haohan
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	/**
	 * 导入json包
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value="pn", defaultValue="1") Integer pn) {
		//引入pageHelper分页插件,传入页码和每页的记录条数
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的查询就是一个分页查询
		List<Employee> emps = empService.getAll();
		//查询后将结果用PageInfo进行包装,第二个参数为需要连续显示的页面
		//将PageInfo交给页面，里面封装了分页详细信息
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 查询所有信息
	 * @return
	 */
//	@RequestMapping("/emps")
	public String emps(@RequestParam(value="pn", defaultValue="1") Integer pn, Model model) {
		//引入pageHelper分页插件,传入页码和每页的记录条数
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的查询就是一个分页查询
		List<Employee> emps = empService.getAll();
		//查询后将结果用PageInfo进行包装,第二个参数为需要连续显示的页面
		//将PageInfo交给页面，里面封装了分页详细信息
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
