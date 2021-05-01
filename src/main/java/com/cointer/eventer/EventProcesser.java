package com.cointer.eventer;




import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.mapper.gameUserMapper;
import com.cointer.exception.TransException;
import com.cointer.mapper.billsMapper;
import com.cointer.mapper.rbBallMapper;
import com.cointer.pojo.po.gameUser;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.RedGreenBallService;
import com.cointer.pojo.po.bills;
import com.cointer.pojo.po.coinFailed;
import com.cointer.util.StringUtil;




import redis.clients.jedis.Jedis;

@Component
public class EventProcesser {
	private static  String  Event="Event:";


	public static final int   EVENT_TASK_REWARD=2;   //任务奖励
	public static final int   EVENT_CHARGE=3;        //充值
	public static final int   EVENT_FREEZE=4;        //冻结
	public static final int   EVENT_FREEZE_REBACK=5; //冻结返还
	public static final int   EVENT_EXTRACT=6;       //提现
	public static final int   EVENT_COIN_GM_CHARGE=12; // 后台充值金币	
   



	
	public static final int   EVENT_REDGREENBALL_BET=20; // 红绿球下注
	public static final int   EVENT_BENZBMW_BET=21; // 奔驰宝马下注
	public static final int   EVENT_CROWDFUND_BET=22; // 一元购下注
	public static final int   EVENT_REDGREENBALL_DRAW=23; // 红绿球中奖
	public static final int   EVENT_BENZBMW_DRAW=24; // 奔驰宝马中奖
	public static final int   EVENT_EXTRACT_REBATES=25; // 提取邀请反水
	public static final int   EVENT_ROULETTE_DRAW=26; // 转盘中奖
	private static final Logger log = LoggerFactory.getLogger(EventProcesser.class);
	//  Event={obj,[{"uid",Uid},{"E",?EVENT_WIN},{"price",Price},{"game",GameId},{"desc","play_game"}]},
	//	Event={obj,[{"uid",Uid},{"E",?EVENT_PAY},{"pay",Coin},{"game","GameId"},{"desc","play_game"}]},
	//  Event={obj,[{"uid",Uid},{"E",?EVENT_PAY},{"pay",Coin},{"game","GameId"},{"desc","buy_skin"}]},
	//  Event={obj,[{"E",?EVENT_INIT_GAME},{"game",?GAME_SNAKE},{"recCode",RecCode},{"time",Time}]},
	@Autowired
	private   gameUserMapper gameUserMapper;

	@Autowired
	private   billsMapper billsMapper;

	@Autowired
	private   rbBallMapper rbBallMapper;

	@Autowired
	private   RedGreenBallService RedGreenBallService;
	@Autowired
	private   IJedisClient jedisClient;
	public  void routeEvent(Jedis jedis,String id) {
		while (true) {
			String DataStr=jedis.lpop(Event+id);
			if(StringUtil.isEmpty(DataStr)){
				break;
			}else{
				try {
					JSONObject  EventObj =  JSON.parseObject(DataStr);
					int type = EventObj.getIntValue("E");

					process(type, EventObj);
				} catch (Exception e) {
					log.error("EventProcess error DataStr:"+DataStr , e);
				}

			}
		}

	}




	public  void process(int event, JSONObject data) throws Exception {
		int cost;
		String  reason;
		int tagId;
		int uid;
		String result;
		long issue;
		Integer remain=null;
		switch (event) {




		case EVENT_REDGREENBALL_DRAW:
			 uid = data.getIntValue("uid");
			 result = data.getString("result");
			 issue = data.getLongValue("issue");
			 cost =	data.getIntValue("cost");
				if (cost != 0) {
					for (int i = 0; i < 10; i++) {
						try {
							remain = gameCoinChange(uid, cost, EVENT_REDGREENBALL_DRAW, 0, "Lottery Ball issue:"+issue);
							break;
						} catch (Exception e) {
							log.error("EVENT_REDGREENBALL_DRAW",e);
						}
					}
					if (remain == null) {
						writeCoinFailed(uid, cost, EVENT_REDGREENBALL_DRAW, 0, "Lottery Ball issue:"+issue);
						log.warn("EVENT_REDGREENBALL_DRAW_FAILED uid:" + uid + "===cost:" + cost);
					}
				}
		
			break;
		case EVENT_BENZBMW_DRAW:
			uid = data.getIntValue("uid");
		    result = data.getString("result");
			issue = data.getLongValue("issue");
			uid = data.getIntValue("uid");
			cost=EventProcesser.platExtract(data.getIntValue("num"));
				if (cost != 0) {
					for (int i = 0; i < 10; i++) {
						try {                                                       
							remain = gameCoinChange(uid, cost, EVENT_BENZBMW_DRAW, 0, "Lottery Car Issue:"+issue);
							break;
						} catch (Exception e) {
							log.error("EVENT_BENZBMW_DRAW",e);
						}
					}
					if (remain == null) {
						writeCoinFailed(uid, cost, EVENT_BENZBMW_DRAW, 0, "Lottery Car Issue:"+issue);
						log.warn("EVENT_BENZBMW_DRAW_FAILED uid:" + uid + "===cost:" + cost);
					}
					
				}
			break;	
		case EVENT_ROULETTE_DRAW:
			uid = data.getIntValue("uid");
		    result = data.getString("result");
			issue = data.getLongValue("issue");
			uid = data.getIntValue("uid");
			cost=EventProcesser.platExtract(data.getIntValue("num"));
				if (cost != 0) {
					for (int i = 0; i < 10; i++) {
						try {                                                       
							remain = gameCoinChange(uid, cost, EVENT_ROULETTE_DRAW, 0, "Lottery Roulette Issue:"+issue);
							break;
						} catch (Exception e) {
							log.error("EVENT_ROULETTE_DRAW",e);
						}
					}
					if (remain == null) {
						writeCoinFailed(uid, cost, EVENT_ROULETTE_DRAW, 0, "Lottery Roulette Issue:"+issue);
						log.warn("EVENT_ROULETTE_DRAW_FAILED uid:" + uid + "===cost:" + cost);
					}
					
				}
			break;	 	
	
			
		default:
			break;
		}
	}




	@Transactional
	public  Integer gameCoinChange(int uid, int cost, int type, int tagId,String reason) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.userById(uid);
		gameUser DBUser=DBUsers.get(0);
		int newCoin = DBUser.getCoin()+cost;
		if (gameUserMapper.coinChange(uid, newCoin, DBUser.getVersion())!=1) {
			throw new TransException("coin_modify_failed");
		}
		writeBill(uid,DBUser.getNick(),DBUser.getAgentId(), cost, newCoin, type, tagId, reason, "", "");
		return newCoin;
	}



	public  void writeBill(int Uid,String nick,int agentId,int Cost ,int Remain, int Type, int TagId,String Reason,String accountOut,String accountIn) throws Exception {	

		bills  bills= new  bills();
		bills.setUid(Uid);
		bills.setAgentId(agentId);
		bills.setNick(nick);
		bills.setRemain(Remain);
		bills.setCost(Cost);
		bills.setType(Type);
		bills.setTagId(TagId);
		bills.setAccountOut(accountOut);
		bills.setAccountIn(accountIn);
		bills.setReason(Reason);
		bills.setTime(new Date().getTime()/1000);
		billsMapper.writeBills(bills);
		RedisData.updateUserField(jedisClient, Uid, "coin", Remain+"");
	}

	public  void writeCoinFailed(int uid,int cost , int type, int tagId,String reason) throws Exception {	
		coinFailed coinChange=new coinFailed();
		coinChange.setCost(cost);
		coinChange.setUid(uid);
		coinChange.setType(type);
		coinChange.setTagId(tagId);
		coinChange.setReason(reason);
		coinChange.setTime(new Date().getTime()/1000);
		gameUserMapper.saveFailedCoin(coinChange);
	}

	public static  int platExtract(int num){
		return num*95/100;
	}
	public static  float chargeExtract(float num,int chargeExtract){
		return num*(100-chargeExtract)/100;
	}
}
