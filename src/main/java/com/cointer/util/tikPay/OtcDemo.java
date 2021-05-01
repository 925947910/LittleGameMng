package com.cointer.util.tikPay;





import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.pojo.tikPay.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;



public class OtcDemo {
	
    public static  String key = "decfc978c14871768c6f761250869b51";
    public static  String api = "70928538";
    public static  String appsecret = "decfc978c14871768c6f761250869b51";




    public static void main(String[] args) {
        CommonResult result =new CommonResult(1,"SCUESS","2");
        System.out.println(JSONObject.toJSON(result));


    }




    public static  String getSignatueStr() {
        ReqOrderPo reqOrderPo = new ReqOrderPo();
        reqOrderPo.setAmount("100.00");
        reqOrderPo.setThirdOrderNumber("358041953784434688");
        reqOrderPo.setThirdUserId("001");
        try {
            key = key.substring(0, 16);
            String encrypt = AESOperator.getInstance().encrypt(JSON.toJSONString(reqOrderPo), key);

            System.out.println("encrypt:"+encrypt);
            SignaturePo headers = new SignaturePo();
            headers.setApiId(api);
            headers.setTimestamp(String.valueOf("1615971613927"));
            String nonce = "QM3dQ1wv5vAqqHzN";
            headers.setNonce(nonce);
            String sigString = createSignature(headers.getTimestamp(), headers.getNonce(), headers.getApiId(), appsecret, JSON.toJSONString(reqOrderPo));
            System.out.println("sigString:"+sigString);
            headers.setSignature(sigString);
            EncryptedPo<ReqOrderPo> encryptedReq = new EncryptedPo<ReqOrderPo>();
            encryptedReq.setEncryptedData(encrypt);
            encryptedReq.setSignaturePo(headers);

            System.out.println("encryptedReq:"+encryptedReq);
            return JSON.toJSONString(encryptedReq);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";

    }


    /**
     * @param json  请求JSON
     * @param nonce  10位不重复的数
     * @return
     */
    public static  String getSignatue(String json,String nonce) {

        try {
            key = key.substring(0, 16);
            String encrypt = AESOperator.getInstance().encrypt(json, key);

            System.out.println("encrypt:"+encrypt);
            SignaturePo headers = new SignaturePo();
            headers.setApiId(api);
            headers.setTimestamp(String.valueOf(System.currentTimeMillis()));
            headers.setNonce(nonce);
            String sigString = createSignature(headers.getTimestamp(), headers.getNonce(), headers.getApiId(), appsecret, json);
            System.out.println("sigString:"+sigString);
            headers.setSignature(sigString);
            EncryptedPo<ReqOrderPo> encryptedReq = new EncryptedPo<ReqOrderPo>();
            encryptedReq.setEncryptedData(encrypt);
            encryptedReq.setSignaturePo(headers);

            System.out.println("encryptedReq:"+encryptedReq);
            return JSON.toJSONString(encryptedReq);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";

    }


    /**
     * 生成签名
     * @param timestamp
     * @param nonce
     * @return
     */
    public static String createSignature( String timestamp, String nonce,String appid,String appsecret,String reqJson) {
        String[] arr = new String[] { appsecret, timestamp, nonce, appid,reqJson};
        // 将 appsecret, timestamp, nonce, appid 参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将参数字符串拼接成一个字符串进行 sha1 加密
            byte[] digest = md.digest(content.toString().getBytes());

            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return tmpStr;
    }

    /**
     * 将字节数组转换为十六进制字符串
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }
    /**
     * 将字节转换为十六进制字符串
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }


}
