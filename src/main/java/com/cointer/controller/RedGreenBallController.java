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
	
	@RequestMapping("/winningRec")
	@ResponseBody
	public String winningRec(@RequestParam String param) {
	return 	serviceRun(RedGreenBallService, "winningRec", param);
 
	}
	@RequestMapping("/laidList")
	@ResponseBody
	public String laidList(@RequestParam String param) {
	return 	serviceRun(RedGreenBallService, "laidList", param);
 
	}

	@RequestMapping("/laid")
	@ResponseBody
	public String laid(@RequestParam String param) {
	return 	serviceRun(RedGreenBallService, "laid", param);
 
	}

}