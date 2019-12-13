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
import com.cointer.service.IUserService;






@Controller
@RequestMapping("/user")
public class UserController extends  BaseController{
	@Autowired 
	private IUserService UserService;



	@RequestMapping("/registOrLogin")
	@ResponseBody
	public String login(@RequestParam String param) {
	return 	serviceRun(UserService, "registOrLogin", param);
//		try {
//			Object resultParam = UserService.registOrLogin(param);
//			return succ(StatusCode.SUCC, "", resultParam);
//		} catch (ServiceException e) {
//			return failed(e.getCode(), e.getMsg(), e.getParaMap());
//		} catch (TransException e) {
//			return failed(StatusCode.TRANS_ERROR, e.getMsg(), null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return failed(StatusCode.FAILED, "系统异常", null);
//		} 
	}

	@RequestMapping("/addPhoto")
	@ResponseBody
	public String addPhoto(@RequestParam String param) {
		return 	serviceRun(UserService, "addPhoto", param);
	}

	@RequestMapping("/remotePlats")
	@ResponseBody
	public String remotePlats(@RequestParam String param) {
		return 	serviceRun(UserService, "remotePlats", param);
	}
	@RequestMapping("/remotePlatUserInfo")
	@ResponseBody
	public String remotePlatUserInfo(@RequestParam String param) {
		return 	serviceRun(UserService, "remotePlatUserInfo", param);
	}	
	@RequestMapping("/bindRemoteUser")
	@ResponseBody
	public String bindRemoteUser(@RequestParam String param) {
		return 	serviceRun(UserService, "bindRemoteUser", param);
	}
}