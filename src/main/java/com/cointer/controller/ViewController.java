package com.cointer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cointer.controller.base.BaseController;
import com.cointer.service.IMineralService;
import com.cointer.service.IUserService;


@Controller
@RequestMapping("/view")
public class ViewController extends  BaseController {

    /**
     * 进入注册界面
     */
	@Autowired 
	private IUserService UserService;
    @RequestMapping("/regist")
    public String enterRegister(Model model,@RequestParam String agentId,@RequestParam String presenterId){
    	model.addAttribute("agentId", agentId);
    	model.addAttribute("presenterId", presenterId);
        System.out.println("进入注册界面...");
        return "user_regist";
    }

  
	@RequestMapping("/write")
	@ResponseBody
	public String write(@RequestParam String param) {
	return 	serviceRun(UserService, "write", param);
 
	}
	


}