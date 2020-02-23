package com.cointer.service.impl;









import java.math.BigDecimal;
import java.util.Base64;

import java.util.List;




import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.mapper.gameUserMapper;
import com.cointer.pojo.dto.tokenMapChargeDto;
import com.cointer.pojo.dto.tokenMapExtractOrderDto;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IDealService;
import com.cointer.trans.TransDeal;
import com.cointer.trans.TransExchange;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.util.RSAUtils;





@Service
public class DealService implements IDealService {



	public static final int			OXO2COIN       = 100;


	@Autowired
	private   gameUserMapper gameUserMapper;
	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   TransExchange TransExchange;
	@Autowired
	private   TransDeal TransDeal;




	//设置钱包
	@Override
	public   Object extractPwd(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		String extractPwd =reqData.getString("extractPwd");
		int  uid=reqData.getIntValue("uid");
		if(gameUserMapper.resetPwd(uid, extractPwd)!=1) {
			throw new ServiceException(StatusCode.SET_EXTRACT_PWD_ERROR,"设置钱包失败", null);
		}
		return null;
	}

	//游戏内转账
	@Override
	public   Object coinDeal(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		
		int  uid=reqData.getIntValue("uid");
		String extractPwd =reqData.getString("extractPwd");
		int  coin=reqData.getIntValue("coin");
		String pwd=reqData.getString("pwd");
		if(RedisData.inGame(jedisClient,uid)) {
			throw new ServiceException(StatusCode.EXTRACT_IN_GAME,"游戏中不允许转账", null);
		}
		if(StringUtils.isBlank(extractPwd)) {
			throw new ServiceException(StatusCode.FAILED,"钱包地址不能为空", null);
		}
		TransDeal.tranDealCoin(uid, extractPwd, coin, pwd);
		return null;

	}
	//游戏内提现
	@Override
	public   Object  coinRecover(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int  uid=reqData.getIntValue("uid");
		int  coin=reqData.getIntValue("coin");
		String pwd=reqData.getString("pwd");
		if(RedisData.inGame(jedisClient,uid)) {
			throw new ServiceException(StatusCode.EXTRACT_IN_GAME,"游戏中不允许转账", null);
		}
	   TransDeal.coinRecover(uid,coin,pwd);
		return null;
	}



}


