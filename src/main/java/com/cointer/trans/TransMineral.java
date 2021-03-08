package com.cointer.trans;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cointer.eventer.EventProcesser;
import com.cointer.exception.TransException;
import com.cointer.mapper.mineralMapper;
import com.cointer.pojo.po.gamePresenter;
import com.cointer.pojo.po.mineralCode;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
@Component
public class TransMineral {

	@Autowired
	private   mineralMapper mineralMapper;
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   EventProcesser EventProcesser;


	@Transactional
	public   void  useMineralCode(int uid,String mineralCode) throws Exception {
		if(mineralMapper.useMineralCode(mineralCode,uid)!=1) {
			throw new TransException("矿石码已失效");
		}
		List<mineralCode> lmineralCode=  mineralMapper.getMineralCode(mineralCode);
		mineralCode mineral=lmineralCode.get(0);
		int mineralNum =mineral.getMineral();
		List<Integer> adder=new ArrayList<Integer>();
		Map<String,String> map=RedisData.sysConfig(jedisClient);
		
		try {
			List<gamePresenter>  gamePresenterL3= mineralMapper.getPresenter(uid);
			adder.add(gamePresenterL3.get(0).getPresenterId());
			adder.add((Integer.parseInt(map.get("mineralPerLev3"))*mineralNum)/100);
			adder.add(uid);
			
			List<gamePresenter>  gamePresenterL2= mineralMapper.getPresenter(gamePresenterL3.get(0).getPresenterId());
			adder.add(gamePresenterL2.get(0).getPresenterId());
			adder.add((Integer.parseInt(map.get("mineralPerLev2"))*mineralNum)/100);
			adder.add(gamePresenterL3.get(0).getPresenterId());
			
			List<gamePresenter>  gamePresenterL1= mineralMapper.getPresenter(gamePresenterL2.get(0).getPresenterId());
			adder.add(gamePresenterL1.get(0).getPresenterId());
			adder.add((Integer.parseInt(map.get("mineralPerLev1"))*mineralNum)/100);
			adder.add(gamePresenterL2.get(0).getPresenterId());
			
		} catch (Exception e) {

		}
		EventProcesser.mineralChange(uid, (Integer.parseInt(map.get("mineralPer"))*mineralNum)/100, EventProcesser.EVENT_ADD_MINERAL, mineral.getId(), "购买产品奖励");
        for (int i = 0; i < adder.size(); i+=3) {
        	EventProcesser.mineralChange(adder.get(i),adder.get(i+1),EventProcesser.EVENT_PRESENTER_ADD_MINERAL,adder.get(i+2), "推荐购买返点");
		}

	}




}
