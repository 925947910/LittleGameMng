package com.cointer.service.impl;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cointer.constant.Constant;
import com.cointer.constant.StatusCode;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.ServiceException;
import com.cointer.mapper.gameUserMapper;
import com.cointer.mapper.rbBallMapper;
import com.cointer.pojo.dto.loginUserDto;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.rbBallBet;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IRedGreenBallService;
import com.cointer.service.IUserService;
import com.cointer.trans.TransDeal;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.util.RSAUtils;
import com.cointer.util.StringUtil;
import com.cointer.util.TokenMaker;
import com.github.pagehelper.PageInfo;

import net.sf.jsqlparser.expression.operators.relational.Between;










@Service
public class RedGreenBallService implements IRedGreenBallService {
	private static final Logger log = LoggerFactory.getLogger(RedGreenBallService.class);

	@Autowired
	private   rbBallMapper rbBallMapper;
	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;
	
	@Autowired
	private   TransDeal TransDeal;
	
	@Override
	public  Object   notice(String  RequestJsonData) throws Exception  {
		JSONObject resData=new JSONObject();
		JSONArray notice=RedisData.rbBallNotice(jedisClient);
		resData.put("rbBallNotice", notice);
		return RedisData.rbBallNotice(jedisClient);
	
	}
	
	@Override
	public  Object   laidList(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int uid =reqData.getIntValue("uid");
		return laidList(uid);
	
	}
	public  Object   laidList(int uid) throws Exception  {
		JSONObject resData= new JSONObject();
		JSONArray redGreenRec=RedisData.rbBallRec(jedisClient);
		Map<String,String> issueMap=RedisData.getCurrRbBall(jedisClient);
		List<rbBallBet> Rec=rbBallMapper.currBets(uid, Long.parseLong(issueMap.get("issue")));
		resData.put("betEnd",  Integer.parseInt(issueMap.get("betEnd")));
		resData.put("redGreenRec", redGreenRec);
		resData.put("issue",  Long.parseLong(issueMap.get("issue")));
		resData.put("myBets",  Rec);
		resData.put("coin", Integer.parseInt(RedisData.userField(jedisClient, uid, "coin")));	
		return resData;
	
	}
	
	
	@Override
	public  Object   laid(String  RequestJsonData) throws Exception  {

		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int coin =reqData.getIntValue("coin");
		String bet =reqData.getString("bet");

		Map<String,String> issueMap=RedisData.getCurrRbBall(jedisClient);
		Calendar calendar = Calendar.getInstance();

		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		Integer betStart=Integer.parseInt(issueMap.get("betStart"));
		Integer betEnd=Integer.parseInt(issueMap.get("betEnd"));
		if(!(nowSec>betStart && nowSec<betEnd)){
			throw new ServiceException(StatusCode.LAID_FAILED,"Please_don't_bet", null);
		}
		rbBallBet  rbBallBet=new rbBallBet();
		rbBallBet.setUid(uid);
		rbBallBet.setCoin(coin);
		rbBallBet.setBet(bet);
		rbBallBet.setIssue(Long.parseLong(issueMap.get("issue")));
		rbBallBet.setTime((long)nowSec);
		int PresenterId=TransDeal.laidRbBall(rbBallBet);
		RedisData.currRbBallBet(jedisClient, bet, (long)coin);
		RedisData.setRbBallBeter(jedisClient, Long.parseLong(issueMap.get("issue")), bet, uid);
		 if(PresenterId!=0){
			    JSONObject jsonEvent= new JSONObject();
				jsonEvent.put("E", EventProcesser.EVENT_PRESENTER_ADD);
				jsonEvent.put("uid", PresenterId);
				jsonEvent.put("coin", coin*1/100);
				jsonEvent.put("chargerId", uid);
				RedisData.addEvent(jedisClient, PresenterId, jsonEvent.toString());
		   }
		 resData.put("coin", Integer.parseInt(RedisData.userField(jedisClient, uid, "coin")));	
		return resData;
	}
	
    public Integer getPrice(int uid, Long issue, String Bet){
    	Integer c1=rbBallMapper.coinByBet(uid, issue, Bet);
    	int cost = c1==null?0:c1*9;
    	switch (Bet) {
    	case "0":
    		Integer c2=rbBallMapper.coinByBet(uid, issue, "red");
    		Integer c3=rbBallMapper.coinByBet(uid, issue, "purple");
    		cost+=  c2==null?0:(int)((double)c2*1.5);
    		cost+=  c3==null?0:(int)((double)c3*4.5);
    		break;
    	case "5":
    		Integer c4=rbBallMapper.coinByBet(uid, issue, "green");
    		Integer c5=rbBallMapper.coinByBet(uid, issue, "purple");
    		cost+=  c4==null?0:(int)((double)c4*1.5);
    		cost+=  c5==null?0:(int)((double)c5*4.5);
    		break;
    	default:
    		int num=Integer.parseInt(Bet);
    		if((num % 2)==0){
    			Integer c6=rbBallMapper.coinByBet(uid, issue, "red");
    			cost+=  c6==null?0:c6*2;
    		}else{
    			Integer c7=rbBallMapper.coinByBet(uid, issue, "green");
    			cost+=  c7==null?0:c7*2;
    		}
    		break;
    	}
    	return  cost;

    }
	
	
	
	
}
