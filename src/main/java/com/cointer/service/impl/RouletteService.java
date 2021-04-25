package com.cointer.service.impl;



import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.ServiceException;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IRouletteService;
import com.cointer.task.RouletteDraw;
import com.cointer.trans.TransDeal;
import com.cointer.util.SpringContextUtil;











@Service
public class RouletteService implements IRouletteService {
	
	private static final int [] TOTAL= {0,36};
	private static final int [] BIG= {1,18};
	private static final int [] SMALL= {19,36};
	private static final int [] DOZEN_1= {1,12};
	private static final int [] DOZEN_2= {13,24};
	private static final int [] DOZEN_3= {25,36};
	
	private static final int [] COLUMN_1= {1,34};
	private static final int [] COLUMN_2= {2,35};
	private static final int [] COLUMN_3= {3,36};
	
	private static final int [] RED= {1,2};
	private static final int [] BLACK= {1,2};
	
	private static final int  BEBANKER_LIMIT=100;           
	private static final int  PRICEPOOL_INIT=1000000;           
	private static final int  PERWIN_INIT=30;             
	private static final int  PER_INIT=80;              
	
	private static final Logger log = LoggerFactory.getLogger(RouletteService.class);
	
	
	public static final String Roulette="Roulette:";
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
	
	
	
	public static final String Big ="big";
	public static final String Small ="small";
	public static final String Odd="odd";
	public static final String Even="even";
	public static final String Red="red";
	public static final String Black="black";
	public static final String Dozen="dozen";
	public static final String Column="column";
	public static final String Strike="strike";
	public static final Map<String, Integer>  Multiple= new HashMap<String, Integer>(){{
		
		put(Strike, 36);
        put(Big, 2);
        put(Small, 2);
        put(Odd, 2);
        put(Even, 2);
        put(Red, 2);
        put(Black,2);
        put(Dozen+1, 3);
        put(Dozen+2, 3);
        put(Dozen+3, 3);
        put(Column+1, 3);
        put(Column+2, 3);
        put(Column+3, 3);
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

	    Map<String,String>Roulette=getRoulette(jedisClient,uid);
	    String lastEnd=Roulette.get("end");
	    if(lastEnd==null||Integer.parseInt(lastEnd)<nowSec){
	    	Roulette=initRoulette(jedisClient, uid, issue+"", (nowSec+40)+"");
	    	RouletteDraw RouletteDraw=SpringContextUtil.getBean(RouletteDraw.class);
	    	RouletteDraw.setUid(uid);
	    	RouletteDraw.start();
	    }
	    resData.put("round", Roulette);
		return resData;
	}

	@Override
	public Object bet(String paramJson) throws Exception {
		JSONObject reqData=JSON.parseObject(paramJson);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int issue =reqData.getIntValue("issue");
		
		JSONArray bets=reqData.getJSONArray("bets");
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
		Map<String,String>MapCache=getRoulette(jedisClient,uid);

		int currIssue= Integer.parseInt(MapCache.get("issue"));
		int end=Integer.parseInt(MapCache.get("end"));
		
		Calendar calendar = Calendar.getInstance();
		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		
		if(currIssue!= issue){
			throw new ServiceException(StatusCode.LAID_FAILED,"issue_expire", null);
		}
		if(nowSec>end-40+21){
			throw new ServiceException(StatusCode.LAID_FAILED,"bet_times_up", null);
		}
	     TransDeal.RouletteBet(uid, totalCoin,betMap);
		 resData.put("coin", Integer.parseInt(RedisData.userField(jedisClient, uid, "coin")));	
		
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
		
		 Map<String,String>MapCache=getRoulette(jedisClient,uid);
		 int currIssue= Integer.parseInt(MapCache.get("issue"));
		 int end=Integer.parseInt(MapCache.get("end"));
		 if(currIssue!= issue){
				throw new ServiceException(StatusCode.GET_DRAW_FAILED,"issue_expire", null);
			}
		 
		 if(nowSec<end-40+23){
				throw new ServiceException(StatusCode.GET_DRAW_FAILED,"not_awarded ", null);
			}
		 int coin =Integer.parseInt(RedisData.userField(jedisClient, uid, "coin"));
		 
		 String result= MapCache.get("result");
		 int totalBet= Integer.parseInt(MapCache.get("totalBet"));
		 int priceWithBot= Integer.parseInt(MapCache.get("priceWithBot"));
		 int price= Integer.parseInt(MapCache.get("price"));
		 int pricePool= Integer.parseInt(MapCache.get("pricePool"));
		 
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
			Long issue=Long.parseLong(issueMap.get("issue"));
			String result=issueMap.get("result");
			int totalBet= Integer.parseInt(issueMap.get("totalBet"));
			int price=Integer.parseInt(issueMap.get("price"));
			int totalBetWithBot= Integer.parseInt(issueMap.get("totalBetWithBot"));
			int priceWithBot=Integer.parseInt(issueMap.get("priceWithBot"));
			int num=price;
			drawRoulette(jedisClient,uid, totalBet,totalBetWithBot,price,priceWithBot, result,num);
				JSONObject jsonEvent= new JSONObject();
				jsonEvent.put("E", EventProcesser.EVENT_ROULETTE_DRAW);
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
		            Map<String,String> issueMap=getRoulette(jedisClient,uid);
			    	String Resutl=issueMap.get("result");
			    	String [] Bets=new String[] {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36",
			    			Big,Small,Odd,Even,Red,Black,Dozen+1,Dozen+2,Dozen+3,Column+1,Column+2,Column+3};
			     	String [] results=new String[] {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36"};
			    	
			    	int totalBet=0;
			    	int totalBetBot=0;
			    	for (String bet : Bets) {
			    		totalBet+=Integer.parseInt(issueMap.get(bet));
			    		totalBetBot+=Integer.parseInt(issueMap.get("bot_"+bet));
	    			}
			    	int totalBetWithBot=totalBetBot+totalBet;
			    	
			    	int perWin=	Integer.parseInt(issueMap.get("perWin"));
		    		int pool=	Integer.parseInt(issueMap.get("pool"));
		    		int per=	Integer.parseInt(issueMap.get("per"));
		    		int max=(pool*per)/100;
	    			int price=0;
	    			int index=0;
//==================胜率干预=========================================================================================================
			    	if(Resutl==null){
			    		index=new Random().nextInt(100);
//			    		随机到胜利
			    		if(index < perWin){
			    			price=0;
//			    			获取最接近最大奖励的结果
			    			for (String res : results) {
			    				int r=calculate(res, issueMap, totalBetWithBot,false);
			    				if(r<max&&r>price){
			    					price=r;
			    					Resutl=res;
			    				}
			    			}
			    		}
			    	}
//==================随机获取最小奖励		    	
			    	if(Resutl==null){
			    		//	随机获取奖励最少结果
			    		price=-totalBet;
			    		for (String res : results) {
			    			index=new Random().nextInt(results.length);
			    			int r=calculate(results[index], issueMap, totalBetWithBot,false)-totalBet;
			    			if(r>price&&r<0){
			    				price=r;
			    				Resutl=results[index];
			    			}
			    		}
			    	}
//==================不干预随机			    	
			    	if(Resutl==null){
			    		index=new Random().nextInt(results.length);
			    		Resutl=results[index];
			    	}
//==============================================			    	
			        price=calculate(Resutl, issueMap, totalBetWithBot,false);
					int priceWithBot=price+calculate(Resutl, issueMap, totalBetWithBot,true);
					
			    	issueMap.put("result", Resutl);
			    	issueMap.put("totalBet", totalBet+"");
			    	issueMap.put("price", price+"");
			    	issueMap.put("totalBetWithBot", totalBetWithBot+"");
			    	issueMap.put("priceWithBot", priceWithBot+"");
			    	
		
			    	return issueMap;
			    }
	
	public static final int calculate(String res,Map<String,String> issueData,int totalBetWithBot,boolean isBot){
		int price=0;
		switch (res) {
		case "0":
			res=isBot?Bot_+res:res;
			price+=totalBetWithBot*Integer.parseInt(issueData.get(res))/100;
			break;

		default:
			res=isBot?Bot_+res:res;
			int multiple=Multiple.get(Strike);
			price+=Integer.parseInt(issueData.get(res))*multiple;
			String [] bets= new String []{Big,Small,Odd,Even,Red,Black,Dozen+1,Dozen+2,Dozen+3,Column+1,Column+2,Column+3};
			for (String bet : bets) {
				bet=isBot?Bot_+bet:bet;
				multiple=Multiple.get(bet);
				price+=Integer.parseInt(issueData.get(bet))*multiple; 
			}
			break;
		}
		return price;
		
	}
	
	
	
	
	
	public static final Map<String, String>  initRoulette(IJedisClient client,int uid,String issue,String end){
		String key=Roulette+uid;
		Map<String, String> mapUpdate=client.hgetAll(RedisData.DB1_3,key );
		String pricePool=mapUpdate.get(PricePool);
		if(pricePool==null){
			pricePool=PRICEPOOL_INIT+"";
			mapUpdate = new HashMap<String, String>();
			mapUpdate.put(PricePool, pricePool);
			mapUpdate.put(PerWin, PERWIN_INIT+"");
			mapUpdate.put(Pool, "0");
			mapUpdate.put(Per, PER_INIT+"");
		}
		if(Integer.parseInt(pricePool)<0){
			mapUpdate.put(PricePool, PRICEPOOL_INIT+"");
		}
		mapUpdate.put(Issue, issue);
		mapUpdate.put(End, end);
		Random r= new Random();
		for(int i=0;i<=36; i++){
			mapUpdate.put(i+"", "0");
			
			if(i!=0){
				mapUpdate.put(Bot_+i, (100+r.nextInt(600))+"");
			}
			
		}

		mapUpdate.put(Bot_+Big, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Small, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Odd, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Even, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Red, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Black, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Dozen+1, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Dozen+2, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Dozen+3, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Column+1, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Column+2, (100+r.nextInt(600))+"");
		mapUpdate.put(Bot_+Column+3, (100+r.nextInt(600))+"");
		
		mapUpdate.put(Big, "0");
		mapUpdate.put(Small, "0");
		mapUpdate.put(Odd, "0");
		mapUpdate.put(Even, "0");
		mapUpdate.put(Red, "0");
		mapUpdate.put(Black,"0");
		mapUpdate.put(Dozen+1,"0");
		mapUpdate.put(Dozen+2,"0");
		mapUpdate.put(Dozen+3,"0");
		mapUpdate.put(Column+1,"0");
		mapUpdate.put(Column+2,"0");
		mapUpdate.put(Column+3,"0");
		
		client.hmset(RedisData.DB1_3, key, mapUpdate);
		client.hdel(RedisData.DB1_3, key, Result);
		client.hdel(RedisData.DB1_3, key, Price);
		client.hdel(RedisData.DB1_3, key, PriceWithBot);
		client.hdel(RedisData.DB1_3, key, TotalBet);
		client.expire(RedisData.DB1_3, key, 300);
		return mapUpdate;
	}

	public static final Map<String, String>  getRoulette(IJedisClient client,int uid){
		Map<String, String> mapUpdate=client.hgetAll(RedisData.DB1_3, Roulette+uid);
		return mapUpdate;
	}
	public static final String  getRouletteField(IJedisClient client,int uid,String field){
		 String result=client.hget(RedisData.DB1_3, Roulette+uid,field);
		return result;
	}                                      
	public static final void  drawRoulette(IJedisClient client,int uid,int totalBet,int totalBetWithBot,int price,int priceWithBot,String result,int num){
		client.hincrBy(RedisData.DB1_3, Roulette+uid, Pool, -num);
		client.hincrBy(RedisData.DB1_3, Roulette+uid, PricePool, totalBetWithBot-priceWithBot);
		Map<String,String> map= new HashMap<String,String>();  
		map.put(TotalBet, totalBetWithBot+"");
		map.put(PriceWithBot, priceWithBot+"");  
		map.put(Price, num+"");  
		map.put(Result, result);
		client.hmset(RedisData.DB1_3, Roulette+uid, map);
	}
	
	
	public static final void  RouletteBet(IJedisClient client,int uid,int totalCoin, Map<String,String> bets){
		client.hincrBy(RedisData.DB1_3, Roulette+uid, Pool, totalCoin);
		client.hmset(RedisData.DB1_3,Roulette+uid,bets);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
