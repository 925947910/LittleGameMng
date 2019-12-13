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
//		try {
//			Object resultParam = CoinInfoService.unFreeze(param);
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

	@RequestMapping("/freezeList")
	@ResponseBody
	public String freezeList(@RequestParam String param) {
		return 	serviceRun(CoinInfoService, "freezeList", param);
//		try {
//			Object resultParam = CoinInfoService.freezeList(param);
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
	@RequestMapping("/billsList")
	@ResponseBody
	public String billsList(@RequestParam String param) {
		return 	serviceRun(CoinInfoService, "billsList", param);
//		try {
//			Object resultParam = CoinInfoService.billsList(param);
//			return succ(StatusCode.SUCC, "", resultParam);
//		}catch (ServiceException e) {
//			return failed(e.getCode(), e.getMsg(), e.getParaMap());
//		} catch (TransException e) {
//			return failed(StatusCode.TRANS_ERROR, e.getMsg(), null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return failed(StatusCode.FAILED, "系统异常", null);
//		} 
	}


}