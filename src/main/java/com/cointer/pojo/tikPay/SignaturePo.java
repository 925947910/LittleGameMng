package com.cointer.pojo.tikPay;



import java.io.Serializable;


/**
 * 签名实体SignatureHeaders
 */

public class SignaturePo implements Serializable {


    public static final String HEADER_APPID ="appid";
    public static final String HEADER_TIMESTAMP = "timestamp";
    public static final String HEADER_NONCE =  "nonce";
    public static final String HEADER_SIGNATURE = "signature";
    public static final long  EXPIRE_TIME = 1000*60*10;
    /**
     * 线下分配的值
     * 客户端和服务端各自保存appId对应的appSecret
     */

    private String apiId;
    /**
     * 线下分配的值
     * 客户端和服务端各自保存，与appId对应
     */

    private String appsecret;
    /**
     * 时间戳，单位: ms
     */

    private String timestamp;
    /**
     * 流水号【防止重复提交】; (备注：针对查询接口，流水号只用于日志落地，便于后期日志核查； 针对办理类接口需校验流水号在有效期内的唯一性，以避免重复请求)
     */

    private String nonce;
    /**
     * 签名
     */

    private String signature;


    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
