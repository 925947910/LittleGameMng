package com.cointer.service.impl;









import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.omg.CORBA.INTERNAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.cointer.constant.StatusCode;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.pojo.dto.tokenMapChargeDto;
import com.cointer.pojo.dto.chargeCallBack1Dto;
import com.cointer.pojo.dto.extractDto;
import com.cointer.pojo.dto.freezeDto;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IExchangeService;
import com.cointer.trans.TransExchange;
import com.cointer.util.CommTypeUtils;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.util.RSAUtils;
import com.cointer.util.SpringContextUtil;








@Service
public class ExchangeService  implements IExchangeService{

	public static final int			PAY_BANK       = 907;
	public static final int			PAY_TM       = 931;
	public static final int			PAY_UPI       = 936;
	
	public static final int			SUCC_       = 10000;
	
	
	
	private static final Logger log = LoggerFactory.getLogger(ExchangeService.class);
	@Autowired
	private   gameUserMapper gameUserMapper;
	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   TransExchange TransExchange;
	@Autowired
	private   tradeOrderMapper tradeOrderMapper;
	@Autowired
	private   freezeMapper freezeMapper;

	//客户端发起充值 http://127.0.0.1:8085/GameUser/exchange/chargeOrder?param={"uid": 3, "channel": 907,"cost": 100, "userip": "127.0.0.1"}
	@Override
	public   Object  chargeOrder(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int channel =reqData.getIntValue("channel");
		int cost=reqData.getIntValue("cost");
		String userip=reqData.getString("userip");
		List <gameUser> DBUsers=gameUserMapper.userById(uid);
		if(DBUsers==null || DBUsers.size()==0) {
			throw new ServiceException(StatusCode.GEN_ORDER_FAILED,"user_not_exist", null);
		}
		gameUser gameUser=DBUsers.get(0);
		String orderid=CommTypeUtils.getOrderNo("OrderIn");
		
		String notify_url=RedisData.getUri(jedisClient,0,"chargeCallbackUrl");
		String return_url=RedisData.getUri(jedisClient,0,"chargeSuccUrl");
		String charge_url=RedisData.getUri(jedisClient,0,"chargeUrl");
		String goldKey=RedisData.getConf(jedisClient,0,"goldKey");
		String customerId=RedisData.getConf(jedisClient,0,"customerId");

		Date d=new Date();
		DateFormat format=new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		int timestamp=(int)(d.getTime()/1000);

//		商户 ID            mchId        是         long      20001222                        分配的商户号
//		应用 ID            appId        是       String(32)  0ae8be35ff634e2abe94f5f32f6d5c4f 该商户创建的应用对应的 ID 
//		支付产品 ID           productId     是          int      8000                            支付产品 ID 
//		商户订单号           mchOrderNo      是       String(30)  20160427210604000490            商户生成的订单号
//		币种             currency      是       String(3)   INR                             三位货币代码,卢比币:INR 
//		支付金额             amount        是          int      100                             支付金额,单位盧比
//		客户端 IP           clientIp      否       String(32)  210.73.10.148                   客户端 IP 地址
//		设备              device       否       String(64)  ios10.3.1                       客户端设备
//		支付结果前端跳              returnUrl     否      String(128)  http://domain/return.htm 
//				支付结果后台回              notifyUrl     是      String(128)  http://domain/notify.htm 
//				商品主题                                        subject      是       String(64)  测试商品名称                          商品主题
//				商品描述信息                               body         是      String(256)  测试商品描述                          商品描述信息
//				扩展参数 1           param1        否       String(64)                                  必填，请填入汇款人银行代
//				扩展参数 2           param2        否       String(64)                                  支付中心回调时会原样返回
//				sign        是       String(32) 
//				签名                                               3AD6                            签名值，详见签名算法 
		
		JSONObject ReqParam=  new JSONObject();
		ReqParam.put("mchId",customerId);
		ReqParam.put("appId","bigWinner");
		ReqParam.put("productId",100);
		ReqParam.put("mchOrderNo", orderid);
		ReqParam.put("currency", "INR");
		ReqParam.put("amount", cost*100);
		ReqParam.put("notifyUrl", notify_url);
		ReqParam.put("subject", "coin_add");
		ReqParam.put("body", "add_coin:"+cost);
		
		


		JSONObject custom=new JSONObject();
		custom.put("uid", uid);
		custom.put("coin", cost);
		ReqParam.put("param1", custom.toString());
		
		Map<String, String> jsonMap = JSONObject.toJavaObject(ReqParam, Map.class);

		String sign=MD5Util.paramsSort(jsonMap)+"&key="+goldKey;
		
		sign= MD5Util.getMD5(sign).toUpperCase();
		ReqParam.put("sign", sign);
		String params=ReqParam.toString();
		
		ReqParam.clear();
		ReqParam.put("params", params);
		
		String	JsonAuth;
		try {
			HttpClientUtil  client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(charge_url, ReqParam.toString());
		} catch (Exception e) {
			throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
		}

		if(JsonAuth==null) {
			throw new ServiceException(StatusCode.FAILED,"request_data_null", null);
		}

		JSONObject AuthData = JSONObject.parseObject(JsonAuth, Feature.OrderedField);
		String status=AuthData.getString("retCode");
		if(!status.equals("SUCCESS")) {
			String retMsg=AuthData.getString("retMsg");
			System.out.println("!!!!!!!!!!retMsg:"+retMsg);
			throw new ServiceException(StatusCode.FAILED,"request_failed  status:"+status, null);
		}
		
		String remoteSign=AuthData.getString("sign");
		String transactionid=AuthData.getString("payOrderId");
		String payParams=AuthData.getString("payParams");
		
		Map<String, String> JsonAuthMap = JSONObject.parseObject(JsonAuth, Map.class);
		
		JsonAuthMap.remove("sign");
		JsonAuthMap.put("payParams", payParams);
		sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+goldKey;
//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toUpperCase();

		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
		}

		String payurl=AuthData.getJSONObject("payParams").getString("payUrl");
		TransExchange.tranGenOrderIn(uid,gameUser.getAgentId(),orderid,transactionid, "", "", cost, cost, "INR");	
		resData.put("transactionid", transactionid);
		resData.put("payurl", payurl);

		return resData;
	}
	@Override
	public void chargeCallBack(chargeCallBack1Dto chargeCallBack1Dto)throws Exception{
		
//	      支付订单号             payOrderId      是       String(30)  P20160427210604000490         支付中心生成的订单号
//	       商户 ID             mchId         是       String(30)  20001222                      支付中心分配的商户号
//	       应用 ID             appId         是       String(32)  0ae8be35ff634e2abe94f5f32f6d5 该商户创建的应用对应的
//	     支付产品 ID            productId      是          int      8001                          支付产品 ID 
//	     商户订单号            mchOrderNo       是       String(30)  20160427210604000490          商户生成的订单号
//	      支付金额              amount         是          int      100                           支付金额,单位盧比
//	                                                                                         支付状态,0-订单生成,1-支
//	        状态               status        是          int 
//	                                                           1                             付中,2- 支付成功,3-业务处
//	                                                                                         理完成(成功),5-支付失败
//	                                                           wx2016081611532915ae15beab0
//	     渠道订单号          channelOrderNo     否       String(64)                                三方支付渠道订单号 
//	                                                           167 893571 
//	                                                           {“bank_type”:”CMB_DEBIT                   
//	     渠道数据包            channelAttach    否        String     ”,” 
//	                                                           trade_type”:”pay.weixin.microp 支付渠道数据包 
//	                                                           ay”} 
//
//	     扩展参数 1             param1         否       String(64)                                支付中心回调时会原样返
//	     扩展参数 2             param2         否       String(64)                                支付中心回调时会原样                                                   
//	   支付成功时间             paySuccTime      是         long                                    精确到毫秒                         
//	      通知类型              backType       是          int                                    通知类型，1-前台通知，2-
//	                                                           1                             后台通知
//	                                                           C380BEC2BFD727A4B6845133
//	        签名                sign         是       String(32)                                签名值，详见签名算法
		
		JSONObject AuthData = (JSONObject) JSONObject.toJSON(chargeCallBack1Dto);
		Map<String, String> JsonAuthMap = JSONObject.toJavaObject(AuthData, Map.class);

		String goldKey=RedisData.getConf(jedisClient,0,"goldKey");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+goldKey;
//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toUpperCase();
		if(!chargeCallBack1Dto.getSign().equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error remoteSign:"+chargeCallBack1Dto.getSign()+"****sign:"+sign, null);
		}
		try {
			if(chargeCallBack1Dto.getStatus()==3) {
				JSONObject	custom	=JSONObject.parseObject(chargeCallBack1Dto.getParam1());
				int PresenterId=TransExchange.tranChargeSucc(chargeCallBack1Dto.getMchOrderNo(),custom.getIntValue("uid"),custom.getIntValue("coin"),AuthData.getFloatValue("real_amount"));
			  
			}else {
				TransExchange.tranChargeFailed(chargeCallBack1Dto.getMchOrderNo());
			}
		} 
		catch (TransException TransException) {
			log.warn(TransException.getMsg());
		}
		
	}	
	
	
	//客户端发起提现 http://127.0.0.1:8085/GameUser/exchange/extractOrder?param={"uid": 1, "channel": 713,"coin": 1000, "userip": "127.0.0.1", "bank_ifsc": "HDFC0000027", "bank_id": "3001", "bank_no": "6262662666662666", "bank_account": "yeah"}
		@Override
		public   Object  extractOrder(String  RequestJsonData) throws Exception {
			JSONObject reqData=JSON.parseObject(RequestJsonData);
			JSONObject resData=new JSONObject();
			int uid =reqData.getIntValue("uid");
			int channel =reqData.getIntValue("channel");
			int coin=reqData.getIntValue("coin");
			
			float cost=  coin;
			coin=(int)((float)coin*105/100+0.99);
			String userip=reqData.getString("userip");
			String bank_ifsc=reqData.getString("bank_ifsc");
			String bank_account=reqData.getString("bank_account");
			String bank_no=reqData.getString("bank_no");
			int bank_id =reqData.getIntValue("bank_id");
			List <gameUser> DBUsers=gameUserMapper.userById(uid);
			if(DBUsers==null || DBUsers.size()==0) {
				throw new ServiceException(StatusCode.GEN_ORDER_FAILED,"user_not_exist", null);
			}
			gameUser gameUser=DBUsers.get(0);
			String orderid=CommTypeUtils.getOrderNo("OrderOut");
			int fId = RedisData.genFreezeId(jedisClient);
			JSONObject outInfo= new JSONObject();
			outInfo.put("channel", channel);
			outInfo.put("userip", userip);
			outInfo.put("bank_ifsc", bank_ifsc);
			outInfo.put("bank_account", bank_account);
			outInfo.put("bank_no", bank_no);
			outInfo.put("bank_id", bank_id);
			String AccountOut=outInfo.toString();
			
			TransExchange.tranGenOrderOut(uid,gameUser.getAgentId(),fId,orderid,orderid, bank_no, AccountOut,cost, coin, "INR");	

			return resData;
		}
	
		//客户端发起提现 http://127.0.0.1:8085/GameUser/exchange/verifyExtract
		@Override
		public   Object  verifyExtract(String  RequestJsonData) throws Exception {
			JSONObject reqData=JSON.parseObject(RequestJsonData);
			JSONObject resData=new JSONObject();
			int orderId =reqData.getIntValue("orderId");
			int succ =reqData.getIntValue("succ");
			
			List<tradeOrder> tradeOrders=tradeOrderMapper.tradeOrderById(orderId);
			 tradeOrder tradeOrder= tradeOrders.get(0);
			
			if(succ!=1){
				TransExchange.tranExtractFailed(tradeOrder.getOrderLocal(), tradeOrder.getFreezeId(),tradeOrder.getUid(), tradeOrder.getCoin());
				return  resData;
			}
			 
			JSONObject ReqParam=  new JSONObject();
			String notify_url=RedisData.getUri(jedisClient,0,"extractCallbackUrl");
			String extract_url=RedisData.getUri(jedisClient,0,"extractUrl");
			String goldKey=RedisData.getConf(jedisClient,0,"goldKey");
			String customerId=RedisData.getConf(jedisClient,0,"customerId");

			Date d=new Date();
			DateFormat format=new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
			format.setTimeZone(TimeZone.getTimeZone("GMT"));
			int timestamp=(int)(d.getTime()/1000);

			
//			商户ID	uid	string(5)	商户ID号
//			订单号	orderid	string(50)	商户平台生成的订单号，唯一
//			代付类型	channel	int	参数值见末尾页「代付类型」
//			异步通知地址	notify_url	string(100)	http/https开头字符串，支付完成后，通过POST请求的形式将支付结果作为参数通知到商户系统
//			金额	amount	float	商家提交金额，接受小数点后两位
//			客端IP	userip	string(40)	商家会员ip地址
//			时间戳	timestamp	int	GMT时间戳
//			自定义	custom	string(100)	原样返回（空字符串也必需传输）
//			数据签名	sign	string(32)	32位大写MD5签名值
//			IFSC	bank_ifsc	string(20)	IFSC
//			收款人开户姓名	bank_account	string(50)	收款人开户姓名
//			收款人银行帐号	bank_no	string(20)	收款人银行帐号
//			银行编号	bank_id	int	参数值见末尾页「银行编号」
			String AccountOut=tradeOrder.getAccountOut();
			JSONObject outInfo=JSONObject.parseObject(AccountOut);
			
			
			ReqParam.put("uid",customerId);
			ReqParam.put("orderid", tradeOrder.getOrderLocal());
			ReqParam.put("channel", outInfo.getInteger("channel"));
			ReqParam.put("notify_url", notify_url);
			ReqParam.put("amount", tradeOrder.getCost()+"");
			ReqParam.put("userip", outInfo.getString("userip"));
			ReqParam.put("timestamp", timestamp);
			JSONObject custom=new JSONObject();
			custom.put("uid", tradeOrder.getUid());
			custom.put("coin", tradeOrder.getCoin());
			custom.put("freezeId", tradeOrder.getFreezeId());
			
			ReqParam.put("custom", custom.toString());
			ReqParam.put("bank_ifsc", outInfo.getString("bank_ifsc"));
			ReqParam.put("bank_account", outInfo.getString("bank_account"));
			ReqParam.put("bank_no", outInfo.getString("bank_no"));
			ReqParam.put("bank_id", outInfo.getInteger("bank_id"));
			
			Map<String, String> jsonMap = JSONObject.toJavaObject(ReqParam, Map.class);

			String sign=MD5Util.paramsSort(jsonMap)+"&key="+goldKey;
//			sign= sign.replaceAll("/", "\\\\/");
			System.out.println("sign1:"+sign);
			sign= MD5Util.getMD5(sign).toUpperCase();
			System.out.println("sign2:"+sign);
			ReqParam.put("sign", sign);
			String	JsonAuth;
			try {
				HttpClientUtil  client=HttpClientUtil.getInstance();
				JsonAuth=client.doPostWithJsonResult(extract_url, ReqParam.toString());
			} catch (Exception e) {
				throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
			}

			if(JsonAuth==null) {
				throw new ServiceException(StatusCode.FAILED,"request_data_null", null);
			}
			System.out.println("JsonAuth:"+JsonAuth);
			JSONObject AuthData = JSONObject.parseObject(JsonAuth, Feature.OrderedField);
			int status=AuthData.getIntValue("status");
			String remoteSign=AuthData.getString("sign");
			String resultData=AuthData.getString("result");
			if(status!=SUCC_) {
				throw new ServiceException(StatusCode.FAILED,"request_failed  status:"+status, null);
			}

			Map<String, String> JsonAuthMap = JSONObject.parseObject(JsonAuth, Map.class);
			JsonAuthMap.remove("sign");
			JsonAuthMap.put("result", resultData);
			sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+goldKey;
			sign= sign.replaceAll("/", "\\\\/");
			sign= MD5Util.getMD5(sign).toUpperCase();

			if(!remoteSign.equals(sign)){
				throw new ServiceException(StatusCode.FAILED,"sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
			}

			String transactionid=AuthData.getJSONObject("result").getString("transactionid");
			tradeOrderMapper.updateOrderRemote(tradeOrder.getId(),  transactionid);
			resData.put("transactionid", transactionid);

			return resData;
		}

		

		
		
		
		
		
		

	

	//  提现回调
	@Override
	public   void  extractCallBack(int status,String resultData,String remoteSign) throws Exception {
		JSONObject AuthData = JSONObject.parseObject(resultData, Feature.OrderedField);
		Map<String, String> JsonAuthMap = new HashMap<String,String>();

		String goldKey=RedisData.getConf(jedisClient,0,"goldKey");
		JsonAuthMap.put("result", resultData);
		JsonAuthMap.put("status", status+"");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+goldKey;
		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toUpperCase();
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error  remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		try {
			JSONObject	custom	=JSONObject.parseObject(AuthData.getString("custom"));
			if(status==SUCC_) {
				TransExchange.tranExtractSucc( AuthData.getString("orderid"), custom.getIntValue("freezeId"), custom.getIntValue("uid"), custom.getIntValue("coin"),AuthData.getFloatValue("real_amount"));
			}else {                            
				TransExchange.tranExtractFailed( AuthData.getString("orderid"), custom.getIntValue("freezeId"), custom.getIntValue("uid"), custom.getIntValue("coin"));
			}
		} 
		catch (TransException TransException) {
			log.warn(TransException.getMsg());
		}
		
		
	}	



	//  鏌ヨ璁㈠崟鎺ュ彛
	public   Object  orderInfo(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		String orderNo=reqData.getString("orderNo");
		String sign=reqData.getString("orderNoStr");
		String genSign = MD5Util.getSaltMD5(orderNo, MD5Util.SALT);
		//楠岃瘉绛惧悕鏄惁姝ｇ‘
		if(!genSign.equals(sign)) {
			throw new ServiceException(StatusCode.SIGN_ERROR,"sign_error", null);
		}
			List<tradeOrder> tradeOrders=tradeOrderMapper.OrderStatusByOrderRemote(orderNo);
			int orderStatus=4;
			if(tradeOrders.size()!=0) {
				orderStatus= tradeOrders.get(0).getStatus();
			}else {
				orderStatus=4;
			}
			switch (orderStatus) {
			case 3:
				orderStatus=0;
				break;
			case 4:
				orderStatus=1;
				break;
			default:
				orderStatus=2;
				break;
			}
			JSONObject data=new JSONObject();
			data.put("orderStatus", orderStatus);
			return data;
		
	}


	


	



//	{"code":0,"data":[{"type":"deposit","snapshot_id":"74e3c5d2-04b7-405d-b509-81291c048bbe","asset_id":"4d8c508b-91c5-375b-92b0-ee702ed2dac5","transaction_hash":"0x02de278dd526f57fb146844b244051a4e28ad375c274e3b4caac8225344ac6ab","output_index":0,"sender":"0x6748F50f686bfbcA6Fe8ad62b22228b87F31ff2b","amount":"3","opening_balance":"2","closing_balance":"5","created_at":"2020-03-04T12:26:56.646442Z"},{"type":"deposit","snapshot_id":"fa4c6fa4-164f-42f9-8e2f-75e8cc037b5f","asset_id":"4d8c508b-91c5-375b-92b0-ee702ed2dac5","transaction_hash":"0xe7b4eac519250351dcf5fb50fe8dd5ab277339bcd56f49db7feb9f6a93a8ace0","output_index":0,"sender":"0x46705dfff24256421A05D056c29E81Bdc09723B8","amount":"2","opening_balance":"0","closing_balance":"2","created_at":"2020-03-04T11:26:45.729179Z"}]}


























}


