package com.cointer.service.tikPay;












import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.pojo.tikPay.CallVo;
import com.cointer.pojo.tikPay.EncryptedPo;
import com.cointer.pojo.tikPay.IssueOrderPo;
import com.cointer.pojo.tikPay.IssuePayPo;
import com.cointer.pojo.tikPay.OtcCallPo;
import com.cointer.pojo.tikPay.ReqOrderPo;
import com.cointer.pojo.tikPay.SignaturePo;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.ExchangeService;
import com.cointer.util.tikPay.AESOperator;










@Service
public class TikPayService  {
	private static final Logger log = LoggerFactory.getLogger(TikPayService.class);

	private   static int channelIndex =2;
	private   static int PAY_UPI=7;
	private   static int PAY_BANKCARD=11;
	
	private static String CHARGEURL="chargeUrl";
	private static String EXTRACTURL="extractUrl";
	private static String EXTRACTPER="extractPer";
	private static String API="api";
	private static String APPSECRET="appsecret";
	private static String PAYURL="payurl";
	
	@Autowired
	private   IJedisClient jedisClient;
	@Autowired
	private   ExchangeService ExchangeService;

	 /**
     * 充值接口示例----基于Basic Authentication
	 * @return 
	 * @throws Exception 
     */
    public   JSONObject chargeOrder(JSONObject reqData,String orderLocal) throws Exception {
    	ReqOrderPo ReqOrderPo= new ReqOrderPo();
    	ReqOrderPo.setAmount(reqData.getIntValue("cost")+"");
    	ReqOrderPo.setThirdUserId(reqData.getIntValue("uid")+"");
    	ReqOrderPo.setThirdOrderNumber(orderLocal);
    	JSONObject result=null;
		String chargeUrl=RedisData.getUri(jedisClient,channelIndex,CHARGEURL);
		String payurl=RedisData.getUri(jedisClient,channelIndex,PAYURL);
		String api=RedisData.getConf(jedisClient,channelIndex,API);
		String appsecret=RedisData.getConf(jedisClient,channelIndex,APPSECRET);
		long now=	System.currentTimeMillis()/1000;
		 String str =  JSONObject.toJSONString(ReqOrderPo);
		 log.info("=====================chargeOrder:"+str);
       
        String authorization = AESOperator.getInstance().basic(api,appsecret);
        String JsonAuth  =call(authorization,chargeUrl,str);
        /*
        call 返回后格式：
        {"code": 0,"data": {"orderNumber": "tc00000"},"message": "","param": [],"success": true }
        解析得到 orderNumber ，跳转页面就是https://paytest.soon-ex.com/#/?orderId=tc00000
		 */
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
	//客户端发起提现 http://127.0.0.1:8085/GameUser/exchange/extractOrder?param={"uid": 30, "coin": 100, "name": "yeah", "account": "6262662666662666", "ifsc": "HDFC0000027","bank_name":"indbank", "bank_code": "IDPT0001"}
	public   String accountInfo(JSONObject reqData) throws Exception {
		String name= reqData.getString("name");
		String account= reqData.getString("account");
		String ifsc= reqData.getString("ifsc");
		String bank_name= reqData.getString("bank_name");
		JSONObject accountInfo= new JSONObject();
		accountInfo.put("name", name);
		accountInfo.put("account", account);
		accountInfo.put("ifsc", ifsc);
		accountInfo.put("bank_name", bank_name);
		return accountInfo.toString();
	}
    /**
     * 下发接口接口示例
     * @throws Exception 
     */
    
    public   JSONObject verifyExtract(tradeOrder tradeOrder) throws Exception {
		String extractUrl=RedisData.getUri(jedisClient,channelIndex,EXTRACTURL);
		String api=RedisData.getConf(jedisClient,channelIndex,API);
		String appsecret=RedisData.getConf(jedisClient,channelIndex,APPSECRET);
		long now=	System.currentTimeMillis();
        long nonceTime=now%10000000000l;
		String nonceStr="1111111111"+nonceTime;
		String nonce=nonceStr.substring(nonceStr.length()-10, nonceStr.length());
		JSONObject outInfo=JSONObject.parseObject(tradeOrder.getAccountOut());

		    IssueOrderPo issueOrderPo = new IssueOrderPo();
	        issueOrderPo.setAmount(tradeOrder.getCost()+"");
	        issueOrderPo.setThirdOrderNumber(tradeOrder.getOrderLocal());
	        issueOrderPo.setThirdUserId(tradeOrder.getUid()+"");

	        IssuePayPo issuePayPo = new  IssuePayPo();
	        issuePayPo.setPaymentId(PAY_BANKCARD);
	        issuePayPo.setName(outInfo.getString("name"));
	        issuePayPo.setAccountName(outInfo.getString("account"));
	        issuePayPo.setIfscCode(outInfo.getString("ifsc"));
	        issuePayPo.setBankName(outInfo.getString("bank_name"));
	        issueOrderPo.setIssuePayPo(issuePayPo);
	        String issueOrderPoStr=JSON.toJSONString(issueOrderPo);
	        log.info("=====================verifyExtract:"+issueOrderPoStr);
	        String str =  getSignatue(issueOrderPoStr, nonce+"", appsecret, api, appsecret);
            String JsonAuth  = call("encryptedReq",extractUrl,str);
        /*
        call 返回后格式：
        {
	       "code": 0,
	           "data": {
		       "orderNumber": "",
		       "thirdOrderNumber": "",
		       "thirdUserId": ""
	             },
	           "success": true
          }
         */

        JSONObject AuthData =JSON.parseObject(JsonAuth);
        JSONObject result=new JSONObject();
        if(AuthData.getIntValue("code")==0){
        	String orderRemote=AuthData.getJSONObject("data").getString("orderNumber");
        	result.put("orderRemote",orderRemote);
        	result.put("succ", true);
        }else{
        	result.put("succ", false);
        }
        return result;
    }
    


    

    
    public void chargeCallBack(OtcCallPo callPo) throws Exception { 
    	JSONObject AuthData=null;
    	String appsecret=RedisData.getConf(jedisClient,channelIndex,APPSECRET);
    	String extractPer=RedisData.getConf(jedisClient,channelIndex,EXTRACTPER);
    	String data =  AESOperator.getInstance().decrypt(callPo.getEncryptedData(),appsecret.substring(0,16));
    	CallVo callVo = JSON.parseObject(data, CallVo.class);
    	  log.info("------------------------chargeCallBackData:"+data);
    	AuthData=new JSONObject();
    	switch (callVo.getStatus()) {
    	case 1:
    		AuthData.put("succ", true);
    		AuthData.put("orderLocal", callVo.getThirdOrderNumber());
    		AuthData.put("extractPer", extractPer);
    		break;
    	default:
    		AuthData.put("succ", false);
    		AuthData.put("orderLocal", callVo.getThirdOrderNumber());
    		AuthData.put("extractPer", extractPer);
    		break;
    	}
    	ExchangeService.processCharge(AuthData);
    		/*   String decryptedData = AESOperator.getInstance().decrypt(encryptedReq.getEncryptedData());
        AdInfoPo adInfoPo = JSON.parseObject(decryptedData, AdInfoPo.class);*/
    }
    
    public void extractCallBack(OtcCallPo callPo) throws Exception { 
    	    JSONObject AuthData=null; 
    		String appsecret=RedisData.getConf(jedisClient,channelIndex,APPSECRET);
    		String data =  AESOperator.getInstance().decrypt(callPo.getEncryptedData(),appsecret.substring(0,16));

    		CallVo callVo = JSON.parseObject(data, CallVo.class);
    		 log.info("------------------------extractCallBackData:"+data);
    		AuthData=new JSONObject();
        	switch (callVo.getStatus()) {
        	case 1:
        		AuthData.put("succ", true);
        		AuthData.put("orderLocal", callVo.getThirdOrderNumber());
        		break;
        	default:
        		AuthData.put("succ", false);
        		AuthData.put("orderLocal", callVo.getThirdOrderNumber());
        		break;
        	}
        	ExchangeService.processExtract(AuthData);

    
    }
    
    public static  String getSignatue(String json,String nonce,String key,String api,String appsecret) throws Exception {
        key = key.substring(0, 16);
        String encrypt = AESOperator.getInstance().encrypt(json, key);
//        System.out.println("encrypt:"+encrypt);
        SignaturePo headers = new SignaturePo();
        headers.setApiId(api);
        headers.setTimestamp(String.valueOf(System.currentTimeMillis()));
        headers.setNonce(nonce);
        String sigString = AESOperator.createSignature(headers.getTimestamp(), headers.getNonce(), headers.getApiId(), appsecret, json);
//        System.out.println("sigString:"+sigString);
        headers.setSignature(sigString);
        EncryptedPo<ReqOrderPo> encryptedReq = new EncryptedPo<ReqOrderPo>();
        encryptedReq.setEncryptedData(encrypt);
        encryptedReq.setSignaturePo(headers);
//        System.out.println("encryptedReq:"+encryptedReq);
        return JSON.toJSONString(encryptedReq);

}
    
    public   String call(String header,String url, String json)  throws Exception{
    	//post请求
    	/* FormBody formBody = new FormBody.Builder()
                .add(keyName, json)
                .build();*/
    	
    	try {
    		MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        	Request request = new Request.Builder().addHeader("Authorization",header).url(url).post(RequestBody.create(mediaType, json)).build();
        	OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();   
    		Call call = okHttpClient.newCall(request);
            Response response = call.execute();
			if(response.code()==200){
				String returnStr= response.body().string();
				  log.info("call:"+url+"==============result:"+returnStr);
				return returnStr;
			}else{
				  log.info("call:"+url+"failed========code:"+response.code()+"======result:"+response.body().string());
				throw new ServiceException(StatusCode.FAILED,"response_code_error", null);
			}
			
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
        }
		
    }
}

