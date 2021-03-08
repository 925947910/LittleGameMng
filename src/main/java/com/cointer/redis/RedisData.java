package com.cointer.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

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
	public static final  Map<String,String>  authSession(IJedisClient client,String session){
		Map<String,String> map= client.hgetAll(DB1_5,session);
		return map;
	}
	public static final  Map<String,String>  authToken(IJedisClient client,int plat, String token){
		Map<String,String> map=new HashMap<String, String>();
		if(!StringUtils.isBlank(token)) {
			String key="token:"+plat+"_"+token;
			map= client.hgetAll(DB1_5,key);
		}
		return map;
	}
	public static final  String genTokenInfo(IJedisClient client,int plat, String token,Map<String,String> mapData){
		String key="token:"+plat+"_"+token;
		client.hmset(DB1_5,key, mapData);
		client.expire(DB1_5,key, 3600*24*7);
		client.expire(DB1_0,User+mapData.get("uid"), 3600*24*8);
		return key;
	}
	
	
	
	
	public static final String  myBenzBmwPrice(IJedisClient client,Integer uid){
		String BenzBmwPrice=client.hget(DB1_0, User+uid,"BenzBmwPrice");
		client.hdel(DB1_0, User+uid,"BenzBmwPrice");
		return BenzBmwPrice;
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

	public static final void  setRbBallBeter(IJedisClient client,Long issue,String bet,int uid){
		client.sadd(DB1_2,"rbBall:"+issue+"bet:"+bet, uid+"");
		client.expire(DB1_2, "rbBall:"+issue+"bet:"+bet, 200);
	}
	public static final Set<String>  getRbBallBeter(IJedisClient client,Long issue,String bet){
		return client.smembers(DB1_2, "rbBall:"+issue+"bet:"+bet);
	}
	public static final void   currRbBallBet(IJedisClient client,String bet,Long value){
		client.hincrBy(DB1_2, "currRbBall", "bet"+bet, value);
	}
	public static final void  setCurrRbBall(IJedisClient client,Map<String,String> issue){
		client.hmset(DB1_2, "currRbBall",issue);
		client.expire(DB1_2, "currRbBall", 200);
	}
	public static final Map<String,String>  getCurrRbBall(IJedisClient client){
		Map<String,String> mapData=client.hgetAll(DB1_2, "currRbBall");
		return mapData;
	}
	public static final JSONArray  rbBallRec(IJedisClient client){
		JSONArray  resultData=new JSONArray();
		List<String> records=client.lrange(DB1_2, "rbBallRec", 0, 9);
		Iterator<String> i=records.iterator();
		while (i.hasNext()) {
			String jsonStr=i.next();
			JSONObject obj= JSONObject.parseObject(jsonStr);
			resultData.add(obj);
		}
		return resultData;
	}
	public static final void  addRbBallRec(IJedisClient client,String rec){
		client.lpush(DB1_2, "rbBallRec", rec);
		client.ltrim(DB1_2, "rbBallRec", 0, 9);
	}
	
	public static final JSONArray rbBallNotice(IJedisClient client){
		List<String> records=client.lrange(DB1_2, "rbBallNotice", 0, 19);
		JSONArray datas=JSONArray.parseArray(JSON.toJSONString(records));
		return datas;
	}
	public static final void  addRbBallNotice(IJedisClient client,String rec){
		client.lpush(DB1_2, "rbBallNotice", rec);
		client.ltrim(DB1_2, "rbBallNotice", 0, 19);
	}
	
	
	
	
	public static final Map<String, String>  initBenzBmw(IJedisClient client,String issue,String start,String end,String bankerStatus){
		Map<String, String> mapUpdate=client.hgetAll(DB1_3, "BenzBmw");
		
		if(mapUpdate.isEmpty()){
			mapUpdate = new HashMap<String, String>();
			mapUpdate.put("pricePool", "1000000");
		}
		mapUpdate.put("issue", issue);
		mapUpdate.put("betStart", start);
		mapUpdate.put("betEnd", end);
		mapUpdate.put("bankerStatus", bankerStatus);
		mapUpdate.put("Ferrari", 0+"");
		mapUpdate.put("Lambo", 0+"");
		mapUpdate.put("BMW", 0+"");
		mapUpdate.put("Benz", 0+"");
		mapUpdate.put("Audi", 0+"");
		mapUpdate.put("Honda", 0+"");
		mapUpdate.put("Toyota", 0+"");
		mapUpdate.put("Volkswagen", 0+"");
		
		mapUpdate.put("real_Ferrari", 0+"");
		mapUpdate.put("real_Lambo", 0+"");
		mapUpdate.put("real_BMW", 0+"");
		mapUpdate.put("real_Benz", 0+"");
		mapUpdate.put("real_Audi", 0+"");
		mapUpdate.put("real_Honda", 0+"");
		mapUpdate.put("real_Toyota", 0+"");
		mapUpdate.put("real_Volkswagen", 0+"");
		
		client.hmset(DB1_3, "BenzBmw", mapUpdate);
		client.hdel(DB1_3, "BenzBmw", "result");
		client.hdel(DB1_3, "BenzBmw", "price");
		client.hdel(DB1_3, "BenzBmw", "totalBet");
		return mapUpdate;
	}

	public static final Map<String, String>  getBenzBmw(IJedisClient client){
		Map<String, String> mapUpdate=client.hgetAll(DB1_3, "BenzBmw");
		return mapUpdate;
	}
	public static final String  getBenzBmwField(IJedisClient client,String field){
		 String result=client.hget(DB1_3, "BenzBmw",field);
		return result;
	}                                      
	public static final void  drawBenzBmw(IJedisClient client,int totalBet,int totalBetWithBot,int price,int priceWithBot,String result){
		client.hincrBy(DB1_3, "BenzBmw", "pricePool", totalBetWithBot-priceWithBot);
		Map<String,String> map= new HashMap<String,String>();  
		map.put("totalBet", totalBetWithBot+"");
		map.put("price", priceWithBot+"");  
		map.put("result", result);
		client.hmset(DB1_3, "BenzBmw", map);
	}
	
	public static final void  cleanBenzBmwBets(IJedisClient client,List<String> bets){
		for (int i = 0; i < bets.size(); i++) {
			client.del(DB1_3, "BenzBmwBet:"+bets.get(i),"BenzBmwBetList:"+bets.get(i));
			
		}
	}
	public static final void  BenzBmwBet(IJedisClient client,int uid,String bet,int num ,boolean isBot){
		client.hincrBy(DB1_3,"BenzBmw",bet,num);
		if(!isBot){
			client.hincrBy(DB1_3,"BenzBmw","real_"+bet,num);
		}
		client.hincrBy(DB1_3,"BenzBmwBet:"+bet, uid+"",num);
		client.rpush(DB1_3, "BenzBmwBetList:"+bet, num+"");
		
	}
	
	public static final boolean  BenzBmwBeBanker(IJedisClient client,int uid,String name,int coin ){
		if (client.exists(DB1_3, "BenzBmwBanker")){
			return false;
		}
		Map <String,String> map= new HashMap<String,String>();
		map.put("uid", uid+"");
		map.put("name",name);
		map.put("pool",coin+"");
		map.put("bankerStatus","1");
		client.hmset(DB1_3, "BenzBmwBanker", map);
		return true;
	}
	
	public static final Map <String,String>  BenzBmwGetBanker(IJedisClient client,int uid){
		Map<String,String> map=client.hgetAll(DB1_3, "BenzBmwBanker");
		if (uid!=0&&(map==null||!(uid+"").equals(map.get("uid")))){
			return null;
		}
		return map;
	}
	public static final void  SetBenzBmwBankerField(IJedisClient client,String field,String value){
		client.hset(DB1_3, "BenzBmwBanker", field, value);
	}
	public static final void  BenzBmwFallBanker(IJedisClient client){
	    client.del(DB1_3, "BenzBmwBanker");
	}
	
	public static final Map<String,String>  getBenzBmwBetNums(IJedisClient client,String bet){
		Map<String,String> beters=client.hgetAll(DB1_3,"BenzBmwBet:"+bet);
		return beters;
		
	}
	public static final JSONArray  getBenzBmwBetList(IJedisClient client,String bet,int begin){
		List<String> BenzBmwBetList =client.lrange(DB1_3, "BenzBmwBetList:"+bet, begin, -1);
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(BenzBmwBetList));
		return array;
	}
	
	public static final JSONArray  getBenzBmwRec(IJedisClient client){
		
		List<String> records=client.lrange(DB1_3, "BenzBmwRec", 0, 9);
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(records));
		return array;
	}
	public static final void  addBenzBmwRec(IJedisClient client,String rec){
		client.lpush(DB1_3, "BenzBmwRec", rec);
		client.ltrim(DB1_3, "BenzBmwRec", 0, 9);
	}
	public static final Map<String, String>  getCrowdFundItem(IJedisClient client){
		Map<String, String> mapUpdate=client.hgetAll(DB1_1, "crowdFundItem");
		return mapUpdate;
	}
	public static final void  setCurrCrowdFund(IJedisClient client,Map<String,String> issue){
		client.hmset(DB1_2, "currCrowdFund",issue);
		client.expire(DB1_2, "currCrowdFund", 2000);
	}
	public static final Map<String,String>  getCurrCrowdFund(IJedisClient client){
		Map<String,String> mapData=client.hgetAll(DB1_2, "currCrowdFund");
		return mapData;
	}
	
	public static final void   updateCurrCrowdFundField(IJedisClient client,String field,String value){
		client.hset(DB1_2, "currCrowdFund", field, value);
	}
	public static final String  getBots(IJedisClient client){
		String bot=client.lpop(DB1_1, "InfoBots");
		client.rpush(DB1_1, "InfoBots",bot);
		return bot;
	}

	public static final JSONArray  crowdFundIssueList(IJedisClient client){
		JSONArray  resultData=new JSONArray();
		List<String> records=client.lrange(DB1_2, "crowdFundRecs", 0, 6);
		Iterator<String> i=records.iterator();
		while (i.hasNext()) {
			String jsonStr=i.next();
			resultData.add(jsonStr);
		}
		return resultData;
	}
	public static final void  addCrowdFundIssueList(IJedisClient client,String Issue){
		client.lpush(DB1_2, "crowdFundRecs", Issue);
		client.ltrim(DB1_2, "crowdFundRecs", 0, 5);
	}
	
	public static final JSONArray crowdFundRec(IJedisClient client,String issue){
		JSONArray  resultData=new JSONArray();
		List<String> records=client.lrange(DB1_2, "crowdFundRec:"+issue, 0, 16);
		Iterator<String> i=records.iterator();
		while (i.hasNext()) {
			String jsonStr=i.next();
			JSONObject obj= JSONObject.parseObject(jsonStr);
			resultData.add(obj);
		}
		return resultData;
	}
	public static final void  addCrowdFundRec(IJedisClient client,String issue,String rec){
		client.lpush(DB1_2, "crowdFundRec:"+issue, rec);
		client.ltrim(DB1_2, "crowdFundRec:"+issue, 0, 15);
		client.expire(DB1_2, "crowdFundRec:"+issue, 3600);
	}
	
	
	
	
}
