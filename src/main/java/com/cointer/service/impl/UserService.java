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
import com.alibaba.fastjson.TypeReference;
import com.cointer.constant.Constant;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.mapper.gameUserMapper;
import com.cointer.pojo.dto.loginUserDto;
import com.cointer.pojo.po.bots;
import com.cointer.pojo.po.gameUser;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IUserService;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;
import com.cointer.util.RSAUtils;
import com.cointer.util.StringUtil;
import com.cointer.util.TokenMaker;










@Service
public class UserService implements IUserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private   gameUserMapper gameUserMapper;

	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;


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
		 resData.put("message", "Congratulations on your registration. Please click the following link to download the game");
		 resData.put("gameUrl", RedisData.getUri(jedisClient, platFrom,"gameUrl"));
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
			DBUser.setCoin(10000);
			DBUser.setPhoto("");
			DBUser.setPhone(loginDto.getPhone());
			DBUser.setAgentId(loginDto.getAgentId());
			DBUser.setPresenterId(loginDto.getPresenterId());
			DBUser.setFreezed(0);
			DBUser.setIsLeader(0);
			DBUser.setIsTourist(1);
			DBUser.setVersion(0);
			DBUser.setRegTime((new Date().getTime()/1000));
			if(gameUserMapper.registGameUser(DBUser)!=1){
				throw new ServiceException(StatusCode.REGIST_FAILED,"account_regist_failed", null);
			}
		RedisData.setAccKey(jedisClient,id, loginDto.getPlat(), loginDto.getAcc());
		return id;
	}
	@Override
	public  Object   login(String  RequestJsonData) throws Exception  {
		int platFrom=0;
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		String token=reqData.getString(Constant._TOKEN);
		Map<String,String> tokenInfo=RedisData.authToken(jedisClient,platFrom,token);
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
		String session=RedisData.genTokenInfo(jedisClient,Integer.parseInt(MapResult.get("plat")), token,mapData);
		MapResult.put(Constant._SESSION,session);
		MapResult.put(Constant._TOKEN,token);
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
	
	public   Object  userInfo(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int uid=reqData.getIntValue("uid");
		
		Map<String,String> MapResult=RedisData.userInfo(jedisClient, uid);

		return MapResult;
	}
	@Override
	public  Object   write(String  RequestJsonData) throws Exception  {
		Map<String,String> interfaceUri= new HashMap<String,String>();
		
		interfaceUri.put("chargeUrl", "https://api.quickpayind.support/pay");
		interfaceUri.put("chargeCallbackUrl", "http://377u408z76.wicp.vip:47585/GameUser/exchange/chargeCallBack");
		interfaceUri.put("chargeSuccUrl", "http://www.baidu.com/");
		
		interfaceUri.put("extractUrl", "https://api.quickpayind.support/applyfor");
		interfaceUri.put("verifyOrderUrl", "http://127.0.0.1:8085/GameUser/exchange/verifyExtract");
		interfaceUri.put("extractCallbackUrl", "http://377u408z76.wicp.vip:47585/GameUser/exchange/extractCallBack");
		
		interfaceUri.put("gameUrl", "http://www.baidu.com/");
		interfaceUri.put("shareUrl", "http://127.0.0.1:8085/GameUser/view/regist");
		interfaceUri.put("customerId", "big22");
		interfaceUri.put("goldKey", "0Q5gl3OYT2oHA5c5");
		
		try {
		
			 jedisClient.hmset(RedisData.DB1_1, RedisData.INTERFACE_URI+0, interfaceUri);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		

		Map<String,String>  crowdFundItem= new HashMap<String,String>();
		
		crowdFundItem.put("name", "iphone12");
		crowdFundItem.put("price", "100000");
		crowdFundItem.put("picture", "[www.baidu.com,www.baidu.com,www.baidu.com,www.baidu.com]");
		try {
			jedisClient.hmset(RedisData.DB1_1, "crowdFundItem", crowdFundItem);			
		} catch (Exception e) {
			// TODO: handle exception
		}
		  
						   
						
		List<String> photos= new ArrayList<String>();
		
		photos.add("http://129.226.35.186/head/man1.jpg");
		photos.add("http://129.226.35.186/head/man2.jpg");
		photos.add("http://129.226.35.186/head/man3.jpg");
		photos.add("http://129.226.35.186/head/man4.jpg");
		photos.add("http://129.226.35.186/head/man5.jpg");
		photos.add("http://129.226.35.186/head/woman1.jpg");
		photos.add("http://129.226.35.186/head/woman2.jpg");
		photos.add("http://129.226.35.186/head/woman3.jpg");
		photos.add("http://129.226.35.186/head/woman4.jpg");
		photos.add("http://129.226.35.186/head/woman5.jpg");
		
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
