package com.cointer.trans;


import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cointer.eventer.EventProcesser;
import com.cointer.exception.TransException;
import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.pojo.po.freeze;
import com.cointer.pojo.po.gameUser;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
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
	private   freezeMapper  freezeMapper;
	@Transactional
	public   void  tranDealCoin( int uid,int tagUid, int excoin,String pwd) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		int newCoin = oldCoin-excoin;
		if(newCoin<0) {
			throw new TransException("金币不足");
		}
		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
			throw new TransException("修改金币失败");
		}
		int payerCoin=newCoin;
		DBUsers=gameUserMapper.checkCoin(tagUid);
		DBUser=DBUsers.get(0);
		version = DBUser.getVersion();
		oldCoin = DBUser.getCoin();
		newCoin = oldCoin+excoin;
		if(gameUserMapper.coinChange(tagUid, newCoin, version)!=1) {
			throw new TransException("修改金币失败");
		}
		EventProcesser.writeBill(uid,-excoin, payerCoin, EventProcesser.EVENT_GAME_EXCHANGE, tagUid,"游戏内交易给其他玩家","","");
		EventProcesser.writeBill(tagUid,excoin, newCoin, EventProcesser.EVENT_GAME_EXCHANGE, uid,"游戏内从其他玩家交易获得","","");
	}
	
	@Transactional
	public   void  coinRecover( int uid, int excoin,String pwd) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		int newCoin = oldCoin-excoin;
		if(newCoin<0) {
			throw new TransException("金币不足");
		}
		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
			throw new TransException("修改金币失败");
		}
		int fId = RedisData.genFreezeId(jedisClient);
		long now=	new Date().getTime()/1000;
		freeze freezeBean= new freeze();
		freezeBean.setId(fId);
		freezeBean.setUid(uid);
		freezeBean.setOrderId(0);
		freezeBean.setCoin(excoin);
		freezeBean.setOrderType(TransExchange.ORDEROUT);
		freezeBean.setTime(now);
		if(freezeMapper.insertFreeze(freezeBean)!=1) {
			throw new TransException("资金冻结失败");
		}
		EventProcesser.writeBill(uid,-excoin, newCoin, EventProcesser.EVENT_COIN_RECOVER, 0,"金币回收冻结","","");
	}
}
