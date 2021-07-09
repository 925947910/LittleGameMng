package com.cointer.service.amPay;








import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.pojo.po.tradeOrder;
import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.service.impl.ExchangeService;
import com.cointer.util.HttpClientUtil;
import com.cointer.util.MD5Util;








@Service
public class AmPayService  {


	private   static int channelIndex =3;


	private static final Logger log = LoggerFactory.getLogger(AmPayService.class);
	
	private static String CHARGEURL="chargeUrl";
	private static String CHARGECALLBACKURL="chargeCallbackUrl";
	private static String EXTRACTURL="extractUrl";
	private static String EXTRACTCALLBACKURL="extractCallbackUrl";
	private static String EXTRACTPER="extractPer";
	private static String MER_NO="mer_no";
	private static String KEY="Key";
	
	@Autowired
	private   IJedisClient jedisClient;

	@Autowired
	private   ExchangeService ExchangeService;

	//客户端发起充值 http://127.0.0.1:8085/GameUser/exchange/chargeOrder?param={"uid": 30, "channel": 102,"bank_code":"IDPT0001","cost": 100}

	public   JSONObject  chargeOrder(JSONObject reqData,String orderLocal) throws Exception {
		JSONObject result=null;
		String notifyUrl=RedisData.getUri(jedisClient,channelIndex,CHARGECALLBACKURL);
		String chargeUrl=RedisData.getUri(jedisClient,channelIndex,CHARGEURL);
		String Key=RedisData.getConf(jedisClient,channelIndex,KEY);
		String mer_no=RedisData.getConf(jedisClient,channelIndex,MER_NO);
		long now=	System.currentTimeMillis()/1000;
		//		1. mer_no 商户号 String 是 商户编号
		//		2. mer_order_no 商户订单号 String 是 商户必须保证唯一
		//		3. pname 姓名 String 是 案例:Zhangsan(一般为字母)
		//		4. pemail 邮箱 String 是 案列:test@email.com
		//		5. phone 手机号 Int 是 印尼 OVO 业务时,手机号必须时注册 OVO 预留手机号案例:131********
		//		6. order_amount 交易金额 Number 是 金额,两位小数
		//		7. countryCode 国家简写(大写） String 是 IND:印度
		//		8. ccy_no 币种简写(大写) String 是   INR:印度卢比
		//		9.timeout_express  订单有限期 String 可选 该笔订单允许的最晚支付时间,逾期将关闭交易,取值范围:( m-分钟，h-小时),该参数数值不接受小数点.示例:90m
		//		10. busi_code 支付类型编码 String 是 详情见：附件业务编码
		//		11. goods 商品详情 String 是  商品详情
		//		12. notifyUrl 异步通知地址 String 是  支付成功后，平台主动通知商家系统，商家系统必须指定接收通知的地址。序号 参数名 参数名称 类型 是否必填 说明
		//		13. accNo 银行账户 String 某业务必填  泰国网银业务必须上送银行账号
		//		14. bankCode 银行编码 String 一定场景，必填 网银业务必填
		//		15. pageUrl支付成功，页面跳转地址 String 可选 支付成功,页面跳转地址
		//		16. sign 数字签名 String 是 详情见：数字签名
		JSONObject ReqParam=  new JSONObject();

		ReqParam.put("mer_no",mer_no);
		ReqParam.put("mer_order_no",orderLocal);
		ReqParam.put("pname", "player");
		ReqParam.put("pemail", "475454554@qq.com");
		ReqParam.put("phone","8790071999");
		ReqParam.put("order_amount",reqData.getFloatValue("cost")+"");
		ReqParam.put("countryCode", "IND");
		ReqParam.put("ccy_no", "INR");
		ReqParam.put("timeout_express","15m");
		ReqParam.put("busi_code","UPI");
		ReqParam.put("goods", "game_coin_charge");
		ReqParam.put("notifyUrl", notifyUrl);

		Map<String, String> paramsMap = JSONObject.toJavaObject(ReqParam, Map.class);
		String sign=MD5Util.paramsSort(paramsMap)+"&key="+Key;
		sign= MD5Util.getMD5(sign);
		paramsMap.put("sign", sign);
		log.info("=====================chargeOrder:"+paramsMap.toString());
		String	JsonAuth;
		try{
			HttpClientUtil  client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(chargeUrl, paramsMap.toString());
		} catch (Exception e) {
			throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
		}
		if(JsonAuth==null) {
			throw new ServiceException(StatusCode.FAILED,"request_data_null", null);
		}
		log.info("=====================JsonAuth:"+JsonAuth);
		//		17. mer_no 商户号 String 否 商户编号
		//		18. mer_order_no
		//		商户订单
		//		号
		//		String 否 商户必须保证唯一
		//		19. order_amount 交易金额 Number 否 元,保留小位小数
		//		20. busi_code 业务编码 String 否 详情见：附件业务编码
		//		21. goods 商品详情 String 否 商品详情
		//		22. notifyUrl
		//		异步通知
		//		地址 String 否
		//		支付成功后，平台主动通知商家系
		//		统，商家系统必须指定接收通知的
		//		地址。
		//		23. pageUrl
		//		支付成功
		//		页面跳转
		//		地址
		//		String 否 支付成功,页面跳转地址
		//		24. order_no
		//		平台订单
		//		号
		//		String 否 平台唯一
		//		25. order_time 订单时间 String 否
		//		时间戳： ( 格式为
		//		yyyyMMddHHmmss 4位年+2位月
		//		+2 位日+2 位时+2 位分+2 位秒)
		//		26. pay_amount
		//		实际支付
		//		金额 Number 否 实际支付金额
		//		27. status 状态 String 是 成功：SUCCESS 失败：FAIL
		//		28. err_code 错误码 String 否 详见：附件错误码
		//		29. err_msg 错误信息 Sring 否 详见：附件错误码中错误描述
		//		30. order_data 下单成 String 否 状态成功时,有值,支付链接或者收
		JSONObject AuthData =JSON.parseObject(JsonAuth);
		Map<String, String> JsonAuthMap = JSONObject.toJavaObject(AuthData, Map.class);
		String	remoteSign=AuthData.getString("sign");
		JsonAuthMap.remove("sign");
		sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+Key;
		//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign);
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"chargeOrder:sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		if("SUCCESS".equals(AuthData.getString("status"))){
			String payurl=AuthData.getString("order_data");
			String orderRemote=AuthData.getString("order_no");
			result=new JSONObject();
			result.put("orderRemote",orderRemote);
			result.put("payurl", payurl);
			result.put("now", now);
			log.info("call:"+chargeUrl+"==============result:"+payurl);
		}else{
			log.info("call:"+chargeUrl+"failed========err_code:"+AuthData.getString("err_code")+"======err_msg:"+AuthData.getString("err_msg"));
		}
		return result;
	}

	public void chargeCallBack(JSONObject reqData)throws Exception{
		log.info("------------------------chargeCallBackData:"+reqData.toString());
		//		52. busi_code 支付类型 String 是 详见：附件业务编码
		//		53. err_code 错误码 String 否 详见：附件错误码
		//		54. err_msg 错误信息 String 否 详见：附件错误码中错误描述
		//		55. mer_no 商户号 String 是 商户编号
		//		56. mer_order_no 商户订单号 Number 是 商户唯一订单号
		//		57. order_amount 订单金额 String 是 保留二位小数
		//		58. order_no 平台订单号 String 是 平台唯一订单号
		//		59. order_time 订单时间 String 是 格式 (yyyy-MM-dd HH:mm:ss)
		//		60. pay_amount 支付金额 String 是 整数
		//		61. pay_time 支付时间 String 是 格式 (yyyy-MM-dd HH:mm:ss)
		//		62. reserver 订单保留信息 String 否 订单保留信息
		//		63. status 订单状态 String 是 SUCCESS：成功 FAIL:失败
		//		64. sign 数字签名 String 是 详见：数字签名
		String extractPer=RedisData.getConf(jedisClient,channelIndex,EXTRACTPER);
		String Key=RedisData.getConf(jedisClient,channelIndex,KEY);
		String	remoteSign=reqData.getString("sign");
		Map<String, String> JsonAuthMap = JSONObject.toJavaObject(reqData, Map.class);
		JsonAuthMap.remove("sign");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+Key;
		//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign);
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"chargeCallBack:sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		String orderLocal=reqData.getString("mer_order_no");
		JSONObject  AuthData=new JSONObject();
		switch (reqData.getString("status")) {
		case "SUCCESS":
			AuthData.put("succ", true);
			AuthData.put("orderLocal", orderLocal);
			AuthData.put("extractPer", extractPer);
			log.info("chargeCallBack========orderLocal:"+orderLocal);
			break;
		default:
			AuthData.put("succ", false);
			AuthData.put("orderLocal", orderLocal);
			AuthData.put("extractPer", extractPer);
			log.info("chargeCallBack:failed========err_code:"+reqData.getString("err_code")+"======err_msg:"+reqData.getString("err_msg"));
			break;
		}
		ExchangeService.processCharge(AuthData);

	}
	//客户端发起提现 http://127.0.0.1:8085/GameUser/exchange/extractOrder?param={"uid": 30, "coin": 100, "name": "yeah", "account": "6262662666662666", "ifsc": "HDFC0000027","bank_name":"indbank", "bank_code": "IDPT0001"}
	public   String accountInfo(JSONObject reqData) throws Exception {
		String name= reqData.getString("name");
		String account= reqData.getString("account");
		String ifsc= reqData.getString("ifsc");
		String bank_code= reqData.getString("bank_code");
		JSONObject accountInfo= new JSONObject();
		accountInfo.put("name", name);
		accountInfo.put("account", account);
		accountInfo.put("ifsc", ifsc);
		accountInfo.put("bank_code", bank_code);
		return accountInfo.toString();
	}
	public   JSONObject  verifyExtract(tradeOrder  tradeOrder) throws Exception {
		JSONObject result=null;
		String notifyUrl=RedisData.getUri(jedisClient,channelIndex,EXTRACTCALLBACKURL);
		String extractUrl=RedisData.getUri(jedisClient,channelIndex,EXTRACTURL);
		String Key=RedisData.getConf(jedisClient,channelIndex,KEY);
		String mer_no=RedisData.getConf(jedisClient,channelIndex,MER_NO);
		String AccountOut=tradeOrder.getAccountOut();
		JSONObject outInfo=JSONObject.parseObject(AccountOut);

		//		mer_no 商户号 String 是 平台分配的唯一商户编号
		//		mer_order_no 商户订单号 String 是 商户订单号需要唯一,不能重复
		//		acc_no 收款账号 String 是 收款账号
		//		acc_name 收款户名 String 是 收款姓名
		//		ccy_no 币种 String 是
		//		IDR:印尼卢比
		//		VND:越南盾
		//		THB:泰铢
		//		INR:印度卢比
		//		MYR:马来西亚币
		//		USDTERC:虚拟币
		//		NGN:尼日利亚币
		//		order_amount 金额 Number 是 元为单位,保留二位小数
		//		bank_code 银行编码 String 是
		//		银行编码,印度 UPI 出款,需要填写
		//		UPI
		//		mobile_no 手机号 String 否 手机号
		//		province 省份 String 否 印度银行卡代付必填(IFSC)
		//		notifyUrl 回调地址 String 否
		//		代付失败或成功,会向该地址发
		//		送回调
		//		summary 备注 String 是 备注
		//		sign 数字签名 String 是 详见：数字签名
		JSONObject ReqParam=  new JSONObject();
		ReqParam.put("mer_no",mer_no);
		ReqParam.put("mer_order_no",tradeOrder.getOrderLocal());
		ReqParam.put("acc_no",outInfo.getString("account"));
		ReqParam.put("acc_name",outInfo.getString("name"));
		ReqParam.put("ccy_no","INR");
		ReqParam.put("order_amount",tradeOrder.getCost()+"");
		ReqParam.put("bank_code","UPI");
		ReqParam.put("province",outInfo.getString("ifsc"));
		ReqParam.put("notifyUrl",notifyUrl);
		ReqParam.put("summary","game_coin_extract");

		Map<String, String> paramsMap = JSONObject.toJavaObject(ReqParam, Map.class);

		String sign=MD5Util.paramsSort(paramsMap)+"&key="+Key;
		//			sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign);
		paramsMap.put("sign", sign);
		log.info("=====================verifyExtract:"+paramsMap.toString());
		String	JsonAuth=null;
		try {
			HttpClientUtil  client=HttpClientUtil.getInstance();
			JsonAuth=client.doPostWithJsonResult(extractUrl, paramsMap.toString());
		} catch (Exception e) {
			throw new ServiceException(StatusCode.FAILED,"request_time_out", null);
		}

		if(JsonAuth==null) {
			throw new ServiceException(StatusCode.FAILED,"request_data_null", null);
		}
		//		status 状态 String 是
		//		仅表示订单受理状态，非订单代付状
		//		态; SUCCESS：成功 FAIL:失败
		//		err_code 错误码 String 否 详见：错误码
		//		err_msg 错误信息 String 否 详见：错误码中错误描述
		//		stauts 等于 SUCCESS,以下参数才返回
		//		mer_no 商户号 String 是 原样返回
		//		mer_order_no 商户订单号 String 是 原样返回
		//		order_no 平台订单号 String 是 平台订单号
		//		account_no 子账户号 String 否 原样返回
		//		acc_no 收款账号 String 是 原样返回
		//		acc_name 收款户名 String 是 原样返回
		//		ccy_no 币种 String 否 原样返回
		//		order_amount 金额 Number 是 原样返回
		//		summary 摘要 String 否 原样返回

		JSONObject AuthData =JSON.parseObject(JsonAuth);
		Map<String, String> JsonAuthMap = JSONObject.toJavaObject(AuthData, Map.class);
		String	remoteSign=AuthData.getString("sign");
		JsonAuthMap.remove("sign");
		sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+Key;
		//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign);
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"verifyExtract:sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		result=new JSONObject();
		if("SUCCESS".equals(AuthData.getString("status"))){
			String orderRemote=AuthData.getString("order_no");
			result.put("succ",true);
			result.put("orderRemote",orderRemote);
			log.info("call:"+extractUrl+"==============result:"+orderRemote);
		}else{
			result.put("succ",false);
			log.info("call:"+extractUrl+"failed========err_code:"+AuthData.getString("err_code")+"======err_msg:"+AuthData.getString("err_msg"));
		}
		return result;
	}	

















	//  提现回调
	public   void  extractCallBack(JSONObject reqData) throws Exception {
		
		log.info("------------------------extractCallBack:"+reqData.toString());
//		err_code 错误码 String 否 详见：附件错误码
//		err_msg 错误信息 String 否 详见：附件错误码中错误描述
//		mer_no 商户号 String 是 商户编号
//		mer_order_no 商户订单号 Number 是 商户订单号
//		order_amount 订单金额 String 是 元,保留二位小数
//		ccy_no 币种 String 是 币种
//		order_no 平台订单号 String 是 平台订单号
//		create_time 订单创建时间 String 是 格式 (yyyy-MM-dd HH:mm:ss)
//		pay_time 订单支付时间 String 否 格式 (yyyy-MM-dd HH:mm:ss)
//		status 订单状态 String 是
//		SUCCESS:成功
//		FAIL:失败
//		UNKNOW:处理中
//		sign 数字签名 String 是 详见：数字签名
		String Key=RedisData.getConf(jedisClient,channelIndex,KEY);
		String	remoteSign=reqData.getString("sign");
		Map<String, String> JsonAuthMap = JSONObject.toJavaObject(reqData, Map.class);
		JsonAuthMap.remove("sign");
		String sign=MD5Util.paramsSort(JsonAuthMap)+"&key="+Key;
		//		sign= sign.replaceAll("/", "\\\\/");
		sign= MD5Util.getMD5(sign);
		if(!remoteSign.equals(sign)){
			throw new ServiceException(StatusCode.FAILED,"extractCallBack:sign_error remoteSign:"+remoteSign+"****sign:"+sign, null);
		}
		String orderLocal=reqData.getString("mer_order_no");
		JSONObject  AuthData=new JSONObject();
		switch (reqData.getString("status")) {
		case "SUCCESS":
			AuthData.put("succ", true);
			AuthData.put("orderLocal", orderLocal);
			log.info("extractCallBack========orderLocal:"+orderLocal);
			break;
		default:
			AuthData.put("succ", false);
			AuthData.put("orderLocal", orderLocal);
			log.info("extractCallBack:failed========err_code:"+reqData.getString("err_code")+"======err_msg:"+reqData.getString("err_msg"));
			break;
		}
		ExchangeService.processExtract(AuthData);




	}	

































}


