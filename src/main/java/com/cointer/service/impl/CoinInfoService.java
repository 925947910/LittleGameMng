package com.cointer.service.impl;



import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.OrderedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.TransException;
import com.cointer.mapper.billsMapper;
import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.vo.billsInfo;
import com.cointer.pojo.vo.freezeInfo;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.ICoinInfoService;
import com.cointer.service.IExchangeService;
import com.cointer.trans.TransExchange;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.cointer.mapper.tradeOrderMapper;








@Service
public class CoinInfoService implements ICoinInfoService {
	private static final Logger log = LoggerFactory.getLogger(CoinInfoService.class);
	@Autowired
	private   IExchangeService ExchangeService;
	// 注入Jedis接口用来操作缓存
		@Autowired
		private   IJedisClient jedisClient;

	@Autowired
	private   freezeMapper freezeMapper;

	@Autowired
	private   billsMapper billsMapper;
	@Autowired
	private   tradeOrderMapper tradeOrderMapper;
	@Autowired
	private   EventProcesser EventProcesser;
	
	@Autowired
	private   gameUserMapper gameUserMapper;


	@Override
	public   Object  freezeList(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int start=reqData.getIntValue("start");
		int uid=reqData.getIntValue("uid");
		int num=reqData.getIntValue("num");
		PageHelper.startPage(start,num);
		List<freezeInfo> freezes=freezeMapper.freezeList(uid);
		return  new PageInfo<>(freezes);
	}

	@Override
	public Object currCoin(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);	
		int uid=reqData.getIntValue("uid");
		String coin=RedisData.userField(jedisClient, uid, "coin");
		JSONObject resData=new JSONObject();
		resData.put("coin", coin);
		return resData;
		}
	@Override
	public Object personalInfo(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);

		int uid=reqData.getIntValue("uid");

		List<billsInfo> bills=billsMapper.billsListByTypes(uid, EventProcesser.EVENT_3MIN_REDGREENBALL_DRAW, EventProcesser.EVENT_5MIN_REDGREENBALL_DRAW, EventProcesser.EVENT_10MIN_REDGREENBALL_DRAW,EventProcesser.EVENT_BENZBMW_DRAW);

		//		String isLeader=RedisData.userField(jedisClient, uid, "isLeader");
		String agentId=RedisData.userField(jedisClient, uid, "agentId");

		String url=RedisData.getUri(jedisClient, 0, "shareUrl");

		JSONObject resData=new JSONObject();
		resData.put("bills", bills);
		//		resData.put("isLeader", isLeader);
		resData.put("shareUrl", url+"?agentId="+agentId+"&presenterId="+uid);
		return resData;
	}
	
	@Override
	public Object billsList(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		long begin=reqData.getLongValue("begin");
		long end=reqData.getLongValue("end");
		int uid=reqData.getIntValue("uid");
		int start=reqData.getIntValue("start");
		int num=reqData.getIntValue("num");
		PageHelper.startPage(start,num);
		List<billsInfo> bills=billsMapper.billsList(uid, begin, end);
		
		
		
		List<gameUser> DBUsers=gameUserMapper.checkCoin(uid);
		gameUser DBUser=DBUsers.get(0);
		int Coin = DBUser.getCoin();
		String extractPwd =  DBUser.getPwd();
		
		JSONObject resData=new JSONObject();
		resData.put("bills", new PageInfo<>(bills));
		resData.put("coin", Coin);
		resData.put("extractPwd", extractPwd);
		return resData;
	}
	@Override
	public Object dailyCheck(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);	
		JSONObject resData=new JSONObject();
		int uid=reqData.getIntValue("uid");
		String rewards=getDailySign(jedisClient, uid);
		if(rewards==null){
			Calendar calendar = Calendar.getInstance();
	    	long nowSec=calendar.getTimeInMillis()/1000;
	    	calendar.set(Calendar.HOUR_OF_DAY, 0);
	    	calendar.set(Calendar.MINUTE, 0);
	    	calendar.set(Calendar.SECOND, 0);
	    	long endSec=calendar.getTimeInMillis()/1000+24*3600+1;
	    	float orderin=tradeOrderMapper.sumTradeOrder(uid, endSec-24*3600-1, endSec-1, TransExchange.ORDERIN);
	    	float orderout=tradeOrderMapper.sumTradeOrder(uid, endSec-24*3600-1, endSec-1, TransExchange.ORDEROUT);
	    	float earn= (orderin-orderout);
	    	int newRewards=earn==0?1:(int)(earn/100);
	    	EventProcesser.gameCoinChange(uid, newRewards, EventProcesser.EVENT_DAILY_ACTIVE, 0, "日常签到获取");
		    setDailySign(jedisClient, uid, newRewards, (int)(endSec-nowSec));	
			resData.put("succ",true );
			resData.put("rewards", newRewards);
		}else{
			resData.put("succ",false );
			resData.put("rewards", rewards);
		}
		return resData;
		}
	
	@Override
	public Object dailySignInfo(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);	
		JSONObject resData=new JSONObject();
		int uid=reqData.getIntValue("uid");
		String rewards=getDailySign(jedisClient, uid);
		if(rewards!=null){
			resData.put("received",true );
			resData.put("rewards", rewards);
		}else{
			resData.put("received",false );
		}
		return resData;
		}
	
	public static final void  setDailySign(IJedisClient client,int uid,int rewards,int expire){
		client.hset(RedisData.DB1_0,"DailySign:"+uid, "rewards",rewards+"");
		client.expire(RedisData.DB1_2, "DailySign:"+uid, expire);
	}
	public static final String getDailySign(IJedisClient client,int uid){
		return client.hget(RedisData.DB1_0,"DailySign:"+uid, "rewards");
	}
}
