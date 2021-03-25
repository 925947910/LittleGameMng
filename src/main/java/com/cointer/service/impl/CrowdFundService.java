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
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
import com.cointer.mapper.crowdFundMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.pojo.dto.loginUserDto;
import com.cointer.pojo.po.crowdFund;
import com.cointer.pojo.po.crowdFundBet;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.rbBallBet;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.ICrowdFundService;
import com.cointer.service.IUserService;
import com.cointer.trans.TransDeal;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.util.RSAUtils;
import com.cointer.util.StringUtil;
import com.cointer.util.TokenMaker;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.xdevapi.JsonArray;

import net.sf.jsqlparser.expression.operators.relational.Between;










@Service
public class CrowdFundService implements       ICrowdFundService        {
	private static final Logger log = LoggerFactory.getLogger(CrowdFundService.class);

	@Autowired
	private   crowdFundMapper crowdFundMapper;
	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;

	@Autowired
	private   TransDeal TransDeal;


	@Override
	public  Object   currIssue(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int uid =reqData.getIntValue("uid");
		JSONObject resData= new JSONObject();

		Map<String,String> crowdFundMap=RedisData.getCurrCrowdFund(jedisClient);
		long issue =Long.parseLong(crowdFundMap.get("issue"));
		JSONArray crowdFundIssues= RedisData.crowdFundIssueList(jedisClient);
		JSONArray crowdFundRec= RedisData.crowdFundRec(jedisClient, issue+"");

		List<crowdFundBet> DbMybetRec=crowdFundMapper.MybetRec(issue,uid);
		JSONArray mybetRec= JSONArray.parseArray(JSON.toJSONString(DbMybetRec));

		
		
		resData.put("issue", crowdFundMap.get("issue"));
		resData.put("name", crowdFundMap.get("name"));
		resData.put("price", crowdFundMap.get("price"));
		resData.put("picture",  JSONArray.parseArray(crowdFundMap.get("picture")));
		resData.put("schedule",  crowdFundMap.get("schedule"));
		resData.put("crowdFundIssues",  crowdFundIssues);
		resData.put("crowdFundRec",  crowdFundRec);
		resData.put("mybetRec",  mybetRec);
		return resData;

	}

	@Override
	public  Object   historyIssue(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int uid =reqData.getIntValue("uid");
		long issue =reqData.getLongValue("issue");


		JSONObject resData= new JSONObject();


		JSONArray crowdFundRec= RedisData.crowdFundRec(jedisClient, issue+"");

		List<crowdFundBet> DbMybetRec=crowdFundMapper.MybetRec(issue,uid);
		JSONArray mybetRec= JSONArray.parseArray(JSON.toJSONString(DbMybetRec));

		List<crowdFund> crowdFundl=crowdFundMapper.crowdFundByIssue(issue);
		if(crowdFundl.size()==0){
			throw new ServiceException(StatusCode.FAILED, "issue_not_exsist", null);
		}
		crowdFund crowdFund=crowdFundl.get(0);
		resData.put("issue", crowdFund.getIssue());
		resData.put("name", crowdFund.getName());
		resData.put("price", crowdFund.getPrice());
		resData.put("picture",  JSONArray.parseArray(crowdFund.getPicture()));
		resData.put("schedule",  crowdFund.getCurrBuy());

		resData.put("uid",  crowdFund.getUid());
		resData.put("uname",  crowdFund.getUname());
		resData.put("uticket",  crowdFund.getUticket());
		resData.put("uphoto",  crowdFund.getUphoto());

		resData.put("crowdFundRec",  crowdFundRec);
		resData.put("mybetRec",  mybetRec);
		return resData;

	}
	@Override
	public  Object   currBuy(String  RequestJsonData) throws Exception  {
		
		JSONObject resData= new JSONObject();

		Map<String,String> crowdFundMap=RedisData.getCurrCrowdFund(jedisClient);
		
		resData.put("issue", crowdFundMap.get("issue"));

		resData.put("schedule",  crowdFundMap.get("schedule"));
		
		return resData;

	}


	@Override
	public  Object   laid(String  RequestJsonData) throws Exception  {

		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData= new JSONObject();
		int uid =reqData.getIntValue("uid");
		int coin =reqData.getIntValue("coin");

		Map<String,String> issueMap=RedisData.getCurrCrowdFund(jedisClient);
		long issue=Long.parseLong(issueMap.get("issue"));
		Calendar calendar = Calendar.getInstance();

		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		int price = Integer.parseInt(issueMap.get("price"));
		
		String uname=RedisData.userField(jedisClient, uid, "nick");
		String uphoto=RedisData.userField(jedisClient, uid, "photo");
		crowdFundBet  crowdFundBet= new crowdFundBet();
		crowdFundBet.setIssue(issue);
		crowdFundBet.setUid(uid);
		crowdFundBet.setName(uname);
		crowdFundBet.setCoin(coin);
		crowdFundBet.setTime((long)nowSec);
		
		int newCurrBuy=TransDeal.laidCrowdFund(crowdFundBet,false);
		RedisData.updateCurrCrowdFundField(jedisClient, "schedule", newCurrBuy+"");
		String rec=JSONObject.toJSONString(crowdFundBet);
		RedisData.addCrowdFundRec(jedisClient, issueMap.get("issue"), rec);
		RedisData.UpdateUserSign(jedisClient, uid, 1);
		if(newCurrBuy==price){
		
			String uticket=(crowdFundBet.getIssue()+"")+(newCurrBuy+"");
			crowdFundMapper.addWinner(issue,uid,uname,uphoto,uticket);
		}
		 resData.put("schedule", newCurrBuy);	
		 resData.put("coin", Integer.parseInt(RedisData.userField(jedisClient, uid, "coin")));	
		return resData;
	}






}
