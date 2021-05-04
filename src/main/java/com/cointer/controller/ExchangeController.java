package com.cointer.controller;





import java.net.URLDecoder;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cointer.service.IExchangeService;
import com.cointer.service.tikPay.TikPayService;
import com.cointer.service.otPay.OtPayService;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.tikPay.AESOperator;








@Controller
@RequestMapping("/exchange")
public class ExchangeController extends  BaseController{
	private static final Logger log = LoggerFactory.getLogger(ExchangeController.class);
	@Autowired 
	private IExchangeService ExchangeService;
	
	@Autowired 
	private TikPayService TikPayService;
	@Autowired 
	private OtPayService OtPayService;
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
	
	@RequestMapping("/otPayChargeCallBack")
	@ResponseBody
	public String otPayChargeCallBack(@RequestBody String str ) {
		String res="success";
		  try {
				String params =URLDecoder.decode(str,"UTF-8");
				Map<String,String>paramsMap=HttpClientUtil.URLRequest(params);
				JSONObject  obj=JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			    OtPayService.chargeCallBack(obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			  res="failed";
		}
		return res;
	}
	@RequestMapping("/otPayExtractCallBack")
	@ResponseBody
	public String extractCallBack(@RequestBody String str) {
		String res="success";
		  try {
			  String params =URLDecoder.decode(str,"UTF-8");
				Map<String,String>paramsMap=HttpClientUtil.URLRequest(params);
				JSONObject  obj=JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				OtPayService.extractCallBack(obj);
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
	 @PostMapping("/tikPayChargeCallBack")
	 @ResponseBody
	    public String tikChargeCallBack(@RequestBody OtcCallPo callPo) {
		 JSONObject  obj=new JSONObject();
		 String resultJson;
		  try {
			  TikPayService.chargeCallBack(callPo);
	             obj.put("code", 1);
	             obj.put("message", "SUCCESS");
	             resultJson = obj.toJSONString();
	             log.debug("tikPayChargeCallBack!!!!!!!!!!!!!!!!!!!json:"+resultJson);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
            obj.put("code", 2);
            obj.put("message", "FAIL");
            resultJson = obj.toJSONString();
            log.debug("tikPayChargeCallBack!!!!!!!!!!!!!!!!!!!json:"+resultJson);
           
		}
		  return resultJson;
	    }
	 @PostMapping("/tikPayExtractCallBack")
	 @ResponseBody
	 public String tikExtractCallBack(@RequestBody OtcCallPo callPo) {
		 JSONObject  obj=new JSONObject();
		 String resultJson;
		 try {
			 TikPayService.extractCallBack(callPo);
			 obj.put("code", 1);
			 obj.put("message", "SUCCESS");
			 resultJson = obj.toJSONString();
			 log.debug("tikPayExtractCallBack!!!!!!!!!!!!!!!!!!!json:"+resultJson);

		 } catch (Exception e) {
			 e.printStackTrace();
			 obj.put("code", 2);
			 obj.put("message", "FAIL");
			 resultJson = obj.toJSONString();
			 log.debug("tikPayExtractCallBack!!!!!!!!!!!!!!!!!!!json:"+resultJson);
		 }
		 return resultJson;
	 }



	    @PostMapping("/tikFail")
	    public String fail(@RequestBody OtcCallPo callPo) {
	        try {
	            String data =AESOperator.getInstance().decrypt(callPo.getEncryptedData(),"2qnt0DQoHrBLDQYkW45hYOMwfYIHdFsOuqrJ4pkzAVA=".substring(0,16));
	            CallVo callVo = JSON.parseObject(data, CallVo.class);

	            System.out.println("------------------------"+callVo.getThirdOrderNumber()+";"+callVo.getStatus());


	         /*   String decryptedData = AESOperator.getInstance().decrypt(encryptedReq.getEncryptedData());
	            AdInfoPo adInfoPo = JSON.parseObject(decryptedData, AdInfoPo.class);*/

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        CommonResult CommonResult=new CommonResult(1,"FAIL",null);
			 return JSONObject.toJSONString(CommonResult);


	    }


}