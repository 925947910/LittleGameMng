package com.cointer.service.tikPay;












import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.pojo.tikPay.IssueOrderPo;
import com.cointer.pojo.tikPay.IssuePayPo;
import com.cointer.pojo.tikPay.ReqOrderPo;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.ExchangeService;
import com.cointer.util.MD5Util;
import com.cointer.util.tikPay.AESOperator;
import com.cointer.util.tikPay.OtcDemo;









@Service
public class TikPayService  {
	private static final Logger log = LoggerFactory.getLogger(ExchangeService.class);

//    public static  String key = "decfc978c14871768c6f761250869b51";
//    public static  String api = "70928538";
//    public static  String appsecret = "decfc978c14871768c6f761250869b51";
//    private   static String chargeUrl ="https://payapitest.soon-ex.com/otc/api/getRechargeData";
	private   static int channelIndex =2;
	@Autowired
	private   IJedisClient jedisClient;
	 /**
     * 充值接口示例----基于Basic Authentication
	 * @return 
     */
    public   JSONObject chargeOrder(ReqOrderPo ReqOrderPo) {
    	JSONObject result=null;
		String chargeUrl=RedisData.getUri(jedisClient,channelIndex,"chargeUrl");
		String payurl=RedisData.getUri(jedisClient,channelIndex,"payurl");
		String api=RedisData.getConf(jedisClient,channelIndex,"api");
		String appsecret=RedisData.getConf(jedisClient,channelIndex,"appsecret");
		 Date Date =new Date(); 
		long now=	Date.getTime()/1000;
        String str =  JSONObject.toJSONString(ReqOrderPo);
        String authorization = AESOperator.getInstance().basic(api,appsecret);
        String JsonAuth  =call(authorization,chargeUrl,str);
        /*
        call 返回后格式：
        {"code": 0,"data": {"orderNumber": "tc00000"},"message": "","param": [],"success": true }
        解析得到 orderNumber ，跳转页面就是https://paytest.soon-ex.com/#/?orderId=tc00000
		 */
        if(JsonAuth==null){
        	return result;
        }
        JSONObject AuthData =JSON.parseObject(JsonAuth);
        if(AuthData.getIntValue("code")==0){
        	String orderRemote=AuthData.getJSONObject("data").getString("orderNumber");
        	result=new JSONObject();
        	result.put("orderRemote",orderRemote);
        	result.put("payurl", payurl+"?orderId="+orderRemote);
        	result.put("now", now);
        }
        
        return result;
    }

    /**
     * 充值接口示例
     */
//    public   void recharge() {
//
//        String str =  OtcDemo.getSignatueStr();
//
//        try {
//            call("encryptedReq","https://payapitest.soon-ex.com/otc/api/recharge","sdffffff");
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    /**
     * 充值接口示例
     */
//    public   void queryOrderStatus() {
//
//        String str =  OtcDemo.getSignatueStr();
//
//        try {
//            call("encryptedReq","https://payapitest.soon-ex.com/otc/api/queryOrderStatus",str,"queryOrderStatus");
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    /**
     * 提现接口示例
     */
//    public   void withdrawa() {
//
//        String str =  OtcDemo.getSignatueStr();
//
//        try {
//            call("encryptedReq","https://payapitest.soon-ex.com/otc/api/withdrawal",str);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    /**
     * 下发接口接口示例
     */
    
    public   JSONObject verifyExtract(ReqOrderPo ReqOrderPo) {
    	JSONObject result=null;
		String extractUrl=RedisData.getUri(jedisClient,channelIndex,"extractUrl");
		String payurl=RedisData.getUri(jedisClient,channelIndex,"payurl");
		String api=RedisData.getConf(jedisClient,channelIndex,"api");
		String appsecret=RedisData.getConf(jedisClient,channelIndex,"appsecret");
		 Date Date =new Date(); 
		long now=	Date.getTime()/1000;
        String str =  JSONObject.toJSONString(ReqOrderPo);
        String authorization = AESOperator.getInstance().basic(api,appsecret);
        String JsonAuth  = call("encryptedReq",extractUrl,str);
        /*
        call 返回后格式：
        {"code": 0,"data": {"orderNumber": "tc00000"},"message": "","param": [],"success": true }
        解析得到 orderNumber ，跳转页面就是https://paytest.soon-ex.com/#/?orderId=tc00000
		 */
        if(JsonAuth==null){
        	return result;
        }
        JSONObject AuthData =JSON.parseObject(JsonAuth);
        if(AuthData.getIntValue("code")==0){
        	String orderRemote=AuthData.getString("orderNumber");
        	result=new JSONObject();
        	result.put("orderRemote",orderRemote);
        	result.put("payurl", payurl+"?orderId="+orderRemote);
        	result.put("now", now);
        }
        
        return result;
    }
    
    
    public   void issue() {
        IssueOrderPo issueOrderPo = new IssueOrderPo();
        issueOrderPo.setAmount("1000");
        issueOrderPo.setThirdOrderNumber("TSSSSDFFDDFDFD");
        issueOrderPo.setThirdUserId("2222");

        IssuePayPo issuePayPo = new  IssuePayPo();
        issuePayPo.setPaymentId(7);
        issuePayPo.setName("sssss");
        issuePayPo.setAccountName("dfdfdf");
        issueOrderPo.setIssuePayPo(issuePayPo);
        String str =  OtcDemo.getSignatue(JSON.toJSONString(issueOrderPo),"123456789.");

        try {
            call("encryptedReq","https://payapitest.soon-ex.com/otc/api/issue",str);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public   String call(String header,String url, String json)  {
    	//post请求
    	/* FormBody formBody = new FormBody.Builder()
                .add(keyName, json)
                .build();*/
    	String returnStr=null;
    	try {
    		MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        	Request request = new Request.Builder().addHeader("Authorization",header).url(url).post(RequestBody.create(mediaType, json)).build();
        	OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();   
    		Call call = okHttpClient.newCall(request);
            Response response = call.execute();
			if(response.code()==200){
				//修改回调状态
			    returnStr= response.body().string();
				System.out.println("call:"+url+"==============result:"+returnStr);
				
			}
//			else if(response.code() > 200 && response.code() < 300) {
//			  returnStr= response.body().string();
//				System.out.println(returnStr);
//			}
        } catch (IOException e) {
            e.printStackTrace();
        }
		return returnStr;
    	

    }

}

