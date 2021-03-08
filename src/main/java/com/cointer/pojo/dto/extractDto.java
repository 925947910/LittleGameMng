package com.cointer.pojo.dto;

import java.math.BigDecimal;



public class extractDto {
	//用户id
	private	Integer aid;
	//转出账户
	private	String accOut;
	//转入账户
	private		String accIn;
	//平台
	private	Integer plat;
	//币种
	private		String currency;
	//转出数额
	private		BigDecimal cost;
	//游戏币数量
	private	Integer coin;
	//游戏端订单号
	private		String localOrderNo;
	//订单号
	private		String remoteOrderNo;
	//签名
	private		String sign;
	//结果
	private		Integer status;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAccOut() {
		return accOut;
	}
	public void setAccOut(String accOut) {
		this.accOut = accOut;
	}
	public String getAccIn() {
		return accIn;
	}
	public void setAccIn(String accIn) {
		this.accIn = accIn;
	}
	public Integer getPlat() {
		return plat;
	}
	public void setPlat(Integer plat) {
		this.plat = plat;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public Integer getCoin() {
		return coin;
	}
	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	public String getLocalOrderNo() {
		return localOrderNo;
	}
	public void setLocalOrderNo(String localOrderNo) {
		this.localOrderNo = localOrderNo;
	}
	public String getRemoteOrderNo() {
		return remoteOrderNo;
	}
	public void setRemoteOrderNo(String remoteOrderNo) {
		this.remoteOrderNo = remoteOrderNo;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


}
