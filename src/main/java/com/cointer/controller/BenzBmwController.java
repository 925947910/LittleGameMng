package com.cointer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cointer.constant.StatusCode;
import com.cointer.controller.base.BaseController;
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
import com.cointer.service.IBenzBmwService;
import com.cointer.service.IUserService;






@Controller
@RequestMapping("/benzBmw")
public class BenzBmwController extends  BaseController{
	@Autowired 
	private IBenzBmwService IBenzBmwService;

	@RequestMapping("/initRoom")
	@ResponseBody
	public String initRoom(@RequestParam String param) {
	return 	serviceRun(IBenzBmwService, "initRoom", param);
 
	}

	@RequestMapping("/bet")
	@ResponseBody
	public String bet(@RequestParam String param) {
	return 	serviceRun(IBenzBmwService, "bet", param);
 
	}
	@RequestMapping("/draw")
	@ResponseBody
	public String draw(@RequestParam String param) {
	return 	serviceRun(IBenzBmwService, "draw", param);
 
	}

	@RequestMapping("/beBanker")
	@ResponseBody
	public String beBanker(@RequestParam String param) {
	return 	serviceRun(IBenzBmwService, "beBanker", param);
 
	}
	@RequestMapping("/fallBanker")
	@ResponseBody
	public String fallBanker(@RequestParam String param) {
	return 	serviceRun(IBenzBmwService, "fallBanker", param);
 
	}
	


}