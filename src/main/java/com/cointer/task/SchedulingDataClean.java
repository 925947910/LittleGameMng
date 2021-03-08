package com.cointer.task;


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
import com.cointer.mapper.billsMapper;
import com.cointer.mapper.crowdFundMapper;
import com.cointer.mapper.rbBallMapper;
import com.cointer.pojo.po.rbBall;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.BenzBmwService;
import com.cointer.service.impl.ExchangeService;



@Component
public class SchedulingDataClean {
	private static final Logger log = LoggerFactory.getLogger(SchedulingDataClean.class);
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   rbBallMapper rbBallMapper;
	
	@Autowired
	private   billsMapper billsMapper;
	@Autowired
	private   crowdFundMapper crowdFundMapper;

    @Scheduled(cron = "0 0 00 * * ?")
    public void CleanBills() {
    	try {
         long time =System.currentTimeMillis()/1000;
         
    	 billsMapper.cleanBills(time+(3*24*3600), EventProcesser.EVENT_CHARGE,EventProcesser.EVENT_FREEZE);
    	 rbBallMapper.cleanRbballBets(time+(3*24*3600));	
    	 crowdFundMapper.cleanCrowdfundBet(time+(3*24*3600));	
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
 
    
}