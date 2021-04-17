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
import com.cointer.service.IRedGreenBallService;
import com.cointer.service.IUserService;






@Controller
@RequestMapping("/redGreenBall")
public class RedGreenBallController extends  BaseController{
	@Autowired 
	private IRedGreenBallService RedGreenBallService;


	
	@RequestMapping("/notice")
	@ResponseBody
	public String notice(@RequestParam String param) {
	return 	serviceRun(RedGreenBallService, "notice", param);
 
	}
	
	@RequestMapping("/winRec")
	@ResponseBody
	public String winRec(@RequestParam String param) {
	return 	serviceRun(RedGreenBallService, "winRec", param);
 
	}
	@RequestMapping("/historyIssue")
	@ResponseBody
	public String historyIssue(@RequestParam String param) {
	return 	serviceRun(RedGreenBallService, "historyIssue", param);
 
	}
	@RequestMapping("/currIssue")
	@ResponseBody
	public String currIssue(@RequestParam String param) {
	return 	serviceRun(RedGreenBallService, "currIssue", param);
 
	}
	@RequestMapping("/bet")
	@ResponseBody
	public String bet(@RequestParam String param) {
	return 	serviceRun(RedGreenBallService, "bet", param);
 
	}
	@RequestMapping("/betRec")
	@ResponseBody
	public String betRec(@RequestParam String param) {
	return 	serviceRun(RedGreenBallService, "betRec", param);
 
	}
}