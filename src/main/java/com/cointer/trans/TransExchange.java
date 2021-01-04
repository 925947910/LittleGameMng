package com.cointer.trans;

import java.math.BigDecimal;
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
import com.cointer.util.CommTypeUtils;
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
	public   int tranChargeFreeze(int orderId,int uid,int coin) throws Exception {
		int fId = RedisData.genFreezeId(jedisClient);
		if(tradeOrderMapper.updateStatusWithFreezeId(orderId, ORDER_MATCHED, ORDER_PROCESSING, fId)!=1) {
			
		}
		long now  = new Date().getTime()/1000;
		freeze freezeBean= new freeze();
		freezeBean.setId(fId);
		freezeBean.setUid(uid);
		freezeBean.setOrderId(orderId);
		freezeBean.setCoin(coin);
		freezeBean.setOrderType(ORDERIN);
		freezeBean.setTime(now);
		if(freezeMapper.insertFreeze(freezeBean)!=1) {
			throw new TransException("资金冻结失败");
		}
		return fId;
	}
	@Transactional
	public   void  tranExtractFailed(int orderId,int uid,int fId,int excoin,boolean check) throws Exception {
			if(check) {
				if(tradeOrderMapper.updateStatus(orderId, ORDER_FAILED)!=1) {
					throw new TransException("订单状态修改失败");
				}
			}else {
				if(tradeOrderMapper.updateStatusByStatus(orderId, ORDER_PROCESSING, ORDER_FAILED)!=1) {
					throw new TransException("订单状态修改失败");
				}
			}
			List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
			gameUser DBUser=DBUsers.get(0);
			int version = DBUser.getVersion();
			int oldCoin = DBUser.getCoin();
			int newCoin = oldCoin+excoin;
			
			if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
				throw new TransException("金币修改失败");
			}
			if(freezeMapper.delFreeze(fId)!=1) {
				throw new TransException("删除冻结资金失败");
			}
			EventProcesser.writeBill(uid, excoin, newCoin, EventProcesser.EVENT_FREEZE_REBACK, orderId,"提现失败返还冻结资金","","");
	}
	@Transactional
	public   void  tranExtractSucc(int orderId, int uid, int fId, int excoin,boolean check) throws Exception {
		if(check) {
			if(tradeOrderMapper.updateStatus(orderId, ORDER_SUCC)!=1) {
				throw new TransException("订单状态修改失败");
			}
		}else {
			if(tradeOrderMapper.updateStatusByStatus(orderId, ORDER_PROCESSING, ORDER_SUCC)!=1) {
				throw new TransException("订单状态修改失败");
			}
		}
		if(freezeMapper.delFreeze(fId)!=1) {
			throw new TransException("删除冻结资金失败");
		}
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int oldCoin = DBUser.getCoin();
		EventProcesser.writeBill(uid,0, oldCoin, EventProcesser.EVENT_EXTRACT, orderId,"提现成功解除冻结资金自身金币数量不变","","");
	
	}
	@Transactional
	public   void  tranExtractOrderFailed(int orderId,int uid,int fId,int excoin) throws Exception {
		if(tradeOrderMapper.updateStatusByStatus(orderId, ORDER_INIT, ORDER_FAILED)!=1) {
			throw new TransException("订单状态修改失败");
		}
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
			int newCoin = oldCoin+excoin;
			if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
				throw new TransException("金币修改失败");
			}
			if(freezeMapper.delFreeze(fId)!=1) {
				throw new TransException("删除冻结资金失败");
			}
			EventProcesser.writeBill(uid, excoin, newCoin, EventProcesser.EVENT_FREEZE_REBACK, orderId,"提现订单验证失败返还冻结资金","","");
		
	}
	@Transactional
	public   void  tranExtractOrderSucc(int orderId,int uid,String OrderRemote) throws Exception {
		if(tradeOrderMapper.updateStatusWithOrderRemote(orderId, ORDER_INIT, ORDER_PROCESSING, OrderRemote)!=1) {
			throw new TransException("订单状态修改失败");
		}	
	}   
	@Transactional
	public   tradeOrder  tranGenOrderOut(int uid,int plat,BigDecimal cost,int excoin,String currency) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		int newCoin = oldCoin-excoin;
		if(newCoin<0) {
			throw new TransException("金币不足");
		}
		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
			throw new TransException("金币修改失败");
		}
		int fId = RedisData.genFreezeId(jedisClient);
		long now=	new Date().getTime()/1000;
		int orderId = RedisData.genOrderId(jedisClient);
		freeze freezeBean= new freeze();
		freezeBean.setId(fId);
		freezeBean.setUid(uid);
		freezeBean.setOrderId(orderId);
		freezeBean.setCoin(excoin);
		freezeBean.setOrderType(ORDEROUT);
		freezeBean.setTime(now);
		if(freezeMapper.insertFreeze(freezeBean)!=1) {
			throw new TransException("资金冻结失败");
		}
		String order=CommTypeUtils.getOrderNo("OrderOut");
		tradeOrder  orderBean= new tradeOrder();
		orderBean.setId(orderId);
		orderBean.setOrderLocal(order);
		orderBean.setOrderRemote("");
		orderBean.setPlat(plat);
		orderBean.setUid(uid);
		orderBean.setCost(cost);
		orderBean.setCoin(excoin);
		orderBean.setCurrency(currency);
		orderBean.setOrderType(ORDEROUT);
		orderBean.setFreezeId(fId);
		orderBean.setStatus(ORDER_INIT);  // 0 初始  1 订单对接成功    2转账中  3成功   4失败
		orderBean.setTime(now);
		int res=tradeOrderMapper.insertTradeOrder(orderBean);
		if(res!=1) {
			throw new TransException("生成订单失败");
		}
		EventProcesser.writeBill(uid, -excoin, newCoin, EventProcesser.EVENT_FREEZE, orderId,"生成提现订单冻结提现资金","","");
		return orderBean;
	}
		
	
	@Transactional
	public   void  tranChargeSucc(int orderId,int uid,int coin) throws Exception {
		if(tradeOrderMapper.updateStatusByStatus(orderId, ORDER_PROCESSING, ORDER_SUCC)!=1) {
			throw new TransException("订单状态修改失败");
		}
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		int newCoin = oldCoin+coin;
		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
			throw new TransException("金币修改失败");
		}
		EventProcesser.writeBill(uid, coin, newCoin, EventProcesser.EVENT_CHARGE, orderId,"充值成功","","");
	}
	@Transactional
	public   void  tranChargeFailed(int orderId,int fId,boolean check) throws Exception {
		if(check) {
			if(tradeOrderMapper.updateStatus(orderId, ORDER_FAILED)!=1) {
				throw new TransException("订单状态修改失败");
			}
		}else {
			if(tradeOrderMapper.updateStatusByStatus(orderId, ORDER_PROCESSING, ORDER_FAILED)!=1) {
				throw new TransException("订单状态修改失败");
			}
		}
		if(freezeMapper.delFreeze(fId)!=1) {
			throw new TransException("删除冻结资金失败");
		}
	}
	@Transactional
	public   tradeOrder tranGenOrderIn(int uid,String accIn,String accOut,BigDecimal cost,int coin,String orderFrom,String currency) throws Exception {
		
		long now=	new Date().getTime()/1000;
		int orderId = RedisData.genOrderId(jedisClient);
		String order=CommTypeUtils.getOrderNo("OrderIn");
		tradeOrder  orderBean= new tradeOrder();
		orderBean.setId(orderId);
		orderBean.setAccountIn(accIn);
		orderBean.setAccountOut(accOut);
		orderBean.setOrderLocal(order);
		orderBean.setOrderRemote(orderFrom);
		orderBean.setUid(uid);
		orderBean.setCost(cost);
		orderBean.setCoin(coin);
		orderBean.setCurrency(currency);
		orderBean.setOrderType(ORDERIN);
		orderBean.setStatus(ORDER_PROCESSING);  // 0 初始  1 订单对接成功    2转账中  3成功   4失败
		orderBean.setTime(now);
		if(tradeOrderMapper.insertTradeOrder(orderBean)!=1) {
			throw new TransException("生成订单失败订单号:"+orderFrom);
		}
       return orderBean;
	}
	
	
	
}
