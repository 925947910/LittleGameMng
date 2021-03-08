package com.cointer.eventer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.util.StringUtil;

import redis.clients.jedis.Jedis;
@Component
public class EventDistributor implements ExecutorHandle{
	private Logger logger=LoggerFactory.getLogger(EventDistributor.class);
	private String  Distributor="Distributor:";
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
			 jedis=jedisClient.getJedis();
			while (true) {
				jedis.select(RedisData.DB1_1);
				List<String> idStrList=jedis.blpop(10,Distributor+Group);
				if(idStrList==null||idStrList.size()==0){
					break;
				}else{
					String idStr=idStrList.get(1);
					EventProcesser.routeEvent(jedis, idStr);
				}
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
	

}
