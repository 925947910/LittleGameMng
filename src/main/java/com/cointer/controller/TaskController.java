package com.cointer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.controller.base.BaseController;
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
import com.cointer.pojo.po.gameUser;
import com.cointer.service.IGameTaskService;
import com.cointer.service.IUserService;






@Controller
@RequestMapping("/task")
public class TaskController extends  BaseController{
	@Autowired 
	private IGameTaskService IGameTaskService;

	

	
	
	@RequestMapping("/taskInfo")
	@ResponseBody
	public String taskInfo(@RequestParam String param) {
	return 	serviceRun(IGameTaskService, "taskInfo", param);
	}
	@RequestMapping("/getRewards")
	@ResponseBody
	public String getRewards(@RequestParam String param) {
	return 	serviceRun(IGameTaskService, "getRewards", param);
	}
	
	
}