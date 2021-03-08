package com.cointer.pojo.dto;

import java.math.BigDecimal;

public class tokenMapExtractOrderDto {
	private BigDecimal tokenmapNum; // tokenmap方数额
	 private String tokenmapAccount; //tokenmap方用户账户
	 private String thirdAccount; //第三方用户账户
	 private Integer tokenmapUserId; //tokenmap方用户id
	 private String tokenmapOrderNo;//tokenmap方生成的订单号
	 private String tokenCode; //当前币种
	 private String tokenmapTag;//tokenmap在第三方的标识
	 private BigDecimal thirdNum;//第三方数额
	 private String sign; //签名
	 private String callBackUrl; //游戏方提供的callback地址
	 private String thirdOrderNo;//第三方生成的订单号
	 private String thirdPartTag; //第三方在tokenmap的标识
	 
	public BigDecimal getTokenmapNum() {
		return tokenmapNum;
	}
	public void setTokenmapNum(BigDecimal tokenmapNum) {
		this.tokenmapNum = tokenmapNum;
	}
	public String getTokenmapAccount() {
		return tokenmapAccount;
	}
	public void setTokenmapAccount(String tokenmapAccount) {
		this.tokenmapAccount = tokenmapAccount;
	}
	public String getThirdAccount() {
		return thirdAccount;
	}
	public void setThirdAccount(String thirdAccount) {
		this.thirdAccount = thirdAccount;
	}
	public Integer getTokenmapUserId() {
		return tokenmapUserId;
	}
	public void setTokenmapUserId(Integer tokenmapUserId) {
		this.tokenmapUserId = tokenmapUserId;
	}
	public String getTokenmapOrderNo() {
		return tokenmapOrderNo;
	}
	public void setTokenmapOrderNo(String tokenmapOrderNo) {
		this.tokenmapOrderNo = tokenmapOrderNo;
	}
	public String getTokenCode() {
		return tokenCode;
	}
	public void setTokenCode(String tokenCode) {
		this.tokenCode = tokenCode;
	}
	public String getTokenmapTag() {
		return tokenmapTag;
	}
	public void setTokenmapTag(String tokenmapTag) {
		this.tokenmapTag = tokenmapTag;
	}
	public BigDecimal getThirdNum() {
		return thirdNum;
	}
	public void setThirdNum(BigDecimal thirdNum) {
		this.thirdNum = thirdNum;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getCallBackUrl() {
		return callBackUrl;
	}
	public void setCallBackUrl(String callBackUrl) {
		this.callBackUrl = callBackUrl;
	}
	public String getThirdOrderNo() {
		return thirdOrderNo;
	}
	public void setThirdOrderNo(String thirdOrderNo) {
		this.thirdOrderNo = thirdOrderNo;
	}
	public String getThirdPartTag() {
		return thirdPartTag;
	}
	public void setThirdPartTag(String thirdPartTag) {
		this.thirdPartTag = thirdPartTag;
	}
	 
}

