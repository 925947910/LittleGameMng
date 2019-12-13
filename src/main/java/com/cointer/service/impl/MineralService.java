package com.cointer.service.impl;



import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.mapper.mineralMapper;
import com.cointer.pojo.po.mineralBills;
import com.cointer.pojo.po.userMineral;
import com.cointer.service.IMineralService;
import com.cointer.trans.TransMineral;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.cointer.eventer.EventProcesser;









@Service
public class MineralService implements IMineralService {
	private static final Logger log = LoggerFactory.getLogger(MineralService.class);

	// 注入Jedis接口用来操作缓存
	//	@Autowired
	//	private   IJedisClient jedisClient;

	@Autowired
	private   mineralMapper mineralMapper;

	@Autowired
	private   TransMineral TransMineral;
	
	@Autowired
	private   EventProcesser EventProcesser;
	

	@Override
	public   Object  getMineral(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		Integer uid=reqData.getIntValue("uid");
		List<userMineral>Lum=mineralMapper.getUserMineral(uid);
		userMineral userMineral=new userMineral();
		userMineral.setFreeze(0);
		userMineral.setMineral(0);
		if (Lum!=null&&Lum.size()!=0) {
			userMineral.setFreeze(Lum.get(0).getFreeze());
			userMineral.setMineral(Lum.get(0).getMineral());
		}
		return userMineral;
	}
	@Override
	public   Object  useMineralCode(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		Integer uid=reqData.getIntValue("uid");
		String  mineralCode=reqData.getString("mineralCode");
		TransMineral.useMineralCode(uid,mineralCode);
		return null;
	}
	@Override
	public Object mineralBillsList(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		long begin=reqData.getLongValue("begin");
		long end=reqData.getLongValue("end");
		int uid=reqData.getIntValue("uid");
		int start=reqData.getIntValue("start");
		int num=reqData.getIntValue("num");
		PageHelper.startPage(start,num);
		List<mineralBills> mineralBills=mineralMapper.mineralBillsList(uid, begin, end);
		return new PageInfo<>(mineralBills);
	}
	@Override
	public   Object  digMineral(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		Integer uid=reqData.getIntValue("uid");
		Integer tagId=reqData.getIntValue("gameId");
		String  desc=reqData.getString("desc");
		int num=0;
		try {
			num=EventProcesser.dig_mineral(uid, EventProcesser.EVENT_DIG_MINERAL, tagId,desc);
		} catch (Exception e) {
		}
		Map<String,String> resMap=  new HashMap<String, String>();
		resMap.put("digCoin", num+"");
		return resMap;
	}
	@Override
	public Object presenterMembers(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int uid=reqData.getIntValue("uid");
		List<Integer> L1=mineralMapper.presenterMembers(uid);
		Map<String,String> resultMap= new HashMap<String, String>();
       int  Num1=L1.size();
       int  Num2=0;
       int  Num3=0;
       Iterator<Integer> i1 =L1.iterator();
		while (i1.hasNext()) {
			Integer id1 = (Integer) i1.next();
			List<Integer> L2=mineralMapper.presenterMembers(id1);
			Num2+=L2.size();
			Iterator<Integer> i2 =L2.iterator();
			while (i2.hasNext()) {
				Integer id2 = (Integer) i2.next();
				List<Integer> L3=mineralMapper.presenterMembers(id2);
				Num3+=L3.size();
			}
		}
		resultMap.put("members1", Num1+"");
		resultMap.put("members2", Num2+"");
		resultMap.put("members3", Num3+"");
		return resultMap;
	}
}
