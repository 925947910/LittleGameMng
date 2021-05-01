package com.cointer.pojo.tikPay;



import java.io.Serializable;



public class OtcCallPo implements Serializable {




    private String encryptedData;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }
}
