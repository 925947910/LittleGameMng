package com.cointer.pojo.dto;

import java.math.BigDecimal;

public class chargeOrderDto {
	//转入消费金额
	private BigDecimal cost;
	//转入游戏账户（手机号码）
	private String accIn;
	//用户昵称
	private String accOut;
	//订单号
	private String remoteOrderNo;
	//钱包地址
	private String currency;
	//充值金币数量 分为单位
	private Integer coin;
	//签名
	private String sign;
	
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getAccIn() {
		return accIn;
	}
	public void setAccIn(String accIn) {
		this.accIn = accIn;
	}
	public String getAccOut() {
		return accOut;
	}
	public void setAccOut(String accOut) {
		this.accOut = accOut;
	}
	
	public String getRemoteOrderNo() {
		return remoteOrderNo;
	}
	public void setRemoteOrderNo(String remoteOrderNo) {
		this.remoteOrderNo = remoteOrderNo;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public Integer getCoin() {
		return coin;
	}
	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
    // 充值接口 "status":"200"  成功   
	// http://47.99.220.0:8089/GameUser/exchange/charge?param={%22accIn%22:%2218570603854%22,%22accOut%22:%2218570603854%22,%22remoteOrderNo%22:%22123%22,%22currency%22:%22123%22,%22coin%22:%221000%22,%22cost%22:%2210%22}
	// 查询充值订单   返回0  成功   1 失败  2  其他
	// http://47.99.220.0:8089/GameUser/exchange/orderInfo?param={%22orderNo%22:%22123%22}
	
}

