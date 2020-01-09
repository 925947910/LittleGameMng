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
	@Override
	public   Object  extractOrder(String  RequestJsonData) throws  Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int excoin=reqData.getIntValue("coin");
		int uid=reqData.getIntValue("uid");
		String extractPwd =Base64.getEncoder().encodeToString(reqData.getString("extractPwd").getBytes());
		List<gameUser> AuthDatas=gameUserMapper.authPwd(uid,extractPwd);
		if(AuthDatas==null || AuthDatas.size()==0) {
			throw new ServiceException(StatusCode.EXTRACT_PWD_ERROR,"提取密码错误", null);
		}
		if(RedisData.inGame(jedisClient,uid)) {
			throw new ServiceException(StatusCode.EXTRACT_IN_GAME,"游戏中不允许提取", null);
		}
		gameUser authGameUser=AuthDatas.get(0);
		int oldCoin=authGameUser.getCoin();
		if  (oldCoin<excoin) {
			throw new ServiceException(StatusCode.COIN_NO_ENOUGH,"资金不足", null);
		}  
		if  (excoin<1000||excoin>1000000) {
			throw new ServiceException(StatusCode.EXTRACT_OUT_LIMIT,"资金超出限制", null);
		} 
		int aid=authGameUser.getAid();
		String account=authGameUser.getPhone();
		String email=authGameUser.getEmail();
		int plat=authGameUser.getPlat();
		int myPlat=RedisData.platNo(jedisClient,plat);
		if(StringUtils.isBlank(account)) {
			account=email;
		}
		BigDecimal cost  = new BigDecimal(excoin);
		cost=cost.divide(new BigDecimal(OXO2COIN));
		
		tradeOrder tradeOrder=TransExchange.tranGenOrderOut(uid,plat, cost, excoin, "OXO");
		int orderId=tradeOrder.getId();
		String orderNo=tradeOrder.getOrderLocal();
		boolean chargeResult;
		String remoteOrderNo;
		String genSign;
		String uri;
		String  platName=RedisData.AuthPlatNo(jedisClient,plat);
		switch (platName) {
		case "_PLAT_OXO_EXCHANGE":
			JSONObject param=new JSONObject();
			param.put("account", account);
			param.put("mobile", account);
			param.put("num", cost);
			param.put("platform",myPlat);
			param.put("receiveurl", RedisData.extractCallbackUri(jedisClient,plat));
			param.put("thirdOrderNo",orderNo);
			param.put("tradeType", "in");
			param.put("type", "OXO");
			param.put("exchangeRatioNum",excoin);
			param.put("userId",aid);
			String str = cost.intValue()+account+aid+orderNo+"OXO"+myPlat;
			String data=MD5Util.getSaltMD5(str, MD5Util.SALT);
			genSign= RSAUtils.priKeyGenSign(data,RedisData.localPrivateKey(jedisClient));
			param.put("sign", genSign);
			HttpClientUtil client=HttpClientUtil.getInstance();
			String ParamJson=param.toString();
			uri=RedisData.extractOrderUri(jedisClient,plat);
			String JsonAuth=client.doPostWithJsonResult(uri, ParamJson);
			if(JsonAuth==null) {
				throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
			}
			JSONObject AuthData=  JSON.parseObject(JsonAuth);
			chargeResult=AuthData.getIntValue("code")==0;
			remoteOrderNo=AuthData.getJSONObject("data").getString("orderNo");
			break;
		case "_PLAT_TOKENMAP":
			tokenMapExtractOrderDto dto=new tokenMapExtractOrderDto();
			dto.setTokenmapNum(cost);// tokenmap方数额
			dto.setTokenmapAccount(account); //tokenmap方用户账户
			dto.setThirdAccount(account); //第三方用户账户
			dto.setTokenmapUserId(aid); //tokenmap方用户id
			dto.setTokenCode("OXO"); //当前币种
			dto.setTokenmapTag(plat+"");//tokenmap在第三方的标识
			dto.setThirdNum(new BigDecimal(excoin));//第三方数额
			dto.setCallBackUrl(RedisData.extractCallbackUri(jedisClient,plat)); //游戏方提供的callback地址
			dto.setThirdOrderNo(orderNo);//第三方生成的订单号
			dto.setThirdPartTag(myPlat+""); //第三方在tokenmap的标识
			str = dto.getTokenmapNum().intValue() + dto.getTokenmapAccount() +dto.getThirdOrderNo()+ dto.getTokenmapUserId() + dto.getTokenCode()
			+ dto.getThirdPartTag();
			data = MD5Util.encrypt(str, MD5Util.SALT);
			genSign = RSAUtils.priKeyGenSign(data,RedisData.localPrivateKey(jedisClient));
			dto.setSign(genSign); //签名
			ParamJson=JSON.toJSONString(dto);	
			uri=RedisData.extractOrderUri(jedisClient,plat);
			client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(uri, ParamJson);
			if(JsonAuth==null) {
				throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
			}
			AuthData=  JSON.parseObject(JsonAuth);
			chargeResult=AuthData.getIntValue("code")==200;
			remoteOrderNo=AuthData.getString("data");
			break;
		default:throw new ServiceException(StatusCode.FAILED,"无效第三方", null);
		}
		if(chargeResult) {
			//+++++++++++++++++++ 成功 订单状态 改成2
			TransExchange.tranExtractOrderSucc(orderId, uid,remoteOrderNo);
			return	null;
		}else {
			TransExchange.tranExtractOrderFailed(orderId, uid, tradeOrder.getFreezeId(), excoin);
			throw new ServiceException(StatusCode.GEN_REMOTE_ORDER_FAILED,"第三方生成订单失败", null);
		}
	}



	//设置资金密码
	@Override
	public   Object extractPwd(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		String email=reqData.getString("email");
		String phone=reqData.getString("phone");
		String extractPwd =reqData.getString("extractPwd");
		int  uid=reqData.getIntValue("uid");
		List<gameUser> DBDatas=gameUserMapper.phoneEmailById(uid);
		gameUser  result=DBDatas.get(0);
		String emailDb = result.getEmail();
		String phoneDb = result.getPhone();
		if(!(email.equals(emailDb)||phone.equals(phoneDb))) {
			throw new ServiceException(StatusCode.PHONE_OR_EMAIL_ERROR,"手机或邮箱错误", null);
		}
		if(gameUserMapper.resetPwd(uid, extractPwd)!=1) {
			throw new ServiceException(StatusCode.SET_EXTRACT_PWD_ERROR,"设置密码失败", null);
		}
		return null;
	}

	//游戏内转账
	@Override
	public   Object coinDeal(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		
		int  uid=reqData.getIntValue("uid");
		int  tagUid=reqData.getIntValue("tagUid");
		int  coin=reqData.getIntValue("coin");
		if(RedisData.inGame(jedisClient,uid)) {
			throw new ServiceException(StatusCode.EXTRACT_IN_GAME,"游戏中不允许转账", null);
		}
		String extractPwd=Base64.getEncoder().encodeToString(reqData.getString("extractPwd").getBytes());
		TransDeal.tranDealCoin(uid, tagUid, coin, extractPwd);
		return null;

	}
	//游戏内转账
	@Override
	public   Object  coinRecover(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int  uid=reqData.getIntValue("uid");
		int  coin=reqData.getIntValue("coin");
		String extractPwd=reqData.getString("extractPwd");
		if(RedisData.inGame(jedisClient,uid)) {
			throw new ServiceException(StatusCode.EXTRACT_IN_GAME,"游戏中不允许转账", null);
		}
	   TransDeal.coinRecover(uid,coin,extractPwd);
		return null;
	}



}


