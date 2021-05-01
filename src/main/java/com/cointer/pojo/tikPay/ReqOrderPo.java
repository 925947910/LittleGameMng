package com.cointer.pojo.tikPay;


import java.io.Serializable;


public class ReqOrderPo implements Serializable {


    private String amount;

    private String thirdOrderNumber;

    private String thirdUserId;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getThirdOrderNumber() {
        return thirdOrderNumber;
    }

    public void setThirdOrderNumber(String thirdOrderNumber) {
        this.thirdOrderNumber = thirdOrderNumber;
    }

    public String getThirdUserId() {
        return thirdUserId;
    }

    public void setThirdUserId(String thirdUserId) {
        this.thirdUserId = thirdUserId;
    }
}
