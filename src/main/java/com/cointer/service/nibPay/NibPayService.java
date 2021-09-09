package com.cointer.service.nibPay;








import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.config.StaticDataCache;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.ExchangeService;
import com.cointer.mapper.gameUserMapper;
import com.cointer.trans.TransExchange;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.util.SpringContextUtil;








@Service
public class NibPayService  {


	private   static int channelIndex =5;


	private static final Logger log = LoggerFactory.getLogger(NibPayService.class);
	
	private static String CHARGEURL="chargeUrl";
	private static String CHARGECALLBACKURL="chargeCallbackUrl";
	private static String EXTRACTURL="extractUrl";
	private static String EXTRACTCALLBACKURL="extractCallbackUrl";
	private static String EXTRACTPER="extractPer";
	private static String MER_NO="mer_no";
	private static String KEY="Key";
	

	private   IJedisClient jedisClient;

	@Autowired
	private   ExchangeService ExchangeService;
	@Autowired
	private   TransExchange TransExchange;
	@Autowired
	private   tradeOrderMapper  tradeOrderMapper;
	@Autowired
	private   gameUserMapper  gameUserMapper;
	
	
	
	//客户端发起充值 http://127.0.0.1:8085/GameUser/exchange/chargeOrder?param={"uid": 30, "channel": 102,"bank_code":"IDPT0001","cost": 100}

	public   JSONObject  chargeOrder(JSONObject reqData,String orderLocal) throws Exception {
		String amount= reqData.getIntValue("cost")+"";
		long cost=reqData.getIntValue("cost")*100;
		int customer= reqData.getIntValue("customer");
		int uid= reqData.getIntValue("uid");
		String buy_currency= reqData.getString("buy_currency");
		String currency=reqData.getString("currency");
		long now=	System.currentTimeMillis()/1000;
		JSONObject 	result=new JSONObject();
		
		 StaticDataCache StaticDataCache=SpringContextUtil.getBean(StaticDataCache.class);
		 JSONObject NibPay=StaticDataCache.getData("NibPay",customer);
		 
		String chargeUrl= NibPay.getString("chargeUrl");
		String key= NibPay.getString("key");
		String merchant_id= NibPay.getString("merchant_id");
		String notifyUrl= NibPay.getString("chargeCallBack");
	
		List <gameUser> DBUsers=gameUserMapper.userById(uid);
		if(DBUsers==null || DBUsers.size()==0) {
			throw new ServiceException(StatusCode.GEN_ORDER_FAILED,"user_not_exist", null);
		}
		
//		{
//			“service”:”Pay.GatewayPay”
//			“channel_id”:”100000001”
//			“amount":"1",
//			"merchant_id":"100520000001",
//			“out_order_id”:"1111111111",
//			“timestamp":"14904528822",
//			“nonce”:”123123123123",
//			“notify_url”:”http://www.xxx.com”,
//			“pay_currency”:“USD”,
//			“buy_currency”:“USDT”,
//			“email”:”123456@qq.com ",
//			“attach”:"",
//			“sign":"SDGHYGHJ467FHJBNGCC",
//		}

		JSONObject ReqParam=  new JSONObject();

		ReqParam.put("service","Pay.GatewayPay");
		ReqParam.put("channel_id","1000000007");
//		ReqParam.put("s","\\\\/Pay.GatewayPay");
		ReqParam.put("s","s");
		ReqParam.put("amount",amount);
		ReqParam.put("merchant_id",merchant_id);
		ReqParam.put("out_order_id", orderLocal);
		ReqParam.put("timestamp",now+"");
		ReqParam.put("nonce",orderLocal);
		ReqParam.put("attach",customer+"");
		ReqParam.put("notify_url", notifyUrl);
		ReqParam.put("pay_currency",currency);
		ReqParam.put("buy_currency",buy_currency);

		Map<String, String> paramsMap = JSONObject.toJavaObject(ReqParam, Map.class);
		String sign=MD5Util.paramsSort(paramsMap)+"&secret="+key;
//		sign= sign.replaceAll("/", "\\\\/");
		log.info("=====================signStr:"+sign);
		sign= MD5Util.getMD5(sign).toUpperCase();
		log.info("=====================signResult:"+sign);
		paramsMap.put("sign", sign);
//		paramsMap.remove("s");
		log.info("=====================chargeOrder:"+paramsMap.toString());
		String	JsonAuth;
		try{
			HttpClientUtil  client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(chargeUrl, paramsMap);
		} catch (Exception e) {
			throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
		}
		if(JsonAuth==null) {
			throw new ServiceException(StatusCode.FAILED,"request_data_null", null);
		}
		log.info("=====================JsonAuth:"+JsonAuth);
		
//		{
//		"ret":200，
//		“data":{
//			“out_order_id”:"2154648931213456",
//			“gateway_url”:”http://www.xxx.cm/#/f9f6f194eaa6ffee96b5dcb31c4c12bb”,
//			“merchant_id":"15000001001"
//	"order_status":"1"
//		},
//		“msg":"success"

//}
		
		JSONObject AuthData =JSON.parseObject(JsonAuth);
		
		if(200==AuthData.getInteger("ret")){
			JSONObject data=AuthData.getJSONObject("data");
			String payurl=data.getString("gateway_url");
			String orderRemote=data.getString("out_order_id");
			result.put("orderRemote",orderRemote);
			result.put("payurl", payurl);
			result.put("now", now);
			
//			TransExchange.tranGenOrderIn(now,uid, orderLocal, orderRemote, "NibPay", "", cost, cost, currency);
			log.info("call:"+chargeUrl+"==============result:"+payurl);
		}else{
			log.info("call:"+chargeUrl+"failed===========err_msg:"+AuthData.getString("msg"));
		}
		return result;
	}

//	public void chargeCallBack(JSONObject reqData)throws Exception{
//		log.info("------------------------chargeCallBackData:"+reqData.toString());
//		StaticDataCache StaticDataCache=SpringContextUtil.getBean(StaticDataCache.class);
//		 JSONObject NibPay=StaticDataCache.getData("NibPay",reqData.getIntValue("attach"));
//		 String key=NibPay.getString("key");
//		 
////		 {
////				“order_id":"132154987",
////				“amount":"70.2",
////				“usd_amount”:”70.2”
////				“fee_amount":"2",
////				“fee_usd_amount":"2",
////				“value”:”10”,
////				“settle_value”:”9.8”,
////				“buy_currency”:”USDT”,
////				“pay_currency”:”USD”,
////				"merchant_id":"100520000001",
////				“out_order_id”:"1111111111",
////				"create_time":"14904528822",
////			    "order_status":"1"
////				“attach”:"",
////				“sign”:”",
////			}
//		 
//		 String remoteSign=reqData.getString("sign");
//		 reqData.remove("sign");
//		 Map<String, String> paramsMap = JSONObject.toJavaObject(reqData, Map.class);
//			String sign=MD5Util.paramsSort(paramsMap)+"&secret="+key;
//			sign= MD5Util.getMD5(sign);
//		if(!remoteSign.equals(sign)){
//			throw new ServiceException(StatusCode.FAILED,"chargeCallBack:sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
//		}
//		String orderLocal=reqData.getString("out_order_id");
//		String orderRemote=reqData.getString("order_id");
//		Double usd_amount =Double.valueOf(reqData.getString("usd_amount"))*100;//转换为Int类型
//		Double fee_usd_amount =Double.valueOf(reqData.getString("fee_usd_amount"))*100;//转换为Int类型
//		switch (reqData.getInteger("order_status")) {
//		case 1:
//			if(tradeOrderMapper.orderCallBack(orderLocal,orderRemote, usd_amount.longValue()-fee_usd_amount.longValue(),TransExchange.ORDER_PROCESSING, TransExchange.ORDER_SUCC)!=1) {
//				throw new TransException("status_update_failed");
//			}
//			log.info("chargeCallBack========orderRemote:"+orderRemote);
//			break;
//		default:
//			if(tradeOrderMapper.orderCallBack(orderLocal,orderRemote, usd_amount.longValue()-fee_usd_amount.longValue(),TransExchange.ORDER_PROCESSING, TransExchange.ORDER_FAILED)!=1) {
//				throw new TransException("status_update_failed");
//			}
//	
//			log.info("chargeCallBack:failed========orderRemote:"+orderRemote);
//			break;
//		}
//
//	}


	
	
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
		StaticDataCache StaticDataCache=SpringContextUtil.getBean(StaticDataCache.class);
		 JSONObject SepPay=StaticDataCache.getData("SepPay",1);
		 String merchantId=SepPay.getString("merchantId");
		 String extractUrl=SepPay.getString("extractUrl");
		 Integer accountType=SepPay.getInteger("accountType");
		 String notifyUrl=SepPay.getString("extractCallBack");
		 String key=SepPay.getString("key");
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
		StaticDataCache StaticDataCache=SpringContextUtil.getBean(StaticDataCache.class);
		 JSONObject SepPay=StaticDataCache.getData("SepPay",1);
		 String key=SepPay.getString("key");
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


