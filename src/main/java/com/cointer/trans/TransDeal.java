package com.cointer.trans;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cointer.eventer.EventProcesser;
import com.cointer.exception.TransException;
import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.pojo.po.freeze;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.util.CommTypeUtils;
@Component
public class TransDeal {
	@Autowired
	private   gameUserMapper gameUserMapper;
	@Autowired
	private EventProcesser EventProcesser;
	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   tradeOrderMapper tradeOrderMapper;
	@Transactional
	public   void  tranDealCoin( int uid,String extractPwd, int excoin,String pwd) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		String dbPwd= DBUser.getPwd();
		int newCoin = oldCoin-excoin;
		if(!dbPwd.equals(pwd)) {
			throw new TransException("密码错误");
		}
		if(newCoin<0) {
			throw new TransException("金币不足");
		}
		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
			throw new TransException("修改金币失败");
		}
		int payerCoin=newCoin;
		DBUsers=gameUserMapper.checkCoinByExtractPwd(extractPwd);
		DBUser=DBUsers.get(0);
		version = DBUser.getVersion();
		oldCoin = DBUser.getCoin();
		newCoin = oldCoin+excoin;
		if(gameUserMapper.coinChange(DBUser.getId(), newCoin, version)!=1) {
			throw new TransException("修改金币失败");
		}
		EventProcesser.writeBill(uid,-excoin, payerCoin, EventProcesser.EVENT_GAME_EXCHANGE, DBUser.getId(),"游戏内交易给其他玩家","","");
		EventProcesser.writeBill(DBUser.getId(),excoin, newCoin, EventProcesser.EVENT_GAME_EXCHANGE, uid,"游戏内从其他玩家交易获得","","");
	}
	
	@Transactional
	public   void  coinRecover( int uid, int excoin,String pwd) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		String acc =  DBUser.getAcc();
		String nick =  DBUser.getNick();
		String dbPwd= DBUser.getPwd();
		String extractPwd =  DBUser.getExtractPwd();
		int newCoin = oldCoin-excoin;
		if(!dbPwd.equals(pwd)) {
			throw new TransException("密码错误");
		}
		if(newCoin<0) {
			throw new TransException("金币不足");
		}
		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
			throw new TransException("修改金币失败");
		}
		int OrderId = RedisData.genOrderId(jedisClient);
		long now=	new Date().getTime()/1000;
		tradeOrder order= new tradeOrder();
		String orderNo=CommTypeUtils.getOrderNo("OrderOut");
		order.setId(OrderId);
		order.setUid(uid);
		order.setAccountOut(acc);
		order.setAccountIn(nick);
		order.setCurrency(extractPwd);
		order.setCost(new BigDecimal(0));
		order.setCoin(excoin);
		order.setOrderLocal(orderNo);
		order.setOrderRemote(orderNo);
		order.setStatus(TransExchange.ORDER_PROCESSING);
		order.setOrderType(TransExchange.ORDEROUT);
		order.setTime(now);
		if(tradeOrderMapper.insertTradeOrder(order)!=1) {
			throw new TransException("金币回收失败");
		}
		EventProcesser.writeBill(uid,-excoin, newCoin, EventProcesser.EVENT_COIN_RECOVER, 0,"金币回收","","");
	}
}
