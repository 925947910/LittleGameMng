package com.cointer.pojo.dto;

import java.math.BigDecimal;

public class chargeOrderDto {
	//转入数量
	private BigDecimal cost;
	//转入账户
	private String accIn;
	//转出账户
	private String accOut;
	//第三方用户id
	private Integer aid;
	//第三方订单号
	private String remoteOrderNo;
	//货币类型
	private String currency;
	//平台id
	private Integer plat;
	//充值金币数量
	private Integer coin;
	//回调地址
	private String receiveurl;
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
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
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
	public Integer getPlat() {
		return plat;
	}
	public void setPlat(Integer plat) {
		this.plat = plat;
	}
	public Integer getCoin() {
		return coin;
	}
	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	public String getReceiveurl() {
		return receiveurl;
	}
	public void setReceiveurl(String receiveurl) {
		this.receiveurl = receiveurl;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
	
}

