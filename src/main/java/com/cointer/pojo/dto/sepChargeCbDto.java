package com.cointer.pojo.dto;





public class sepChargeCbDto {

//	merchantId string 商户号
//	orderId string 订单号
//	amount string 订单⾦额，单位雷亚尔R$
//	remark string 商品名称(不参与签名)
//	orderStatus int 订单状态，1成功，-1失败
//	sign string 签名，签名规则请看下⾯说明
	private		String merchantId;
	private		String orderId;
	private		String amount;
	private		String remark;
	private		Integer orderStatus;
	private		String sign;
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	

}
