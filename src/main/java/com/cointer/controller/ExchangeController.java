package com.cointer.controller;





import java.net.URLDecoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.controller.base.BaseController;
import com.cointer.pojo.tikPay.*;
import com.cointer.redis.IJedisClient;
import com.cointer.service.IExchangeService;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.tikPay.AESOperator;








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
	public String chargeCallBack(@RequestBody String str ) {
		String res="success";
		  try {
				String params =URLDecoder.decode(str,"UTF-8");
				Map<String,String>paramsMap=HttpClientUtil.URLRequest(params);
				JSONObject  obj=JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			  ExchangeService.chargeCallBack(obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			  res="failed";
		}
		return res;
	}
	@RequestMapping("/extractCallBack")
	@ResponseBody
	public String extractCallBack(@RequestBody String str) {
		String res="success";
		  try {
			  String params =URLDecoder.decode(str,"UTF-8");
				Map<String,String>paramsMap=HttpClientUtil.URLRequest(params);
				JSONObject  obj=JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			  ExchangeService.extractCallBack(obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
	@RequestMapping("/test")
	@ResponseBody
	public String test(@RequestParam String param) {
		
		return 	serviceRun(ExchangeService, "test", param);
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
	 @PostMapping("/tikSucess")
	    public CommonResult sucess(@RequestBody OtcCallPo callPo) {
	        try {
	            String data =  AESOperator.getInstance().decrypt(callPo.getEncryptedData(),"2qnt0DQoHrBLDQYkW45hYOMwfYIHdFsOuqrJ4pkzAVA=".substring(0,16));

	            CallVo callVo = JSON.parseObject(data, CallVo.class);

	            System.out.println("------------------------"+callVo.getThirdOrderNumber()+";"+callVo.getStatus());

	         /*   String decryptedData = AESOperator.getInstance().decrypt(encryptedReq.getEncryptedData());
	            AdInfoPo adInfoPo = JSON.parseObject(decryptedData, AdInfoPo.class);*/

	        } catch (Exception e) {
	            e.printStackTrace();
	        }


	        return new CommonResult(1,"SCUESS",null);
	    }




	    @PostMapping("/tikFail")
	    public CommonResult fail(@RequestBody OtcCallPo callPo) {
	        try {
	            String data =AESOperator.getInstance().decrypt(callPo.getEncryptedData(),"2qnt0DQoHrBLDQYkW45hYOMwfYIHdFsOuqrJ4pkzAVA=".substring(0,16));
	            CallVo callVo = JSON.parseObject(data, CallVo.class);

	            System.out.println("------------------------"+callVo.getThirdOrderNumber()+";"+callVo.getStatus());


	         /*   String decryptedData = AESOperator.getInstance().decrypt(encryptedReq.getEncryptedData());
	            AdInfoPo adInfoPo = JSON.parseObject(decryptedData, AdInfoPo.class);*/

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return new CommonResult(2,"FAIL",null);


	    }


}