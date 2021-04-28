package com.cointer.service.impl;



import java.util.ArrayList;
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
import com.cointer.constant.Constant;
import com.cointer.constant.StatusCode;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.ServiceException;
import com.cointer.mapper.billsMapper;
import com.cointer.mapper.gameUserMapper;
import com.cointer.pojo.dto.loginUserDto;
import com.cointer.pojo.po.bots;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.vo.billsInfo;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IUserService;
import com.cointer.util.StringUtil;
import com.cointer.util.TokenMaker;








@Service
public class UserService implements IUserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private   gameUserMapper gameUserMapper;
	@Autowired
	private   billsMapper billsMapper;

	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private EventProcesser EventProcesser;
	@Autowired
	private GameTaskService GameTaskService;
	
	@Override
	public  Object   regist(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int platFrom=0;
		loginUserDto loginDto=new loginUserDto();
		loginDto.setPlat(platFrom);
		loginDto.setAgentId(reqData.getIntValue("agentId"));
		loginDto.setPresenterId(reqData.getIntValue("presenterId"));
		loginDto.setAcc(reqData.getString("phone"));
		loginDto.setPwd(reqData.getString("pwd"));
		loginDto.setNick(reqData.getString("nick"));
		loginDto.setPhone(reqData.getString("phone"));
		loginDto.setSex(reqData.getIntValue("sex"));
		 regist(loginDto);
		 resData.put("messageAndroid", "Congratulations on your registration.For Android users,Please click the following link to download the game");
		 resData.put("gameUrlAndroid", RedisData.getUri(jedisClient, platFrom,"gameUrlAndroid"));
		 resData.put("messageIos", "Congratulations on your registration.For iOS users,Please click the following link to download the game");
		 resData.put("gameUrlIos", RedisData.getUri(jedisClient, platFrom,"gameUrlIos"));
		 return resData;
	}
	
	public   Integer  regist(loginUserDto loginDto) throws Exception {
		if(StringUtils.isBlank(loginDto.getAcc())){
			throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"account_not_null", null);
		}
		List<gameUser> DBUsers=gameUserMapper.checkAcc(loginDto.getAcc(), loginDto.getPlat());
		gameUser DBUser=new gameUser();
		Integer id;
			//注册用户
			if(!StringUtil.MobileNumber("+91",loginDto.getPhone())) {
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"phone_number_illegal", null);
			}
			if(StringUtils.isBlank(loginDto.getNick())) {
				throw new ServiceException(StatusCode.REGIST_FAILED,"nick_not_null", null);
			}
			if(loginDto.getAgentId()==null||loginDto.getAgentId()==0){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"agentId_not_null", null);
			}
			if(loginDto.getPresenterId()==null){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"presenterId_not_null", null);
			}
			if(DBUsers.size()!=0){
				throw new ServiceException(StatusCode.REGIST_FAILED,"account_exsist", null);
			}
			id= RedisData.genAccId(jedisClient);
			DBUser.setId(id);
			DBUser.setPlat(loginDto.getPlat());
			DBUser.setSex(loginDto.getSex());
			DBUser.setAcc(loginDto.getAcc());
			DBUser.setPwd(loginDto.getPwd());
			DBUser.setNick(loginDto.getNick());
			DBUser.setCoin(8888);
			DBUser.setPhoto("");
			DBUser.setPhone(loginDto.getPhone());
			DBUser.setAgentId(loginDto.getAgentId());
			DBUser.setPresenterId(loginDto.getPresenterId());
			DBUser.setFreezed(0);
			DBUser.setIsLeader(1);
			DBUser.setIsTourist(1);
			DBUser.setVersion(0);
			DBUser.setRegTime((new Date().getTime()/1000));
			if(gameUserMapper.registGameUser(DBUser)!=1){
				throw new ServiceException(StatusCode.REGIST_FAILED,"account_regist_failed", null);
			}
			GameTaskService.updateSchedul(loginDto.getPresenterId(), GameTaskService.TASK1, 1);
		return id;
	}
	@Override
	public  Object   login(String  RequestJsonData) throws Exception  {
		int platFrom=0;
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		String token=reqData.getString(Constant._TOKEN);
		Map<String,String> tokenInfo=RedisData.getSessionInfo(jedisClient,token);
		if(tokenInfo.get("uid")!=null) {
			return login(Integer.parseInt(tokenInfo.get("uid")), token);
		}
		List<gameUser> DBUsers=gameUserMapper.checkAcc(reqData.getString("acc"), platFrom);
		if(DBUsers.size()==0){
			throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"account_error", null);
		}
		gameUser DBUser=new gameUser();
		DBUser=DBUsers.get(0);
		 if(!DBUser.getPwd().equals(reqData.getString("pwd"))){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"password_error", null);
			}
		 RedisData.updateUser(jedisClient,DBUser); 
		 return login(DBUser.getId(),TokenMaker.getInstance().makeToken());
	}
	
	public   Object  login(int id,String token) throws Exception {
		Map<String,String> MapResult=RedisData.userInfo(jedisClient, id);
		Map<String,String> mapData= new HashMap<String, String>();
		mapData.put("uid", MapResult.get("id"));
		RedisData.setSessionInfo(jedisClient, token, mapData);
		MapResult.put(Constant._SESSION,token);
		return MapResult;
	}




	public   Object  addPhoto(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		String photo=reqData.getString("photo");
		Integer uid=reqData.getIntValue("uid");
		if(gameUserMapper.updatePhoto(uid, photo)!=1) {
			throw new ServiceException(StatusCode.FAILED,"添加头像失败", null);
		}
		Map<String,String> map= new HashMap<String, String>();
		map.put("photo", photo);
		RedisData.updateUser(jedisClient, uid, map);
		return null;
	}
	public   Object  remotePlats(String  RequestJsonData) throws Exception {
		List<Map<String,String>> plats= new ArrayList<Map<String,String>>();
		plats= RedisData.AllPlats(jedisClient);
		return plats;
	}
	

	@Override
	public  Object   	leaderInfo(String  RequestJsonData) throws Exception  {
		
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		Integer uid=reqData.getInteger("uid");
		List<gameUser> DBUsers=gameUserMapper.userById(uid);
		gameUser DBUser=DBUsers.get(0);
		int members=gameUserMapper.getMembers(uid);
		List<billsInfo> rewardsRec=billsMapper.billsByType(uid, EventProcesser.EVENT_EXTRACT_REBATES);
		String rewardsPool="0";
		String chargeRebates=RedisData.userField(jedisClient, uid, "chargeRebates");
		if(chargeRebates!=null){
			rewardsPool=chargeRebates;
		}
		resData.put("rewardsPool",rewardsPool);
		resData.put("isLeader",DBUser.getIsLeader());
		resData.put("members",members);
		resData.put("rewardsRec",rewardsRec);
		 return resData;
	}
	@Override
	public  Object  extractRebates(String  RequestJsonData) throws Exception  {
		
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		Integer uid=reqData.getInteger("uid");
		Integer rewardsPool=0;
		String  chargeRebates=RedisData.userField(jedisClient, uid, "chargeRebates");
		if(chargeRebates!=null){
			rewardsPool=Integer.parseInt(chargeRebates);
		}
		if(rewardsPool==0){
			throw new ServiceException(StatusCode.FAILED,"rewardsPool_not_enough", null);
		}
		EventProcesser.gameCoinChange(uid, rewardsPool, EventProcesser.EVENT_EXTRACT_REBATES, 0, "extractRebates");
		RedisData.addChargeRebates(jedisClient, uid, -rewardsPool);
		List<billsInfo> rewardsRec=billsMapper.billsByType(uid, EventProcesser.EVENT_EXTRACT_REBATES);
		resData.put("rewardsRec",rewardsRec);
		resData.put("rewardsPool", RedisData.userField(jedisClient, uid, "chargeRebates"));
		resData.put("coin",RedisData.userField(jedisClient, uid, "coin"));
		return resData;
	}
	
	
	
	
//	@Override
//	public  Object   	getSign(String  RequestJsonData) throws Exception  {
//		JSONObject reqData=JSON.parseObject(RequestJsonData);
//		JSONObject resData=new JSONObject();
//		Integer uid=reqData.getInteger("uid");
//
//		String schedul=RedisData.userSign(jedisClient, uid);
//		resData.put("schedul", schedul);
//		return resData;
//	}
//	@Override
//	public  Object  getSignPrice(String  RequestJsonData) throws Exception  {
//		JSONObject reqData=JSON.parseObject(RequestJsonData);
//		JSONObject resData=new JSONObject();
//		Integer uid=reqData.getInteger("uid");
//	
//		boolean result=RedisData.UpdateUserSign(jedisClient, uid, 2);
//		resData.put("result", result);
//		if(result){
//			int newCoin=EventProcesser.gameCoinChange(uid,5,EventProcesser.EVENT_USERSIGN_ADD,0,"user sign add");
//			resData.put("newCoin",newCoin);
//		}
//		return resData;
//	}
	
	public   Object  userInfo(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int uid=reqData.getIntValue("uid");
		
		Map<String,String> MapResult=RedisData.userInfo(jedisClient, uid);
		String url=RedisData.getUri(jedisClient, 0, "shareUrl");
		List<billsInfo> bills=billsMapper.billsListByTypes(uid, EventProcesser.EVENT_REDGREENBALL_DRAW,EventProcesser.EVENT_BENZBMW_DRAW);
		resData.put("userInfo", MapResult);
		resData.put("bills", bills);
//		resData.put("isLeader", isLeader);
		resData.put("shareUrl", url+"?agentId="+MapResult.get("agentId")+"&presenterId="+uid);
		
		return resData;
	}
	

	
	
	@Override
	public  Object   write(String  RequestJsonData) throws Exception  {
		Map<String,String> interfaceUri= new HashMap<String,String>();
		
		
		interfaceUri.put("mch_id", "100017003");
		interfaceUri.put("payKey", "0Q5gl3OYT2oHA5c5");
		interfaceUri.put("transferKey", "100017003");
		
		
	    interfaceUri.put("chargeUrl", "https://api.quickpayind.support/pay");
		interfaceUri.put("chargeCallbackUrl", "http://377u408z76.wicp.vip:47585/GameUser/exchange/chargeCallBack");
		interfaceUri.put("chargeSuccUrl", "http://www.baidu.com/");
		interfaceUri.put("extractUrl", "https://api.quickpayind.support/applyfor");
		interfaceUri.put("verifyOrderUrl", "http://127.0.0.1:8085/GameUser/exchange/verifyExtract");
		interfaceUri.put("extractCallbackUrl", "http://377u408z76.wicp.vip:47585/GameUser/exchange/extractCallBack");	
		
		interfaceUri.put("shareUrl", "http://127.0.0.1:8085/GameUser/view/regist");
		interfaceUri.put("gameUrlAndroid", "http://www.baidu.com/");
		interfaceUri.put("gameUrlIos", "http://www.baidu.com/");
		
		try {
		
			 jedisClient.hmset(RedisData.DB1_1, RedisData.INTERFACE_URI+0, interfaceUri);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		


		  
						   
						
		List<String> photos= new ArrayList<String>();
		String headUrl=jedisClient.hget(RedisData.DB1_1, RedisData.INTERFACE_URI+0, "headUrl");
		photos.add(headUrl+"man1.jpg");
		photos.add(headUrl+"man2.jpg");
		photos.add(headUrl+"man3.jpg");
		photos.add(headUrl+"man4.jpg");
		photos.add(headUrl+"man5.jpg");
		photos.add(headUrl+"woman1.jpg");
		photos.add(headUrl+"woman2.jpg");
		photos.add(headUrl+"woman3.jpg");
		photos.add(headUrl+"woman4.jpg");
		photos.add(headUrl+"woman5.jpg");
		jedisClient.del(RedisData.DB1_1, "InfoBots");
		
		List<bots>bots=gameUserMapper.getBots();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!begin:"+System.currentTimeMillis()/1000);
		for (int i = 0; i < bots.size(); i++) {
			JSONObject bot = new JSONObject();
			bot.put("name",bots.get(i).getName());
			bot.put("uid",10000000+i);
			bot.put("photo",photos.get(i%photos.size()));
			try {
				jedisClient.lpush(RedisData.DB1_1, "InfoBots", bot.toString());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!end:"+System.currentTimeMillis()/1000);
		
		
		
							 
							   
		return "succ";
		
		
		
	}


	
}
