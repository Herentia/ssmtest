package com.pb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * 导入json包, 返回页面信息
	 * @param pn 当前页
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
	
	/**
	 * 验证用户名
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkuser")
	public Msg checkUser(@RequestParam("empName") String empName) {
		boolean b = empService.checkUser(empName);
		String regName = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u4e00-\u9fa5]{2,5}$)";
		if(!empName.matches(regName))
			return Msg.error().add("va_msg", "用户名为2-5为中文或者6-16位英文");
		if(b) {
			return Msg.success();
		} else {
			return Msg.error().add("va_msg", "用户名不可用");
		}
	}
	
	/**
	 * 保存员工
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee, Errors errors, Map<String, String> map) {
		if(errors.hasErrors()) {
			for (FieldError error : errors.getFieldErrors()) {
				map.put(error.getField(), error.getDefaultMessage());
			}
			return Msg.error().add("errorFields", map);
		} else {
			empService.saveEmp(employee);
			return Msg.success();
		}
	}
	
	/**
	 * 通过ID获取需要修改 的用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/editEmp/{id}", method=RequestMethod.GET)
	public Msg getEmpById(@PathVariable("id") Integer empId) {
		Employee emp = empService.getEmpById(empId);
		return Msg.success().add("emp", emp);
	}
	/**
	 * 修改用户
	 * @param employee 需要修改用户对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/editEmp/{empId}", method=RequestMethod.PUT)
	public Msg editEmp(Employee employee) {
		empService.updateEmp(employee);
		return Msg.success();
	}
	
	/**
	 * 通过ID删除单个用户---改为传入字符串使单个和多个删除都可以执行
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{ids}", method=RequestMethod.DELETE)
	public Msg delEmpById(@PathVariable("ids") String ids) {
		if(ids.contains("-")) {
			List<Integer> list = new ArrayList<Integer>();
			String[] str_ids = ids.split("-");
			for (String string : str_ids) {
				list.add(Integer.parseInt(string));
			}
			empService.delBatch(list);
		} else {
			Integer id = Integer.parseInt(ids);
			empService.delEmp(id);
		}
		return Msg.success();
	}

}
