package com.cointer.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.controller.base.BaseController;
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
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
//		try {
//			Object resultParam = ExchangeService.chargeOrder(param);
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
	@RequestMapping("/extract")
	@ResponseBody
	public String extract(@RequestParam String param) {
		return 	serviceRun(ExchangeService, "extract", param);
//		try {
//			Object resultParam = ExchangeService.extract(param);
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