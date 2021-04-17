package com.cointer.service.impl;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.cointer.task.BenzBmwDraw;
import com.cointer.trans.TransDeal;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.util.RSAUtils;
import com.cointer.util.SpringContextUtil;
import com.cointer.util.StringUtil;
import com.cointer.util.TokenMaker;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.xdevapi.JsonArray;

import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.JsonOperator;










@Service
public class BenzBmwService implements IBenzBmwService {
	private static final int  BEBANKER_LIMIT=10000;           
	private static final int  PRICEPOOL_INIT=1000000;           
	private static final int  PERWIN_INIT=30;             
	private static final int  PER_INIT=80;              
	
	private static final Logger log = LoggerFactory.getLogger(BenzBmwService.class);
	
	
	public static final String BenzBmw="BenzBmw:";
	public static final String PricePool="pricePool";
	public static final String PerWin="perWin";
	public static final String Pool="pool";
	public static final String Per="per";
	public static final String Bank="bank";
	public static final String Issue="issue";
	public static final String End="end";
	public static final String Bot_="bot_";
	public static final String Price="price";
	public static final String PriceWithBot="priceWithBot";
	public static final String Result="result";
	public static final String TotalBet="totalBet";
	public static final String TotalBetWithBot="totalBetWithBot";
	
	
	
	
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
		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
		Integer uid= reqData.getInteger("uid");
		
		Calendar calendar = Calendar.getInstance();
    	long nowSec=calendar.getTimeInMillis()/1000;
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	long zeroSec=calendar.getTimeInMillis()/1000;
    	long issue=nowSec-zeroSec+1;

		
	    Map<String,String>BenzBmw=getBenzBmw(jedisClient,uid);
	    String lastEnd=BenzBmw.get(End);
	    if(lastEnd==null||Integer.parseInt(lastEnd)<nowSec){
	    	BenzBmw=initBenzBmw(jedisClient, uid, issue+"", (nowSec+40)+"");
	    	BenzBmwDraw	BenzBmwDraw=SpringContextUtil.getBean(BenzBmwDraw.class);
	    	BenzBmwDraw.setUid(uid);
            BenzBmwDraw.start();
	    }
	    resData.put("round", BenzBmw);
		return resData;
	}

	@Override
	public Object bet(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int issue =reqData.getIntValue("issue");
		JSONArray bets=reqData.getJSONArray("bets");
		System.out.println("!!!!!!!!!!!!!!!!!!bets"+bets.toString());
		if(bets==null||bets.isEmpty()){
			throw new ServiceException(StatusCode.LAID_FAILED,"bet_empty", null);
		}
		Iterator<Object> i= bets.iterator();
		int totalCoin=0;
		Map<String,String> betMap=new HashMap<String,String>();
		while (i.hasNext()) {
			JSONObject o = (JSONObject) i.next();
			int    coin=o.getInteger("coin");
			String  bet=o.getString("bet");
			betMap.put(bet, coin+"");
			totalCoin+=coin;
		}
		Map<String,String>MapCache=getBenzBmw(jedisClient,uid);

		int currIssue= Integer.parseInt(MapCache.get(Issue));
		int end=Integer.parseInt(MapCache.get(End));
		
		Calendar calendar = Calendar.getInstance();
		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		
		if(currIssue!= issue){
			throw new ServiceException(StatusCode.LAID_FAILED,"issue_expire", null);
		}
		if(nowSec>end-40+21){
			throw new ServiceException(StatusCode.LAID_FAILED,"bet_times_up", null);
		}
	     TransDeal.BenzBmwBet(uid, totalCoin,betMap);
		 resData.put("coin", Integer.parseInt(RedisData.userField(jedisClient, uid, "coin")));	
		
		return resData;
	}
	
	
	@Override
	public   Object beBanker(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
		int issue =reqData.getIntValue("issue");
		int uid =reqData.getIntValue("uid");
		int coin =reqData.getIntValue("coin");
		if(coin< BEBANKER_LIMIT){
			throw new ServiceException(StatusCode.FAILED,"coin_not_enough", null);
		}
		Calendar calendar = Calendar.getInstance();
		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		Map<String,String>MapCache=getBenzBmw(jedisClient,uid);
		int currIssue= Integer.parseInt(MapCache.get(Issue));
		int end=Integer.parseInt(MapCache.get(End));
		
		if(currIssue!= issue){
			throw new ServiceException(StatusCode.LAID_FAILED,"issue_expire", null);
		}
		if(nowSec>end-40+5){
			throw new ServiceException(StatusCode.LAID_FAILED,"beBanker_times_up", null);
		}
		TransDeal.beBanker(uid, coin);
	    coin =Integer.parseInt(RedisData.userField(jedisClient, uid, "coin"));
		resData.put("coin", coin);
		return resData;
	}
	
	@Override
	public Object fallBanker(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
		int issue =reqData.getIntValue("issue");
		int uid =reqData.getIntValue("uid");
		Calendar calendar = Calendar.getInstance();
		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		Map<String,String>MapCache=getBenzBmw(jedisClient,uid);
		int currIssue=Integer.parseInt(getBenzBmwField(jedisClient, uid, Issue));
		int end=Integer.parseInt(getBenzBmwField(jedisClient, uid, End));
		
		if(currIssue!= issue){
			throw new ServiceException(StatusCode.LAID_FAILED,"issue_expire", null);
		}
		if(nowSec>end-40+5){
			throw new ServiceException(StatusCode.LAID_FAILED,"fallBanker_times_up", null);
		}
		TransDeal.fallBanker(uid);
		int coin =Integer.parseInt(RedisData.userField(jedisClient, uid, "coin"));
		resData.put(PricePool, Integer.parseInt(getBenzBmwField(jedisClient, uid, PricePool)));
		resData.put("coin", coin);
		return resData;
	}
	
	
	@Override
	public Object draw(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int issue =reqData.getIntValue("issue");
		
		Calendar calendar = Calendar.getInstance();
		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		
		 Map<String,String>MapCache=getBenzBmw(jedisClient,uid);
		 int currIssue= Integer.parseInt(MapCache.get(Issue));
		 int end=Integer.parseInt(MapCache.get(End));
		 if(currIssue!= issue){
				throw new ServiceException(StatusCode.GET_DRAW_FAILED,"issue_expire", null);
			}
		 System.out.println("!!!!!!!!!!!!!!!!!check"+(end-40+23));
		 System.out.println("!!!!!!!!!!!!!!!!!nowSec"+nowSec);
		 if(nowSec<end-40+23){
				throw new ServiceException(StatusCode.GET_DRAW_FAILED,"not_awarded ", null);
			}
		 int coin =Integer.parseInt(RedisData.userField(jedisClient, uid, "coin"));
		 
		 String result= MapCache.get(Result);
		 int totalBet= Integer.parseInt(MapCache.get(TotalBet));
		 int priceWithBot= Integer.parseInt(MapCache.get(PriceWithBot));
		 int price= Integer.parseInt(MapCache.get(Price));
		 int pricePool= Integer.parseInt(MapCache.get(PricePool));
		 
		 resData.put("result", result);
		 resData.put("pricePool", pricePool+"");
		 resData.put("totalBet", totalBet+"");
		 resData.put("price", priceWithBot+"");
		 resData.put("coin", coin);
		 resData.put("myPrice", price);
		 
		return resData;
	}


		
	
	public void draw(int uid) {
		try {
			Thread.sleep(22000);
			Map<String,String> issueMap=result(uid);
			Long issue=Long.parseLong(issueMap.get(Issue));
			String result=issueMap.get(Result);
			int totalBet= Integer.parseInt(issueMap.get(TotalBet));
			int price=Integer.parseInt(issueMap.get(Price));
			int totalBetWithBot= Integer.parseInt(issueMap.get(TotalBetWithBot));
			int priceWithBot=Integer.parseInt(issueMap.get(PriceWithBot));
			int bank=Integer.parseInt(issueMap.get(Bank));
			int num=price;
			if(bank>0){
				num=totalBetWithBot-priceWithBot;
				if((bank+num)<0){
					num=-bank;
				}
				bank=bank+num;
			}
			drawBenzBmw(jedisClient,uid, totalBet,totalBetWithBot,price,priceWithBot, result,num,bank);
				JSONObject jsonEvent= new JSONObject();
				jsonEvent.put("E", EventProcesser.EVENT_BENZBMW_DRAW);
				jsonEvent.put("uid", uid);
				jsonEvent.put("issue", issue);
				jsonEvent.put("num", num);
				jsonEvent.put("result", result);
				RedisData.addEvent(jedisClient, uid, jsonEvent.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 	
   
	public Map<String,String>  result(int uid) {			    	
		            Map<String,String> issueMap=getBenzBmw(jedisClient,uid);
			    	String resutl=issueMap.get(Result);
			    	int bank=Integer.parseInt(issueMap.get(Bank));
			    	String [] Bets=new String[] {Ferrari,Lambo,BMW,Benz,Audi,Honda,Toyota,Volkswagen};
			    	int totalBet=0;
			    	int totalBetBot=0;
			    	for (String bet : Bets) {
			    		totalBet+=Integer.parseInt(issueMap.get(bet));
			    		totalBetBot+=Integer.parseInt(issueMap.get(Bot_+bet));
	    			}
			    	int totalBetWithBot=totalBetBot+totalBet;
			    	
			    	int perWin=	Integer.parseInt(issueMap.get(PerWin));
		    		int pool=	Integer.parseInt(issueMap.get(Pool));
		    		int per=	Integer.parseInt(issueMap.get(Per));
		    		int max=(pool*per)/100;
	    			int price=0;
	    			int index=0;
//==================上庄干预==========			    	
			    	if(resutl==null&&bank>0){
			    		index=new Random().nextInt(100);
//			    		随机到胜利
			    		if(index < perWin){
//			    			获取最接近最大奖励的结果
			    			for (String bet : Bets) {
			    				int b1=Integer.parseInt(issueMap.get(Bot_+bet));
			    				int b2=Integer.parseInt(issueMap.get(bet));
			    				int r=totalBetWithBot-(b1+b2)*Multiple.get(bet);
			    				if(r<max&&r>price){
			    					price=r;
			    					resutl=bet;
			    				}
			    			}
			    		}
			    	}
			    	if(resutl==null&&bank>0){
//			    		随机获取奖励最少结果
			    	    price=-totalBetWithBot;
			    		for (int i=0; i<Bets.length;i++) {
			    			index=new Random().nextInt(Bets.length);
			    			int b1=Integer.parseInt(issueMap.get(Bot_+Bets[index]));
			    			int b2=Integer.parseInt(issueMap.get(Bets[index]));
			    			int r=totalBetWithBot-(b1+b2)*Multiple.get(Bets[index]);
			    			if(r>price&&r<0){
			    				price=r;
			    				resutl=Bets[index];
			    			}
			    		}
			    	}
			    	
//==================胜率干预=========================================================================================================
			    	if(resutl==null){
			    		index=new Random().nextInt(100);
//			    		随机到胜利
			    		if(index < perWin){
			    			price=0;
//			    			获取最接近最大奖励的结果
			    			for (String bet : Bets) {
			    				int r=Integer.parseInt(issueMap.get(bet))*Multiple.get(bet);
			    				if(r<max&&r>price){
			    					price=r;
			    					resutl=bet;
			    				}
			    			}
			    		}
			    	}
//==================随机获取最小奖励		    	
			    	if(resutl==null){
			    		//	随机获取奖励最少结果
			    		price=-totalBet;
			    		for (int i=0; i<Bets.length;i++) {
			    			index=new Random().nextInt(Bets.length);
			    			int r=Integer.parseInt(issueMap.get(Bets[index]))*Multiple.get(Bets[index])-totalBet;
			    			if(r>price&&r<0){
			    				price=r;
			    				resutl=Bets[index];
			    			}
			    		}
			    	}
//==================不干预随机			    	
			    	if(resutl==null){
			    		index=new Random().nextInt(Bets.length);
			    		resutl=Bets[index];
			    	}
//==============================================			    	
			        price=Multiple.get(resutl)*Integer.parseInt(issueMap.get(resutl));
					int priceWithBot=Multiple.get(resutl)*Integer.parseInt(issueMap.get(Bot_+resutl))+price;
					
					issueMap.put(Bank, bank+"");
			    	issueMap.put(Result, resutl);
			    	issueMap.put(TotalBet, totalBet+"");
			    	issueMap.put(TotalBetWithBot, totalBetWithBot+"");
			    	issueMap.put(Price, price+"");
			    	issueMap.put(PriceWithBot, priceWithBot+"");
			    	
		
			    	return issueMap;
			    }
	
	
	public static final Map<String, String>  initBenzBmw(IJedisClient client,int uid,String issue,String end){
		String key=BenzBmw+uid;
		Map<String, String> mapUpdate=client.hgetAll(RedisData.DB1_3,key );
		String pricePool=mapUpdate.get(PricePool);
		if(pricePool==null){
			pricePool=PRICEPOOL_INIT+"";
			mapUpdate = new HashMap<String, String>();
			mapUpdate.put(PricePool, pricePool);
			mapUpdate.put(PerWin, PERWIN_INIT+"");
			mapUpdate.put(Pool, "0");
			mapUpdate.put(Per, PER_INIT+"");
			mapUpdate.put(Bank, "0");
		}
		if(Integer.parseInt(pricePool)<0){
			mapUpdate.put(PricePool, PRICEPOOL_INIT+"");
		}
		mapUpdate.put(Issue, issue);
		mapUpdate.put(End, end);
		mapUpdate.put(Ferrari, "0");
		mapUpdate.put(Lambo, "0");
		mapUpdate.put(BMW, "0");
		mapUpdate.put(Benz, "0");
		mapUpdate.put(Audi, "0");
		mapUpdate.put(Honda, "0");
		mapUpdate.put(Toyota, "0");
		mapUpdate.put(Volkswagen,"0");
		Random r= new Random();
		int base =5000;
		int base1=base/7;
		int base2=base/7;
		int base3=base/3;
		int base4=base/2;
		int base5=base;
		mapUpdate.put(Bot_+Ferrari, r.nextInt(base1)+"");
		mapUpdate.put(Bot_+Lambo, r.nextInt(base2)+"");
		mapUpdate.put(Bot_+BMW, (r.nextInt(base3))+"");
		mapUpdate.put(Bot_+Benz,(r.nextInt(base4))+"");
		mapUpdate.put(Bot_+Audi,(r.nextInt(base5))+"");
		mapUpdate.put(Bot_+Honda,(r.nextInt(base5))+"");
		mapUpdate.put(Bot_+Toyota, (r.nextInt(base5))+"");
		mapUpdate.put(Bot_+Volkswagen,(r.nextInt(base5))+"");
		
		client.hmset(RedisData.DB1_3, key, mapUpdate);
		client.hdel(RedisData.DB1_3, key, Result);
		client.hdel(RedisData.DB1_3, key, Price);
		client.hdel(RedisData.DB1_3, key, PriceWithBot);
		client.hdel(RedisData.DB1_3, key, TotalBet);
		client.expire(RedisData.DB1_3, key, 300);
		return mapUpdate;
	}

	public static final Map<String, String>  getBenzBmw(IJedisClient client,int uid){
		Map<String, String> mapUpdate=client.hgetAll(RedisData.DB1_3, BenzBmw+uid);
		return mapUpdate;
	}
	public static final String  getBenzBmwField(IJedisClient client,int uid,String field){
		 String result=client.hget(RedisData.DB1_3, BenzBmw+uid,field);
		return result;
	}                                      
	public static final void  drawBenzBmw(IJedisClient client,int uid,int totalBet,int totalBetWithBot,int price,int priceWithBot,String result,int num,int bank){
		client.hincrBy(RedisData.DB1_3, BenzBmw+uid, Pool, -num);
		client.hincrBy(RedisData.DB1_3, BenzBmw+uid, PricePool, totalBetWithBot-priceWithBot);
		Map<String,String> map= new HashMap<String,String>();  
		map.put(TotalBet, totalBetWithBot+"");
		map.put(PriceWithBot, priceWithBot+"");  
		map.put(Price, num+"");  
		map.put(Result, result);
		map.put(Bank, bank+"");
		client.hmset(RedisData.DB1_3, BenzBmw+uid, map);
	}
	
	
	public static final void  BenzBmwBet(IJedisClient client,int uid,int totalCoin, Map<String,String> bets){
		client.hincrBy(RedisData.DB1_3, BenzBmw+uid, Pool, totalCoin);
		client.hmset(RedisData.DB1_3,BenzBmw+uid,bets);
	}	
	public static final boolean  BenzBmwOnbank(IJedisClient client,int uid,int coin){
		String key=BenzBmw+uid;
		int bank=Integer.parseInt(client.hget(RedisData.DB1_3, key, Bank));
		boolean result = bank==0;
		if(result){
			client.hset(RedisData.DB1_3, key, Bank,coin+"");
		}
		return result;
	}
	public static final int  BenzBmwFallbank(IJedisClient client,int uid){
		String key=BenzBmw+uid;
		int bank=Integer.parseInt(client.hget(RedisData.DB1_3, key, Bank));
		boolean result = bank!=0;
		if(result){
			client.hset(RedisData.DB1_3, key, Bank,"0");
		}
		return bank;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
