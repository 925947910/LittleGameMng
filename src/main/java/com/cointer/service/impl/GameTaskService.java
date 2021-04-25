package com.cointer.service.impl;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.ServiceException;
import com.cointer.mapper.gameTaskMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.pojo.dto.staticTask;
import com.cointer.pojo.po.gameTask;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IGameTaskService;
import com.cointer.trans.TransDeal;










@Service
public class GameTaskService implements IGameTaskService {
	private static final Logger log = LoggerFactory.getLogger(GameTaskService.class);
	public static final  int TASK1=1;
	public static final  int TASK2=2;
	public static final  int COIN=1;
	public static final  int EXTRACT_PER=2;
	public static  staticTask task1;
	public static  staticTask task2;
	static{
		task1=new staticTask();
		task1.setId(TASK1);
		task1.setConditions(new ArrayList<Integer>(){
			{add(5);add(10);add(20);add(30);add(100);}	
		});
		task1.setPriceTypes(new ArrayList<Integer>(){
			{add(COIN);add(COIN);add(COIN);add(EXTRACT_PER);add(EXTRACT_PER);}	
		});
		task1.setPriceNums(new ArrayList<Integer>(){
			{add(10);add(20);add(50);add(2);add(3);}	
		});
		
		task2=new staticTask();
		task2.setId(TASK2);
		task2.setConditions(new ArrayList<Integer>(){
			{add(3);add(8);add(15);add(30);add(50);}	
		});
		task2.setPriceTypes(new ArrayList<Integer>(){
			{add(COIN);add(COIN);add(COIN);add(COIN);add(COIN);}	
		});
		task2.setPriceNums(new ArrayList<Integer>(){
			{add(30);add(100);add(175);add(450);add(800);}	
		});
	}
	
	@Autowired
	private   TransDeal TransDeal;
	@Autowired
	private   gameUserMapper gameUserMapper;
	@Autowired
	private   gameTaskMapper gameTaskMapper;

	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	EventProcesser EventProcesser;
	@Override
	public  Object   taskInfo(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int uid=reqData.getInteger("uid");
		List<staticTask> staticTasks=new ArrayList<staticTask>(){
			{add(task1);add(task2);}	
		};
		List<gameTask> gameTasks  =gameTaskMapper.getTask(uid);
		if(gameTasks.isEmpty()){
		    gameTasks=genInitTasks(uid);
		    for (int i = 0; i < gameTasks.size(); i++) {
		    	gameTaskMapper.initTask(gameTasks.get(i));	
			}
		}
		resData.put("staticTask", staticTasks);
		resData.put("myTask", gameTasks);
		 return resData;
	}
	
	@Override
	public  Object   getRewards(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int uid=reqData.getInteger("uid");
		int taskId=reqData.getInteger("taskId");
		List<gameTask> gameTasks  =gameTaskMapper.getTaskByType(uid, taskId);
		if(gameTasks.isEmpty()){
		 throw new ServiceException(StatusCode.FAILED,"no_task", null);
		}
		gameTask gameTask=gameTasks.get(0);
		staticTask staticTask;
		switch (taskId) {
		case TASK1:
			staticTask=task1;
			break;
		case TASK2:
			staticTask=task2;
			break;
		default:
			throw new ServiceException(StatusCode.FAILED,"no_task_id", null);
		}
		
		 List<Integer> conditions =staticTask.getConditions();
		 List<Integer> priceTypes =staticTask.getPriceTypes();
		 List<Integer> priceNums =staticTask.getPriceNums();
		 for (int i = gameTask.getStep(); i < conditions.size(); i++) {
			 if(gameTask.getSchedul()>=conditions.get(i)){
				 int type=priceTypes.get(i);
				 int num= priceNums.get(i);
				 switch (type) {
				 case COIN:
                TransDeal.taskAddCoin(gameTask.getId(),type, i+1, uid, num);
                
					 break;
				 case EXTRACT_PER:
				 TransDeal.taskAddExtractPer(gameTask.getId(), i+1, uid, num);
					 break;
				 default:
					 break;
				 }	
			 }
		 }
		 resData.put("isLeader", Integer.parseInt(RedisData.userField(jedisClient, uid, "isLeader")));	
		 resData.put("coin", Integer.parseInt(RedisData.userField(jedisClient, uid, "coin")));	
	 return resData;	
	
	}
	
	public  void updateSchedul(int uid,int taskId,int num){
		if(uid==0){
			return;
		}
		List<gameTask> tasks=gameTaskMapper.getTaskByType(uid, taskId);
		if(tasks.isEmpty()){
			return;
		}
		gameTask task=tasks.get(0);
		gameTaskMapper.Onschedul(task.getId(), task.getSchedul()+num);
	}
	
	
	public List<gameTask> genInitTasks(int uid){
		gameTask task1= new gameTask();
		task1.setSchedul(0);
		task1.setStep(0);
		task1.setTaskId(TASK1);
		task1.setUid(uid);
		gameTask task2= new gameTask();
		task2.setSchedul(0);
		task2.setStep(0);
		task2.setTaskId(TASK2);
		task2.setUid(uid);
		List<gameTask> gameTasks=new ArrayList<gameTask>();
		gameTasks.add(task1);
		gameTasks.add(task2);
	 return 	gameTasks;	 
	}
	
	

	
}
