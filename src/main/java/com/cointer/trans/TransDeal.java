package com.cointer.trans;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cointer.eventer.EventProcesser;
import com.cointer.exception.TransException;
import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.mapper.rbBallMapper;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.mapper.crowdFundMapper;
import com.cointer.pojo.po.crowdFund;
import com.cointer.pojo.po.crowdFundBet;
import com.cointer.pojo.po.freeze;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.rbBallBet;
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
	@Autowired
	private   rbBallMapper rbBallBMapper;
	
	@Autowired
	private   crowdFundMapper crowdFundMapper;
	
	@Transactional
	public   int  laidRbBall( rbBallBet rbBallBet) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.checkCoin(rbBallBet.getUid());
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		int newCoin = oldCoin-rbBallBet.getCoin();
		if(newCoin<0) {
			throw new TransException("coin_not_enough");
		}
		if(gameUserMapper.coinChange(rbBallBet.getUid(), newCoin, version)!=1) {
			throw new TransException("coin_modify_failed");
		}
		
		if(rbBallBMapper.laid(rbBallBet)!=1) {
			throw new TransException("bet_failed");
		}	
		EventProcesser.writeBill(rbBallBet.getUid(),DBUser.getNick(),DBUser.getAgentId(),-rbBallBet.getCoin(), newCoin, EventProcesser.EVENT_REDGREENBALL_BET, rbBallBet.getUid(),"红绿球下注","","");
	    return DBUser.getPresenterId();
	}
	
	@Transactional
	public   void  beBanker(int uid ,String name,int coin) throws Exception {

			List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
			gameUser DBUser=DBUsers.get(0);
			int version = DBUser.getVersion();
			int oldCoin = DBUser.getCoin();
			int newCoin = oldCoin-coin;
			if(newCoin<0) {
				throw new TransException("coin_not_enough");
			}
			if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
				throw new TransException("coin_modify_failed");
			}
			EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),-coin, newCoin, EventProcesser.EVENT_BENZBMW_BET, uid,"BenzBmw上庄","","");
		RedisData.BenzBmwBeBanker(jedisClient, uid, name, coin);
		
	}
	@Transactional
	public   void  fallBanker(int uid ) throws Exception {
        Map <String,String> map=RedisData.BenzBmwGetBanker(jedisClient, uid);
        if(map==null) {
			throw new TransException("falled_banker");
		}
        int add=Integer.parseInt(map.get("pool"));
        if(add!=0) {
        	List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
    		gameUser DBUser=DBUsers.get(0);
    		int version = DBUser.getVersion();
    		int oldCoin = DBUser.getCoin();
    		int newCoin = oldCoin+add;
    		if(newCoin<0) {
    			throw new TransException("coin_not_enough");
    		}
    		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
    			throw new TransException("coin_modify_failed");
    		}
    		EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),add,newCoin,EventProcesser.EVENT_BENZBMW_BET, uid,"BenzBmw下庄","","");
		}
	    RedisData.BenzBmwFallBanker(jedisClient);
		
	}
	@Transactional
	public   int  BenzBmwBet(int uid ,String bet,int coin, boolean isBot) throws Exception {
		int PresenterId=0;
		if (!isBot){
			List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
			gameUser DBUser=DBUsers.get(0);
			int version = DBUser.getVersion();
			int oldCoin = DBUser.getCoin();
			int newCoin = oldCoin-coin;
			if(newCoin<0) {
				throw new TransException("coin_not_enough");
			}
			if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
				throw new TransException("coin_modify_failed");
			}
			EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),-coin, newCoin, EventProcesser.EVENT_BENZBMW_BET, uid,"BenzBmw下注","","");
			PresenterId=DBUser.getPresenterId();
		}
		RedisData.BenzBmwBet(jedisClient, uid, bet, coin,isBot);
		return  PresenterId;
	}
	@Transactional
	public   int  laidCrowdFund( crowdFundBet crowdFundBet,boolean isBot) throws Exception {
		
		if(!isBot){
			List<gameUser> DBUsers=gameUserMapper.checkCoin(crowdFundBet.getUid());
			gameUser DBUser=DBUsers.get(0);
			int version = DBUser.getVersion();
			int oldCoin = DBUser.getCoin();
			int newCoin = oldCoin-crowdFundBet.getCoin();
			if(newCoin<0) {
				throw new TransException("coin_not_enough");
			}
			if(gameUserMapper.coinChange(crowdFundBet.getUid(), newCoin, version)!=1) {
				throw new TransException("coin_modify_failed");
			}
			
			EventProcesser.writeBill(crowdFundBet.getUid(),DBUser.getNick(),DBUser.getAgentId(),-crowdFundBet.getCoin(), newCoin, EventProcesser.EVENT_CROWDFUND_BET, crowdFundBet.getUid(),"一元购下注","","");
			
		}
		List<crowdFund> crowdFunds=crowdFundMapper.checkCurrBuy(crowdFundBet.getIssue());
		crowdFund crowdFund=crowdFunds.get(0);
		int cVersion = crowdFund.getVersion();
		int oldCurrBuy = crowdFund.getCurrBuy();
		int price   =  crowdFund.getPrice();
		
		int newCurrBuy = oldCurrBuy+crowdFundBet.getCoin();
		if(newCurrBuy>price) {
			throw new TransException("stock_not_enough");
		}
		if(crowdFundMapper.addCurrBuy(crowdFundBet.getIssue(), newCurrBuy, cVersion)<1){
			throw new TransException("buy_failed");
		}
		crowdFundBet.setTicket((crowdFundBet.getIssue()+"")+(newCurrBuy+""));
		if(crowdFundMapper.addCrowdFundBet(crowdFundBet)!=1){
			throw new TransException("buy_failed");
		}
		
		return  newCurrBuy;
	}
	
	
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
		EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),-excoin, payerCoin, EventProcesser.EVENT_GAME_EXCHANGE, DBUser.getId(),"游戏内交易给其他玩家","","");
		EventProcesser.writeBill(DBUser.getId(),DBUser.getNick(),DBUser.getAgentId(),excoin, newCoin, EventProcesser.EVENT_GAME_EXCHANGE, uid,"游戏内从其他玩家交易获得","","");
	}	
	@Transactional
	public   void  coinRecover( int uid, int excoin,String pwd,String extractPwd) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		String acc =  DBUser.getAcc();
		String nick =  DBUser.getNick();
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
		int OrderId = RedisData.genOrderId(jedisClient);
		long now=	new Date().getTime()/1000;
		tradeOrder order= new tradeOrder();
		String orderNo=CommTypeUtils.getOrderNo("OrderOut");
		order.setId(OrderId);
		order.setUid(uid);
		order.setAccountOut(acc);
		order.setAccountIn(nick);
		order.setCurrency(extractPwd);
		order.setCost(0);
		order.setCoin(excoin);
		order.setOrderLocal(orderNo);
		order.setOrderRemote(orderNo);
		order.setStatus(TransExchange.ORDER_PROCESSING);
		order.setOrderType(TransExchange.ORDEROUT);
		order.setTime(now);
		if(tradeOrderMapper.insertTradeOrder(order)!=1) {
			throw new TransException("金币回收失败");
		}
		EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),-excoin, newCoin, EventProcesser.EVENT_COIN_RECOVER, 0,"金币回收","","");
	}
}
