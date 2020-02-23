package com.cointer.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cointer.pojo.po.gameUser;

public  class RedisData {



	public static final int     DB1_0=10;
	public static final int     DB1_1=11;
	public static final int     DB1_2=12;
	public static final int     DB1_3=13;
	public static final int     DB1_4=14;
	public static final int     DB1_5=15;
	public static final String  User  = "user:";
	public static final String  GameUserId  = "gameUserId";
	public static final String  OrderId  = "orderId";
	public static final String  FreezeId  = "freezeId";
	public static final String  UserKeys   = "userKeys";
	public static final String  Svr="Svr:";
	public static final String  INTERFACE_URI="interfaceUri:";
	public static final String  ALLOW_DOMAIN="AllowDomain";
	public static final String  SYSTEM_CONFIG="systemConfig";



	public static final  Map<String,String>  sysConfig(IJedisClient client){
		Map<String,String> map= client.hgetAll(DB1_4,SYSTEM_CONFIG);
		return map;
	}
	public static final  String  localPrivateKey(IJedisClient client){
		String Key= client.hget(DB1_4,SYSTEM_CONFIG,"privateKey");
		return Key;
	}
	public static final  String  localPublicKey(IJedisClient client){
		String Key= client.hget(DB1_4,SYSTEM_CONFIG,"publicKey");
		return Key;
	}
	public static final  String  remotePublicKey(IJedisClient client,int plat){
		String key=client.hget(DB1_4,INTERFACE_URI+plat,"publicKey");
		return key;
	}
	public static final  Map<String,String>  authSession(IJedisClient client,String session){
		Map<String,String> map= client.hgetAll(DB1_5,session);
		return map;
	}
	public static final  Map<String,String>  authToken(IJedisClient client,int plat, String token){
		Map<String,String> map=new HashMap<String, String>();
		if(!StringUtils.isBlank(token)) {
			String key="token:"+plat+"_"+token;
			map= client.hgetAll(DB1_5,key);
			if(map==null) {
				map=new  HashMap<String, String>();
			}
		}
		return map;
	}
	public static final  String genTokenInfo(IJedisClient client,int plat, String token,Map<String,String> mapData){
		String key="token:"+plat+"_"+token;
		client.hmset(DB1_5,key, mapData);
		client.expire(DB1_5,key, 3600*24*7);
		return key;
	}
	public static final Map<String, String>  userInfo(IJedisClient client,Integer id){
		Map<String, String> map=new  HashMap<String, String>();
		if(id!=null) {
			map=client.hgetAll(DB1_0, User+id);	
			if(map==null) {
				map=new  HashMap<String, String>();
			}
		}
		return map;
	}
	public static final void  updateUser(IJedisClient client,gameUser user){
		Map<String, String> mapUpdateUser=new HashMap<String, String>();
		mapUpdateUser.put("id", user.getId()+"");
		mapUpdateUser.put("sex", user.getSex()+"");
		mapUpdateUser.put("nick", user.getNick());
		mapUpdateUser.put("photo", user.getPhoto());
		mapUpdateUser.put("coin", user.getCoin()+"");
		mapUpdateUser.put("email", user.getEmail());
		mapUpdateUser.put("phone", user.getPhone());
		mapUpdateUser.put("aid", user.getAid()+"");
		mapUpdateUser.put("plat", user.getPlat()+"");
		client.hmset(DB1_0, User+user.getId(), mapUpdateUser);
	}
	public static final void  updateUser(IJedisClient client,int id,Map<String, String> map){
		client.hmset(DB1_0, User+id, map);
	}

	public static final int  genAccId(IJedisClient client){
		int id=client.incr(DB1_4, GameUserId).intValue();
		return id;
	}

	public static final int  genOrderId(IJedisClient client){
		int id=client.incr(DB1_4,OrderId).intValue();
		return id;
	}

	public static final List<Map<String,String>>  AllPlats(IJedisClient client){
		Set<String> keys=client.keys(DB1_4, INTERFACE_URI+"*");
		keys.remove(INTERFACE_URI+0);
		List<Map<String,String>> plats= new ArrayList<Map<String,String>>();
		Iterator<String> i=keys.iterator();
		List<String> res;
		while (i.hasNext()) {
			String Key = (String) i.next();
		    res=client.hmget(DB1_4, Key,"platNo","platName");
			Map<String,String> map= new HashMap<String,String>();
			String [] strs=StringUtils.split(Key, ':');
			map.put("platNo", strs[1]);
			map.put("platName",res.get(1));
			plats.add(map);
		}
		return plats;
	}
	
	public static final String  AuthPlatNo(IJedisClient client,int Plat){
		String result=client.hget(DB1_4,INTERFACE_URI+Plat, "platName");
		return result;
	}
	public static final int  platNo(IJedisClient client,int Plat){
		String result=client.hget(DB1_4,INTERFACE_URI+Plat, "platNo");
		return Integer.parseInt(result);
	}
	public static final String  loginAuthUri(IJedisClient client,int Plat){
		String uri=client.hget(DB1_4,INTERFACE_URI+Plat, "loginAuthUri");
		return uri;
	}
	public static final String  remoteUserInfoUri(IJedisClient client,int Plat){
		String uri=client.hget(DB1_4,INTERFACE_URI+Plat, "remoteUserInfoUri");
		return uri;
	}
	public static final String  extractOrderUri(IJedisClient client,int Plat){
		String uri=client.hget(DB1_4,INTERFACE_URI+Plat, "extractOrderUri");
		return uri;
	}

	public static final String  extractCallbackUri(IJedisClient client,int Plat){
		String uri=client.hget(DB1_4,INTERFACE_URI+Plat, "extractCallbackUri");
		return uri;
	}
	public static final String  remoteOrderInfoUri(IJedisClient client,int Plat){
		String uri=client.hget(DB1_4,INTERFACE_URI+Plat, "remoteOrderInfoUri");
		return uri;
	}

	public static final int  genFreezeId(IJedisClient client){
		int id=client.incr(DB1_4,FreezeId).intValue();
		return id;
	}
	public static final  boolean   inGame(IJedisClient client,int uid){
		String key="inGame:"+uid;
		boolean ingame= client.exists(DB1_5,key);
		return ingame;
	}

	public static final Integer  getAccId(IJedisClient client,int plat, String acc){
		Integer id=null;
		String userKey="plat_"+plat+":acc_"+acc;
		Double score= client.zscore(DB1_4,RedisData.UserKeys, userKey); 
		if(score!=null) {
			id=score.intValue();
		}
		return id;
	}
	public static final void  setAccKey(IJedisClient client,int id,int plat, String acc){
		String userKey="plat_"+plat+":acc_"+acc;
		client.zadd(DB1_4,RedisData.UserKeys, id, userKey);
	}

	public static final String []    getAllowDomain(IJedisClient client){
		List<String> paths=client.lrange(DB1_4,ALLOW_DOMAIN, 0, -1);
		String[] allowDomain = new String[paths.size()];
		paths.toArray(allowDomain);
		return allowDomain;
	}

	public  static  final Map<String,String> SvrInfo(IJedisClient client,String SvrKey){
		List<String> SvrDatas=client.hmget(DB1_4,SvrKey, "ip","port","conns","max");
		Map<String,String> map=new HashMap<String, String>();
		map.put("ip", SvrDatas.get(0));
		map.put("port", SvrDatas.get(1));
		map.put("conns", SvrDatas.get(2));
		map.put("max", SvrDatas.get(3));
		return map;
	}
	public  static  final void addEvent(IJedisClient client,int id,String... jsonEvents){
		String Distributor="Distributor:"+id%10;
		String Queue="Event:"+id;
		client.rpush(DB1_1, Queue, jsonEvents);
		client.rpush(DB1_1, Distributor, id+"");
	}
	public static final ArrayList<JSONObject>  rank(IJedisClient client,int uid,int rankSize){
		int count=rankSize;
		ArrayList<JSONObject> resultData= new ArrayList<JSONObject>();
		Set<String > rank=client.zrevrange(DB1_2, "rank", 0, -1);
		Iterator<String> i=rank.iterator();
		while (i.hasNext()&& count>0) {
			int id = Integer.parseInt((String) i.next());
			JSONObject obj= new JSONObject();
			int coin=client.zscore(DB1_2, "rank", id+"").intValue();
			String nick=client.hget(DB1_0, User+id, "nick");
			obj.put("uid", id);
			obj.put("coin", coin);
			obj.put("nick", nick);
			resultData.add(obj);
			count--;
		}
		
		JSONObject obj= new JSONObject();
		Double c=client.zscore(DB1_2, "rank", uid+"");
		int coin=0;
		Long myRank=0L;
		if (c!=null) {
		 coin=client.zscore(DB1_2, "rank", uid+"").intValue();
		 myRank=client.zrevrank(DB1_2, "rank", uid+"");
		}
		String nick=client.hget(DB1_0, User+uid, "nick");
		obj.put("uid", uid);
		obj.put("nick", nick);
		obj.put("coin", coin);
		obj.put("myRank", myRank);
		resultData.add(obj);
		return  resultData;
	}
	public static final void  inRank(IJedisClient client,int uid,int coin){
		Double myRank=client.zincrby(DB1_2, "rank", Double.valueOf(coin), uid+"");
	}



}
