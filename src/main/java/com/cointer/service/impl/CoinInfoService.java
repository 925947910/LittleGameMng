package com.cointer.service.impl;



import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.eventer.EventProcesser;
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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;










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

		List<billsInfo> bills=billsMapper.billsListByTypes(uid, EventProcesser.EVENT_REDGREENBALL_DRAW,EventProcesser.EVENT_BENZBMW_DRAW);
		
		String isLeader=RedisData.userField(jedisClient, uid, "isLeader");
		String agentId=RedisData.userField(jedisClient, uid, "agentId");
		
		String url=RedisData.getUri(jedisClient, 0, "shareUrl");
		
		JSONObject resData=new JSONObject();
		resData.put("bills", bills);
		resData.put("isLeader", isLeader);
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


}
