package com.cointer.pojo.dto;





public class chargeCallBack1Dto {
	
//	   支付订单号             payOrderId      是       String(30)  P20160427210604000490         支付中心生成的订单号
	private	String  payOrderId;
//    商户 ID             mchId         是       String(30)  20001222                      支付中心分配的商户号
	private	String  mchId;
//    应用 ID             appId         是       String(32)  0ae8be35ff634e2abe94f5f32f6d5 该商户创建的应用对应的
	private	String  appId;
//  支付产品 ID            productId      是          int      8001                          支付产品 ID 
	private	Integer productId;
//  商户订单号            mchOrderNo       是       String(30)  20160427210604000490          商户生成的订单号
	private	String  mchOrderNo;
//   支付金额              amount         是          int      100                           支付金额,单位盧比
	private	Integer amount;
	
//                                                                                      支付状态,0-订单生成,1-支
//     状态               status        是          int 
//                                                        1                             付中,2- 支付成功,3-业务处
//                                                                                      理完成(成功),5-支付失败
	private	Integer status;
//                                                        wx2016081611532915ae15beab0
//  渠道订单号          channelOrderNo     否       String(64)                                三方支付渠道订单号 
//                                                        167 893571 
//                                                        {“bank_type”:”CMB_DEBIT   
	private	String  channelOrderNo;
	
	
//  渠道数据包            channelAttach    否        String     ”,” 
//                                                        trade_type”:”pay.weixin.microp 支付渠道数据包 
//                                                        ay”} 
	private	String  channelAttach;
//
//  扩展参数 1             param1         否       String(64)                                支付中心回调时会原样返
	private	String  param1;
//  扩展参数 2             param2         否       String(64)                                支付中心回调时会原样               
	private	String  param2;
//支付成功时间             paySuccTime      是         long                                    精确到毫秒                        
	private	Long  paySuccTime;
//   通知类型              backType       是          int                                    通知类型，1-前台通知，2-
//                                                        1                             后台通知
//                                                        C380BEC2BFD727A4B6845133
	private	Integer  backType;
	
//     签名                sign         是       String(32)                                签名值，详见签名算
	private	String  sign;

	public String getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getMchOrderNo() {
		return mchOrderNo;
	}

	public void setMchOrderNo(String mchOrderNo) {
		this.mchOrderNo = mchOrderNo;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getChannelOrderNo() {
		return channelOrderNo;
	}

	public void setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo = channelOrderNo;
	}

	public String getChannelAttach() {
		return channelAttach;
	}

	public void setChannelAttach(String channelAttach) {
		this.channelAttach = channelAttach;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public Long getPaySuccTime() {
		return paySuccTime;
	}

	public void setPaySuccTime(Long paySuccTime) {
		this.paySuccTime = paySuccTime;
	}

	public Integer getBackType() {
		return backType;
	}

	public void setBackType(Integer backType) {
		this.backType = backType;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
	
	
}
