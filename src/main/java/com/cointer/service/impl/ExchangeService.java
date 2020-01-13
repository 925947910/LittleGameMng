package com.cointer.service.impl;









import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.mapper.freezeMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.mapper.tradeOrderMapper;
import com.cointer.pojo.dto.tokenMapChargeDto;
import com.cointer.pojo.dto.chargeOrderDto;
import com.cointer.pojo.dto.doChargeDto;
import com.cointer.pojo.dto.extractDto;
import com.cointer.pojo.dto.freezeDto;
import com.cointer.pojo.dto.retChargeOrderDto;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IExchangeService;
import com.cointer.trans.TransExchange;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.util.RSAUtils;
import com.cointer.util.SpringContextUtil;






@Service
public class ExchangeService  implements IExchangeService{

	public static final int			OXO2COIN       = 100;
	private static final Logger log = LoggerFactory.getLogger(ExchangeService.class);
	@Autowired
	private   gameUserMapper gameUserMapper;
	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   TransExchange TransExchange;
	@Autowired
	private   tradeOrderMapper tradeOrderMapper;
	@Autowired
	private   freezeMapper freezeMapper;

	
	//充值
	public   Object  charge(String  RequestJsonData) throws Exception {
		chargeOrderDto Dto = JSONObject.parseObject(RequestJsonData,chargeOrderDto.class);
		String signStr = Dto.getAccIn()+Dto.getCoin()+Dto.getRemoteOrderNo()+Dto.getCurrency();
		//验证签名是否正确
		boolean verify = RSAUtils.pubKeyVerSign(signStr, Dto.getSign(),RSAUtils.publicKeys);
		if (!verify) {
			throw new ServiceException(StatusCode.SIGN_ERROR,"签名错误", null);
		}
		List <gameUser> DBUsers=gameUserMapper.checkAcc(Dto.getAccIn(), 0);
		if(DBUsers==null || DBUsers.size()==0) {
			throw new ServiceException(StatusCode.ORDER_ACC_ERROR,"游戏账户不存在", null);
		}
		gameUser resUser=DBUsers.get(0);
		int  uid=resUser.getId();

		tradeOrder tradOrder=TransExchange.tranGenOrderIn(uid,Dto.getAccIn(), Dto.getAccOut(), Dto.getCost(), Dto.getCoin(), Dto.getRemoteOrderNo(), Dto.getCurrency());		
		TransExchange.tranChargeSucc(tradOrder.getId(), tradOrder.getUid(),  tradOrder.getCoin());		
		return null;
	}
	

	//  查询订单接口
	public   Object  orderInfo(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		String orderNo=reqData.getString("orderNo");
			List<tradeOrder> tradeOrders=tradeOrderMapper.OrderStatusByOrderRemote(orderNo);
			int orderStatus=4;
			if(tradeOrders.size()!=0) {
				orderStatus= tradeOrders.get(0).getStatus();
			}else {
				orderStatus=4;
			}
			switch (orderStatus) {
			case 3:
				orderStatus=0;
				break;
			case 4:
				orderStatus=1;
				break;
			default:
				orderStatus=2;
				break;
			}
			JSONObject data=new JSONObject();
			data.put("orderStatus", orderStatus);
			return data;
		
	}

	






























}


