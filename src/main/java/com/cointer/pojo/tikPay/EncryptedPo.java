package com.cointer.pojo.tikPay;


import java.io.Serializable;


public class EncryptedPo<T> implements Serializable {


    private String encryptedData;

    private T data;

    private SignaturePo signaturePo;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SignaturePo getSignaturePo() {
        return signaturePo;
    }

    public void setSignaturePo(SignaturePo signaturePo) {
        this.signaturePo = signaturePo;
    }
}
