package com.cointer.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cointer.eventer.EventDistributor;
import com.cointer.eventer.Executor;
import com.cointer.eventer.ExecutorHandle;
import com.cointer.eventer.ExecutorPool;
import com.cointer.util.SpringContextUtil;

@Component
public class StartEventProcesser implements CommandLineRunner{
	private Logger logger=LoggerFactory.getLogger(StartEventProcesser.class);
	@Autowired
	public  ExecutorPool ExecutorPool;
	@Autowired
	ExecutorHandle ExecutorHandle;

	public void run(String... args) throws Exception {
		 int[] threadIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		   for (int i = 0; i < threadIds.length; i++) {
			   int group=threadIds[i];
			   Executor Executor=SpringContextUtil.getBean(Executor.class);
			   Executor.setId(group);
			   ExecutorPool.addExecutor(group,Executor);
			   ExecutorPool.enqueueHandle(group, ExecutorHandle);
		   }

	}
}