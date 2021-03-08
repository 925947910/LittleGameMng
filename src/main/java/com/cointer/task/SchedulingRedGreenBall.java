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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.ServiceException;
import com.cointer.mapper.rbBallMapper;
import com.cointer.pojo.po.rbBall;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.BenzBmwService;
import com.cointer.service.impl.ExchangeService;



@Component
public class SchedulingRedGreenBall {
	private static final Logger log = LoggerFactory.getLogger(SchedulingRedGreenBall.class);
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   rbBallMapper rbBallMapper;
//  生成彩票
    @Scheduled(cron = "0 0/3 * * * ?")
    public void GenRedGreenBall() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	try {
    		Map<String,String> issueMap=getIssue();
            RedisData.setCurrRbBall(jedisClient, issueMap);
            rbBall rbBall=new rbBall();
            rbBall.setIssue( Long.parseLong(issueMap.get("issue")));
            rbBall.setTime(Long.parseLong(issueMap.get("betStart")));
            rbBall.setLotteryPool(0);
            rbBall.setLotteryPrice(0);
            rbBallMapper.initRbBall(rbBall);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    //  封盘算结果
    @Scheduled(cron = "30 2/3 * * * ?")
    public void RedGreenBallResult() {
    	try {
    		Map<String,String> issueMap=lotteryResult();
    		Long issue=Long.parseLong(issueMap.get("issue"));
			String lotteryResult=issueMap.get("lotteryResult");
			int lotteryPool= Integer.parseInt(issueMap.get("lotteryPool"));
			int lotteryPrice=Integer.parseInt(issueMap.get("lotteryPrice"));
			rbBall rbBall=new rbBall();
			rbBall.setIssue(issue);
			rbBall.setLotteryResult(lotteryResult);
			rbBall.setLotteryPrice(lotteryPrice);
			rbBall.setLotteryPool(lotteryPool);
			rbBallMapper.updateRbBall(rbBall);
			String rec=JSONObject.toJSONString(rbBall);
			RedisData.addRbBallRec(jedisClient, rec);
			
			String botStr=RedisData.getBots(jedisClient);
	        JSONObject botObj=JSONObject.parseObject(botStr);
	        String botName=botObj.getString("name");
	         Random rand = new Random();
		     int num=100000*rand.nextInt(10)+10000*rand.nextInt(10);
	        
	        RedisData.addRbBallNotice(jedisClient, "Congratulations to player "+botName+" for winning "+num+" rupees in the "+issue+"nd issue of the red and green ball game!");
			
			
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }    
//  封盘开奖
    @Scheduled(cron = "59 2/3 * * * ? ")
    public void DrawRedGreenBall() {
    	try {
    		Map<String,String> issueMap=lotteryResult();
    		String result=issueMap.get("lotteryResult");
    		Long issue=Long.parseLong(issueMap.get("issue"));
    		Set<String> uids =RedisData.getRbBallBeter(jedisClient, issue, issueMap.get("lotteryResult"));
    		Set<String> uidAdd;
    		switch (result) {
			case "0":
				 uidAdd =RedisData.getRbBallBeter(jedisClient, issue, "purple");
				break;
            case "5":
            	uidAdd =RedisData.getRbBallBeter(jedisClient, issue, "purple");
				break;
			default:
				int num=Integer.parseInt(result);
				if((num % 2)==0){
					uidAdd =RedisData.getRbBallBeter(jedisClient, issue, "red");
				}else{
					uidAdd =RedisData.getRbBallBeter(jedisClient, issue, "green");
				}
				break;
			}
    		uids.retainAll(uidAdd);
    		Iterator<String>  i= uids.iterator();
    		while (i.hasNext()) {
				int uid =  Integer.parseInt(i.next());
				JSONObject jsonEvent= new JSONObject();
				jsonEvent.put("E", EventProcesser.EVENT_REDGREENBALL_DRAW);
				jsonEvent.put("uid", uid);
				jsonEvent.put("result", result);
				jsonEvent.put("issue", issue);
				RedisData.addEvent(jedisClient, uid, jsonEvent.toString());
			}
    		
    	} 
    	catch (ServiceException ServiceException) {
    		log.info(ServiceException.getMessage());
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	
      
    }    
    
    
    public Map<String,String> getIssue(){
    	  Calendar calendar = Calendar.getInstance();
          long day = calendar.get(Calendar.DATE);
          long month = calendar.get(Calendar.MONTH)+1;
          long year = calendar.get(Calendar.YEAR);
          long nowSec=calendar.getTimeInMillis()/1000;
          
          calendar.set(Calendar.HOUR_OF_DAY, 0);
          calendar.set(Calendar.MINUTE, 0);
          calendar.set(Calendar.SECOND, 0);
          
          long zeroSec=calendar.getTimeInMillis()/1000;
         
         long issueToday=(nowSec-zeroSec+1)/180;
         long issue= year*10000000+month*100000+day*1000+issueToday;
         
         Map<String,String> result= new HashMap<String,String>();
         
         result.put("bet1", "0");
         result.put("bet2", "0");
         result.put("bet3", "0");
         result.put("bet4", "0");
         result.put("bet5", "0");
         result.put("bet6", "0");
         result.put("bet7", "0");
         result.put("bet8", "0");
         result.put("bet9", "0");
         result.put("bet0", "0");
         result.put("betred", "0");
         result.put("betgreen", "0");
         result.put("betpurple", "0");
         result.put("issue", issue+"");
         result.put("betStart", nowSec+"");
         result.put("betEnd", (nowSec+150)+"");
		return result;
    	
    }
    
    
    public Map<String,String>  lotteryResult() {
    	Map<String,String> issueMap=RedisData.getCurrRbBall(jedisClient);
    	if(issueMap.isEmpty()){
    		return null;
    	}
    	Long issue=Long.parseLong(issueMap.get("issue"));
    	List<rbBall> rbBallList=rbBallMapper.currRbBall(issue);
    	String Resutl=null;
    	int bet0=	Integer.parseInt(issueMap.get("bet0"));
    	int bet1=	Integer.parseInt(issueMap.get("bet1"));
    	int bet2=	Integer.parseInt(issueMap.get("bet2"));
    	int bet3=	Integer.parseInt(issueMap.get("bet3"));
    	int bet4=	Integer.parseInt(issueMap.get("bet4"));
    	int bet5=	Integer.parseInt(issueMap.get("bet5"));
    	int bet6=	Integer.parseInt(issueMap.get("bet6"));
    	int bet7=	Integer.parseInt(issueMap.get("bet7"));
    	int bet8=	Integer.parseInt(issueMap.get("bet8"));
    	int bet9=	Integer.parseInt(issueMap.get("bet9"));
    	
    	int betRed=	Integer.parseInt(issueMap.get("betred"));
    	int betGreen=	Integer.parseInt(issueMap.get("betgreen"));
    	int betPurple=	Integer.parseInt(issueMap.get("betpurple"));
    	int total=bet0+bet1+bet2+bet3+bet4+bet5+bet6+bet7+bet8+bet9+betRed+betGreen+betPurple;

    	int price0=bet0*9+
    			(int)((double)betRed*1.5)+
    			(int)((double)betPurple*4.5);
    	int price1=bet1*9+betGreen*2;
		int price2=bet2*9+betRed*2;
		int price3=bet3*9+betGreen*2;
		int price4=bet4*9+betRed*2;
		int price5=bet5*9+
				(int)((double)betGreen*1.5)+
				(int)((double)betPurple*4.5);
		int price6=bet6*9+betRed*2;
		int price7=bet7*9+betGreen*2;
		int price8=bet8*9+betRed*2;
		int price9=bet9*9+betGreen*2;
		
      
		
		List<String> resultList=new ArrayList<String>();
		int [] prices=new int[] {price0,price1,price2,price3,price4,price5,price6,price7,price8,price9};
		int [] pricesort=new int[] {price0,price1,price2,price3,price4,price5,price6,price7,price8,price9};
		Arrays.sort(pricesort);
		Integer price=pricesort[0];

		rbBall rbBall=rbBallList.get(0);
		Resutl=rbBall.getLotteryResult();
		
		if(Resutl==null){
			for (int i = 0; i < prices.length; i++) {
				int p=prices[i];
				if(p==price){
					resultList.add(i+""); 
				}
			}
			Random rand = new Random();
			int index=rand.nextInt(resultList.size());
			Resutl = resultList.get(index);
		}
		 price=prices[Integer.parseInt(Resutl)];
		 
    	 issueMap.put("lotteryResult", Resutl+"");
    	 issueMap.put("lotteryPool", total+"");
    	 issueMap.put("lotteryPrice", price+"");

    	return issueMap;
    }
    
}