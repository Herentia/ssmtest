package com.pb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pb.bean.Department;
import com.pb.bean.Msg;
import com.pb.service.DepartmentService;

/**
 * ��������ص�����
 * @author haohan
 *
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/depts", method=RequestMethod.GET)
	@ResponseBody
	public Msg getDepts() {
		List<Department> depts = departmentService.getDepts();
		return Msg.success().add("depts", depts);
	}
	
	

}
