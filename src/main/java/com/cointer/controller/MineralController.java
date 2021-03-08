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
import com.cointer.service.IDealService;
import com.cointer.service.IMineralService;







@Controller
@RequestMapping("/mineral")
public class MineralController extends  BaseController{
	@Autowired 
	private IMineralService MineralService;



	@RequestMapping("/useMineralCode")
	@ResponseBody
	public String useMineralCode(@RequestParam String param) {
		return 	serviceRun(MineralService, "useMineralCode", param);

	}
	@RequestMapping("/getMineral")
	@ResponseBody
	public String getMineral(@RequestParam String param) {
		return 	serviceRun(MineralService, "getMineral", param);

	}
	@RequestMapping("/mineralBillsList")
	@ResponseBody
	public String mineralBillsList(@RequestParam String param) {
		return 	serviceRun(MineralService, "mineralBillsList", param);
 
	}
	@RequestMapping("/presenterMembers")
	@ResponseBody
	public String presenterMembers(@RequestParam String param) {
		return 	serviceRun(MineralService, "presenterMembers", param);
 
	}
	@RequestMapping("/digMineral")
	@ResponseBody
	public String digMineral(@RequestParam String param) {
		return 	serviceRun(MineralService, "digMineral", param);

	}

}