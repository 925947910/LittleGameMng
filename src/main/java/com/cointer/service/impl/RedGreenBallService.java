package com.cointer.service.impl;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.eventer.EventProcesser;
import com.cointer.exception.ServiceException;
import com.cointer.mapper.billsMapper;
import com.cointer.mapper.rbBallMapper;
import com.cointer.pojo.po.rbBall;
import com.cointer.pojo.po.rbBallBet;
import com.cointer.pojo.vo.billsInfo;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.IRedGreenBallService;
import com.cointer.trans.TransDeal;











@Service
public class RedGreenBallService implements IRedGreenBallService {
	private static final Logger log = LoggerFactory.getLogger(RedGreenBallService.class);
	public static final String RbBallNotice="rbBallNotice";
	public static final String RbBallRec="rbBallRec";
	public static final String CurrRbBall="currRbBall";
	public static final String Issue="issue";
	public static final String BetStart="betStart";
	public static final String BetEnd="betEnd";
	public static final String Red="red";
	public static final String Purple="purple";
	public static final String Green="green";
	public static final String Bet="bet";
	public static final String LotteryResult="lotteryResult";
	public static final String LotteryPool="lotteryPool";
	public static final String LotteryPrice="lotteryPrice";
	public static final String TotalWin="totalWin";
	public static final String IsDraw="isDraw";
	
	@Autowired
	private   billsMapper billsMapper;
	@Autowired
	private   rbBallMapper rbBallMapper;
	// 注入Jedis接口用来操作缓存
	@Autowired
	private   IJedisClient jedisClient;
	
	@Autowired
	private   TransDeal TransDeal;
	
	
	
	
	@Override
	public  Object   winRec(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData= new JSONObject();
		int uid =reqData.getIntValue("uid");
		List<billsInfo> winningRec=billsMapper.billsByType(uid, EventProcesser.EVENT_REDGREENBALL_DRAW);
		resData.put("winningRec",  winningRec);
		return resData;
	
	}
	
	@Override
	public  Object   notice(String  RequestJsonData) throws Exception  {
		JSONObject resData=new JSONObject();
		JSONArray notice=rbBallNotice(jedisClient);
		resData.put("rbBallNotice", notice);
		return resData;
	
	}
	
	@Override
	public  Object   historyIssue(String  RequestJsonData) throws Exception  {
		JSONObject resData= new JSONObject();
		JSONArray redGreenRec=rbBallRec(jedisClient);
		resData.put("historyIssue", redGreenRec);
		return resData;
	
	}
	@Override
	public  Object   currIssue(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData= new JSONObject();
		int uid =reqData.getIntValue("uid");
		Map<String,String> issueMap=getCurrRbBall(jedisClient);
		List<String> rbBallPrice=jedisClient.lrange(RedisData.DB1_2,"rbBallPrice:"+uid, 0, -1);
		jedisClient.del(RedisData.DB1_2,"rbBallPrice:"+uid);
		resData.put("betEnd",  Integer.parseInt(issueMap.get(BetEnd)));
		resData.put("issue",  Long.parseLong(issueMap.get(Issue)));
		resData.put("coin", Integer.parseInt(RedisData.userField(jedisClient, uid, "coin")));	
		resData.put("rbBallPrice",rbBallPrice);	
		return resData;
	
	}
	
	
	@Override
	public  Object   betRec(String  RequestJsonData) throws Exception  {
		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData= new JSONObject();
		int uid =reqData.getIntValue("uid");
		List<rbBallBet> Rec=rbBallMapper.myBets(uid);
		resData.put("myBets",  Rec);
		return resData;
	
	}
	

	
	
	@Override
	public  Object   bet(String  RequestJsonData) throws Exception  {

		JSONObject reqData=JSON.parseObject(RequestJsonData);
		JSONObject resData=new JSONObject();
		int uid =reqData.getIntValue("uid");
		int coin =reqData.getIntValue("coin");
		String bet =reqData.getString("bet");

		Map<String,String> issueMap=getCurrRbBall(jedisClient);
		Calendar calendar = Calendar.getInstance();

		int nowSec=(int)(calendar.getTimeInMillis()/1000);
		Integer betStart=Integer.parseInt(issueMap.get(BetStart));
		Integer betEnd=Integer.parseInt(issueMap.get(BetEnd));
		if(!(nowSec>betStart && nowSec<betEnd)){
			throw new ServiceException(StatusCode.LAID_FAILED,"Please_don't_bet", null);
		}
		rbBallBet  rbBallBet=new rbBallBet();
		rbBallBet.setUid(uid);
		rbBallBet.setCoin(coin);
		rbBallBet.setBet(bet);
		rbBallBet.setIssue(Long.parseLong(issueMap.get(Issue)));
		rbBallBet.setTime((long)nowSec);
		TransDeal.laidRbBall(rbBallBet);
	    currRbBallBet(jedisClient, bet, (long)coin);
		setRbBallBeter(jedisClient, Long.parseLong(issueMap.get(Issue)), bet, uid);
		resData.put("coin", Integer.parseInt(RedisData.userField(jedisClient, uid, "coin")));	
		return resData;
	}
	
    public Integer getPrice(int uid, Long issue, String Bet){
    	Integer c1=rbBallMapper.coinByBet(uid, issue, Bet);
    	int cost = c1==null?0:c1*9;
    	switch (Bet) {
    	case "0":
    		Integer c2=rbBallMapper.coinByBet(uid, issue, Red);
    		Integer c3=rbBallMapper.coinByBet(uid, issue, Purple);
    		cost+=  c2==null?0:(int)((double)c2*1.5);
    		cost+=  c3==null?0:(int)((double)c3*4.5);
    		break;
    	case "5":
    		Integer c4=rbBallMapper.coinByBet(uid, issue, Green);
    		Integer c5=rbBallMapper.coinByBet(uid, issue, Purple);
    		cost+=  c4==null?0:(int)((double)c4*1.5);
    		cost+=  c5==null?0:(int)((double)c5*4.5);
    		break;
    	default:
    		int num=Integer.parseInt(Bet);
    		if((num % 2)==0){
    			Integer c6=rbBallMapper.coinByBet(uid, issue, Red);
    			cost+=  c6==null?0:c6*2;
    		}else{
    			Integer c7=rbBallMapper.coinByBet(uid, issue, Green);
    			cost+=  c7==null?0:c7*2;
    		}
    		break;
    	}
    	return  cost;

    }
	
    
    
    
    
//  生成彩票
    public void GenRedGreenBall() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	try {
    		Map<String,String> issueMap=getIssue();
    		issueMap.put(IsDraw,"0");
            setCurrRbBall(jedisClient, issueMap);
            rbBall rbBall=new rbBall();
            rbBall.setIssue( Long.parseLong(issueMap.get(Issue)));
            rbBall.setTime(Long.parseLong(issueMap.get(BetStart)));
            rbBall.setLotteryPool(0);
            rbBall.setLotteryPrice(0);
            rbBall.setTotalWin(0);
            rbBall.setIsDraw(0);
           if(rbBallMapper.currRbBall(Long.parseLong(issueMap.get(Issue))).isEmpty()){
        	  rbBallMapper.initRbBall(rbBall); 
           } 
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    //  封盘算结果
    public void RedGreenBallResult() {
    	try {
    		Map<String,String> issueMap=lotteryResult();
    		Long issue=Long.parseLong(issueMap.get(Issue));
			String lotteryResult=issueMap.get(LotteryResult);
			int lotteryPool= Integer.parseInt(issueMap.get(LotteryPool));
			int totalWin=Integer.parseInt(issueMap.get(TotalWin));
			rbBall rbBall=new rbBall();
			
			  Random rand = new Random();
			  int basePrice=rand.nextInt(30)*10;
			  basePrice=26100+basePrice+Integer.parseInt(lotteryResult);
			
			rbBall.setIssue(issue);
			rbBall.setLotteryResult(lotteryResult);
			rbBall.setLotteryPrice(basePrice);
			rbBall.setLotteryPool(lotteryPool);
			rbBall.setTotalWin(totalWin);
			rbBall.setIsDraw(1);
			issueMap.clear();
			issueMap.put(IsDraw,"1");
			issueMap.put(LotteryResult, lotteryResult);
			rbBallMapper.updateRbBall(rbBall);
			setCurrRbBall(jedisClient, issueMap);
			String rec=JSONObject.toJSONString(rbBall);
			addRbBallRec(jedisClient, rec);
			
			String botStr=RedisData.getBots(jedisClient);
	        JSONObject botObj=JSONObject.parseObject(botStr);
	        String botName=botObj.getString("name");
		     int num=100000*rand.nextInt(10)+10000*rand.nextInt(10);
	        
		     addRbBallNotice(jedisClient, "Congratulations to player "+botName+" for winning "+num+" rupees in the "+issue+"nd issue of the red and green ball game!");
			
			
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }    
//  封盘开奖
    public void DrawRedGreenBall() {
    	try {
    		Map<String,String> issueMap=getCurrRbBall(jedisClient);
    		String result=issueMap.get(LotteryResult);
    		Long issue=Long.parseLong(issueMap.get(Issue));
    		Set<String> uids =getRbBallBeter(jedisClient, issue, issueMap.get(LotteryResult));
    		switch (result) {
			case "0":
				 uids.addAll(getRbBallBeter(jedisClient, issue, Purple));
            case "5":
            	 uids.addAll(getRbBallBeter(jedisClient, issue, Purple));
			default:
				int num=Integer.parseInt(result);
				if((num % 2)==0){
					uids.addAll(getRbBallBeter(jedisClient, issue, Red));
				}else{
					uids.addAll(getRbBallBeter(jedisClient, issue, Green));
				}
			}
    		Iterator<String>  i= uids.iterator();
    		while (i.hasNext()) {
				int uid =  Integer.parseInt(i.next());
				int cost=EventProcesser.platExtract(getPrice(uid, issue, result));
				if(cost>0){
					JSONObject jsonEvent= new JSONObject();
					jsonEvent.put("E", EventProcesser.EVENT_REDGREENBALL_DRAW);
					jsonEvent.put("uid", uid);
					jsonEvent.put("result", result);
					jsonEvent.put("issue", issue);
					jsonEvent.put("cost", cost);
					RedisData.addEvent(jedisClient, uid, jsonEvent.toString());
					jedisClient.rpush(RedisData.DB1_2,"rbBallPrice:"+uid,jsonEvent.toString());
				}
			}
    		
    	} 
    	catch (ServiceException ServiceException) {
    		log.info(ServiceException.getMessage());
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	
      
    }    
    
    
    public Map<String,String> getIssue(){
    	  Calendar calendar = Calendar.getInstance();
          long day = calendar.get(Calendar.DATE);
          long month = calendar.get(Calendar.MONTH)+1;
          long year = calendar.get(Calendar.YEAR);
          long nowSec=calendar.getTimeInMillis()/1000;
          
          calendar.set(Calendar.HOUR_OF_DAY, 0);
          calendar.set(Calendar.MINUTE, 0);
          calendar.set(Calendar.SECOND, 0);
          
          long zeroSec=calendar.getTimeInMillis()/1000;
         
         long issueToday=1+(nowSec-zeroSec+1)/180;
         long issue= year*10000000+month*100000+day*1000+issueToday;
         
         Map<String,String> result= new HashMap<String,String>();
         
         result.put(Bet+0, "0");
         result.put(Bet+1, "0");
         result.put(Bet+2, "0");
         result.put(Bet+3, "0");
         result.put(Bet+4, "0");
         result.put(Bet+5, "0");
         result.put(Bet+6, "0");
         result.put(Bet+7, "0");
         result.put(Bet+8, "0");
         result.put(Bet+9, "0");
         result.put(Bet+Red, "0");
         result.put(Bet+Green, "0");
         result.put(Bet+Purple, "0");
         result.put(Issue, issue+"");
         result.put(BetStart, nowSec+"");
         result.put(BetEnd, (nowSec+150)+"");
		return result;
    	
    }
    
    
    public Map<String,String>  lotteryResult() {
    	Map<String,String> issueMap=getCurrRbBall(jedisClient);
    	if(issueMap.isEmpty()){
    		return null;
    	}
    	Long issue=Long.parseLong(issueMap.get(Issue));
    	List<rbBall> rbBallList=rbBallMapper.currRbBall(issue);
    	String Resutl=null;
    	int bet0=	Integer.parseInt(issueMap.get(Bet+0));
    	int bet1=	Integer.parseInt(issueMap.get(Bet+1));
    	int bet2=	Integer.parseInt(issueMap.get(Bet+2));
    	int bet3=	Integer.parseInt(issueMap.get(Bet+3));
    	int bet4=	Integer.parseInt(issueMap.get(Bet+4));
    	int bet5=	Integer.parseInt(issueMap.get(Bet+5));
    	int bet6=	Integer.parseInt(issueMap.get(Bet+6));
    	int bet7=	Integer.parseInt(issueMap.get(Bet+7));
    	int bet8=	Integer.parseInt(issueMap.get(Bet+8));
    	int bet9=	Integer.parseInt(issueMap.get(Bet+9));
    	
    	int betRed=	Integer.parseInt(issueMap.get(Bet+Red));
    	int betGreen=	Integer.parseInt(issueMap.get(Bet+Green));
    	int betPurple=	Integer.parseInt(issueMap.get(Bet+Purple));
    	int total=bet0+bet1+bet2+bet3+bet4+bet5+bet6+bet7+bet8+bet9+betRed+betGreen+betPurple;

    	int price0=bet0*9+
    			(int)((double)betRed*1.5)+
    			(int)((double)betPurple*4.5);
    	int price1=bet1*9+betGreen*2;
		int price2=bet2*9+betRed*2;
		int price3=bet3*9+betGreen*2;
		int price4=bet4*9+betRed*2;
		int price5=bet5*9+
				(int)((double)betGreen*1.5)+
				(int)((double)betPurple*4.5);
		int price6=bet6*9+betRed*2;
		int price7=bet7*9+betGreen*2;
		int price8=bet8*9+betRed*2;
		int price9=bet9*9+betGreen*2;
		
      
		
		List<String> resultList=new ArrayList<String>();
		int [] prices=new int[] {price0,price1,price2,price3,price4,price5,price6,price7,price8,price9};
		int [] pricesort=new int[] {price0,price1,price2,price3,price4,price5,price6,price7,price8,price9};
		Arrays.sort(pricesort);
		Integer price=pricesort[0];

		rbBall rbBall=rbBallList.get(0);
		Resutl=rbBall.getLotteryResult();
		
		if(Resutl==null){
			for (int i = 0; i < prices.length; i++) {
				int p=prices[i];
				if(p==price){
					resultList.add(i+""); 
				}
			}
			Random rand = new Random();
			int index=rand.nextInt(resultList.size());
			Resutl = resultList.get(index);
		}
		 price=prices[Integer.parseInt(Resutl)];
		 
    	 issueMap.put(LotteryResult, Resutl+"");
    	 issueMap.put(LotteryPool, total+"");
    	 issueMap.put(TotalWin, price+"");

    	return issueMap;
    }
    
    
    
    
    
    public static final void  delRbBallBeter(IJedisClient client,int uid){
    	String issue=client.hget(RedisData.DB1_2, CurrRbBall,"issue");
    	String [] bets= {"1","2","3","4","5","6","7","8","9","0",Red,Green,Purple};
    	for (int i = 0; i < bets.length; i++) {
    		client.srem(RedisData.DB1_2, "rbBall:"+issue+"bet:"+bets[i], uid+"");
    	}
    }	
	public static final void  setRbBallBeter(IJedisClient client,Long issue,String bet,int uid){
		client.sadd(RedisData.DB1_2,"rbBall:"+issue+"bet:"+bet, uid+"");
		client.expire(RedisData.DB1_2, "rbBall:"+issue+"bet:"+bet, 200);
	}
	public static final Set<String>  getRbBallBeter(IJedisClient client,Long issue,String bet){
		return client.smembers(RedisData.DB1_2, "rbBall:"+issue+"bet:"+bet);
	}
	public static final void   currRbBallBet(IJedisClient client,String bet,Long value){
		client.hincrBy(RedisData.DB1_2, CurrRbBall, Bet+bet, value);
	}
	public static final void  setCurrRbBall(IJedisClient client,Map<String,String> issue){
		client.hmset(RedisData.DB1_2, CurrRbBall,issue);
		client.expire(RedisData.DB1_2, CurrRbBall, 200);
	}
	public static final Map<String,String>  getCurrRbBall(IJedisClient client){
		Map<String,String> mapData=client.hgetAll(RedisData.DB1_2, CurrRbBall);
		return mapData;
	}
	public static final JSONArray  rbBallRec(IJedisClient client){
		JSONArray  resultData=new JSONArray();
		List<String> records=client.lrange(RedisData.DB1_2, RbBallRec, 0, 9);
		Iterator<String> i=records.iterator();
		while (i.hasNext()) {
			String jsonStr=i.next();
			JSONObject obj= JSONObject.parseObject(jsonStr);
			resultData.add(obj);
		}
		return resultData;
	}
	public static final void  addRbBallRec(IJedisClient client,String rec){
		client.lpush(RedisData.DB1_2, RbBallRec, rec);
		client.ltrim(RedisData.DB1_2, RbBallRec, 0, 9);
	}
	
	public static final JSONArray rbBallNotice(IJedisClient client){
		List<String> records=client.lrange(RedisData.DB1_2, RbBallNotice, 0, 19);
		JSONArray datas=JSONArray.parseArray(JSON.toJSONString(records));
		return datas;
	}
	public static final void  addRbBallNotice(IJedisClient client,String rec){
		client.lpush(RedisData.DB1_2, RbBallNotice, rec);
		client.ltrim(RedisData.DB1_2, RbBallNotice, 0, 19);
	}
	
}
