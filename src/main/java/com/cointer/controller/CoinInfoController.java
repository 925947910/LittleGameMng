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
import com.cointer.service.ICoinInfoService;






@Controller
@RequestMapping("/coin")
public class CoinInfoController extends  BaseController{
	@Autowired 
	private ICoinInfoService CoinInfoService;

	@RequestMapping("/unfreeze")
	@ResponseBody
	public String unFreeze(@RequestParam String param) {
	return 	serviceRun(CoinInfoService, "unFreeze", param);

	}

	@RequestMapping("/freezeList")
	@ResponseBody
	public String freezeList(@RequestParam String param) {
		return 	serviceRun(CoinInfoService, "freezeList", param);

	}
	@RequestMapping("/billsList")
	@ResponseBody
	public String billsList(@RequestParam String param) {
		return 	serviceRun(CoinInfoService, "billsList", param);

	}


}