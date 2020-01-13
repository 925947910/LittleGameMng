package com.cointer.eventer;



import java.util.ArrayList;
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
import com.cointer.mapper.mineralMapper;
import com.cointer.exception.TransException;
import com.cointer.mapper.billsMapper;
import com.cointer.mapper.gameRecMapper;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.mineralBills;
import com.cointer.pojo.po.mineralCode;
import com.cointer.pojo.po.userMineral;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.pojo.po.bills;
import com.cointer.pojo.po.coinFailed;
import com.cointer.pojo.po.gamePresenter;
import com.cointer.pojo.po.gameRec;
import com.cointer.util.StringUtil;




import redis.clients.jedis.Jedis;

@Component
public class EventProcesser {
	private static  String  Event="Event:";

	private static final int  EVENT_PAY=1;           //游戏扣费
	private static final int  EVENT_WIN=2;            //游戏胜利

	public static final int   EVENT_CHARGE=3;        //充值
	public static final int   EVENT_FREEZE=4;        //冻结
	public static final int   EVENT_FREEZE_REBACK=5; //冻结返还
	public static final int   EVENT_EXTRACT=6;       //提现
	public static final int   EVENT_GAME_EXCHANGE=7; //游戏内转账
	public static final int   EVENT_ADD_MINERAL=8; // 购买商品奖励
	public static final int   EVENT_PRESENTER_ADD_MINERAL=9; // 推荐购买返点
	public static final int   EVENT_DIG_MINERAL=10; // 挖矿
	public static final int   EVENT_COIN_RECOVER=11; // 回收金币	
	public static final int   EVENT_COIN_GM_CHARGE=12; // 后台充值金币	
	public static final int   EVENT_MINERAL_GM_CHARGE=13; // 后台充值矿石返点
	public static final int   EVENT_INIT_GAME=14; // 游戏记录初始化
	public static final int   EVENT_CLEAN_GAME=15; // 游戏记录结算信息
	public static final int   EVENT_PRESENTER_REBATE=16; // 邀请返利
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
	private   mineralMapper mineralMapper;
	@Autowired
	private   gameRecMapper gameRecMapper;
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
		switch (event) {
		case EVENT_PAY:
			uid = data.getIntValue("uid");
			cost=-data.getIntValue("pay");
			reason=data.getString("desc");
			tagId= data.getIntValue("game");
			if (cost != 0) {
				Integer remain = null;
				for (int i = 0; i < 10; i++) {
					try {
						remain = gameCoinChange(uid, cost, EVENT_PAY, tagId, reason);
						break;
					} catch (Exception e) {
						log.error("EVENT_PAY",e);
					}
				}
				if (remain == null) {
					writeCoinFailed(uid, cost, EVENT_PAY, tagId, reason);
					log.warn("EVENT_PAY_FAILED uid:" + uid + "===cost:" + cost);
				}else {
					addPresenterEvent(uid, -cost);
				}
			}
			break;
		case EVENT_WIN:
			uid = data.getIntValue("uid");
			cost=data.getIntValue("price");
			reason=data.getString("desc");
			tagId= data.getIntValue("game");
			if (cost != 0) {
				Integer remain = null;
				for (int i = 0; i < 10; i++) {
					try {
						remain = gameCoinChange(uid, cost, EVENT_WIN, tagId, reason);
						break;
					} catch (Exception e) {
						log.error("EVENT_WIN",e);
					}
				}
				if (remain == null) {
					writeCoinFailed(uid, cost, EVENT_WIN, tagId, reason);
					log.warn("EVENT_WIN_FAILED uid:" + uid + "===cost:" + cost);
				}
			}
			break;
		case EVENT_INIT_GAME:
			int gameId = data.getIntValue("game");
			String recCode=data.getString("recCode");
			long beginTime=data.getLongValue("time");
			gameInit(gameId, beginTime, recCode);
			break;
		case EVENT_CLEAN_GAME:
			log.info("EVENT_CLEAN_GAME");
			recCode=data.getString("recCode");
			long endTime=data.getLongValue("time");
			String gameResult=data.getString("gameResult");
			gameClean(gameResult, endTime, recCode);
			break;
			//		case EVENT_DIG_MINERAL:
			//			tagId= data.getIntValue("game");
			//			reason=data.getString("desc");
			//			try {
			//				dig_mineral(uid, EVENT_DIG_MINERAL, tagId, reason);
			//			} catch (Exception e) {
			//				log.error("",e);
			//			}
			//			break;
		case EVENT_PRESENTER_REBATE:
			uid = data.getIntValue("uid");
			cost= data.getIntValue("coin");
			tagId=data.getIntValue("uidFrom");
			if (cost != 0) {
				Integer remain = null;
				for (int i = 0; i < 10; i++) {
					try {
						remain = gameCoinChange(uid, cost, EVENT_PRESENTER_REBATE, tagId,"目标Id为被抽水玩家");
						break;
					} catch (Exception e) {
						log.error("EVENT_PRESENTER_REBATE",e);
					}
				}
				if (remain == null) {
					writeCoinFailed(uid, cost, EVENT_PRESENTER_REBATE, tagId, "目标Id为被抽水玩家");
					log.warn("EVENT_PRESENTER_REBATE_FAILED uid:" + uid + "===cost:" + cost);
				}
			}
			break;
		default:
			break;
		}
	}


	@Transactional
	public  void gameInit(int gameId,long beginTime,String recCode) throws Exception {
		gameRec  gameRec=new gameRec();
		gameRec.setBeginTime(beginTime);
		gameRec.setGameId(gameId);
		gameRec.setRecordCode(recCode);
		gameRecMapper.initGameRec(gameRec);

	}
	@Transactional
	public  void gameClean(String gameResult,long endTime,String recCode) throws Exception {
		gameRec  gameRec=new gameRec();
		gameRec.setEndTime(endTime);
		gameRec.setGameResult(gameResult);
		gameRec.setRecordCode(recCode);
		gameRecMapper.gameCleanRec(gameRec);
	}
	@Transactional
	public  Integer gameCoinChange(int uid, int cost, int type, int tagId,String reason) throws Exception {
		return coinChange(uid, cost, type, tagId, reason);
	}

	@Transactional
	public int  dig_mineral(int uid, int type, int tagId,String reason) throws Exception {
		List<userMineral> l=mineralMapper.getUserMineral(uid);
		int num=0;
		if(l.size()!=0) {
			num=l.get(0).getMineral()/10;
			if(num<100) {
				num=100;
			}
			mineralChange(uid, -num, type, tagId, reason);
			coinChange(uid, num, type, tagId, reason);
		}
		return num;
	}

	public  Integer coinChange(int uid, int cost, int type, int tagId,String reason) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.userById(uid);
		gameUser DBUser=DBUsers.get(0);
		int newCoin = DBUser.getCoin()+cost;
		if (gameUserMapper.coinChange(uid, newCoin, DBUser.getVersion())!=1) {
			throw new TransException("金币修改失败");
		}
		writeBill(uid, cost, newCoin, type, tagId, reason, "", "");
		return newCoin;	
	}



	public  void writeBill(int Uid,int Cost ,int Remain, int Type, int TagId,String Reason,String accountOut,String accountIn) throws Exception {	
		Map<String, String> map =new HashMap<String, String>();
		map.put("coin", Remain+"");
		RedisData.updateUser(jedisClient, Uid, map);
		map=RedisData.userInfo(jedisClient, Uid);
		bills  bills= new  bills();
		bills.setUid(Uid);
		bills.setNick(map.get("nick"));
		bills.setRemain(Remain);
		bills.setCost(Cost);
		bills.setType(Type);
		bills.setTagId(TagId);
		bills.setAccountOut(accountOut);
		bills.setAccountIn(accountIn);
		bills.setReason(Reason);
		bills.setTime(new Date().getTime()/1000);
		billsMapper.writeBills(bills);
	}

	public void  mineralChange(int uid,int Num,int type,int tagId,String Reason) throws Exception  {
		List<userMineral> luserMineral=mineralMapper.getUserMineral(uid);
		int newMineral= Num;
		if(luserMineral.size()==0) {
			//新插入矿
			if(Num<0) {
				throw new TransException("矿石初始不能为负");	
			}
			if(mineralMapper.insertMineral(uid,newMineral)!=1) {
				throw new TransException("新增矿石失败");
			}
		}else {
			//更新玩家矿
			newMineral=Num+luserMineral.get(0).getMineral();
			if(newMineral<0) {
				throw new TransException("矿石不足");	
			}
			if(mineralMapper.updateMineralNum(uid, newMineral, luserMineral.get(0).getVersion())!=1) {
				throw new TransException("修改矿石失败");
			}
		}
		writeMineralBill(uid, Num, type, tagId, Reason, newMineral, 0);

	}

	public  void writeMineralBill(int Uid,int Cost , int Type, int tagId,String Reason,int mineral,int freeze) throws Exception {	
		Map<String, String> map =new HashMap<String, String>();
		map=RedisData.userInfo(jedisClient, Uid);
		mineralBills  mineralBills= new  mineralBills();
		mineralBills.setUid(Uid);
		mineralBills.setNick(map.get("nick"));
		mineralBills.setMineral(mineral);
		mineralBills.setCost(Cost);
		mineralBills.setType(Type);
		mineralBills.setTagId(tagId);
		mineralBills.setFreeze(freeze);
		mineralBills.setReason(Reason);
		mineralBills.setTime(new Date().getTime()/1000);
		mineralMapper.writeMineralBills(mineralBills);
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


	public   void  addPresenterEvent(int uid,int coin ) throws Exception {
		Map<String,String> perMap=RedisData.sysConfig(jedisClient);
		int currUid=uid;
		for (int i = 6; i > 0; i--) {
			List<gamePresenter>  gamePresenterL= mineralMapper.getPresenter(currUid);
			if(gamePresenterL==null||gamePresenterL.size()==0) {
				break;
			}
			currUid=gamePresenterL.get(0).getPresenterId();
			int addCoin=(Integer.parseInt(perMap.get("presenterPer"+i))*coin)/1000;
			JSONObject jsonEvent= new JSONObject();
			jsonEvent.put("E", EVENT_PRESENTER_REBATE);
			jsonEvent.put("uid", currUid);
			jsonEvent.put("coin", addCoin);
			jsonEvent.put("uidFrom", uid);
			RedisData.addEvent(jedisClient, currUid, jsonEvent.toString());
		}


	}


}
