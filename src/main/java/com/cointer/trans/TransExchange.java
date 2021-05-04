package com.cointer.trans;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.pojo.po.freeze;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.GameTaskService;
import com.alibaba.fastjson.JSONObject;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.TransException;

@Component
public class TransExchange {

	public static final int			ORDERIN        = 1;
	public static final int			ORDEROUT       = 2;
	// 0 初始  1 订单对接成功    2转账中  3成功   4失败
	public static final int			ORDER_INIT          = 0;
	public static final int			ORDER_MATCHED       = 1;
	public static final int			ORDER_PROCESSING    = 2;
	public static final int			ORDER_SUCC          = 3;
	public static final int			ORDER_FAILED        = 4;

	@Autowired
	private   gameUserMapper gameUserMapper;
	@Autowired
	private   tradeOrderMapper  tradeOrderMapper;
	@Autowired
	private   freezeMapper  freezeMapper;
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private EventProcesser EventProcesser;
	
		
	
	@Transactional
	public   JSONObject  tranChargeSucc(String orderLocal,int uid,int coin,float cost) throws Exception {
		JSONObject res=new JSONObject();
		res.put("firstCharge", false);
		if(tradeOrderMapper.updateStatusCostByOrder(orderLocal,cost, ORDER_PROCESSING, ORDER_SUCC)!=1) {
			throw new TransException("status_update_failed");
		}
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		int isTourist=DBUser.getIsTourist();
		int newCoin = oldCoin+coin;
		if(isTourist==1){
			newCoin=coin;
			if(gameUserMapper.updateTourist(uid, 0)!=1) {
				throw new TransException("tourist_status_update_failed");
			}
			res.put("firstCharge", true);
			RedisData.updateUserField(jedisClient, uid, "isTourist", "0");
		}
		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
			throw new TransException("coin_modify_failed");
		}
		EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(), coin, newCoin, EventProcesser.EVENT_CHARGE, 0,"充值成功orderLocal:"+orderLocal,"","");
		res.put("presenterId", DBUser.getPresenterId());
		return res;
	}
	@Transactional
	public   void  tranChargeFailed(String orderLocal) throws Exception {
		if(tradeOrderMapper.updateStatusByOrder(orderLocal, ORDER_PROCESSING, ORDER_FAILED)!=1) {
			throw new TransException("tourist_status_update_failed");
		}
		
	}
	
	
	@Transactional
	public   tradeOrder tranGenOrderIn(int plat,long now,int uid,int agentId,int presenterId,String orderLocal,String orderRemote,String accIn,String accOut,float cost,int coin,String currency) throws Exception {
		
	
		int orderId = RedisData.genOrderId(jedisClient);
		
		tradeOrder  orderBean= new tradeOrder();
		orderBean.setId(orderId);
		orderBean.setAccountIn(accIn);
		orderBean.setAccountOut(accOut);
		orderBean.setOrderLocal(orderLocal);
		orderBean.setOrderRemote(orderRemote);
		orderBean.setPlat(plat);
		orderBean.setUid(uid);
		orderBean.setAgentId(agentId);
		orderBean.setPresenterId(presenterId);
		orderBean.setCost(cost);
		orderBean.setFreezeId(0);
		orderBean.setCoin(coin);
		orderBean.setCurrency(currency);
		orderBean.setOrderType(ORDERIN);
		orderBean.setStatus(ORDER_PROCESSING);  // 0 初始  1 订单对接成功    2转账中  3成功   4失败
		orderBean.setTime(now);
		if(tradeOrderMapper.insertTradeOrder(orderBean)!=1) {
			throw new TransException("gen_order_failed:"+orderRemote);
		}
       return orderBean;
	}
	
	
	@Transactional                        
	public   tradeOrder  tranGenOrderOut(int uid,int agentId,int presenterId,int freezeId,String orderLocal,String orderRemote,String accIn,String accOut,float cost,int coin,String currency) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		int isTourist=DBUser.getIsTourist();
		int newCoin = oldCoin-coin;
		if(isTourist==1) {
			throw new TransException("isTourist_can_not_tran");
		}
		if(newCoin<0) {
			throw new TransException("coin_not_enough");
		}
		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
			throw new TransException("coin_modify_failed");
		}
		long now=	new Date().getTime()/1000;
		
		int orderId = RedisData.genOrderId(jedisClient);
		freeze freezeBean= new freeze();
		freezeBean.setId(freezeId);
		freezeBean.setUid(uid);
		freezeBean.setOrderId(orderId);
		freezeBean.setCoin(coin);
		freezeBean.setOrderType(ORDEROUT);
		freezeBean.setTime(now);
		if(freezeMapper.insertFreeze(freezeBean)!=1) {
			throw new TransException("freeze_coin_failed");
		}
		tradeOrder  orderBean= new tradeOrder();
		orderBean.setId(orderId);
		orderBean.setOrderLocal(orderLocal);
		orderBean.setOrderRemote(orderRemote);
		orderBean.setPlat(0);
		orderBean.setUid(uid);
		orderBean.setAgentId(agentId);
		orderBean.setPresenterId(presenterId);
		orderBean.setCost(cost);
		orderBean.setCoin(coin);
		orderBean.setAccountOut(accOut);
		orderBean.setCurrency(currency);
		orderBean.setOrderType(ORDEROUT);
		orderBean.setFreezeId(freezeId);
		orderBean.setStatus(ORDER_PROCESSING);  // 0 初始  1 订单对接成功    2转账中  3成功   4失败
		orderBean.setTime(now);
		int res=tradeOrderMapper.insertTradeOrder(orderBean);
		if(res!=1) {
			throw new TransException("gen_order_failed");
		}
		EventProcesser.writeBill(uid,DBUser.getNick(),agentId, -coin, newCoin, EventProcesser.EVENT_FREEZE, orderId,"生成提现订单冻结提现资金","","");
		return orderBean;
	}
	@Transactional
	public   void  tranExtractSucc(String orderLocal,int freezeId,int uid,int coin,float cost) throws Exception {
		if(tradeOrderMapper.updateStatusCostByOrder(orderLocal,cost ,ORDER_PROCESSING, ORDER_SUCC)!=1) {
			throw new TransException("status_update_failed");
		}
		if(freezeMapper.delFreeze(freezeId)!=1) {
			throw new TransException("unfreeze_failed");
		}
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int oldCoin = DBUser.getCoin();
		EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),0, oldCoin, EventProcesser.EVENT_EXTRACT, 0,"提现成功orderLocal:"+orderLocal,"","");
	
	}
	@Transactional
	public   void  tranExtractFailed(String orderLocal,int freezeId,int uid,int coin) throws Exception {
	
		if(tradeOrderMapper.updateStatusByOrder(orderLocal, ORDER_PROCESSING, ORDER_FAILED)!=1) {
			throw new TransException("status_update_failed");
		}
			List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
			gameUser DBUser=DBUsers.get(0);
			int version = DBUser.getVersion();
			int oldCoin = DBUser.getCoin();
			int newCoin = oldCoin+coin;
			if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
				throw new TransException("coin_modify_failed");
			}
			
			if(freezeMapper.delFreeze(freezeId)!=1) {
				throw new TransException("unfreeze_failed");
			}
			EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(), coin, newCoin, EventProcesser.EVENT_FREEZE_REBACK, 0,"提现失败orderLocal:"+orderLocal,"","");
	}

	
}
