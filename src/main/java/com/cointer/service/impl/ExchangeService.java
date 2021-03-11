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

	//客户端发起充值 http://127.0.0.1:8085/GameUser/exchange/chargeOrder?param={"uid": 3, "channel": 8021,"cost": 100}
	@Override
	public   Object  chargeOrder(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int channel =reqData.getIntValue("channel");
		int cost=reqData.getIntValue("cost");
		List <gameUser> DBUsers=gameUserMapper.userById(uid);
		if(DBUsers==null || DBUsers.size()==0) {
			throw new ServiceException(StatusCode.GEN_ORDER_FAILED,"user_not_exist", null);
		}
		gameUser gameUser=DBUsers.get(0);
		String orderid=CommTypeUtils.getOrderNo("OrderIn");
		
		String notify_url=RedisData.getUri(jedisClient,0,"chargeCallbackUrl");
		String charge_url=RedisData.getUri(jedisClient,0,"chargeUrl");
		String goldKey=RedisData.getConf(jedisClient,0,"goldKey");
		String customerId=RedisData.getConf(jedisClient,0,"customerId");
		String appId=RedisData.getConf(jedisClient,0,"appId");
		


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
		ReqParam.put("appId",appId);
		ReqParam.put("productId",channel);
		ReqParam.put("mchOrderNo", orderid);
		ReqParam.put("currency", "INR");
		ReqParam.put("amount", cost*100);
		ReqParam.put("notifyUrl", notify_url);
		ReqParam.put("subject", "coin_add");
		ReqParam.put("body", "add_coin:"+cost);
		
		


		JSONObject custom=new JSONObject();
		custom.put("uid", uid);
		custom.put("coin", cost);
		custom.put("channel",channel);
		ReqParam.put("param1", custom.toString());
		
		Map<String, String> jsonMap = JSONObject.toJavaObject(ReqParam, Map.class);

		String sign=MD5Util.paramsSort(jsonMap)+"&key="+goldKey;
		
		sign= MD5Util.getMD5(sign).toUpperCase();
		ReqParam.put("sign", sign);
		Map<String,String> paramsMap=new HashMap<String,String>();
		paramsMap.put("params", ReqParam.toString());
		
		String	JsonAuth;
		try {
			HttpClientUtil  client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(charge_url, paramsMap);
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
	public void chargeCallBack(JSONObject reqData)throws Exception{
		
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
		
	
		Map<String, String> JsonAuthMap = JSONObject.toJavaObject(reqData, Map.class);
	    String	remoteSign=reqData.getString("sign");
		JsonAuthMap.remove("sign");
		String goldKey=RedisData.getConf(jedisClient,0,"goldKey");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+goldKey;
//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toUpperCase();
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error remoteSign:"+reqData.getString("sign")+"****sign:"+sign, null);
		}
		try {
			if(reqData.getInteger("status")==2) {
				JSONObject	custom	=JSONObject.parseObject(reqData.getString("param1"));
				int realMoney=custom.getInteger("coin")*89/100;
				int PresenterId=TransExchange.tranChargeSucc(reqData.getString("mchOrderNo"),custom.getIntValue("uid"),custom.getIntValue("coin"),realMoney);
			  
			}else {
				TransExchange.tranChargeFailed(reqData.getString("mchOrderNo"));
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
			int coin=reqData.getIntValue("coin");
//			String accountAttr=reqData.getString("accountAttr");
//			Integer bankType=reqData.getInteger("bankType");
//			String bankCode=reqData.getString("bankCode");
//			String bankName= reqData.getString("bankName");
			String accountType= reqData.getString("accountType");
			String accountName= reqData.getString("accountName");
			String accountNo= reqData.getString("accountNo");
			String province= reqData.getString("province");
			String city= reqData.getString("city");
			
			float cost=  coin;
			coin=(int)((float)coin*102/100+0.99);
			
			List <gameUser> DBUsers=gameUserMapper.userById(uid);
			if(DBUsers==null || DBUsers.size()==0) {
				throw new ServiceException(StatusCode.GEN_ORDER_FAILED,"user_not_exist", null);
			}
			gameUser gameUser=DBUsers.get(0);
			String orderid=CommTypeUtils.getOrderNo("OrderOut");
			int fId = RedisData.genFreezeId(jedisClient);
			JSONObject outInfo= new JSONObject();
			
//			outInfo.put("accountAttr", accountAttr);
//			outInfo.put("bankType", bankType);
//			outInfo.put("bankCode", bankCode);
//			outInfo.put("bankName", bankName);
			outInfo.put("accountType", accountType);
			outInfo.put("accountName", accountName);
			outInfo.put("accountNo", accountNo);
			outInfo.put("province", province);
			outInfo.put("city", city);
			String AccountOut=outInfo.toString();
			
			TransExchange.tranGenOrderOut(uid,gameUser.getAgentId(),fId,orderid,orderid, accountNo, AccountOut,cost, coin, "INR");	

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
			String appId=RedisData.getConf(jedisClient,0,"appId");
			

			
//		  商户 ID            mchId        是         long      20001222                        分配的商户号
//		     应用 ID            appId        是       String(32)  0ae8be35ff634e2abe94f5f32f6d5c4f 该商户创建的应用对应的 ID                    
//		   商户订单号                           是       String(30) 
//		      币种             currency      是       String(3)   INR                             三位货币代码,卢比币:INR 
//		    代付金额             amount        是          int      100                             代付金额,单位盧比
//		    客户端 IP           clientIp      否       String(32)  210.73.10.148                   客户端 IP 地址
//		      设备              device       否       String(64)  ios10.3.1                       客户端设备
//		代付结果后台回              notifyUrl     是      String(128) 
			
//		    账户属性            accountAttr    否       String(1)   0             
//		     联行号            bankType       否          int      123                             联行号
//		    银行代码            bankCode       否       String(32)  HP00001                         参考章节4.3的代付银行代码 
//		   开户行名称            bankName       否      String(128)  中国建设银行                                                     1-银行卡转账,2-微信转账,3-支付
//		    账户类型           accountType     是       String(1)   1 
//		     账户名           accountName     是       String(64)  测试                              账户名
//		     账户号            accountNo      是       String(64)  1234567890123                   账户号
//		 开户行所在省份             province      是       String(32)  江苏                              开户行所在省份
//		  开户行所在市               city        是       String(32)  上海                              开户行所在市 
//		    扩展参数 1           param1        否       String(64)    
//		    扩展参数 2           param2        否       String(64)                                    C380BEC2BFD727A4B6845133519F
//		      签名               sign        是       String(32)                                  签名值，详见签名算法
			String AccountOut=tradeOrder.getAccountOut();
			JSONObject outInfo=JSONObject.parseObject(AccountOut);
			
			
			ReqParam.put("mchId",customerId);
			ReqParam.put("appId",appId);
			ReqParam.put("mchTransOrderNo", tradeOrder.getOrderLocal());
			ReqParam.put("currency", tradeOrder.getCurrency());
			ReqParam.put("amount", (int)tradeOrder.getCost()*100+"");
			ReqParam.put("notifyUrl", notify_url);
			
			
			
			
			
//			ReqParam.put("accountAttr", outInfo.getString("accountAttr"));
//			ReqParam.put("bankType", outInfo.getInteger("bankType"));
//			ReqParam.put("bankCode", outInfo.getString("bankCode"));
//			ReqParam.put("bankName", outInfo.getString("bankName"));
			ReqParam.put("accountType", outInfo.getString("accountType"));
			ReqParam.put("accountName", outInfo.getString("accountName"));
			ReqParam.put("accountNo", outInfo.getString("accountNo"));
			ReqParam.put("province", outInfo.getString("province"));
			ReqParam.put("city", outInfo.getString("city"));
		
			JSONObject custom=new JSONObject();
			custom.put("uid", tradeOrder.getUid());
			custom.put("coin", (int)tradeOrder.getCost());
			custom.put("freezeId", tradeOrder.getFreezeId());
			ReqParam.put("param1", custom.toString());
			
			
			Map<String, String> jsonMap = JSONObject.toJavaObject(ReqParam, Map.class);

			String sign=MD5Util.paramsSort(jsonMap)+"&key="+goldKey;
//			sign= sign.replaceAll("/", "\\\\/");
			System.out.println("sign1:"+sign);
			sign= MD5Util.getMD5(sign).toUpperCase();
			System.out.println("sign2:"+sign);
			jsonMap.put("sign", sign);
			String	JsonAuth;
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
			
			
			String status=AuthData.getString("retCode");
			if(!status.equals("SUCCESS")) {
				String retMsg=AuthData.getString("retMsg");
				System.out.println("!!!!!!!!!!retMsg:"+retMsg);
				throw new ServiceException(StatusCode.FAILED,"request_failed  status:"+status, null);
			}
			
			String remoteSign=AuthData.getString("sign");
//			String orderStatus=AuthData.getString("status");
			String transactionid=AuthData.getString("transOrderId");
			
			Map<String, String> JsonAuthMap = JSONObject.parseObject(JsonAuth, Map.class);
			JsonAuthMap.remove("sign");
			sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+goldKey;
//			sign= sign.replaceAll("/", "\\\\/");
			sign= MD5Util.getMD5(sign).toUpperCase();

			if(!remoteSign.equals(sign)){
				throw new ServiceException(StatusCode.FAILED,"sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
			}
			
			tradeOrderMapper.updateOrderRemote(tradeOrder.getId(),  transactionid);
			resData.put("transactionid", transactionid);

			return resData;
		}

		

		
		
		
		
		
		

	

	//  提现回调
	@Override
	public   void  extractCallBack(JSONObject reqData) throws Exception {
		Map<String, String> JsonAuthMap = JSONObject.toJavaObject(reqData, Map.class);
        String remoteSign=reqData.getString("sign");
        
        JsonAuthMap.remove("sign");
		String goldKey=RedisData.getConf(jedisClient,0,"goldKey");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+goldKey;
//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toUpperCase();
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error  remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		try {
			JSONObject	custom	=JSONObject.parseObject(reqData.getString("param1"));
			if(reqData.getInteger("status")==2) {
				TransExchange.tranExtractSucc( reqData.getString("mchTransOrderNo"), custom.getIntValue("freezeId"), custom.getIntValue("uid"), custom.getIntValue("coin"),(float)custom.getIntValue("coin"));
			}else {                            
				TransExchange.tranExtractFailed( reqData.getString("mchTransOrderNo"), custom.getIntValue("freezeId"), custom.getIntValue("uid"), custom.getIntValue("coin"));
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


