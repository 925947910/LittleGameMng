package com.cointer.config;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cointer.eventer.ExecutorPool;
import com.cointer.util.SpringContextUtil;
 
 
@Component
public class EndEventProcesser {


	@PreDestroy
	public void destory() throws Exception {
		 ExecutorPool ExecutorPool=SpringContextUtil.getBean("ExecutorPool", ExecutorPool.class);
		if (ExecutorPool != null) {
			System.out.println("EventProcesser ExecutorPool stop ExecutorsNum:"+ExecutorPool._poolMap.size());
			ExecutorPool.stop();
		}
	
	}
}