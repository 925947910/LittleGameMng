package com.cointer.task;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import com.cointer.mapper.billsMapper;
import com.cointer.mapper.rbBallMapper;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.redis.IJedisClient;



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
	private   tradeOrderMapper tradeOrderMapper;
	
   
//    @Scheduled(cron = "0 0/1 * * * ?")
	 @Scheduled(cron = "0 0 00 * * ?")
    public void CleanBills() {
    	try {
         long time =System.currentTimeMillis()/1000;
         
    	 billsMapper.cleanBills(time-(3*24*3600));
//    	 EventProcesser.EVENT_CHARGE,EventProcesser.EVENT_FREEZE);
    	 rbBallMapper.cleanRbballBets(time-(3*24*3600));	
    	 rbBallMapper.cleanRbball(time-(3*24*3600));		
    	 tradeOrderMapper.cleanTradeorder(time-(30*24*3600));
    	 tradeOrderMapper.cleanTradeorderOut(time-(3*24*3600));
    	 tradeOrderMapper.cleanTradeorderIn(time-(3*24*3600));
    	 log.warn("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!CleanDatas");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
 
    
}