package com.cointer.service.otPay;







import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.ExchangeService;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;








@Service
public class OtPayService  {

	public static final int			PAY_BANK       = 907;
	public static final int			PAY_TM       = 931;
	public static final int			PAY_UPI       = 936;

	public static final int			SUCC_       = 10000;
	private   static int channelIndex =1;


	private static final Logger log = LoggerFactory.getLogger(OtPayService.class);

	@Autowired
	private   IJedisClient jedisClient;

	@Autowired
	private   ExchangeService ExchangeService;
	
	//客户端发起充值 http://127.0.0.1:8085/GameUser/exchange/chargeOrder?param={"uid": 30, "channel": 102,"bank_code":"IDPT0001","cost": 100}

	public   JSONObject  chargeOrder(int uid,int cost,String orderLocal,String bank_code) throws Exception {
		JSONObject resData=new JSONObject();

		String notify_url=RedisData.getUri(jedisClient,channelIndex,"chargeCallbackUrl");
		String charge_url=RedisData.getUri(jedisClient,channelIndex,"chargeUrl");
		String payKey=RedisData.getConf(jedisClient,channelIndex,"payKey");
		String channel=RedisData.getConf(jedisClient,channelIndex,"channel");
		String orderKey=RedisData.getConf(jedisClient,channelIndex,"orderKey");
		String mch_id=RedisData.getConf(jedisClient,channelIndex,"mch_id");

		//		sign_type	签名方式	String	Y	固定值 MD5，不参与签名
		//		sign	签名	String	Y	不参与签名
		//		mch_id	商户号	String	Y	平台分配唯一
		//		notify_url	后台通知地址	String	Y	不超过 200 字节
		//		page_url	前台通知地址	String	N	不超过 200 字节
		//		mch_order_no	商家订单号	String	Y	保证每笔订单唯一
		//		pay_type	支付类型	String	Y	请查阅商户后台通道编码
		//		trade_amount	交易金额	String	Y	整数，以元为单位
		//		order_date	订单时间	String	Y	时间格式： yyyy-MM-dd
		//		HH:mm:ss
		//		bank_code	银行代码	String	Y	网银B2C必填
		//		goods_name	商品名称	String	Y	不超过 50 字节
		//		mch_return_msg	透传参数	String	N	 不超过200字节
		Date Date =new Date(); 
		long now=	Date.getTime()/1000;
		DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；  
		String dateStr = DateFormat.format(Date);  

		JSONObject ReqParam=  new JSONObject();

		ReqParam.put("mch_id",mch_id);
		ReqParam.put("notify_url",notify_url);
		ReqParam.put("mch_order_no", orderLocal);
		ReqParam.put("pay_type", channel);
		ReqParam.put("trade_amount", cost+"");
		ReqParam.put("order_date", dateStr);
		ReqParam.put("bank_code", bank_code);
		ReqParam.put("goods_name", "coin_add");

//		JSONObject custom=new JSONObject();
//		custom.put("uid", uid);
//		custom.put("coin", cost);
//		custom.put("channel",channel);
//		custom.put("chargeExtract",chargeExtract);
//		ReqParam.put("mch_return_msg", custom.toString());

		Map<String, String> paramsMap = JSONObject.toJavaObject(ReqParam, Map.class);
		String sign=MD5Util.paramsSort(paramsMap)+"&key="+payKey;

		sign= MD5Util.getMD5(sign).toLowerCase();
		paramsMap.put("sign", sign);
		paramsMap.put("sign_type","MD5");
		String	JsonAuth;
		try{
			HttpClientUtil  client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(charge_url, paramsMap);
		} catch (Exception e) {
			throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
		}
		if(JsonAuth==null) {
			throw new ServiceException(StatusCode.FAILED,"request_data_null", null);
		}
		System.out.println("!!!!!!!!!!JsonAuth:"+JsonAuth);

		//		 JsonAuth =URLDecoder.decode(JsonAuth,"UTF-8");
		String paramStr =HttpClientUtil.TruncateUrlPage(JsonAuth);
		paramsMap=HttpClientUtil.URLRequest(paramStr);
		//		102 String orderKey="orderId";
		//		121 String orderKey="outOrderNo";
		resData.put("payurl", JsonAuth);
		resData.put("orderRemote", paramsMap.get(orderKey));
		resData.put("now", now);
		return resData;
	}

	public void chargeCallBack(JSONObject reqData)throws Exception{
		JSONObject  AuthData=null;
		//		tradeResult	订单状态	String	Y	1：支付成功
		//		mchId	商户号	String	Y	
		//		mchOrderNo	商家订单号	String	Y	
		//		oriAmount	原始订单金额	String	Y	商家上传的订单金额
		//		amount	交易金额	String	Y	实际支付金额
		//		orderDate	订单时间	String	Y	
		//		orderNo	平台支付订单号	  String	Y	
		//		merRetMsg	透传参数	  String	N	下单时未提交则无需参与签名
		//		signType	签名方式	String	Y	不参与签名
		//		sign	签名	String	Y	不参与签名

		System.out.println("!!!!!!!!!!JsonAuth:"+reqData.toString());
		Map<String, String> JsonAuthMap = JSONObject.toJavaObject(reqData, Map.class);
		String	remoteSign=reqData.getString("sign");
		JsonAuthMap.remove("sign");
		JsonAuthMap.remove("signType");
		String payKey=RedisData.getConf(jedisClient,channelIndex,"payKey");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+payKey;
		//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toLowerCase();
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error remoteSign:"+reqData.getString("sign")+"****sign:"+sign, null);
		}
    	AuthData=new JSONObject();
    	String orderLocal=reqData.getString("mchOrderNo");
    	String extractPer=RedisData.getConf(jedisClient,channelIndex,"extractPer");
    	switch (reqData.getIntValue("tradeResult")) {
    	case 1:
    		AuthData.put("succ", true);
    		AuthData.put("orderLocal", orderLocal);
    		AuthData.put("extractPer", extractPer);
    		break;
    	default:
    		AuthData.put("succ", false);
    		AuthData.put("orderLocal", orderLocal);
    		AuthData.put("extractPer", extractPer);
    		break;
    	}
    	ExchangeService.processCharge(AuthData);
		
		} 

	public   JSONObject  verifyExtract(tradeOrder  tradeOrder) throws Exception {
		JSONObject result=null;
		JSONObject ReqParam=  new JSONObject();
		String notify_url=RedisData.getUri(jedisClient,channelIndex,"extractCallbackUrl");
		String extract_url=RedisData.getUri(jedisClient,channelIndex,"extractUrl");
		String transferKey=RedisData.getConf(jedisClient,channelIndex,"transferKey");
		String mch_id=RedisData.getConf(jedisClient,channelIndex,"mch_id");



		//			sign_type	签名方式	String	Y	固定值MD5，不参与签名
		//			sign	签名	String	Y	不参与签名
		//			mch_id	商户代码	String	Y	平台分配唯一
		//			mch_transferId	商家转账订单号	String	Y	保证每笔订单唯一
		//			transfer_amount	转账金额	String	Y	整数，以元为单位
		//			apply_date	申请时间	String	Y	时间格式：yyyy-MM-dd HH:mm:ss
		//			bank_code	收款银行代码	String	Y	详见银行代码表
		//			receive_name	收款银行户名	String	Y	银行户名
		//			receive_account	收款银行账号	String	Y	银行账号
		//			remark	印度金融系统码(IFSC CODE)	String	N	印度代付必填
		//			back_url	代付异步通知地址	String	N	若填写则需参与签名
		Date Date =new Date(); 
//		long now=	Date.getTime()/1000;
		DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；  
		String dateStr = DateFormat.format(Date);  
		String AccountOut=tradeOrder.getAccountOut();
		JSONObject outInfo=JSONObject.parseObject(AccountOut);


		ReqParam.put("mch_id",mch_id);
		ReqParam.put("mch_transferId", tradeOrder.getOrderLocal());
		ReqParam.put("apply_date", dateStr);
		ReqParam.put("transfer_amount", (int)tradeOrder.getCost()+"");
		ReqParam.put("back_url", notify_url);


		ReqParam.put("receive_name", outInfo.getString("receive_name"));
		ReqParam.put("receive_account", outInfo.getString("receive_account"));
		ReqParam.put("remark", outInfo.getString("remark"));
		ReqParam.put("bank_code", outInfo.getString("bank_code"));
		Map<String, String> jsonMap = JSONObject.toJavaObject(ReqParam, Map.class);

		String sign=MD5Util.paramsSort(jsonMap)+"&key="+transferKey;
		//			sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toLowerCase();
		jsonMap.put("sign", sign);
		jsonMap.put("sign_type", "MD5");

		String	JsonAuth=null;
		try {
			HttpClientUtil  client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(extract_url, jsonMap);
		} catch (Exception e) {
			throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
		}

		if(JsonAuth==null) {
			throw new ServiceException(StatusCode.FAILED,"request_data_null", null);
		}
		System.out.println("JsonAuth:"+JsonAuth);
		JSONObject AuthData = JSONObject.parseObject(JsonAuth, Feature.OrderedField);


		
		
		String remoteSign=AuthData.getString("sign");
		//			String orderStatus=AuthData.getString("status");
		

		Map<String, String> JsonAuthMap = JSONObject.parseObject(JsonAuth, Map.class);
		JsonAuthMap.remove("sign");
		JsonAuthMap.remove("signType");
		JsonAuthMap.remove("errorMsg");
		sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+transferKey;
		//			sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toLowerCase();

		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		
		String status=AuthData.getString("respCode");
		result=new JSONObject();
		if(status.equals("SUCCESS")) {
			String transactionid=AuthData.getString("tradeNo");
			result.put("succ",true);
			result.put("orderRemote",transactionid);
		}else {
			String retMsg=AuthData.getString("errorMsg");
			System.out.println("!!!!!!!!!!retMsg:"+retMsg);
			result.put("succ",false);
		}
		return result;
	}	


	














	//  提现回调
	public   void  extractCallBack(JSONObject reqData) throws Exception {
		JSONObject AuthData=null; 
		Map<String, String> JsonAuthMap = JSONObject.toJavaObject(reqData, Map.class);
		String remoteSign=reqData.getString("sign");

		JsonAuthMap.remove("sign");
		JsonAuthMap.remove("signType");
		String transferKey=RedisData.getConf(jedisClient,channelIndex,"transferKey");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+transferKey;
		//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toLowerCase();
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error  remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		String orderLocal=reqData.getString("merTransferId");

		AuthData=new JSONObject();
    	switch (reqData.getInteger("tradeResult")) {
    	case 1:
    		AuthData.put("succ", true);
    		AuthData.put("orderLocal", orderLocal);
    		break;
    	default:
    		AuthData.put("succ", false);
    		AuthData.put("orderLocal", orderLocal);
    		break;
    	}
    	ExchangeService.processExtract(AuthData);
		



	}	

































}


