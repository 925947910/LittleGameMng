package com.cointer.config;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cointer.eventer.ExecutorPool;
 
 
@Component
public class EndEventProcesser {
	@Autowired
	public  ExecutorPool ExecutorPool;
	@PreDestroy
	public void destory() throws Exception {
		if (ExecutorPool != null) {
			System.out.println("EventProcesser ExecutorPool stop ExecutorsNum:"+ExecutorPool._poolMap.size());
			ExecutorPool.stop();
		}
	
	}
}