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
import com.cointer.pojo.dto.loginUserDto;
import com.cointer.pojo.po.gameUser;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IBenzBmwService;
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
public class BenzBmwService implements IBenzBmwService {
	private static final int  BEBANKER_LIMIT=100000;           //上庄最小值
	private static final Logger log = LoggerFactory.getLogger(BenzBmwService.class);
	public static final String Ferrari="Ferrari";
	public static final String Lambo ="Lambo";
	public static final String BMW="BMW";
	public static final String Benz="Benz";
	public static final String Audi="Audi";
	public static final String Honda="Honda";
	public static final String Toyota="Toyota";
	public static final String Volkswagen="Volkswagen";
	public static final Map<String, Integer>  Multiple= new HashMap<String, Integer>(){{
        put(Ferrari, 40);
        put(Lambo, 30);
        put(BMW, 20);
        put(Benz, 10);
        put(Audi, 5);
        put(Honda,5);
        put(Toyota, 5);
        put(Volkswagen, 5);
    }};

	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;
	
	@Autowired
	private   TransDeal TransDeal;

	
	@Override
	public Object initRoom(String paramJson) throws Exception {
//		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
	    Map<String,String>MapCache=RedisData.getBenzBmw(jedisClient);
	    JSONArray BenzBmwRec=RedisData.getBenzBmwRec(jedisClient);
	      int issue=  Integer.parseInt(MapCache.get("issue"));
	      int betStart=Integer.parseInt(MapCache.get("betStart"));
	      int betEnd=Integer.parseInt(MapCache.get("betEnd"));
	      int drawTime=betStart+20;
	      int nextInit=betStart+35;
	    resData.put("issue",issue);
	    resData.put("betStart",betStart);
	    resData.put("betEnd",betEnd);
	    resData.put("drawTime",drawTime);
	    resData.put("nextInit",nextInit);
	    resData.put("pricePool",Integer.parseInt(MapCache.get("pricePool")));
	    resData.put("bankerStatus",Integer.parseInt(MapCache.get("bankerStatus")));
	    resData.put("BenzBmwRec", BenzBmwRec);
	    if("1".equals(MapCache.get("bankerStatus"))){
	    	 Map<String,String> map=RedisData.BenzBmwGetBanker(jedisClient, 0);
	    	 resData.put("bankerPricePool",Integer.parseInt(map.get("pool")));
	 	     resData.put("bankerUid",Integer.parseInt(map.get("uid")));
	 	     resData.put("bankerName", map.get("name"));	 
	    }
	    
	    Map<String,Integer> begins= new  HashMap<String,Integer> ();
	    begins.put(Ferrari, 0);
	    begins.put(Lambo, 0);
	    begins.put(BMW, 0);
	    begins.put(Benz, 0);
	    begins.put(Audi, 0);
	    begins.put(Honda, 0);
	    begins.put(Toyota, 0);
	    begins.put(Volkswagen, 0);
	    
	    addBetList(resData,MapCache,begins);
		return resData;
	}

	@Override
	public Object bet(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int issue =reqData.getIntValue("issue");
		String bet= reqData.getString("bet");
		int coin =reqData.getIntValue("coin");
		Map<String,String>MapCache=RedisData.getBenzBmw(jedisClient);

		int currIssue= Integer.parseInt(MapCache.get("issue"));
		int betStart=Integer.parseInt(MapCache.get("betStart"));
		int betEnd=Integer.parseInt(MapCache.get("betEnd"));
		
		Calendar calendar = Calendar.getInstance();
		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		
		if(currIssue!= issue){
			throw new ServiceException(StatusCode.LAID_FAILED,"issue_expire", null);
		}
		if(nowSec<betStart || nowSec>betEnd){
			throw new ServiceException(StatusCode.LAID_FAILED,"bet_times_up", null);
		}
	    int PresenterId=TransDeal.BenzBmwBet(uid, bet, coin,false);
		 if(PresenterId!=0){
			    JSONObject jsonEvent= new JSONObject();
				jsonEvent.put("E", EventProcesser.EVENT_PRESENTER_ADD);
				jsonEvent.put("uid", PresenterId);
				jsonEvent.put("coin", coin*1/100);
				jsonEvent.put("chargerId", uid);
				RedisData.addEvent(jedisClient, PresenterId, jsonEvent.toString());
		   }
		 RedisData.UpdateUserSign(jedisClient, uid, 1);
		 resData.put("coin", Integer.parseInt(RedisData.userField(jedisClient, uid, "coin")));	
		
		return resData;
	}
	@Override
	public Object betList(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
		int issue =reqData.getIntValue("issue");
		
		 Map<String,String>MapCache=RedisData.getBenzBmw(jedisClient);
		 int currIssue= Integer.parseInt(MapCache.get("issue"));
		 if(currIssue!= issue){
				throw new ServiceException(StatusCode.GET_DRAW_FAILED,"issue_expire", null);
			}
		    
		    Map<String,Integer> begins= new  HashMap<String,Integer> ();
		    begins.put(Ferrari, reqData.getIntValue(Ferrari));
		    begins.put(Lambo, reqData.getIntValue(Lambo));
		    begins.put(BMW, reqData.getIntValue(BMW));
		    begins.put(Benz, reqData.getIntValue(Benz));
		    begins.put(Audi, reqData.getIntValue(Audi));
		    begins.put(Honda, reqData.getIntValue(Honda));
		    begins.put(Toyota, reqData.getIntValue(Toyota));
		    begins.put(Volkswagen, reqData.getIntValue(Volkswagen));
		 
		   addBetList(resData,MapCache,begins);
		return resData;
	}
	
	@Override
	public  synchronized Object beBanker(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
	    String name=reqData.getString("name");
		int uid =reqData.getIntValue("uid");
		int coin =reqData.getIntValue("coin");
		if(coin< BEBANKER_LIMIT){
			throw new ServiceException(StatusCode.FAILED,"coin_not_enough", null);
		}
		TransDeal.beBanker(uid, name, coin);
		return null;
	}
	
	@Override
	public Object fallBanker(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
		int uid =reqData.getIntValue("uid");
		 Map <String,String> map=RedisData.BenzBmwGetBanker(jedisClient, uid);
		 if((uid+"").equals(map.get("uid"))){
			 RedisData.SetBenzBmwBankerField(jedisClient, "bankerStatus", "0");
		 }
		return null;
	}
	
	
	@Override
	public Object draw(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int issue =reqData.getIntValue("issue");
		
		Calendar calendar = Calendar.getInstance();
		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		
		 Map<String,String>MapCache=RedisData.getBenzBmw(jedisClient);
		 int currIssue= Integer.parseInt(MapCache.get("issue"));
		 int betEnd=Integer.parseInt(MapCache.get("betEnd"));
		 if(currIssue!= issue){
				throw new ServiceException(StatusCode.GET_DRAW_FAILED,"issue_expire", null);
			}
		 
		 if(nowSec<betEnd+5){
				throw new ServiceException(StatusCode.GET_DRAW_FAILED,"not_awarded ", null);
			}
		 int coin =Integer.parseInt(RedisData.userField(jedisClient, uid, "coin"));
		 
		 
		String  myPrice=RedisData.myBenzBmwPrice(jedisClient, uid);
		 
		 
		 
		 String result= MapCache.get("result");
		 int totalBet= Integer.parseInt(MapCache.get("totalBet"));
		 int price= Integer.parseInt(MapCache.get("price"));
		 int pricePool= Integer.parseInt(MapCache.get("pricePool"));
		 
		 resData.put("result", result);
		 resData.put("pricePool", pricePool+"");
		 resData.put("totalBet", totalBet+"");
		 resData.put("price", price+"");
		 resData.put("coin", coin);
		 resData.put("myPrice", myPrice);
		 
		return resData;
	}

	public void addBetList(JSONObject resData,Map<String,String> MapCache,Map<String,Integer>  begins) throws Exception {
		 
		 
		    resData.put(Ferrari, Integer.parseInt(MapCache.get(Ferrari)));
		    resData.put(Lambo, Integer.parseInt(MapCache.get(Lambo)));
		    resData.put(BMW, Integer.parseInt(MapCache.get(BMW)));
		    resData.put(Benz, Integer.parseInt(MapCache.get(Benz)));
		    resData.put(Audi, Integer.parseInt(MapCache.get(Audi)));
		    resData.put(Honda, Integer.parseInt(MapCache.get(Honda)));
		    resData.put(Toyota, Integer.parseInt(MapCache.get(Toyota)));
		    resData.put(Volkswagen, Integer.parseInt(MapCache.get(Volkswagen)));
		    
		    JSONArray FerrariBetList=RedisData.getBenzBmwBetList(jedisClient, Ferrari, begins.get(Ferrari));
		    JSONArray LamboBetList=RedisData.getBenzBmwBetList(jedisClient, Lambo, begins.get(Lambo));
		    JSONArray BMWBetList=RedisData.getBenzBmwBetList(jedisClient, BMW, begins.get(BMW));
		    JSONArray BenzBetList=RedisData.getBenzBmwBetList(jedisClient, Benz, begins.get(Benz));
		    JSONArray AudiBetList=RedisData.getBenzBmwBetList(jedisClient, Audi, begins.get(Audi));
		    JSONArray HondaBetList=RedisData.getBenzBmwBetList(jedisClient, Honda,begins.get(Honda));
		    JSONArray ToyotaBetList=RedisData.getBenzBmwBetList(jedisClient, Toyota, begins.get(Toyota));
		    JSONArray VolkswagenetList=RedisData.getBenzBmwBetList(jedisClient, Volkswagen, begins.get(Volkswagen));
		    resData.put("FerrariBetList", FerrariBetList);
		    resData.put("LamboBetList", LamboBetList);
		    resData.put("BMWBetList", BMWBetList);
		    resData.put("BenzBetList", BenzBetList);
		    resData.put("AudiBetList", AudiBetList);
		    resData.put("HondaBetList", HondaBetList);
		    resData.put("ToyotaBetList", ToyotaBetList);
		    resData.put("VolkswagenBetList", VolkswagenetList);
		
	}
   
	
	
	
}
