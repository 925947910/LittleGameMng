package com.cointer.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.cointer.constant.StatusCode;
import com.cointer.controller.base.BaseController;
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
import com.cointer.pojo.dto.chargeCallBack1Dto;
import com.cointer.redis.IJedisClient;
import com.cointer.service.IExchangeService;








@Controller
@RequestMapping("/exchange")
public class ExchangeController extends  BaseController{
	@Autowired 
	private IExchangeService ExchangeService;
	@Autowired
	private   IJedisClient jedisClient;

	@RequestMapping("/chargeOrder")
	@ResponseBody
	public String chargeOrder(@RequestParam String param) {
		return 	serviceRun(ExchangeService, "chargeOrder", param);
	}
	
	@RequestMapping("/extractOrder")
	@ResponseBody
	public String extractOrder(@RequestParam String param) {
		return 	serviceRun(ExchangeService, "extractOrder", param);
	} 
	@RequestMapping("/verifyExtract")
	@ResponseBody
	public String verifyExtract(@RequestParam String param) {
		return 	serviceRun(ExchangeService, "verifyExtract", param);
	} 
	
	@RequestMapping("/chargeCallBack")
	@ResponseBody
	public String chargeCallBack(@RequestParam chargeCallBack1Dto chargeCallBack1Dto ) {
		String res="success";
		  try {
			  ExchangeService.chargeCallBack(chargeCallBack1Dto);
		} catch (Exception e) {
			// TODO: handle exception
			  res="failed";
		}
		return res;
	}
	@RequestMapping("/extractCallBack")
	@ResponseBody
	public String extractCallBack(@RequestParam int status,String result,String sign) {
		String res="success";
		  try {
			  ExchangeService.extractCallBack(status,result,sign);
		} catch (Exception e) {
			// TODO: handle exception
			  res="failed";
		}
		return res;
	}
	



	@RequestMapping("/orderInfo")
	@ResponseBody
	public String orderInfo(@RequestParam String param) {
		return 	serviceRun(ExchangeService, "orderInfo", param);
//		try {
//			Object resultParam = ExchangeService.orderInfo(param);
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
	@RequestMapping("/checkFreeze")
	@ResponseBody
	public String checkFreeze(@RequestParam String param) {
		
		return 	serviceRun(ExchangeService, "checkFreeze", param);
//		try {
//			Object resultParam = ExchangeService.checkFreeze(param);
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




}