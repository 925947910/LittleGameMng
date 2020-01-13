package com.cointer.pojo.dto;

import java.math.BigDecimal;

public class chargeOrderDto {
	//转入消费金额
	private BigDecimal cost;
	//转入游戏账户（手机号码）
	private String accIn;
	//用户昵称
	private String accOut;
	//转入游戏玩家id
	private Integer uid;
	//订单号
	private String remoteOrderNo;
	//钱包地址
	private String currency;
	//充值金币数量
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	
	
}

