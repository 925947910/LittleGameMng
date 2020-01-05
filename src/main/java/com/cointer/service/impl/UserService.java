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
	public  Object   registOrLogin(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int platFrom=reqData.getIntValue("plat");
		loginUserDto loginDto=new loginUserDto();
		loginDto.setToken(reqData.getString(Constant._TOKEN));
		
		loginDto.setPlat(platFrom);
		// 非第三方登录+++++++++++++++++
		loginDto.setAcc(reqData.getString("acc"));
		loginDto.setNick(reqData.getString("nick"));
		loginDto.setPresenterId(reqData.getIntValue("presenterId"));
		loginDto.setPhone(reqData.getString("phone"));
		// +++++++++++++++++
		//token获取缓存玩家信息登录++++++++++
		Map<String,String> tokenInfo=RedisData.authToken(jedisClient,platFrom, loginDto.getToken());
		if(tokenInfo.get("uid")!=null) {
			loginDto.setId(Integer.parseInt(tokenInfo.get("uid")));
		}
		// +++++++++++++++++
		//token无效 查询玩家信息
		if(loginDto.getId()==null) {
			initLoginUser(loginDto);
			//缓存玩家信息不存在 数据库查询用户
			if(loginDto.getId()==null) {
				loginDto.setId(regist(loginDto.getAid(), loginDto.getAcc(), platFrom,loginDto.getPlatName(),loginDto.getNick(),loginDto.getPhone(),loginDto.getEmail()));
				if(loginDto.getPresenterId()!=null) {
					try {
						gameUserMapper.bindPresenter(loginDto.getId(), loginDto.getPresenterId(), (new Date().getTime()/1000));
					} catch (Exception e) {
						log.warn("!!!!!!!!!!!!!!!!!!!login_rebindPresenter");
					}
				}
			}
		}
		return login(loginDto.getId(), loginDto.getToken());
	}

	public   void  initLoginUser(loginUserDto loginDto) throws Exception {
 		String  platName=RedisData.AuthPlatNo(jedisClient,loginDto.getPlat());
		loginDto.setPlatName(platName);
		switch (platName) {
		case "_PLAT_LITTLE_GAME":
			String regExp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
			if(loginDto.getAcc()==null||!loginDto.getAcc().matches(regExp)){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"登录验证失败acc非法", null);
			}
			if(!StringUtil.isPhone("+86",loginDto.getPhone())) {
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"登录验证失败手机号码非法", null);
			}
			loginDto.setToken(TokenMaker.getInstance().makeToken());
			loginDto.setEmail("");
			loginDto.setAid(0);
			//快速查看id找到用户
			Integer uid=RedisData.getAccId(jedisClient,loginDto.getPlat(), loginDto.getAcc());
			Map<String, String> map=RedisData.userInfo(jedisClient, uid);
			if(loginDto.getPhone().equals(map.get("phone"))) {
				loginDto.setId(uid);	
			}
			break;
		default:throw new ServiceException(StatusCode.FAILED,"无效第三方", null);
		}
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


	public   Integer  regist(int aid,String acc,int plat,String platName,String nick,String phone,String email) throws Exception {
		List<gameUser> DBUsers=gameUserMapper.checkRegist(acc, plat);
		gameUser DBUser=new gameUser();
		Integer id;
		if(DBUsers.size()!=0){
			//找到用户信息
			DBUser= DBUsers.get(0);
			if(!DBUser.getPhone().equals(phone)){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"登陆失败请输入正确手机号码", null);
			}
			id=DBUser.getId();

		}else{
			//注册用户
			if(StringUtils.isBlank(nick)) {
				throw new ServiceException(StatusCode.REGIST_FAILED,"注册失败请输入昵称", null);
			}
			id= RedisData.genAccId(jedisClient);
			DBUser.setId(id);
			DBUser.setAid(aid);
			DBUser.setPlat(plat);
			DBUser.setSex(1);
			DBUser.setAcc(acc);
			DBUser.setNick(nick);
			DBUser.setCoin(0);
			DBUser.setPhoto("");
			DBUser.setPhone(phone);
			DBUser.setEmail(email);
			DBUser.setRegTime((new Date().getTime()/1000));
			if(gameUserMapper.registGameUser(DBUser)!=1){
				throw new ServiceException(StatusCode.REGIST_FAILED,"注册失败", null);
			}
		}
		RedisData.updateUser(jedisClient,DBUser); 
		RedisData.setAccKey(jedisClient,id, plat, acc);
		return id;
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
	


	
	
}
