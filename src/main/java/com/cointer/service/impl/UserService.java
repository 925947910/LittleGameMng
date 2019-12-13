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
			}else {
				//第三方用户更新用户信息
				if(!loginDto.getPlatName().equals("_PLAT_LITTLE_GAME")) {
					gameUser gameUser=new gameUser();
					gameUser.setNick(loginDto.getNick());
					gameUser.setEmail(loginDto.getEmail());
					gameUser.setPhone(loginDto.getPhone());
					gameUser.setId(loginDto.getId());
					if(gameUserMapper.updateUserBaseInfo(gameUser)!=1){
						throw new ServiceException(StatusCode.REGIST_FAILED,"登录失败", null);
					}
					Map<String, String> mapUpdateUser=new HashMap<String, String>();
					mapUpdateUser.put("nick", loginDto.getNick());
					mapUpdateUser.put("email", loginDto.getEmail());
					mapUpdateUser.put("phone", loginDto.getPhone());
					RedisData.updateUser(jedisClient, loginDto.getId(),mapUpdateUser); 
				}
			}
		}
		return login(loginDto.getId(), loginDto.getToken());
	}

	public   void  initLoginUser(loginUserDto loginDto) throws Exception {
		String JsonAuth;
		JSONObject AuthData;
		HttpClientUtil client;
		String  platName=RedisData.AuthPlatNo(jedisClient,loginDto.getPlat());
		loginDto.setPlatName(platName);
		JSONObject param=new JSONObject();
		switch (platName) {
		case "_PLAT_OXO_EXCHANGE":
			param.put(Constant._TOKEN, loginDto.getToken());
			param.put("tokenStr", MD5Util.getSaltMD5(loginDto.getToken(),MD5Util.SALT));
			client=HttpClientUtil.getInstance();
			String ParamJson=JSON.toJSONString(param);
			JsonAuth=client.doPostWithJsonResult(RedisData.loginAuthUri(jedisClient,loginDto.getPlat()), ParamJson);
			if(JsonAuth==null) {
				throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
			}
			AuthData=  JSON.parseObject(JsonAuth);
			String resultCode=AuthData.getString("code");
			if(!"0".equals(resultCode)){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED, "第三方验证失败", null);
			}
			loginDto.setPhone(AuthData.getJSONObject("data").getString("mobileNumber"));
			loginDto.setEmail(AuthData.getJSONObject("data").getString("email"));
			loginDto.setAid(AuthData.getJSONObject("data").getIntValue("id"));
			loginDto.setAcc("_PLAT_OXO_EXCHANGE:"+AuthData.getJSONObject("data").getIntValue("id"));
			loginDto.setNick(AuthData.getJSONObject("data").getString("nickname"));
			if(StringUtils.isBlank(loginDto.getNick())) {
				loginDto.setNick(AuthData.getJSONObject("data").getString("mobileNumber"));
			}
			//快速查看id找到用户
			loginDto.setId(RedisData.getAccId(jedisClient,loginDto.getPlat(), loginDto.getAcc()));
			break;
		case "_PLAT_TOKENMAP":
			String myplat=RedisData.platNo(jedisClient,loginDto.getPlat())+"";
			param.put(Constant._TOKEN, loginDto.getToken());
			param.put("tag", myplat);
			String str=MD5Util.getSaltMD5(loginDto.getToken()+myplat,MD5Util.SALT);
			String genSign=RSAUtils.priKeyGenSign(str,RedisData.localPrivateKey(jedisClient));
			param.put("sign",genSign );
			client=HttpClientUtil.getInstance();
			Map<String,String> paramMap =JSONObject.parseObject(param.toJSONString(), new TypeReference<Map<String, String>>(){});
			String uri=RedisData.loginAuthUri(jedisClient,loginDto.getPlat());
			JsonAuth=client.doPostWithJsonResult(uri, paramMap);
			if(JsonAuth==null) {
				throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
			}
			AuthData=  JSON.parseObject(JsonAuth);
			if(AuthData.getIntValue("code")!=200){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"第三方验证失败", null);
			} 
			loginDto.setPhone(AuthData.getJSONObject("data").getString("phone"));
			loginDto.setEmail(AuthData.getJSONObject("data").getString("email"));
			loginDto.setAid(AuthData.getJSONObject("data").getIntValue("userId"));
			loginDto.setAcc("_PLAT_TOKENMAP:"+AuthData.getJSONObject("data").getIntValue("userId"));
			loginDto.setNick(AuthData.getJSONObject("data").getString("userName"));
			if(StringUtils.isBlank(loginDto.getNick())) {
				loginDto.setNick(AuthData.getJSONObject("data").getString("phone"));
			}
			//快速查看id找到用户
			loginDto.setId(RedisData.getAccId(jedisClient,loginDto.getPlat(), loginDto.getAcc()));
			break;
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
			id=DBUser.getId();
			//第三方用户更新用户信息
			if(!platName.equals("_PLAT_LITTLE_GAME")) {
				DBUser.setNick(nick);
				DBUser.setPhone(phone);
				DBUser.setEmail(email);
				if(gameUserMapper.updateUserBaseInfo(DBUser)!=1){
					throw new ServiceException(StatusCode.REGIST_FAILED,"登录失败", null);
				}
			}
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
	
	public   Object  remotePlatUserInfo(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		String  remoteAcc=reqData.getString("remoteAcc");
		Integer plat=reqData.getIntValue("plat");
		String  platName=RedisData.AuthPlatNo(jedisClient,plat);
		HttpClientUtil client;
		String JsonAuth;
		JSONObject AuthData;
		JSONObject param=new JSONObject();
		gameUser  gameUser= new gameUser();
		switch (platName) {
		case "_PLAT_TOKENMAP":
			String myplat=RedisData.platNo(jedisClient,plat)+"";
			param.put("account",remoteAcc);
			param.put("tag", myplat);
			String str=MD5Util.getSaltMD5(remoteAcc+myplat,MD5Util.SALT);
			String genSign=RSAUtils.priKeyGenSign(str,RedisData.localPrivateKey(jedisClient));
			param.put("sign",genSign );
			client=HttpClientUtil.getInstance();
			Map<String,String> paramMap =JSONObject.parseObject(param.toJSONString(), new TypeReference<Map<String, String>>(){});
			String uri=RedisData.remoteUserInfoUri(jedisClient,plat);
			JsonAuth=client.doPostWithJsonResult(uri, paramMap);
			if(JsonAuth==null) {
				throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
			}
			AuthData=  JSON.parseObject(JsonAuth);
			if(AuthData.getIntValue("code")!=200){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"第三方验证失败", null);
			} 
			gameUser.setPhone(AuthData.getJSONObject("data").getString("phone"));
			gameUser.setEmail(AuthData.getJSONObject("data").getString("email"));
			gameUser.setAid(AuthData.getJSONObject("data").getIntValue("userId"));
			gameUser.setAcc(remoteAcc);
			gameUser.setNick(AuthData.getJSONObject("data").getString("userName"));
			break;
		default:throw new ServiceException(StatusCode.FAILED,"无效第三方", null);
		}
		return gameUser;
	}
	public   Object  bindRemoteUser(String  RequestJsonData) throws Exception {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		Integer Uid=reqData.getIntValue("uid");
		String  remoteAcc=reqData.getString("remoteAcc");
		Integer plat=reqData.getIntValue("plat");
		String  platName=RedisData.AuthPlatNo(jedisClient,plat);
		HttpClientUtil client;
		String JsonAuth;
		JSONObject AuthData;
		JSONObject param=new JSONObject();
		gameUser  gameUser= new gameUser();
		switch (platName) {
		case "_PLAT_TOKENMAP":
			String myplat=RedisData.platNo(jedisClient,plat)+"";
			param.put("account",remoteAcc);
			param.put("tag", myplat);
			String str=MD5Util.getSaltMD5(remoteAcc+myplat,MD5Util.SALT);
			String genSign=RSAUtils.priKeyGenSign(str,RedisData.localPrivateKey(jedisClient));
			param.put("sign",genSign );
			client=HttpClientUtil.getInstance();
			Map<String,String> paramMap =JSONObject.parseObject(param.toJSONString(), new TypeReference<Map<String,String>>(){});
			String uri=RedisData.remoteUserInfoUri(jedisClient,plat);
			JsonAuth=client.doPostWithJsonResult(uri, paramMap);
			if(JsonAuth==null) {
				throw new ServiceException(StatusCode.FAILED,"第三方返回数据错误", null);
			}
			AuthData=  JSON.parseObject(JsonAuth);
			if(AuthData.getIntValue("code")!=200){
				throw new ServiceException(StatusCode.LOGIN_AUTH_FAILED,"第三方验证失败", null);
			} 
			gameUser.setId(Uid);
			gameUser.setPlat(plat);
			gameUser.setAid(AuthData.getJSONObject("data").getIntValue("userId"));
			if(gameUserMapper.bindRemoteUser(gameUser)!=1) {
				throw new ServiceException(StatusCode.FAILED,"绑定第三方用户失败", null);
			}
			Map<String,String> userMap = new HashMap<String, String>();
			userMap.put("plat", plat+"");
			userMap.put("aid", AuthData.getJSONObject("data").getIntValue("userId")+"");
			RedisData.updateUser(jedisClient, Uid, userMap);
			break;
		default:throw new ServiceException(StatusCode.FAILED,"无效第三方", null);
		}
		return null;
	}
	
		
	
	
	
}
