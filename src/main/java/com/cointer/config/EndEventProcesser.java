package com.cointer.config;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cointer.eventer.ExecutorPool;
import com.cointer.service.amPay.AmPayService;
import com.cointer.util.SpringContextUtil;
 
 
@Component
public class EndEventProcesser {
	private static final Logger log = LoggerFactory.getLogger(EndEventProcesser.class);

	@PreDestroy
	public void destory() throws Exception {
		 ExecutorPool ExecutorPool=SpringContextUtil.getBean("ExecutorPool", ExecutorPool.class);
		if (ExecutorPool != null) {
			log.info("EventProcesser ExecutorPool stop ExecutorsNum:"+ExecutorPool._poolMap.size());
			ExecutorPool.stop();
		}
	
	}
}