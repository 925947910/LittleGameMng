package com.cointer.controller;



import java.util.Calendar;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.controller.base.BaseController;






@Controller
@RequestMapping("Common/")
public class CommonController extends  BaseController{

	

	@RequestMapping("/time")
	@ResponseBody
	public String time() {
		Calendar calendar = Calendar.getInstance();
		long nowSec=calendar.getTimeInMillis();
		JSONObject obj= new JSONObject();
		obj.put("time",nowSec);
	return 	succ(StatusCode.SUCC, "", obj);
 
	}
	
}