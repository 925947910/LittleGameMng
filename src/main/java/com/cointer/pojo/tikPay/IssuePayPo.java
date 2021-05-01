package com.cointer.pojo.tikPay;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;

import java.io.Serializable;

//@Data
//@ApiModel
public class IssuePayPo implements Serializable {

    //@ApiModelProperty(value = "姓名")
    private String name;
    // @ApiModelProperty(value = "账号(银行，支付宝&微信）")
    private String accountName;
    //@ApiModelProperty(value = "银行名称")
    private String bankName;

    // @ApiModelProperty(value = "二维码图片地址")
    private String barcodeImg;

    // @ApiModelProperty(value = "IFSC码")
    private String ifscCode;

    //@ApiModelProperty(value = "支付方式")
    private int paymentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBarcodeImg() {
        return barcodeImg;
    }

    public void setBarcodeImg(String barcodeImg) {
        this.barcodeImg = barcodeImg;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
