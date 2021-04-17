package com.cointer.task;


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

import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.mapper.crowdFundMapper;
import com.cointer.pojo.po.crowdFund;
import com.cointer.pojo.po.crowdFundBet;
import com.cointer.pojo.po.gameUser;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.CrowdFundService;
import com.cointer.trans.TransDeal;



@Component
public class SchedulingCrowdFund {
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   crowdFundMapper crowdFundMapper;
	@Autowired
	private   TransDeal TransDeal;
//    生成一元购产品
//	@Scheduled(initialDelay = 10*1000,fixedRate = 1800*1000)
    public void GenCrowdFund() {
    	try {
    		  Calendar calendar = Calendar.getInstance();
    		  long time=calendar.getTimeInMillis()/1000;
    		Map<String,String> issueMap=getIssue();
    		if(issueMap.isEmpty()){
        		throw new ServiceException(StatusCode.FAILED,"GenCrowdFund_not_init", null);
        	}
            CrowdFundService.setCurrCrowdFund(jedisClient, issueMap);
            crowdFund  crowdFund=new crowdFund();
            crowdFund.setIssue(Long.parseLong(issueMap.get("issue")));
            crowdFund.setName(issueMap.get("name"));
            crowdFund.setPicture(issueMap.get("picture"));
            crowdFund.setPrice(Integer.parseInt(issueMap.get("price")));
            crowdFund.setCurrBuy(0);
            crowdFund.setTime(time);
            crowdFund.setVersion(0);
            crowdFundMapper.initCrowdFund(crowdFund);
            CrowdFundService.addCrowdFundRecs(jedisClient, issueMap.get("issue"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
//  添加购买记录
//	@Scheduled(initialDelay = 10*1000,fixedRate = 60*1000)
    public void BotCrowdFund() {
//       
    	try {
    		 Calendar calendar = Calendar.getInstance();
    		   int now=(int)(calendar.getTimeInMillis()/1000);
    			  Map <String,String> crowdFund=CrowdFundService.getCurrCrowdFund(jedisClient);
    			  Long issue=Long.parseLong(crowdFund.get("issue"));
    			   int price=Integer.parseInt(crowdFund.get("price"));
    		       int beginTime=Integer.parseInt(crowdFund.get("beginTime"));
    		       int schedule=Integer.parseInt(crowdFund.get("schedule"));
    		       
    		       Random rand = new Random();
    		       int buy=rand.nextInt((price*2/30));
    		       
    		       if((now-beginTime)>1600){
    		    	   buy=price-schedule;
    		       }else if(schedule>=((now-beginTime)*price/1800)){
    		    	   return;
    		       }
    		        
    		   	String botStr=RedisData.getBots(jedisClient);
    	        JSONObject botObj=JSONObject.parseObject(botStr);
    	        
		        crowdFundBet  crowdFundBet= new crowdFundBet();
		   		crowdFundBet.setIssue(issue);
		   		crowdFundBet.setUid(botObj.getInteger("uid"));
		   		crowdFundBet.setName(botObj.getString("name"));
		   		crowdFundBet.setCoin(buy);
		   		crowdFundBet.setTime((long)now);
		   		
		   		int newCurrBuy=TransDeal.laidCrowdFund(crowdFundBet,true);
		   		CrowdFundService.updateCurrCrowdFundField(jedisClient, "schedule", newCurrBuy+"");
				String rec=JSONObject.toJSONString(crowdFundBet);
				CrowdFundService.addCrowdFundRec(jedisClient, issue+"", rec);
				if(newCurrBuy==price){
					String uticket=(crowdFundBet.getIssue()+"")+(newCurrBuy+"");
					crowdFundMapper.addWinner(issue,0,botObj.getString("name"),botObj.getString("photo"),uticket);
				}
				  
		  
		} catch (Exception e) {
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
         
         long issueToday=(nowSec-zeroSec+1)/1800;
         long issue= year*10000000+month*100000+day*1000+issueToday;
         
         Map<String,String> result= new HashMap<String,String>();
         
         Map<String,String> CrowdFundItem=CrowdFundService.getCrowdFundItem(jedisClient);
         
         
         result.put("issue", issue+"");
         result.put("name", CrowdFundItem.get("name"));
         result.put("price", CrowdFundItem.get("price"));
         result.put("picture", CrowdFundItem.get("picture"));
         result.put("beginTime", nowSec+"");
         result.put("endTime", (nowSec+1800)+"");
         result.put("schedule", 0+"");
        
         
		return result;
    	
    }
    
    
    
}