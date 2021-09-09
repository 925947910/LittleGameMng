package com.cointer.controller;





import java.net.URLDecoder;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.controller.base.BaseController;
import com.cointer.pojo.dto.sepChargeCbDto;
import com.cointer.pojo.tikPay.*;
import com.cointer.service.IExchangeService;
import com.cointer.service.tikPay.TikPayService;
import com.cointer.service.otPay.OtPayService;
import com.cointer.service.sepPay.SepPayService;
import com.cointer.util.CommTypeUtils;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.tikPay.AESOperator;
import com.cointer.service.amPay.AmPayService;
import com.cointer.service.nibPay.NibPayService; 







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
	@Autowired 
	private AmPayService AmPayService;
	@Autowired 
	private SepPayService SepPayService;
	@Autowired 
	private NibPayService NibPayService;
	
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
	public String otPayExtractCallBack(@RequestBody String str) {
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
	@RequestMapping("/amPayChargeCallBack")
	@ResponseBody
	public String amPayChargeCallBack(@RequestBody String str ) {
		String res="SUCCESS";
		  try {
			    String params =URLDecoder.decode(str,"UTF-8");
				Map<String,String>paramsMap=HttpClientUtil.URLRequest(params);
				JSONObject  obj=JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				AmPayService.chargeCallBack(obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			  res="FAILED";
		}
		return res;
	}
	@RequestMapping("/amPayExtractCallBack")
	@ResponseBody
	public String amPayExtractCallBack(@RequestBody String str) {
		String res="SUCCESS";
		  try {
			    String params =URLDecoder.decode(str,"UTF-8");
				Map<String,String>paramsMap=HttpClientUtil.URLRequest(params);
				JSONObject  obj=JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				AmPayService.extractCallBack(obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			  res="FAILED";
		}
		return res;
	}	
	@RequestMapping("/sepPayChargeCallBack")
	@ResponseBody
	public String sepPayChargeCallBack(@RequestBody sepChargeCbDto sepChargeCbDto) {
		
//		merchantId string 商户号
//		orderId string 订单号
//		amount string 订单⾦额，单位雷亚尔R$
//		remark string 商品名称(不参与签名)
//		orderStatus int 订单状态，1成功，-1失败
//		sign string 签名，签名规则请看下⾯说明
		
		
		String res="SUCCESS";
		  try {
			    JSONObject obj = (JSONObject) JSONObject.toJSON(sepChargeCbDto);
				SepPayService.chargeCallBack(obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			  res="FAILED";
		}
		return res;
	}
	@RequestMapping("/sepPayExtractCallBack")
	@ResponseBody
	public String sepPayExtractCallBack(@RequestBody String str) {
		String res="SUCCESS";
		  try {
				JSONObject  obj=JSONObject.parseObject(str);
			  SepPayService.extractCallBack(obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			  res="FAILED";
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
	    public String tikPayChargeCallBack(@RequestBody OtcCallPo callPo) {
		 JSONObject  obj=new JSONObject();
		 String resultJson;
		  try {
			  TikPayService.chargeCallBack(callPo);
	             obj.put("code", 1);
	             obj.put("message", "SUCCESS");
	             resultJson = obj.toJSONString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
            obj.put("code", 2);
            obj.put("message", "FAIL");
            resultJson = obj.toJSONString();
           
		}
		  return resultJson;
	    }
	 @PostMapping("/tikPayExtractCallBack")
	 @ResponseBody
	 public String tikPayExtractCallBack(@RequestBody OtcCallPo callPo) {
		 JSONObject  obj=new JSONObject();
		 String resultJson;
		 try {
			 TikPayService.extractCallBack(callPo);
			 obj.put("code", 1);
			 obj.put("message", "SUCCESS");
			 resultJson = obj.toJSONString();

		 } catch (Exception e) {
			 e.printStackTrace();
			 obj.put("code", 2);
			 obj.put("message", "FAIL");
			 resultJson = obj.toJSONString();
		 }
		 return resultJson;
	 }



	    @PostMapping("/tikFail")
	    public String fail(@RequestBody OtcCallPo callPo) {
	        try {
	            String data =AESOperator.getInstance().decrypt(callPo.getEncryptedData(),"2qnt0DQoHrBLDQYkW45hYOMwfYIHdFsOuqrJ4pkzAVA=".substring(0,16));
	            CallVo callVo = JSON.parseObject(data, CallVo.class);

//	            System.out.println("------------------------"+callVo.getThirdOrderNumber()+";"+callVo.getStatus());


	         /*   String decryptedData = AESOperator.getInstance().decrypt(encryptedReq.getEncryptedData());
	            AdInfoPo adInfoPo = JSON.parseObject(decryptedData, AdInfoPo.class);*/

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        CommonResult CommonResult=new CommonResult(1,"FAIL",null);
			 return JSONObject.toJSONString(CommonResult);


	    }
	    @RequestMapping("/shop")
	    public String enterShop(Model model,@RequestParam int uid,@RequestParam int customer,@RequestParam String buy_currency){
	    	 model.addAttribute("uid", uid);
	    	 model.addAttribute("customer", customer);
	    	 model.addAttribute("buy_currency",buy_currency);
	        return "shop";
	    }   
		@RequestMapping("/genOrder")
		public String genOrder(Model model,@RequestParam int uid,@RequestParam String currency,@RequestParam int cost,@RequestParam int customer,@RequestParam String buy_currency) {
			JSONObject obj=new JSONObject();
			obj.put("uid",uid);
			obj.put("customer",customer);
			obj.put("buy_currency",buy_currency);
			obj.put("currency",currency);
			obj.put("cost",cost);
			String orderLocal=CommTypeUtils.getOrderNo("gs");
		    JSONObject AuthData;
			try {
				 AuthData = NibPayService.chargeOrder(obj, orderLocal);
				 model.addAttribute("payurl", AuthData.getString("payurl"));
				 model.addAttribute("message", "点击跳转支付页面");
				 return "shopPay";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("message", "生成订单失败请重新下单");
			return "shopPay";
			
		}
//		@RequestMapping("/nibPayChargeCallBack")
//		@ResponseBody
//		public String nibPayChargeCallBack(@RequestBody nibChargeCbDto nibChargeCbDto) {
//
//			String res="success";
//			  try {
//				    JSONObject obj = (JSONObject) JSONObject.toJSON(nibChargeCbDto);
//					NibPayService.chargeCallBack(obj);
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				  res="FAILED";
//			}
//			return res;
//		}

}