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







@Controller
@RequestMapping("/deal")
public class DealController extends  BaseController{
	@Autowired 
	private IDealService DealService;



	@RequestMapping("/extractOrder")
	@ResponseBody
	public String extractOrder(@RequestParam String param) {
		return 	serviceRun(DealService, "extractOrder", param);
//		try {
//			Object resultParam = DealService.extractOrder(param);
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
	@RequestMapping("/extractPwd")
	@ResponseBody
	public String extractPwd(@RequestParam String param) {
		return 	serviceRun(DealService, "extractPwd", param);
//		try {
//			Object resultParam = DealService.extractPwd(param);
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
	@RequestMapping("/coinDeal")
	@ResponseBody
	public String coinDeal(@RequestParam String param) {
		return 	serviceRun(DealService, "coinDeal", param);
//		try {
//			Object resultParam = DealService.coinDeal(param);
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

	@RequestMapping("/recover")
	@ResponseBody
	public String coinRecover(@RequestParam String param) {
		return 	serviceRun(DealService, "coinRecover", param);
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