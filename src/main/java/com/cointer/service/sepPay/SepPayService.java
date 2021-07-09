package com.cointer.service.sepPay;








import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.ExchangeService;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.util.SpringContextUtil;








@Service
public class SepPayService  {


	private   static int channelIndex =4;


	private static final Logger log = LoggerFactory.getLogger(SepPayService.class);
	
	private static String CHARGEURL="chargeUrl";
	private static String CHARGECALLBACKURL="chargeCallbackUrl";
	private static String EXTRACTURL="extractUrl";
	private static String EXTRACTCALLBACKURL="extractCallbackUrl";
	private static String EXTRACTPER="extractPer";
	private static String MERCHANTID="merchantId";
	private static String KEY="Key";
	private static String PAYTYPE="payType";
	private static String REDIRECTURL="redirectURL";
	private static String ACCOUNTTYPE="accountType";
	


	private   IJedisClient jedisClient;

	@Autowired
	private   ExchangeService ExchangeService;

	//客户端发起充值 http://127.0.0.1:8085/GameUser/exchange/chargeOrder?param={"uid": 30, "channel": 102,"bank_code":"IDPT0001","cost": 100}

	public   JSONObject  chargeOrder(JSONObject reqData,String orderLocal) throws Exception {
		JSONObject result=null;
		long now=	System.currentTimeMillis()/1000;
		
		
		String chargeUrl=RedisData.getUri(jedisClient,channelIndex,CHARGEURL);
		String key=RedisData.getConf(jedisClient,channelIndex,KEY);
		String merchantId=RedisData.getConf(jedisClient,channelIndex,MERCHANTID);
		int    payType=Integer.parseInt(RedisData.getConf(jedisClient,channelIndex,PAYTYPE));
		
		String amount= reqData.getIntValue("cost")+"";
		String redirectURL=RedisData.getUri(jedisClient,channelIndex,REDIRECTURL);
		String notifyUrl= RedisData.getUri(jedisClient,channelIndex,CHARGECALLBACKURL);
		String sign="payType="+payType+"&merchantId="+merchantId+"&amount="+amount+"&orderId="+orderLocal+"&notifyUrl="+notifyUrl+"&key="+key;
		sign= MD5Util.getMD5(sign);
		

//		{
//		"chargeUrl":"https://pay.speedlyp.com/pay/recharge/order","chargeCallBack":"http://377u408z76.wicp.vip:80/GameUser/exchange/sepPayChargeCallBack",
//		"extractUrl":"https://pay.speedlyp.com/api/withdrawal/order/add","extractCallBack":"http://377u408z76.wicp.vip:80/GameUser/exchange/sepPayExtractCallBack",
//		"redirectURL":"https://www.baidu.com/",
//		"key":"94b86d2bc94e6765ff085fe76c1c38e7","merchantId":"10002","payType":101,"extractPer":1000,
//			}
		
//		merchantId 是 string 商户号
//		payType 是 int ⽀付⽅式，具体⻅⽀付⽅式表格
//		orderId 是 string 订单号（唯⼀，不能
//		重复）
//		cpf 否 string cpf 税号(填了会员不
//		需要再次填写)
//		email 否 String 邮箱
//		phone 否 string 电话号码
//		name 否 string 姓名(填了会员不需
//		要再次填写)
//		amount 是 string 订单⾦额，单位雷亚
//		尔R$
//		redirectURL 是 string 付款完成后跳转地址
//		remark 否 string 订单备注
//		notifyUrl 否 string 异步通知地址
//		sign 是 string 签名，签名规则看下方说明
//		payType=⽀付⽅式&merchantId=商户号&amount=订单⾦额&orderId=订单号&notifyUrl=通知地址&key=商户私钥
		JSONObject paramsMap=  new JSONObject();
		paramsMap.put("merchantId",merchantId);
		paramsMap.put("payType",payType);
		paramsMap.put("orderId",orderLocal);
		paramsMap.put("amount", amount);
		paramsMap.put("redirectURL", redirectURL);
		paramsMap.put("notifyUrl",notifyUrl);
		paramsMap.put("sign", sign);
		log.info("=====================chargeOrder:"+paramsMap.toString());
		String	JsonAuth;
		try{
			HttpClientUtil  client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(chargeUrl, paramsMap.toString());
		} catch (Exception e) {
			throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
		}
		if(JsonAuth==null) {
			throw new ServiceException(StatusCode.FAILED,"request_data_null", null);
		}
		log.info("=====================JsonAuth:"+JsonAuth);
		
//		{
//			"data":{
//			"amount":"100",
//			"merchantId":10001,
//			"orderId":"123456",
//			"payUrl":http://www.pay.com 
//		           },
//			"status":0,
//			"message":"请求成功" 
//		}
		
		JSONObject AuthData =JSON.parseObject(JsonAuth);
		
		if(0==AuthData.getInteger("status")){

			JSONObject data=AuthData.getJSONObject("data");
			String payurl=data.getString("payUrl");
			String orderRemote=data.getString("orderId");
			result=new JSONObject();
			result.put("orderRemote",orderRemote);
			result.put("payurl", payurl);
			result.put("now", now);
			log.info("call:"+chargeUrl+"==============result:"+payurl);
		}else{
			log.info("call:"+chargeUrl+"failed===========err_msg:"+AuthData.getString("message"));
		}
		return result;
	}

	public void chargeCallBack(JSONObject reqData)throws Exception{
		log.info("------------------------chargeCallBackData:"+reqData.toString());
		 String extractPer=RedisData.getConf(jedisClient,channelIndex,EXTRACTPER);
		 String key=RedisData.getConf(jedisClient,channelIndex,KEY);
		 
		 
//		merchantId string 商户号
//		orderId string 订单号
//		amount string 订单⾦额，单位雷亚尔R$
//		remark string 商品名称(不参与签名)
//		orderStatus int 订单状态，1成功，-1失败
//		sign string 签名，签名规则请看下⾯说明
		 
//		 sign = md5(merchantId=商户号&amount=订单⾦额&orderId=订单号&orderStatus=订单状
//				 态&key=商户私钥)
//				 注意：商户收到回调后，请返回SUCCESS字符串。
		 
			String merchantId= reqData.getString("merchantId");
			String orderId=reqData.getString("orderId");
			String amount= reqData.getString("amount");
			int orderStatus= reqData.getIntValue("orderStatus"); 
		    String remoteSign=reqData.getString("sign");
		
		//		sign= sign.replaceAll("/", "\\\\/");
		
		String sign="merchantId="+merchantId+"&amount="+amount+"&orderId="+orderId+"&orderStatus="+orderStatus+"&key="+key;
		sign= MD5Util.getMD5(sign);
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"chargeCallBack:sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		JSONObject  AuthData=new JSONObject();
		switch (orderStatus) {
		case 1:
			AuthData.put("succ", true);
			AuthData.put("orderLocal", orderId);
			AuthData.put("extractPer", extractPer);
			log.info("chargeCallBack========orderLocal:"+orderId);
			break;
		default:
			AuthData.put("succ", false);
			AuthData.put("orderLocal", orderId);
			AuthData.put("extractPer", extractPer);
			log.info("chargeCallBack:failed========orderLocal:"+orderId);
			break;
		}
		ExchangeService.processCharge(AuthData);

	}
	//客户端发起提现 http://127.0.0.1:8085/GameUser/exchange/extractOrder?param={"uid": 30, "coin": 100, "name": "yeah", "account": "6262662666662666", "ifsc": "HDFC0000027","bank_name":"indbank", "bank_code": "IDPT0001"}
	public   String accountInfo(JSONObject reqData) throws Exception {
		String name= reqData.getString("name");
		String account= reqData.getString("account");
		JSONObject accountInfo= new JSONObject();
		accountInfo.put("name", name);
		accountInfo.put("accountNumber", account);
		return accountInfo.toString();
	}
	public   JSONObject  verifyExtract(tradeOrder  tradeOrder) throws Exception {
		JSONObject result=null;
	
		String merchantId=RedisData.getConf(jedisClient,channelIndex,MERCHANTID);
		 String extractUrl=RedisData.getUri(jedisClient,channelIndex,EXTRACTURL);
		 Integer accountType=Integer.parseInt(RedisData.getConf(jedisClient,channelIndex,ACCOUNTTYPE));
		 String notifyUrl=RedisData.getUri(jedisClient,channelIndex,EXTRACTCALLBACKURL);
		 String key=RedisData.getConf(jedisClient,channelIndex,KEY);
		String AccountOut=tradeOrder.getAccountOut();
		JSONObject outInfo=JSONObject.parseObject(AccountOut);
		
		 String bankNumber="BBDEBRSP";
		 String bankName="BANCO BRADESCO S.A., SAO PAULO";
		 String name=outInfo.getString("name");
		 String accountNumber=outInfo.getString("accountNumber");
		 String sign="merchantId="+merchantId+"&bankNumber="+bankNumber+"&amount="+tradeOrder.getCoin()/100+"&orderId="+tradeOrder.getOrderLocal()+"&accountNumber="+accountNumber+"&key="+key;
		 sign= MD5Util.getMD5(sign);
		
//		merchantId 是 string 商户号
//		orderId 是 string 商户订单号
//		amount 是 string 转账⾦额 雷亚尔
//		bankNumber 是 string 银⾏编码
//		bankName 是 string 银⾏名称
//		name 是 string 收款⼈
//		accountNumber 是 string 收款账号
//		accountType YES int 账号类型
//		1:储蓄账户 
//		2:信⽤卡
//		3.pagseguro账户
//		4.pix账户
//		notifyUrl NO string 通知地址，不传
//		则不回调
//		sign YES string 签名
//		 sign = md5(idCard=123456&merchantId=商户号&bankNumber=银⾏编号
//				 &amount=提款⾦额&orderId=订单号&accountNumber=账号&key=商户秘钥)
		JSONObject paramsMap=  new JSONObject();
		paramsMap.put("merchantId",merchantId);
		paramsMap.put("orderId",tradeOrder.getOrderLocal());
		paramsMap.put("amount",tradeOrder.getCoin()/100);
		paramsMap.put("bankNumber",bankNumber);
		paramsMap.put("bankName",bankName);
		
		paramsMap.put("name",name);
		paramsMap.put("accountNumber",accountNumber);
		paramsMap.put("accountType",accountType);
		paramsMap.put("notifyUrl",notifyUrl);
		paramsMap.put("sign", sign);
		log.info("=====================verifyExtract:"+paramsMap.toString());
		String	JsonAuth=null;
		try {
			HttpClientUtil  client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(extractUrl, paramsMap.toString());
		} catch (Exception e) {
			throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
		}

		if(JsonAuth==null) {
			throw new ServiceException(StatusCode.FAILED,"request_data_null", null);
		}
//		{
//			"status":0,
//			"message":"successfully ordered!"
//			}

		JSONObject AuthData =JSON.parseObject(JsonAuth);
	
		result=new JSONObject();
		if(0==AuthData.getInteger("status")){
			result.put("succ",true);
			result.put("orderRemote",tradeOrder.getOrderLocal());
			log.info("call:"+extractUrl+"==============succ_msg:"+AuthData.getString("message"));
		}else{
			result.put("succ",false);
			log.info("call:"+extractUrl+"failed=======err_msg:"+AuthData.getString("message"));
		}
		return result;
	}	

















	//  提现回调
	public   void  extractCallBack(JSONObject reqData) throws Exception {
		
		log.info("------------------------extractCallBack:"+reqData.toString());
//		{"status":0,"data":{"transferStatus":2,"orderId":"OrderOut20210629160314645302780","amount":1,"sign":"d8feddb7b1f3980e5be05b9e90546b47"},"message":"Successful transfer"}
//		status 是 int 状态码，0
//		message 否 string 返回信息，通常返回错误信息
//		data
//		orderId string 代付单号
//		amount string 代付成功⾦额，单位雷亚尔
//		transferStatus int 代付状态， 1代付中，2代付成功，3代
//		付失败
//		sign string 签名
//		sign = md5(amount= 代付⾦额&orderId=代付单号&transferStatus= 代
//				付状态&key=⽀付秘钥)
		 String key=RedisData.getConf(jedisClient,channelIndex,KEY);
		 if(0!=reqData.getIntValue("status")){
				throw new ServiceException(StatusCode.FAILED,"extractCallBackError status:"+reqData.getIntValue("status")+"****message:"+reqData.getString("message"), null);
			}
		 
		 JSONObject data= reqData.getJSONObject("data");
		String	remoteSign=data.getString("sign");
		 String sign="amount="+data.getString("amount")+"&orderId="+data.getString("orderId")+"&transferStatus="+data.getIntValue("transferStatus")+"&key="+key;
		//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign);
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"extractCallBack:sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		String orderLocal=data.getString("orderId");
		JSONObject  AuthData=new JSONObject();
		switch (data.getInteger("transferStatus")) {
		case 2:
			AuthData.put("succ", true);
			AuthData.put("orderLocal", orderLocal);
			log.info("extractCallBack========orderLocal:"+orderLocal);
			break;
		default:
			AuthData.put("succ", false);
			AuthData.put("orderLocal", orderLocal);
			log.info("extractCallBack:failed=======err_code:"+data.getInteger("transferStatus"));
			break;
		}
		ExchangeService.processExtract(AuthData);




	}	

































}


