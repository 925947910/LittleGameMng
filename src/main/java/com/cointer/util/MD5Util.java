package com.cointer.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MD5Util {


    private static final String ALGORITH_NAME = "md5";
    private static final int HASH_ITERATIONS = 2159;
    public  static final String SALT = "keyinttoken2019&";
	private static final Logger log = LoggerFactory.getLogger(MD5Util.class);   
	
	/**
     * 参数名ASCII码从小到大排序（字典序）
     *
     * @param params
     * @return 例如：a=1005&c=190010002&d=1400000001
     */
    public static String paramsSort(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        List<String> paramKeys = new ArrayList<>(params.keySet());
        Collections.sort(paramKeys);
        Iterator<String> iterator = paramKeys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String val = params.get(key);
            if(StringUtils.isEmpty(val)){
            	continue;
            }
            sb.append("&").append(key).append("=").append(val);
        }
        String data = sb.toString();
        data = data.substring(1, data.length());
        return data;
    }
	
    /**
     * 获取String的MD5值
     *
     * @param info 字符串
     * @return 该字符串的MD5值
     */
    public static String getMD5(String info) {
        try {
            //获取 MessageDigest 对象，参数为 MD5 字符串，表示这是一个 MD5 算法（其他还有 SHA1 算法等）：
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //update(byte[])方法，输入原数据
            //类似StringBuilder对象的append()方法，追加模式，属于一个累计更改的过程
            md5.update(info.getBytes("UTF-8"));
            //digest()被调用后,MessageDigest对象就被重置，即不能连续再次调用该方法计算原数据的MD5值。可以手动调用reset()方法重置输入源。
            //digest()返回值16位长度的哈希值，由byte[]承接
            byte[] md5Array = md5.digest();
            //byte[]通常我们会转化为十六进制的32位长度的字符串来使用,本文会介绍三种常用的转换方法
            return bytesToHex(md5Array);
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static String bytesToHex(byte[] md5Array) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < md5Array.length; i++) {
            int temp = 0xff & md5Array[i];//TODO:此处为什么添加 0xff & ？
            String hexString = Integer.toHexString(temp);
            if (hexString.length() == 1) {//如果是十六进制的0f，默认只显示f，此时要补上0
                strBuilder.append("0").append(hexString);
            } else {
                strBuilder.append(hexString);
            }
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
//        System.out.println(MD5Util.getMD5("123456"));
        //3780055367974729
        // 原密码
        String plaintext = "151867036158110061HZ20190827170341248449955OXO1";
         plaintext = "123";
//        Random random = new Random();
//        StringBuilder sBuilder = new StringBuilder(16);
//        sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
//        int len = sBuilder.length();
//        if (len < 16) {
//            for (int i = 0; i < 16 - len; i++) {
//                sBuilder.append("0");
//            }
//        }
//        // 生成最终的加密盐
//        String salt = sBuilder.toString();
//        System.out.println(salt);


        // 获取加盐后的MD5值
        String ciphertext = getSaltMD5(plaintext, SALT);

//        System.out.println("加盐后MD5：" + ciphertext);
//        System.out.println("是否是同一字符串:" + getSaltverifyMD5(plaintext, ciphertext));
    }

    public static String encrypt(String data, String salt) {
        String newPassword = getSaltMD5(data, salt);
        return newPassword;
    }

    /**
     * @param str
     * @return
     */
    @SuppressWarnings("unused")
    private static String md5Hex(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return new String(new Hex().encode(digest));
        } catch (Exception e) {
        	log.error("", e);
            return "";
        }
    }


    /**
     * 加盐MD5加密
     *
     * @param data
     * @return
     */
    public static String getSaltMD5(String data, String salt) {
        // 生成一个16位的随机数
//        Random random = new Random();
        // 生成最终的加密盐
        data = md5Hex(data + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = data.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = data.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }


    /**
     * 验证加盐后是否和原文一致
     *
     * @param password 原数据
     * @param md5str   加盐后的字符串
     * @return
     */
    public static boolean getSaltverifyMD5(String password, String md5str) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5str.charAt(i);
            cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / 3] = md5str.charAt(i + 1);
        }
        String Salt = new String(cs2);
        return md5Hex(password + Salt).equals(String.valueOf(cs1));
    }


}
