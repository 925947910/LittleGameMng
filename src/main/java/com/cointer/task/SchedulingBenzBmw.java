package com.cointer.task;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cointer.eventer.EventProcesser;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.BenzBmwService;
import com.cointer.trans.TransDeal;
import com.cointer.util.SpringContextUtil;





@Component
public class SchedulingBenzBmw {
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   TransDeal TransDeal;
//  生成
//    @Scheduled(cron = "0 0/3 * * * ?")
	@Scheduled(initialDelay = 10*1000,fixedRate = 40*1000)
    public void GenRound() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!getNumActive:"+jedisClient.getNumActive());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!getNumWaiters:"+jedisClient.getNumWaiters());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!getNumIdle:"+jedisClient.getNumIdle());
		
    	try {
    		Map<String,String> issueMap=getIssue();
    		String bankerStatus=issueMap.get("bankerStatus");
    		String currBankerStatus=RedisData.getBenzBmwField(jedisClient, "bankerStatus");
    		switch (bankerStatus) {
			case "0":
				if("1".equals(currBankerStatus)){
					TransDeal.fallBanker(Integer.parseInt(issueMap.get("bankerUid")));
				}
				break;
	        case "1":
	        	if ("1".equals(currBankerStatus)&&"0".equals(issueMap.get("bankerPool"))){
	        		TransDeal.fallBanker(Integer.parseInt(issueMap.get("bankerUid")));	
	        	}
				break;
			default:
				break;
			}
            RedisData.initBenzBmw(jedisClient, issueMap.get("issue"),issueMap.get("betStart"),issueMap.get("betEnd"),bankerStatus);
            BenzBmwDraw	BenzBmwDraw=SpringContextUtil.getBean(BenzBmwDraw.class);
            BenzBmwDraw.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
//  @Scheduled(cron = "0 0/3 * * * ?")
	@Scheduled(initialDelay = 10*1000,fixedRate = 1*1000)
  public void AutoBet() {
//      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	try {
  		Map<String,String>MapCache=RedisData.getBenzBmw(jedisClient);
		int betStart=Integer.parseInt(MapCache.get("betStart"));
		int betEnd=Integer.parseInt(MapCache.get("betEnd"));
		Calendar calendar = Calendar.getInstance();
		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		if(nowSec<betStart || nowSec>betEnd){
			return;
		}
        int [] coins=new int []{10,50,100,200,500,1000};

    	String [] bets=new String []{BenzBmwService.Ferrari,BenzBmwService.Lambo,BenzBmwService.BMW,BenzBmwService.Benz,BenzBmwService.Audi,BenzBmwService.Honda,BenzBmwService.Toyota,BenzBmwService.Volkswagen};
      
    	String botStr=RedisData.getBots(jedisClient);
        JSONObject botObj=JSONObject.parseObject(botStr);
        Random rand = new Random();
        
        for (int i = 0; i < 4; i++) {
        	 int index=rand.nextInt(coins.length);
             int coin=coins[index];
             index=rand.nextInt(bets.length);
             String bet=bets[index];
     		 RedisData.BenzBmwBet(jedisClient, botObj.getInteger("uid"), bet, coin,true);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
  }	 

    //  封盘算结果
    public void draw() {
    	try {
    		Thread.sleep(23000);
    		Map<String,String> issueMap=roundResult();
    		Long issue=Long.parseLong(issueMap.get("issue"));
			String result=issueMap.get("result");
			int totalBet= Integer.parseInt(issueMap.get("totalBet"));
			int price=Integer.parseInt(issueMap.get("price"));
			int totalBetWithBot= Integer.parseInt(issueMap.get("totalBetWithBot"));
			int priceWithBot=Integer.parseInt(issueMap.get("priceWithBot"));
			
			
			RedisData.drawBenzBmw(jedisClient, totalBet,totalBetWithBot,price,priceWithBot, result);
			RedisData.addBenzBmwRec(jedisClient, result);
			Map<String,String> bets=RedisData.getBenzBmwBetNums(jedisClient, result);
			int Multiple=BenzBmwService.Multiple.get(result);
			if(bets!=null){
				Set<String> uids=bets.keySet();
				Iterator<String> i= uids.iterator();
				while (i.hasNext()) {
					String uidStr = i.next();
					int num= Multiple*Integer.parseInt(bets.get(uidStr));
					int uid=Integer.parseInt(uidStr);
					JSONObject jsonEvent= new JSONObject();
					jsonEvent.put("E", EventProcesser.EVENT_BENZBMW_DRAW);
					jsonEvent.put("uid", Integer.parseInt(uidStr));
					jsonEvent.put("issue", issue);
					jsonEvent.put("num", num);
					jsonEvent.put("result", result);
					RedisData.addEvent(jedisClient, uid, jsonEvent.toString());
					if (uid<10000000) {
						RedisData.updateUserField(jedisClient, uid, "BenzBmwPrice", num+"");	
					}
					
				}
			}
			String [] strArray=new String[] {BenzBmwService.Ferrari,BenzBmwService.Lambo,BenzBmwService.BMW,BenzBmwService.Benz,BenzBmwService.Audi,BenzBmwService.Honda,BenzBmwService.Toyota,BenzBmwService.Volkswagen};
    	    List list= new ArrayList<String>(Arrays.asList(strArray)) ;
    		RedisData.cleanBenzBmwBets(jedisClient, list);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }    
    
    
    public Map<String,String> getIssue(){
    	Calendar calendar = Calendar.getInstance();
    	long nowSec=calendar.getTimeInMillis()/1000;
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	long zeroSec=calendar.getTimeInMillis()/1000;
    	long issue=nowSec-zeroSec+1;
    	
        Map<String,String> result= new HashMap<String,String>();
        result.put("issue", issue+"");
        result.put("betStart", (nowSec+5)+"");
        result.put("betEnd",(nowSec+20)+"" );
        String bankerStatus="0";
        Map<String,String> map=RedisData.BenzBmwGetBanker(jedisClient, 0);
        if(!map.isEmpty()){
        	 result.put("bankerUid",map.get("uid"));
         	 result.put("bankerPool",map.get("pool"));
         	bankerStatus=map.get("bankerStatus");
        }
        result.put("bankerStatus", bankerStatus);
		return result;

    }
    
    
    public Map<String,String>  roundResult() {
    	Map<String,String> issueMap=RedisData.getBenzBmw(jedisClient);
    	String Resutl=issueMap.get("result");
    	int betFerrari=	Integer.parseInt(issueMap.get("real_"+BenzBmwService.Ferrari));
    	int betLambo=	Integer.parseInt(issueMap.get("real_"+BenzBmwService.Lambo));
    	int betBMW=	Integer.parseInt(issueMap.get("real_"+BenzBmwService.BMW));
    	int betBenz=	Integer.parseInt(issueMap.get("real_"+BenzBmwService.Benz));
    	int betAudi=	Integer.parseInt(issueMap.get("real_"+BenzBmwService.Audi));
    	int betHonda=	Integer.parseInt(issueMap.get("real_"+BenzBmwService.Honda));
    	int betToyota=	Integer.parseInt(issueMap.get("real_"+BenzBmwService.Toyota));
    	int betVolkswagen=	Integer.parseInt(issueMap.get("real_"+BenzBmwService.Volkswagen));
    	
    	
    	int betFerrariWithBot=	Integer.parseInt(issueMap.get(BenzBmwService.Ferrari));
    	int betLamboWithBot=	Integer.parseInt(issueMap.get(BenzBmwService.Lambo));
    	int betBMWWithBot=	Integer.parseInt(issueMap.get(BenzBmwService.BMW));
    	int betBenzWithBot=	Integer.parseInt(issueMap.get(BenzBmwService.Benz));
    	int betAudiWithBot=	Integer.parseInt(issueMap.get(BenzBmwService.Audi));
    	int betHondaWithBot=	Integer.parseInt(issueMap.get(BenzBmwService.Honda));
    	int betToyotaWithBot=	Integer.parseInt(issueMap.get(BenzBmwService.Toyota));
    	int betVolkswagenWithBot=	Integer.parseInt(issueMap.get(BenzBmwService.Volkswagen));
    
    	

    	int priceFerrari=betFerrari*BenzBmwService.Multiple.get(BenzBmwService.Ferrari);
    	int priceLambo=betLambo*BenzBmwService.Multiple.get(BenzBmwService.Lambo);
    	int priceBMW=betBMW*BenzBmwService.Multiple.get(BenzBmwService.BMW);
    	int priceBenz=betBenz*BenzBmwService.Multiple.get(BenzBmwService.Benz);
    	int priceAudi=betAudi*BenzBmwService.Multiple.get(BenzBmwService.Audi);
    	int priceHonda=betHonda*BenzBmwService.Multiple.get(BenzBmwService.Honda);
    	int priceToyota=betToyota*BenzBmwService.Multiple.get(BenzBmwService.Toyota);
    	int priceVolkswagen=betVolkswagen*BenzBmwService.Multiple.get(BenzBmwService.Volkswagen);
		
    	int priceFerrariWithBot=betFerrariWithBot*BenzBmwService.Multiple.get(BenzBmwService.Ferrari);
    	int priceLamboWithBot=betLamboWithBot*BenzBmwService.Multiple.get(BenzBmwService.Lambo);
    	int priceBMWWithBot=betBMWWithBot*BenzBmwService.Multiple.get(BenzBmwService.BMW);
    	int priceBenzWithBot=betBenzWithBot*BenzBmwService.Multiple.get(BenzBmwService.Benz);
    	int priceAudiWithBot=betAudiWithBot*BenzBmwService.Multiple.get(BenzBmwService.Audi);
    	int priceHondaWithBot=betHondaWithBot*BenzBmwService.Multiple.get(BenzBmwService.Honda);
    	int priceToyotaWithBot=betToyotaWithBot*BenzBmwService.Multiple.get(BenzBmwService.Toyota);
    	int priceVolkswagenWithBot=betVolkswagenWithBot*BenzBmwService.Multiple.get(BenzBmwService.Volkswagen);
    	
    	int totalBet=betFerrari+betLambo+betBMW+betBenz+betAudi+betHonda+betToyota+betToyota+betVolkswagen;
    	int totalBetWithBot=betFerrariWithBot+betLamboWithBot+betBMWWithBot+betBenzWithBot+betAudiWithBot+betHondaWithBot+betToyotaWithBot+betToyotaWithBot+betVolkswagenWithBot;

		
		List<String> resultList=new ArrayList<String>();
		
		
		String [] Bets=new String[] {BenzBmwService.Ferrari,BenzBmwService.Lambo,BenzBmwService.BMW,BenzBmwService.Benz,BenzBmwService.Audi,BenzBmwService.Honda,BenzBmwService.Toyota,BenzBmwService.Volkswagen};
		int [] pricesWithBot=new int[] {priceFerrariWithBot,priceLamboWithBot,priceBMWWithBot,priceBenzWithBot,priceAudiWithBot,priceHondaWithBot,priceToyotaWithBot,priceVolkswagenWithBot};
		int [] prices=new int[] {priceFerrari,priceLambo,priceBMW,priceBenz,priceAudi,priceHonda,priceToyota,priceVolkswagen};
		int [] pricesort=new int[] {priceFerrari,priceLambo,priceBMW,priceBenz,priceAudi,priceHonda,priceToyota,priceVolkswagen};
		Arrays.sort(pricesort);
		int price=pricesort[0];
		

		if(Resutl==null){
			for (int i = 0; i < Bets.length; i++) {
				int p=prices[i];
				if(p==price){
					resultList.add(Bets[i]); 
				} 
			}
			Random rand = new Random();
			int index=rand.nextInt(resultList.size());
			Resutl = resultList.get(index);
		}
		
		for (int i = 0; i < Bets.length; i++) {
			if(Resutl.equals(Bets[i])){
				price=prices[i];
				break;
			} 
		}
		
		int priceWithBot=0;
		for (int i = 0; i < Bets.length; i++) {
			if(Resutl.equals(Bets[i])){
				priceWithBot=pricesWithBot[i];
				break;
			} 
		}
		
    	issueMap.put("result", Resutl);
    	issueMap.put("totalBet", totalBet+"");
    	issueMap.put("price", price+"");
    	issueMap.put("totalBetWithBot", totalBetWithBot+"");
    	issueMap.put("priceWithBot", priceWithBot+"");
    	

    	return issueMap;
    }
    
}