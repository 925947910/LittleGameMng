package com.cointer.eventer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;

import redis.clients.jedis.Jedis;
@Component("EventDistributor")
public class EventDistributor implements ExecutorHandle{
	
	private Logger  logger=LoggerFactory.getLogger(EventDistributor.class);
	private String  Distributor="Distributor:";
	private long s=0;
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   EventProcesser EventProcesser;
     
	

	@Override
	public void handle(int Group) {
		// TODO Auto-generated method stub
//		System.out.println("EventDistributor  thread:"+Thread.currentThread().getId()+"name:"+Thread.currentThread().getName());
		Jedis jedis=null;
		try {
			long now= System.currentTimeMillis()/1000;
			jedis=jedisClient.getJedis();
			while (true) {
				jedis.select(RedisData.DB1_1);
				List<String> idStrList=jedis.blpop(10,Distributor+Group);
				if(now>s){
					break;
				}
				if(idStrList==null){
					break;
				}
				if(idStrList.size()==0){
					break;
				}
				String idStr=idStrList.get(1);
				EventProcesser.routeEvent(jedis, idStr);

			}
		}catch (Exception e) {
			logger.error("",e);
		}
		finally {
			if(jedisClient!=null) {
				jedisClient.returnJedis(jedis);
			}
		}

	}



	public long getS() {
		return s;
	}



	public void setS(long s) {
		this.s = s;
	}
	
  
}
