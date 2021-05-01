package com.cointer.util.tikPay;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import okio.ByteString;

import java.nio.charset.Charset;

public class AESOperator {
    /*
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
     */
    private String KEY = "!QA2Z@w1sxO*(-8L";
    private String VECTOR = "!WFNZFU_{H%M(S|a";
    private static AESOperator instance = null;

    private AESOperator() {

    }
    public   String basic(String appId, String appsecret) {
        String usernameAndPassword = appId + ":" + appsecret;
        byte[] bytes = usernameAndPassword.getBytes(Charset.forName("ISO-8859-1"));
        String encoded = ByteString.of(bytes).base64();
        return "Basic " + encoded;
    }



    public static AESOperator getInstance() {
        return Nested.instance;
    }

    //于内部静态类只会被加载一次，故该实现方式时线程安全的！
    static class Nested {
        private static AESOperator instance = new AESOperator();
    }

    /**
     * 加密
     *
     * @param content
     * @return
     * @throws Exception
     */
 /*   public String encrypt(String content) throws Exception {
        return encrypt(content, KEY, VECTOR);
    }*/

    /**
     * 加密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public String encrypt(String content, String key) throws Exception {
        return encrypt(content, key, VECTOR);
    }

    /**
     * 加密
     *
     * @param content
     * @param key
     * @param vector
     * @return
     * @throws Exception
     */
    public String encrypt(String content, String key, String vector) throws Exception {
        if (key == null) {
            return null;
        }
        if (key.length() != 16) {
            return null;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes("UTF-8"));
        return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
    }

  /*  *//**
     * 解密
     *
     * @param content
     * @return
     * @throws Exception
     *//*
    public String decrypt(String content) throws Exception {
        return decrypt(content, KEY, VECTOR);
    }*/

    /**
     * 解密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public String decrypt(String content, String key) throws Exception {
        return decrypt(content, key, VECTOR);
    }

    /**
     * 解密
     *
     * @param content
     * @param key
     * @param vector
     * @return
     * @throws Exception
     */
    public String decrypt(String content, String key, String vector) throws Exception {
        try {
            if (key == null) {
                return null;
            }
            if (key.length() != 16) {
                return null;
            }
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            IvParameterSpec iv = new IvParameterSpec(vector.getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(content);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "UTF-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
     /*   // 需要加密的字串
        String cSrc = "我爱你";

        // 加密
        long lStart = System.currentTimeMillis();
        String enString = AESOperator.getInstance().encrypt(cSrc, "!QA2Z@w1sxO*(-8L");
        System.out.println("加密后的字串是：" + enString);

        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("加密耗时：" + lUseTime + "毫秒");
        // 解密
        lStart = System.currentTimeMillis();*/
        String DeString =
AESOperator.getInstance().decrypt("SDauNtKOXEdVexgj2LFLMk+Qnuv09WXOv1wNoi+Z4nMxSv/SOsNDBfPBVKu9Wdm2YVrSbovtdSkr\n" +
        "GkeEP5mvNgpdXxLhXUrbAqWHYDrbK2g=","67d1e236b23d9a1037574000edaf2d4f".substring(0,16));
        System.out.println("解密后的字串是：" + DeString);
      /*  lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("解密耗时：" + lUseTime + "毫秒");*/

    }
}