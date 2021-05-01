package com.cointer.service.impl;









import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.cointer.constant.StatusCode;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.pojo.tikPay.ReqOrderPo;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IExchangeService;
import com.cointer.trans.TransExchange;
import com.cointer.util.CommTypeUtils;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.service.tikPay.TikPayService;








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
	@Autowired
	private   GameTaskService GameTaskService;
	@Autowired
	private   TikPayService TikPayService;
	
	//客户端发起充值 http://127.0.0.1:8085/GameUser/exchange/chargeOrder?param={"uid": 30, "channel": 102,"bank_code":"IDPT0001","cost": 100}
	@Override
	public   Object  chargeOrder(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int cost=reqData.getIntValue("cost");
		List <gameUser> DBUsers=gameUserMapper.userById(uid);
		if(DBUsers==null || DBUsers.size()==0) {
			throw new ServiceException(StatusCode.GEN_ORDER_FAILED,"user_not_exist", null);
		}
		gameUser gameUser=DBUsers.get(0);
		String orderLocal=CommTypeUtils.getOrderNo("OrderIn");
		
		String channel=RedisData.getUri(jedisClient,0,"channelIn");
		JSONObject	AuthData=null;
		int plat=0;
		switch (channel) {
		case "OtPay":
			plat=1;
			break;
        case "TikPay":
        	plat=2;
        	ReqOrderPo ReqOrderPo= new ReqOrderPo();
        	ReqOrderPo.setAmount(cost+"");
        	ReqOrderPo.setThirdUserId(uid+"");
        	ReqOrderPo.setThirdOrderNumber(orderLocal);
        	AuthData=TikPayService.chargeOrder(ReqOrderPo);
			break;
		default:
			break;
		}
		if(AuthData==null) {
			throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
	    }
		String orderRemote=AuthData.getString("orderRemote");
		String payurl=AuthData.getString("payurl");
		long   now=AuthData.getLongValue("now");
		TransExchange.tranGenOrderIn(plat,now,uid,gameUser.getAgentId(),gameUser.getPresenterId(),orderLocal,orderRemote, "", "", cost, cost, "INR");	
		resData.put("payurl", payurl);
		return resData;
	}
	@Override
	public void chargeCallBack(JSONObject reqData)throws Exception{
		
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
		String payKey=RedisData.getConf(jedisClient,0,"payKey");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+payKey;
//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toLowerCase();
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error remoteSign:"+reqData.getString("sign")+"****sign:"+sign, null);
		}
		try {
			if("1".equals(reqData.getString("tradeResult"))) {
				JSONObject	custom	=JSONObject.parseObject(reqData.getString("merRetMsg"));
				float realAmount=EventProcesser.chargeExtract(Float.parseFloat(reqData.getString("amount")),custom.getIntValue("chargeExtract"));
				JSONObject res=TransExchange.tranChargeSucc(reqData.getString("mchOrderNo"),custom.getIntValue("uid"),custom.getIntValue("coin"),realAmount);
                  
				    chargeRebates(res.getInteger("presenterId"), custom.getIntValue("coin"));
				    if(res.getBoolean("firstCharge")){
				    	GameTaskService.updateSchedul(res.getInteger("presenterId"), GameTaskService.TASK2, 1);	
				    }
				    
                    
			}else {
				TransExchange.tranChargeFailed(reqData.getString("mchOrderNo"));
			}
		} 
		catch (TransException TransException) {
			log.warn(TransException.getMsg());
		}
		
	}	
	
	
	//客户端发起提现 http://127.0.0.1:8085/GameUser/exchange/extractOrder?param={"uid": 30, "coin": 100, "receive_name": "yeah", "receive_account": "6262662666662666", "remark": "HDFC0000027", "bank_code": "IDPT0001"}
		@Override
		public   Object  extractOrder(String  RequestJsonData) throws Exception {
			JSONObject reqData=JSON.parseObject(RequestJsonData);
			JSONObject resData=new JSONObject();
			int uid =reqData.getIntValue("uid");
			int coin=reqData.getIntValue("coin");
			String receive_name= reqData.getString("receive_name");
			String receive_account= reqData.getString("receive_account");
			String remark= reqData.getString("remark");
			String bank_code= reqData.getString("bank_code");
			
			float cost=  coin;
			Date Date =new Date(); 
			long now=	Date.getTime()/1000;
			String extractLimitStr= RedisData.userField(jedisClient, uid, "extractLimit");
			if(extractLimitStr!=null&&Integer.parseInt(extractLimitStr)>now){
				throw new ServiceException(StatusCode.GEN_ORDER_FAILED,"withdrawal system is busy", null);
			}
			List <gameUser> DBUsers=gameUserMapper.userById(uid);
			if(DBUsers==null || DBUsers.size()==0) {
				throw new ServiceException(StatusCode.GEN_ORDER_FAILED,"user_not_exist", null);
			}
			gameUser gameUser=DBUsers.get(0);
			String orderid=CommTypeUtils.getOrderNo("OrderOut");
			int fId = RedisData.genFreezeId(jedisClient);
			JSONObject outInfo= new JSONObject();
			
			outInfo.put("receive_name", receive_name);
			outInfo.put("receive_account", receive_account);
			outInfo.put("remark", remark);
			outInfo.put("bank_code", bank_code);
			
			String AccountOut=outInfo.toString();
			
			TransExchange.tranGenOrderOut(uid,gameUser.getAgentId(),gameUser.getPresenterId(),fId,orderid,orderid, receive_account, AccountOut,cost, coin, "INR");	

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
			String transferKey=RedisData.getConf(jedisClient,0,"transferKey");
			String mch_id=RedisData.getConf(jedisClient,0,"mch_id");
			

			
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
			long now=	Date.getTime()/1000;
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
			
			
			String status=AuthData.getString("respCode");
			if(!status.equals("SUCCESS")) {
				String retMsg=AuthData.getString("errorMsg");
				System.out.println("!!!!!!!!!!retMsg:"+retMsg);
				throw new ServiceException(StatusCode.FAILED,"request_failed  status:"+status, null);
			}
			
			String remoteSign=AuthData.getString("sign");
//			String orderStatus=AuthData.getString("status");
			String transactionid=AuthData.getString("tradeNo");
			
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
        JsonAuthMap.remove("signType");
        String transferKey=RedisData.getConf(jedisClient,0,"transferKey");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+transferKey;
//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign).toLowerCase();
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"sign_error  remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		String orderLocal=reqData.getString("merTransferId");
		
		
		try {
			List<tradeOrder> tradeOrders=tradeOrderMapper.tradeOrderByOrderLocal(orderLocal);
			tradeOrder tradeOrder=tradeOrders.get(0);
			if(reqData.getInteger("tradeResult")==1) {
				TransExchange.tranExtractSucc( orderLocal, tradeOrder.getFreezeId(),tradeOrder.getUid(),tradeOrder.getCoin(),tradeOrder.getCost());
			}else {                            
				TransExchange.tranExtractFailed( orderLocal, tradeOrder.getFreezeId(),tradeOrder.getUid(),tradeOrder.getCoin());
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
//	http://119.28.250.58:8085/GameUser/exchange/test?param={"uid":29,"order":"","coin":1000,"amount":1000}
//	public   Object  test(String  RequestJsonData) throws Exception {
//		JSONObject reqData=JSON.parseObject(RequestJsonData);
//	JSONObject res=TransExchange.tranChargeSucc(reqData.getString("order"),reqData.getIntValue("uid"),reqData.getIntValue("coin"),Float.parseFloat(reqData.getString("amount"))*87/100);
//    
//    chargeRebates(res.getInteger("presenterId"), reqData.getIntValue("coin"));
//    if(res.getBoolean("firstCharge")){
//    	GameTaskService.updateSchedul(res.getInteger("presenterId"), GameTaskService.TASK2, 1);	
//    }
//	return res;
//	}
	public   void  chargeRebates(int uid,int coin) throws Exception {
		if(uid==0){
			return;
		}
		int per= Integer.parseInt(RedisData.userField(jedisClient, uid, "isLeader"));
		int rebatesCoin=coin*per/100;
        RedisData.addChargeRebates(jedisClient, uid, rebatesCoin);
	}
	


	



//	{"code":0,"data":[{"type":"deposit","snapshot_id":"74e3c5d2-04b7-405d-b509-81291c048bbe","asset_id":"4d8c508b-91c5-375b-92b0-ee702ed2dac5","transaction_hash":"0x02de278dd526f57fb146844b244051a4e28ad375c274e3b4caac8225344ac6ab","output_index":0,"sender":"0x6748F50f686bfbcA6Fe8ad62b22228b87F31ff2b","amount":"3","opening_balance":"2","closing_balance":"5","created_at":"2020-03-04T12:26:56.646442Z"},{"type":"deposit","snapshot_id":"fa4c6fa4-164f-42f9-8e2f-75e8cc037b5f","asset_id":"4d8c508b-91c5-375b-92b0-ee702ed2dac5","transaction_hash":"0xe7b4eac519250351dcf5fb50fe8dd5ab277339bcd56f49db7feb9f6a93a8ace0","output_index":0,"sender":"0x46705dfff24256421A05D056c29E81Bdc09723B8","amount":"2","opening_balance":"0","closing_balance":"2","created_at":"2020-03-04T11:26:45.729179Z"}]}

























}


