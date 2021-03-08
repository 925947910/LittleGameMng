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
import com.cointer.service.ICrowdFundService;
import com.cointer.service.IRedGreenBallService;
import com.cointer.service.IUserService;






@Controller
@RequestMapping("/crowdFund")
public class CrowdFundController extends  BaseController{
	@Autowired 
	private ICrowdFundService CrowdFundService;

	@RequestMapping("/currIssue")
	@ResponseBody
	public String currIssue(@RequestParam String param) {
	return 	serviceRun(CrowdFundService, "currIssue", param);
 
	}
	@RequestMapping("/historyIssue")
	@ResponseBody
	public String historyIssue(@RequestParam String param) {
	return 	serviceRun(CrowdFundService, "historyIssue", param);
 
	}
	@RequestMapping("/currBuy")
	@ResponseBody
	public String currBuy(@RequestParam String param) {
	return 	serviceRun(CrowdFundService, "currBuy", param);
 
	}
	@RequestMapping("/laid")
	@ResponseBody
	public String laid(@RequestParam String param) {
	return 	serviceRun(CrowdFundService, "laid", param);
 
	}

}