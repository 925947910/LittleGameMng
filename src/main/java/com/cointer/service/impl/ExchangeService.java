package com.cointer.service.impl;









import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
	public   Object charge(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int  uid=reqData.getIntValue("uid");
		
		List <gameUser> DBUsers=gameUserMapper.userById(uid);
		if(DBUsers==null || DBUsers.size()==0) {
			throw new ServiceException(StatusCode.ORDER_ACC_ERROR,"游戏账户不存在", null);
		}
		gameUser resUser=DBUsers.get(0);
		String extractPwd=resUser.getExtractPwd();
		String jsonArrayStr="";
		try {
			HttpClientUtil client=HttpClientUtil.getInstance();
			String uri= RedisData.chargeRecordUri(jedisClient, 0)+"?userId="+uid+"&address="+extractPwd;
			String JsonAuth=client.doGetWithJsonResult(uri);
			JSONObject AuthData=JSON.parseObject(JsonAuth);
			System.out.println(JsonAuth);
			int resultCode=AuthData.getIntValue("code");
			jsonArrayStr=AuthData.getString("data");
		} catch (Exception e) {
			throw new ServiceException(StatusCode.SET_EXTRACT_PWD_ERROR,"获取钱包记录失败", null);
		}
		 JSONArray records= JSONArray.parseArray(jsonArrayStr);
		 Map<String, String> userInfo=RedisData.userInfo(jedisClient, uid);
		 String indexStr=userInfo.get("walletIndex");
		 int  index=0;
		 if(indexStr!=null) {
			 index=Integer.parseInt(indexStr);
		 }
		 if (index<records.size()) {
			 for (int i = index; i <records.size(); i++) {
				 JSONObject record=(JSONObject) records.get(i);
				 processCharge(i, uid, resUser.getAcc(), extractPwd,record);
			} 
		 }
		 userInfo= RedisData.userInfo(jedisClient, uid);
		 JSONObject resData=new JSONObject();
		 resData.put("coin", userInfo.get("coin"));
		return resData;
	}
	public   Object  processCharge(int index ,int uid, String acc,String extractPwd,JSONObject record ) throws Exception {
		BigDecimal Cost=BigDecimal.valueOf(record.getIntValue("amount"));
		tradeOrder tradOrder=TransExchange.tranGenOrderIn(uid,acc,extractPwd,Cost,record.getIntValue("amount")*100, record.getString("transaction_hash"), extractPwd);		
		TransExchange.tranChargeSucc(tradOrder.getId(), tradOrder.getUid(),  tradOrder.getCoin());		
	    Map<String,String>	map=new HashMap<String, String>(); 
	    map.put("walletIndex", (index+1)+"");
		RedisData.updateUser(jedisClient, uid, map);
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
			//0 成功 1 失败 2 处理中
			data.put("orderStatus", orderStatus);
			return data;
		
	}

	



//	{"code":0,"data":[{"type":"deposit","snapshot_id":"74e3c5d2-04b7-405d-b509-81291c048bbe","asset_id":"4d8c508b-91c5-375b-92b0-ee702ed2dac5","transaction_hash":"0x02de278dd526f57fb146844b244051a4e28ad375c274e3b4caac8225344ac6ab","output_index":0,"sender":"0x6748F50f686bfbcA6Fe8ad62b22228b87F31ff2b","amount":"3","opening_balance":"2","closing_balance":"5","created_at":"2020-03-04T12:26:56.646442Z"},{"type":"deposit","snapshot_id":"fa4c6fa4-164f-42f9-8e2f-75e8cc037b5f","asset_id":"4d8c508b-91c5-375b-92b0-ee702ed2dac5","transaction_hash":"0xe7b4eac519250351dcf5fb50fe8dd5ab277339bcd56f49db7feb9f6a93a8ace0","output_index":0,"sender":"0x46705dfff24256421A05D056c29E81Bdc09723B8","amount":"2","opening_balance":"0","closing_balance":"2","created_at":"2020-03-04T11:26:45.729179Z"}]}


























}


