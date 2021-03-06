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
import com.cointer.service.IUserService;






@Controller
@RequestMapping("/user")
public class UserController extends  BaseController{
	@Autowired 
	private IUserService UserService;

	

	
	 @RequestMapping("/regist")//注册
	    public String register(Model model,gameUser gameUser){
		 
		 JSONObject obj= (JSONObject) JSONObject.toJSON(gameUser); 
		 String resultStr= serviceRun(UserService, "regist", obj.toString());
		 obj=JSONObject.parseObject(resultStr);
		 if ((boolean)obj.get("succ")==true){
			 model.addAttribute("message", obj.getJSONObject("param").getString("message"));
		     model.addAttribute("gameUrl", obj.getJSONObject("param").getString("gameUrl"));
		 }else{
			 model.addAttribute("message", obj.getString("message"));
		     model.addAttribute("gameUrl", "");
		 }
		 
		 return "user_regist_succ";
				 
				
	    }
	
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam String param) {
	return 	serviceRun(UserService, "login", param);
 
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
	@RequestMapping("/userInfo")
	@ResponseBody
	public String userInfo(@RequestParam String param) {
	return 	serviceRun(UserService, "userInfo", param);
	}
	@RequestMapping("/rank")
	@ResponseBody
	public String rank(@RequestParam String param) {
	return 	serviceRun(UserService, "rank", param);
	}
}