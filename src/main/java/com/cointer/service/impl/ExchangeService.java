package com.cointer.service.impl;









import java.math.BigDecimal;
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
import com.cointer.controller.base.BaseController;
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

	
	//充值订单
	public   Object  chargeOrder(String  RequestJsonData) throws Exception {
		chargeOrderDto Dto = JSONObject.parseObject(RequestJsonData,chargeOrderDto.class);
		String str = Dto.getCost().intValue()+Dto.getAccIn()+Dto.getAid()+Dto.getRemoteOrderNo()+Dto.getCurrency()+Dto.getPlat();
		String genSign = MD5Util.getSaltMD5(str, MD5Util.SALT);
//		System.out.println("!!!!!!!!!!!!str:"+str);
//		System.out.println("!!!!!!!!!!!!genSign:"+genSign);
		//验证签名是否正确
		boolean verify = RSAUtils.pubKeyVerSign(genSign, Dto.getSign(), RedisData.remotePublicKey(jedisClient, Dto.getPlat()));
		if (!verify) {
			throw new ServiceException(StatusCode.SIGN_ERROR,"签名错误", null);
		}
		List <gameUser> DBUsers=gameUserMapper.getIdByRemoteAid(Dto.getAid(), Dto.getPlat());
		if(DBUsers==null || DBUsers.size()==0) {
			throw new ServiceException(StatusCode.ORDER_ACC_ERROR,"游戏账户不存在", null);
		}
		gameUser resUser=DBUsers.get(0);
		int  uid=resUser.getId();
		//	    int  coin  = new BigDecimal(OXO2COIN).multiply(Dto.getCost()).intValue();
		//		if(coin!=exchangeRatioNum) {
		//			return BaseServlet.failed(CHARGE_COIN_ERROR);
		//		}
		tradeOrder tradOrder=TransExchange.tranGenOrderIn(uid, Dto.getPlat(), Dto.getCost(), Dto.getCoin(), Dto.getRemoteOrderNo(), Dto.getCurrency());		
		int myplat=RedisData.platNo(jedisClient,Dto.getPlat());
		String localOrderNo=tradOrder.getOrderLocal();
		JSONObject BackParam=  JSONObject.parseObject(JSONObject.toJSONString(Dto));
		BackParam.put("myplat",myplat);
		BackParam.put("localOrderNo", localOrderNo);
		str = str+localOrderNo;
		genSign = MD5Util.getSaltMD5(str, MD5Util.SALT);
		BackParam.put("sign", genSign);
		retChargeOrderDto retDto = JSONObject.parseObject(BackParam.toString(),retChargeOrderDto.class);
		//==========回调
		BackParam.put("uid", uid);
		BackParam.put("orderId", tradOrder.getId());
		ChargeCallBack	ChargeCallBack=SpringContextUtil.getBean(ChargeCallBack.class);
		ChargeCallBack.setJsonData(BackParam.toString()); 
		ChargeCallBack.start();
		//==========
		return retDto;
	}
	public   void  Charge(String  jsonData)  {
		boolean chargeResult=false;
		String str;
		String data;
		String sign;
		HttpClientUtil client;
		String ParamJson;
		String JsonAuth;
		JSONObject AuthData;
		int code;
		try {
			doChargeDto Dto = JSONObject.parseObject(jsonData,doChargeDto.class);
			String  platName=RedisData.AuthPlatNo(jedisClient,Dto.getPlat());
			int freezeId= TransExchange.tranChargeFreeze(Dto.getOrderId(), Dto.getUid(), Dto.getCoin());
			switch (platName) {
			case "_PLAT_OXO_EXCHANGE":
				JSONObject param= new JSONObject();
				param.put("num", Dto.getCost());
				param.put("account", Dto.getAccIn());
				param.put("mobile", Dto.getAccOut());
				param.put("tradeType", "out");
				param.put("type", Dto.getCurrency());
				param.put("platform", Dto.getMyplat());
				param.put("orderNo", Dto.getRemoteOrderNo());
				param.put("userId", Dto.getAid());
				param.put("thirdOrderNo", Dto.getLocalOrderNo());
				param.put("status",StatusCode.SUCC+"");
				str= Dto.getCost().intValue()+Dto.getAccIn()+Dto.getAid()+Dto.getRemoteOrderNo()+Dto.getCurrency()+Dto.getMyplat();
				data = MD5Util.encrypt(str, MD5Util.SALT);
				sign = RSAUtils.priKeyGenSign(data,RedisData.localPrivateKey(jedisClient));
				param.put("sign", sign);
				if(freezeId==0) {
					param.put("status",StatusCode.FREEZE_FAILED+"");
					param.put("msg","FREEZE_FAILED");
				}
				client=HttpClientUtil.getInstance();
				ParamJson=param.toString();
				JsonAuth=client.doPostWithJsonResult(Dto.getReceiveurl(), ParamJson);
				if(JsonAuth==null) {
					throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
				}
				AuthData=  JSON.parseObject(JsonAuth);
				code=AuthData.getIntValue("code");
				chargeResult=code==0;
				break;
			case "_PLAT_TOKENMAP":
				tokenMapChargeDto dto=new tokenMapChargeDto();
				if(freezeId==0) {
					dto.setResult("2");
				}else {
					dto.setResult("1");
				}
				dto.setOrderNo(Dto.getRemoteOrderNo());
				dto.setThirdAccount(Dto.getAccIn());
				dto.setThirdNum(new BigDecimal(Dto.getCoin()));
				dto.setThirdOrderNo(Dto.getLocalOrderNo());
				dto.setThirdPartTag(Dto.getMyplat()+"");
				dto.setTokenCode(Dto.getCurrency());
				dto.setTokenmapAccount(Dto.getAccOut());
				dto.setTokenmapNum(Dto.getCost());
				dto.setTokenmapTag(Dto.getPlat()+"");
				dto.setTokenmapUserId(Dto.getAid());
				str = dto.getTokenmapNum().intValue() + dto.getTokenmapAccount() + dto.getTokenmapUserId()
				+ dto.getTokenCode()+ dto.getThirdPartTag();
				data = MD5Util.encrypt(str, MD5Util.SALT);
				sign = RSAUtils.priKeyGenSign(data,RedisData.localPrivateKey(jedisClient));
				dto.setSign(sign);
				ParamJson=JSON.toJSONString(dto);				
				client=HttpClientUtil.getInstance();
				JsonAuth=client.doPostWithJsonResult(Dto.getReceiveurl(), ParamJson);
				if(JsonAuth==null) {
					throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
				}
				AuthData=  JSON.parseObject(JsonAuth);
				code=AuthData.getIntValue("code");
				chargeResult=code==200;
				break;
			default:throw new ServiceException(StatusCode.FAILED,"无效第三方", null);
			}
			if(chargeResult) {
				TransExchange.tranChargeSucc(Dto.getOrderId(), Dto.getUid(), freezeId, Dto.getCoin(),false);
			}else {
				TransExchange.tranChargeFailed(Dto.getOrderId(), freezeId,false);
			}
		} catch (Exception e) {
			log.error("",e);
		}


	}	


	//  提现回调
	public   Object  extract(String  RequestJsonData) throws Exception {
		extractDto Dto = JSONObject.parseObject(RequestJsonData,extractDto.class);
		String str = Dto.getCost().intValue()+Dto.getAccOut()+Dto.getAid()+Dto.getRemoteOrderNo()+Dto.getCurrency()+Dto.getPlat();
		String genSign = MD5Util.getSaltMD5(str, MD5Util.SALT);
		//验证签名是否正确
		boolean verify = RSAUtils.pubKeyVerSign(genSign, Dto.getSign(), RedisData.remotePublicKey(jedisClient, Dto.getPlat()));
		if (!verify) {
			throw new ServiceException(StatusCode.SIGN_ERROR,"签名错误", null);
		}
		List<tradeOrder> tradeOrders=tradeOrderMapper.tradeOrderByOrderLocal(Dto.getLocalOrderNo());
		if(tradeOrders==null || tradeOrders.size()==0) {
			throw new ServiceException(StatusCode.ORDER_NOEXSIST,"订单不存在", null);
		}
		tradeOrder  tradeOrder=tradeOrders.get(0);
		if(Dto.getStatus()==StatusCode.SUCC) {
			TransExchange.tranExtractSucc(tradeOrder.getId(), tradeOrder.getUid(), tradeOrder.getFreezeId(), tradeOrder.getCoin(),false);
			return null;
		}else {
			TransExchange.tranExtractFailed(tradeOrder.getId(), tradeOrder.getUid(), tradeOrder.getFreezeId(), tradeOrder.getCoin(),false);
			throw new ServiceException(StatusCode.EXTRACT_FAILED,"提取失败", null);
		}
	}	



	//  查询订单接口
	public   Object  orderInfo(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		String orderNo=reqData.getString("orderNo");
		String sign=reqData.getString("orderNoStr");
		String genSign = MD5Util.getSaltMD5(orderNo, MD5Util.SALT);
		//验证签名是否正确
		if(!genSign.equals(sign)) {
			throw new ServiceException(StatusCode.SIGN_ERROR,"签名错误", null);
		}
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

	//  解冻 	
	public   Object checkFreeze(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int freezeId=reqData.getIntValue("freezeId");
			List<freezeDto> freezeDTOs=freezeMapper.freezeDTOById(freezeId);
			freezeDto	  freezeDTO=freezeDTOs.get(0);
			long now=	new Date().getTime()/1000;
			if(now<(freezeDTO.getTime()+30)) {
				throw new ServiceException(StatusCode.CHECKFREEZE_ERROR,"冻结资金未过有效期", null);
			}
			String  platName=RedisData.AuthPlatNo(jedisClient,freezeDTO.getPlat());
			int orderStatus=1;
			switch (platName) {
			case "_PLAT_OXO_EXCHANGE":
				if(!StringUtils.isBlank(freezeDTO.getOrderLocal())) {
					String genSign = MD5Util.getSaltMD5(freezeDTO.getOrderLocal(), MD5Util.SALT);
					JSONObject param=new JSONObject();
					param.put("orderNo", freezeDTO.getOrderLocal());
					param.put("orderNoStr", genSign);
					HttpClientUtil client=HttpClientUtil.getInstance();
					String ParamJson=param.toString();
					String JsonAuth=client.doPostWithJsonResult(RedisData.remoteOrderInfoUri(jedisClient,freezeDTO.getPlat()), ParamJson);
					if(JsonAuth==null) {
						throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
					}
					JSONObject AuthData=  JSON.parseObject(JsonAuth);
					orderStatus=AuthData.getJSONObject("data").getIntValue("status");
				}
				break;
			case "_PLAT_TOKENMAP":
				if(!StringUtils.isBlank(freezeDTO.getOrderLocal())) {
					String genSign = MD5Util.getSaltMD5(freezeDTO.getOrderLocal(), MD5Util.SALT);
					Map<String,String> param=  new HashMap<String, String>();
					param.put("thirdNo", freezeDTO.getOrderLocal());
					param.put("genSign", genSign);
					HttpClientUtil client=HttpClientUtil.getInstance();
					
					String JsonAuth=client.doPostWithJsonResult(RedisData.remoteOrderInfoUri(jedisClient,freezeDTO.getPlat()), param);
					if(JsonAuth==null) {
						throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
					}
					JSONObject AuthData=  JSON.parseObject(JsonAuth);
					orderStatus=AuthData.getIntValue("data");
				}
				break;
			default:
				throw new ServiceException(StatusCode.FAILED,"无效第三方", null);
			}
			switch (orderStatus) {
			case 0:
				if(freezeDTO.getOrderType()==TransExchange.ORDERIN) {
					TransExchange.tranChargeSucc(freezeDTO.getOrderId(), freezeDTO.getUid(), freezeId,freezeDTO.getCoin(),true);
				}else {
					TransExchange.tranExtractSucc(freezeDTO.getOrderId(), freezeDTO.getUid(), freezeId, freezeDTO.getCoin(),true);
				}
				break;
			default:
				if(freezeDTO.getOrderType()==TransExchange.ORDERIN) {
					TransExchange.tranChargeFailed(freezeDTO.getOrderId(), freezeId,true);
				}else {
					TransExchange.tranExtractFailed(freezeDTO.getOrderId(), freezeDTO.getUid(), freezeId, freezeDTO.getCoin(),true);
				}
				break;
			}
			return null;
		
	}































}


