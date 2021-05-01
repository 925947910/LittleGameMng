package com.cointer.pojo.tikPay;



import java.io.Serializable;


public class CallVo implements Serializable {
    public static final Integer CANLE =0;
    public static final Integer SUCESS = 1;

    public static final Integer FAIL = 2;
    public static final Integer GOING =3;

    private String thirdOrderNumber;

    private Integer status;


    private Integer orderType;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getThirdOrderNumber() {
        return thirdOrderNumber;
    }

    public void setThirdOrderNumber(String thirdOrderNumber) {
        this.thirdOrderNumber = thirdOrderNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
