package com.cointer.service.impl;









import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IExchangeService;
import com.cointer.service.otPay.OtPayService;
import com.cointer.trans.TransExchange;
import com.cointer.util.CommTypeUtils;
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
	@Autowired
	private   OtPayService OtPayService;

	//客户端发起充值 http://127.0.0.1:8085/GameUser/exchange/chargeOrder?param={"uid": 30, "channel": 102,"bank_code":"IDPT0001","cost": 100}
	@Override
	public   Object  chargeOrder(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int cost=reqData.getIntValue("cost");
		String bank_code =reqData.getString("bank_code");
		List <gameUser> DBUsers=gameUserMapper.userById(uid);
		if(DBUsers==null || DBUsers.size()==0) {
			throw new ServiceException(StatusCode.GEN_ORDER_FAILED,"user_not_exist", null);
		}
		gameUser gameUser=DBUsers.get(0);
		String orderLocal=CommTypeUtils.getOrderNo("OrderIn");

		String channel=RedisData.getConf(jedisClient,0,"channelIn");
		JSONObject	AuthData=null;
		int plat=0;
		switch (channel) {
		case "OtPay":
			plat=1;
			AuthData=OtPayService.chargeOrder(uid, cost, orderLocal, bank_code);
			break;
		case "TikPay":
			plat=2;
			AuthData=TikPayService.chargeOrder( uid+"",cost+"", orderLocal);
			break;
		default:
			break;
		}
		if(AuthData==null) {
			throw new ServiceException(StatusCode.FAILED,"chargeOrder_failed_remote_refuse", null);
		}
		String orderRemote=AuthData.getString("orderRemote");
		String payurl=AuthData.getString("payurl");
		long   now=AuthData.getLongValue("now");
		TransExchange.tranGenOrderIn(plat,now,uid,gameUser.getAgentId(),gameUser.getPresenterId(),orderLocal,orderRemote, "", "", cost, cost, "INR");	
		resData.put("payurl", payurl);
		return resData;
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
		if(tradeOrder.getPlat()!=0){
			throw new ServiceException(StatusCode.FAILED,"order_has_commited_please_wait", null);
		}
		if(succ!=1){
			TransExchange.tranExtractFailed(tradeOrder.getOrderLocal(), tradeOrder.getFreezeId(),tradeOrder.getUid(), tradeOrder.getCoin());
			return  resData;
		}

		String channel=RedisData.getConf(jedisClient,0,"channelOut");
		JSONObject	AuthData=null;
		int plat=0;
		switch (channel) {
		case "OtPay":
			plat=1;
			AuthData=OtPayService.verifyExtract(tradeOrder);
			break;
		case "TikPay":
			plat=2;
			AuthData=TikPayService.verifyExtract(tradeOrder);
			break;
		default:
			break;
		}

		boolean orderSucc=AuthData.getBooleanValue("succ");
		if (orderSucc) {
			String orderRemote=AuthData.getString("orderRemote");
			tradeOrderMapper.updateOrderRemote(tradeOrder.getId(),plat,orderRemote);
			resData.put("transactionid", orderRemote);
			return resData;
		}else{
			TransExchange.tranExtractFailed(tradeOrder.getOrderLocal(), tradeOrder.getFreezeId(),tradeOrder.getUid(), tradeOrder.getCoin());
			throw new ServiceException(StatusCode.FAILED,"everifyExtract_failed_remote_refuse", null);
		}

	}


	public void processCharge(JSONObject AuthData)throws Exception{
		if(AuthData==null) {
			throw new ServiceException(StatusCode.FAILED,"data_null", null);
		}
		String orderLocal=AuthData.getString("orderLocal");
		int   extractPer=AuthData.getIntValue("extractPer");
		if(AuthData.getBoolean("succ")) {
			List<tradeOrder>ol=tradeOrderMapper.tradeOrderByOrderLocal(orderLocal);
			if(ol.size()==0) {
				throw new ServiceException(StatusCode.FAILED,"orderLocal_not_exsit", null);
			}
			tradeOrder tradeOrder=ol.get(0);
			float realAmount=EventProcesser.chargeExtract(tradeOrder.getCost(),extractPer);
			try {
				JSONObject res=TransExchange.tranChargeSucc(orderLocal,tradeOrder.getUid(),tradeOrder.getCoin(),realAmount);
				chargeRebates(res.getInteger("presenterId"),tradeOrder.getCoin());
				if(res.getBoolean("firstCharge")){
					GameTaskService.updateSchedul(res.getInteger("presenterId"), GameTaskService.TASK2, 1);	
				} 
			} catch (TransException TransException) {
				log.warn("TransExchange.tranChargeSucc failed:"+TransException.getMsg());
			}
		}else {
			try {	
				TransExchange.tranChargeFailed(orderLocal);
			} catch (TransException TransException) {
				log.warn("TransExchange.tranChargeFailed failed:"+TransException.getMsg());
			}
		}
	}

	public void processExtract(JSONObject AuthData)throws Exception{
		if(AuthData==null) {
			throw new ServiceException(StatusCode.FAILED,"data_null", null);
		}
		String orderLocal=AuthData.getString("orderLocal");
		List<tradeOrder>ol=tradeOrderMapper.tradeOrderByOrderLocal(orderLocal);
		if(ol.size()==0) {
			throw new ServiceException(StatusCode.FAILED,"orderLocal_not_exsit", null);
		}
		tradeOrder tradeOrder=ol.get(0);
		if(AuthData.getBoolean("succ")) {
			try{
				TransExchange.tranExtractSucc( orderLocal, tradeOrder.getFreezeId(),tradeOrder.getUid(),tradeOrder.getCoin(),tradeOrder.getCost());
			} catch (TransException TransException) {
				log.warn("TransExchange.tranExtractSucc failed:"+TransException.getMsg());
			}
		}else {  
			try{
				TransExchange.tranExtractFailed( orderLocal, tradeOrder.getFreezeId(),tradeOrder.getUid(),tradeOrder.getCoin());
			} catch (TransException TransException) {
				log.warn("TransExchange.tranExtractFailed failed:"+TransException.getMsg());
			}
		}

	}

	public   void  chargeRebates(int uid,int coin) throws Exception {
		if(uid==0){
			return;
		}
		int per= Integer.parseInt(RedisData.userField(jedisClient, uid, "isLeader"));
		int rebatesCoin=coin*per/100;
		RedisData.addChargeRebates(jedisClient, uid, rebatesCoin);
	}


























}


