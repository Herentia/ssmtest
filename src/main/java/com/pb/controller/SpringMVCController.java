package com.pb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.pb.service.SpringProducerService;

@Controller
public class SpringMVCController {
	
	@Autowired
	private SpringProducerService springProducerService;
	
	@ResponseBody
	@RequestMapping("/createOrder")
	public DeferredResult<Object> createOrder() {
		DeferredResult<Object> deferredResult = new DeferredResult<Object>((long) 3000, "create fail....");
//		springProducerService.sendMessage(deferredResult);
		return deferredResult;
	}
	
	@RequestMapping("/ceshi")
	@ResponseBody
	public String createtext() {
		springProducerService.sendMessageStr("≤‚ ‘..");
		return "success";
	}

}
