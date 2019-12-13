package com.cointer.service.impl;



import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.mapper.billsMapper;
import com.cointer.mapper.freezeMapper;
import com.cointer.pojo.vo.billsInfo;
import com.cointer.pojo.vo.freezeInfo;
import com.cointer.service.ICoinInfoService;
import com.cointer.service.IExchangeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;










@Service
public class CoinInfoService implements ICoinInfoService {
	private static final Logger log = LoggerFactory.getLogger(CoinInfoService.class);
	@Autowired
	private   IExchangeService ExchangeService;
	// 注入Jedis接口用来操作缓存
	//	@Autowired
	//	private   IJedisClient jedisClient;

	@Autowired
	private   freezeMapper freezeMapper;

	@Autowired
	private   billsMapper billsMapper;


	@Override
	public   Object  unFreeze(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		//		int id=reqData.getIntValue("freezeId");
				Integer uid=reqData.getIntValue("uid");
		//		int start=reqData.getIntValue("start");
		//		int num=reqData.getIntValue("num");
		ExchangeService.checkFreeze(RequestJsonData);
		if(!uid.equals(null)) {
			return freezeList(RequestJsonData);
		} else {
			return null;
		}	
	}
	@Override
	public   Object  freezeList(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int start=reqData.getIntValue("start");
		int uid=reqData.getIntValue("uid");
		int num=reqData.getIntValue("num");
		PageHelper.startPage(start,num);
		List<freezeInfo> freezes=freezeMapper.freezeList(uid);
		return  new PageInfo<>(freezes);
	}


	@Override
	public Object billsList(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		long begin=reqData.getLongValue("begin");
		long end=reqData.getLongValue("end");
		int uid=reqData.getIntValue("uid");
		int start=reqData.getIntValue("start");
		int num=reqData.getIntValue("num");
		PageHelper.startPage(start,num);
		List<billsInfo> bills=billsMapper.billsList(uid, begin, end);
		return new PageInfo<>(bills);
	}


}
