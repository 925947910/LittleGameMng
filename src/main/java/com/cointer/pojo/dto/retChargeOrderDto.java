package com.cointer.pojo.dto;

public class retChargeOrderDto extends chargeOrderDto{
	//第三方订单号
	private String localOrderNo;
	//游戏方在第三方的平台id
	private Integer myplat;
	public String getLocalOrderNo() {
		return localOrderNo;
	}
	public void setLocalOrderNo(String localOrderNo) {
		this.localOrderNo = localOrderNo;
	}
	public Integer getMyplat() {
		return myplat;
	}
	public void setMyplat(Integer myplat) {
		this.myplat = myplat;
	}
	
}
