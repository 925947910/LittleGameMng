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
		int platFrom=0;
		loginUserDto loginDto=new loginUserDto();
		loginDto.setToken(reqData.getString(Constant._TOKEN));
		loginDto.setPlat(platFrom);
		loginDto.setPresenterId(reqData.getIntValue("presenterId"));
		// +++++++++++++++++
		//token获取缓存玩家信息登录++++++++++
		Map<String,String> tokenInfo=RedisData.authToken(jedisClient,platFrom, loginDto.getToken());
		if(tokenInfo.get("uid")!=null) {
			loginDto.setId(Integer.parseInt(tokenInfo.get("uid")));
		}
		// +++++++++++++++++
		//token无效 查询玩家信息
		if(loginDto.getId()==null) {
			loginDto.setAcc(reqData.getString("phone"));
			loginDto.setPwd(reqData.getString("pwd"));
			loginDto.setNick(reqData.getString("nick"));
			loginDto.setPhone(reqData.getString("phone"));
			loginDto.setSex(reqData.getIntValue("sex"));
			loginDto.setAddress(reqData.getString("address"));
			Integer newId=regist(loginDto);
			try {
				gameUserMapper.bindPresenter(loginDto.getId(), loginDto.getPresenterId(), (new Date().getTime()/1000));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			loginDto.setId(newId);
			loginDto.setToken(TokenMaker.getInstance().makeToken());
		}
		return login(loginDto.getId(), loginDto.getToken());
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


	public   Integer  regist(loginUserDto loginDto) throws Exception {
//		String regExp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
		if(StringUtils.isBlank(loginDto.getAcc())){
			throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"登录验证失败acc非法", null);
		}
		List<gameUser> DBUsers=gameUserMapper.checkAcc(loginDto.getAcc(), loginDto.getPlat());
		gameUser DBUser=new gameUser();
		Integer id;
		if(DBUsers.size()!=0){
			//找到用户信息
			DBUser= DBUsers.get(0);
			if(!DBUser.getPwd().equals(loginDto.getPwd())){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"登陆失败请输入正确密码", null);
			}
			id=DBUser.getId();

		}else{
			//注册用户
			if(!StringUtil.isPhone("+86",loginDto.getPhone())) {
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"登录验证失败手机号码非法", null);
			}
			if(StringUtils.isBlank(loginDto.getNick())) {
				throw new ServiceException(StatusCode.REGIST_FAILED,"注册失败请输入昵称", null);
			}
			if(loginDto.getPresenterId()==null||loginDto.getPresenterId()==0){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"登录验证失败请填选邀请者Id", null);
			}
			id= RedisData.genAccId(jedisClient);
			DBUser.setId(id);
			DBUser.setAid(0);
			DBUser.setPlat(loginDto.getPlat());
			DBUser.setSex(loginDto.getSex());
			DBUser.setAcc(loginDto.getAcc());
			DBUser.setPwd(loginDto.getPwd());
			DBUser.setNick(loginDto.getNick());
			DBUser.setCoin(0);
			DBUser.setPhoto("");
			DBUser.setPhone(loginDto.getPhone());
			DBUser.setEmail("");
			DBUser.setAddress(loginDto.getAddress());
			DBUser.setRegTime((new Date().getTime()/1000));
			if(gameUserMapper.registGameUser(DBUser)!=1){
				throw new ServiceException(StatusCode.REGIST_FAILED,"注册失败", null);
			}
		}
		RedisData.updateUser(jedisClient,DBUser); 
		RedisData.setAccKey(jedisClient,id, loginDto.getPlat(), loginDto.getAcc());
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
	
	public   Object  userInfo(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int uid=reqData.getIntValue("uid");
		
		Map<String,String> MapResult=RedisData.userInfo(jedisClient, uid);

		return MapResult;
	}
	public   Object  rank(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		int uid=reqData.getIntValue("uid");
		
		ArrayList<JSONObject> rankData=RedisData.rank(jedisClient, uid, 10);
        JSONObject resData= new JSONObject();
        resData.put("rank", rankData);
        resData.put("myRank", rankData.get(rankData.size()-1));
        rankData.remove(rankData.size()-1);
		return resData;
	}
	
	
	
}
