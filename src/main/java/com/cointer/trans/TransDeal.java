package com.cointer.trans;



import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cointer.config.EndEventProcesser;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.TransException;
import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameTaskMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.mapper.rbBallMapper;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.pojo.po.freeze;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.rbBallBet;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.BenzBmwService;
import com.cointer.service.impl.RouletteService;
import com.cointer.util.CommTypeUtils;
@Component
public class TransDeal {
	private static final Logger log = LoggerFactory.getLogger(TransDeal.class);
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
	private   gameTaskMapper  gameTaskMapper;
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
		EventProcesser.writeBill(rbBallBet.getUid(),DBUser.getNick(),DBUser.getAgentId(),-rbBallBet.getCoin(), newCoin, EventProcesser.EVENT_REDGREENBALL_BET, rbBallBet.getUid(),"红绿球下注issue:"+rbBallBet.getIssue()+"==bet:"+rbBallBet.getBet()+"==coin"+rbBallBet.getCoin(),"","");
	    return DBUser.getPresenterId();
	}
	
	@Transactional
	public   void  beBanker(int uid,int coin) throws Exception {

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
		   boolean  result =BenzBmwService.BenzBmwOnbank(jedisClient, uid,coin);
		   if(!result) {
				throw new TransException("has_being_banker");
			}
		   EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),-coin, newCoin, EventProcesser.EVENT_BENZBMW_BET, uid,"BenzBmw上庄","","");
	}
	@Transactional
	public   void  fallBanker(int uid ) throws Exception {
       int bank=BenzBmwService.BenzBmwFallbank(jedisClient, uid);
        if(bank==0) {
			throw new TransException("has_falled_banker");
		}
        	List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
    		gameUser DBUser=DBUsers.get(0);
    		int version = DBUser.getVersion();
    		int oldCoin = DBUser.getCoin();
    		
    		int extractedBank=EventProcesser.platExtract(bank);
    		int newCoin = oldCoin+extractedBank;
    		if(newCoin<0) {
    			throw new TransException("coin_not_enough");
    		}
    		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
    			throw new TransException("coin_modify_failed");
    		}
    		EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),extractedBank,newCoin,EventProcesser.EVENT_BENZBMW_DRAW, uid,"Lottery Car fallBanker ","","");
		
	}
	@Transactional
	public   int  BenzBmwBet(int uid ,int totalCoin,Map<String,String> bets) throws Exception {
		int PresenterId=0;
			List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
			gameUser DBUser=DBUsers.get(0);
			int version = DBUser.getVersion();
			int oldCoin = DBUser.getCoin();
			int newCoin = oldCoin-totalCoin;
			if(newCoin<0) {
				throw new TransException("coin_not_enough");
			}
			if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
				throw new TransException("coin_modify_failed");
			}
			PresenterId=DBUser.getPresenterId();
		    BenzBmwService.BenzBmwBet(jedisClient, uid,totalCoin, bets);
		    EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),-totalCoin, newCoin, EventProcesser.EVENT_BENZBMW_BET, uid,"BenzBmw下注","","");
		return  PresenterId;
	}
	@Transactional
	public   int  RouletteBet(int uid ,int totalCoin,Map<String,String> bets) throws Exception {
		int PresenterId=0;
			List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
			gameUser DBUser=DBUsers.get(0);
			int version = DBUser.getVersion();
			int oldCoin = DBUser.getCoin();
			int newCoin = oldCoin-totalCoin;
			if(newCoin<0) {
				throw new TransException("coin_not_enough");
			}
			if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
				throw new TransException("coin_modify_failed");
			}
			PresenterId=DBUser.getPresenterId();
			RouletteService.RouletteBet(jedisClient, uid,totalCoin, bets);
		    EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(),-totalCoin, newCoin, EventProcesser.EVENT_ROULETTE_DRAW, uid,"Roulette下注","","");
		return  PresenterId;
	}

	
	@Transactional
	public   void  taskAddCoin(int id,int taskType,int step,int uid,int coin) throws Exception {
		gameTaskMapper.onStep(id, step);
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int version = DBUser.getVersion();
		int oldCoin = DBUser.getCoin();
		int newCoin = oldCoin+coin;
		if(gameUserMapper.coinChange(uid, newCoin, version)!=1) {
			throw new TransException("coin_modify_failed");
		}
			EventProcesser.writeBill(uid,DBUser.getNick(),DBUser.getAgentId(), coin, newCoin, EventProcesser.EVENT_TASK_REWARD, 0,"task_rewards taskId:"+taskType+"   step:"+step,"","");
	  
	}
	@Transactional
	public   void  taskAddExtractPer(int id,int step,int uid,int per) throws Exception {
		gameTaskMapper.onStep(id, step);
		gameUserMapper.updateLeader(uid, per);
		RedisData.updateUserField(jedisClient, uid, "isLeader", per+"");
		
	}
	
}
