package com.cointer.redis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections.bag.SynchronizedBag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.connection.ReactiveHashCommands.HGetCommand;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cointer.pojo.po.gameUser;
import com.mysql.cj.xdevapi.JsonArray;

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
	public static final  Map<String,String>  getSessionInfo(IJedisClient client,String session){
		Map<String,String> map= client.hgetAll(DB1_5,"token:"+session);
		return map;
	}

	public static final  String setSessionInfo(IJedisClient client,String token,Map<String,String> mapData){
		client.hmset(DB1_5,"token:"+token, mapData);
		client.expire(DB1_5,"token:"+token, 3600*24*7);
		client.expire(DB1_0,User+mapData.get("uid"), 3600*24*8);
		return token;
	}	
	
	public static final String  userField(IJedisClient client,Integer id,String field){
		String fieldValue=client.hget(DB1_0, User+id, field);
		return fieldValue;
	}
	public static final Map<String, String>  userInfo(IJedisClient client,Integer id){
		Map<String, String> map=new  HashMap<String, String>();
		if(id!=null) {
			map=client.hgetAll(DB1_0, User+id);	
		}
		return map;
	}
	public static final void  updateUser(IJedisClient client,gameUser user){
		Map<String, String> mapUpdateUser=new HashMap<String, String>();
		mapUpdateUser.put("id", user.getId()+"");
		mapUpdateUser.put("acc", user.getAcc());
		mapUpdateUser.put("sex", user.getSex()+"");
		mapUpdateUser.put("nick", user.getNick());
		mapUpdateUser.put("photo", user.getPhoto());
		mapUpdateUser.put("coin", user.getCoin()+"");
		mapUpdateUser.put("freezed", user.getFreezed()+"");
		mapUpdateUser.put("isLeader", user.getIsLeader()+"");
		mapUpdateUser.put("isTourist", user.getIsTourist()+"");
		mapUpdateUser.put("agentId", user.getAgentId()+"");
		mapUpdateUser.put("phone", user.getPhone());
		mapUpdateUser.put("plat", user.getPlat()+"");
		client.hmset(DB1_0, User+user.getId(), mapUpdateUser);
		
	}
	public static final void  updateUserField(IJedisClient client,Integer id,String field,String value){
		client.hset(DB1_0, User+id, field,value);
	}
	public static final void  updateUser(IJedisClient client,int id,Map<String, String> map){
		client.hmset(DB1_0, User+id, map);
	}
	public static final void  addChargeRebates(IJedisClient client,Integer id,int coin){
		client.hincrBy(DB1_0, User+id,"chargeRebates",coin);
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
	public static final String  getUri(IJedisClient client,int Plat,String Key){
		String uri=client.hget(DB1_1,INTERFACE_URI+Plat, Key);
		return uri;
	}
	public static final String  getConf(IJedisClient client,int Plat,String Key){
		String str=client.hget(DB1_1,INTERFACE_URI+Plat, Key);
		return str;
	}
	public static final String  chargeRecordUri(IJedisClient client,int Plat){
		String uri=client.hget(DB1_4,INTERFACE_URI+Plat, "chargeRecordUri");
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
	
	public static final String  getBots(IJedisClient client){
		String bot=client.lpop(DB1_1, "InfoBots");
		client.rpush(DB1_1, "InfoBots",bot);
		return bot;
	}
	
//	public static final ArrayList<JSONObject>  rank(IJedisClient client,int uid,int rankSize){
//		int count=rankSize;
//		ArrayList<JSONObject> resultData= new ArrayList<JSONObject>();
//		Set<String > rank=client.zrevrange(DB1_2, "rank", 0, -1);
//		Iterator<String> i=rank.iterator();
//		while (i.hasNext()&& count>0) {
//			int id = Integer.parseInt((String) i.next());
//			JSONObject obj= new JSONObject();
//			int coin=client.zscore(DB1_2, "rank", id+"").intValue();
//			String nick=client.hget(DB1_0, User+id, "nick");
//			obj.put("uid", id);
//			obj.put("coin", coin);
//			obj.put("nick", nick);
//			resultData.add(obj);
//			count--;
//		}
//		
//		JSONObject obj= new JSONObject();
//		Double c=client.zscore(DB1_2, "rank", uid+"");
//		int coin=0;
//		Long myRank=0L;
//		if (c!=null) {
//		 coin=client.zscore(DB1_2, "rank", uid+"").intValue();
//		 myRank=client.zrevrank(DB1_2, "rank", uid+"");
//		}
//		String nick=client.hget(DB1_0, User+uid, "nick");
//		obj.put("uid", uid);
//		obj.put("nick", nick);
//		obj.put("coin", coin);
//		obj.put("myRank", myRank);
//		resultData.add(obj);
//		return  resultData;
//	}
//	public static final void  inRank(IJedisClient client,int uid,int coin){
//		Double myRank=client.zincrby(DB1_2, "rank", Double.valueOf(coin), uid+"");
//	}

	


//	public static final String  userSign(IJedisClient client,int uid){
//		
//		Calendar calendar = Calendar.getInstance();
//    	calendar.set(Calendar.HOUR_OF_DAY, 0);
//    	calendar.set(Calendar.MINUTE, 0);
//    	calendar.set(Calendar.SECOND, 0);
//    	long zeroSec=calendar.getTimeInMillis()/1000;
//		
//		String key= "sign:"+uid+"time:"+zeroSec;
//		if(!client.exists(DB1_0,key)){
//			Map<String, String> map= new HashMap<String,String>();
//			map.put("schedul", "0");
//			client.hmset(DB1_0, key, map);
//			client.expire(DB1_0, key, 24*3600);
//			return "0";
//		}
//		    return client.hget(DB1_0, key, "schedul");
//		
//	}
//	public synchronized static final boolean  UpdateUserSign(IJedisClient client,int uid,int status){
//		Calendar calendar = Calendar.getInstance();
//    	calendar.set(Calendar.HOUR_OF_DAY, 0);
//    	calendar.set(Calendar.MINUTE, 0);
//    	calendar.set(Calendar.SECOND, 0);
//    	long zeroSec=calendar.getTimeInMillis()/1000;
//		String key= "sign:"+uid+"time:"+zeroSec;
//		if(!client.exists(DB1_0,key)){
//			Map<String, String> map= new HashMap<String,String>();
//			map.put("schedul", status+"");
//			client.hmset(DB1_0, key, map);
//			client.expire(DB1_0, key, 24*3600);
//			return true;
//		}
//		if(((status-1)+"").equals(client.hget(DB1_0, key, "schedul"))){
//			client.hset(DB1_0, key, "schedul", status+"");
//			return true;
//		}
//		   return false;
//		
//	}
	
}
