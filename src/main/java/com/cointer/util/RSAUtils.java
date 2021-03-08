package com.cointer.util;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cointer.controller.base.BaseController;

import sun.misc.BASE64Decoder;

//import sun.misc.*;
import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

/**
 * Created by wenbo
 * RSA类
 */
public class RSAUtils {
    public static final String CHARSET = "UTF-8";
    public static final String RSA_ALGORITHM = "RSA";
    public static String publicKeys = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDG8Pq1rECl2RZOoEzH8fN4LZPTFWDsR5TEl6OSLDM8nQFulqTyT5Ee-2iaF3jpNqvk7i0xE-HhZZelV-swaY4xfHIYjBTlVYulXlBKo7oglE8oCSvEoKIywspXkvhEilnR7sNW504ZE0N4xN_hOysIHpUcxcgg3KO0JTKcTm-AvwIDAQAB";
    public static String privateKeys = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMbw-rWsQKXZFk6gTMfx83gtk9MVYOxHlMSXo5IsMzydAW6WpPJPkR77aJoXeOk2q-TuLTET4eFll6VX6zBpjjF8chiMFOVVi6VeUEqjuiCUTygJK8SgojLCyleS-ESKWdHuw1bnThkTQ3jE3-E7KwgelRzFyCDco7QlMpxOb4C_AgMBAAECgYA-tvESHH80yT7TAo2x6oBKPnP_cxne4qHvZ65VAkIUtZoh9rOA_7xL_A15pjSjsGx3-u2cLxxiJdiscw7dcCk2uaWiqLI95_SdzSFmSW6Y01JLDqFcgXAPjYLkXxevJEehh2BlXZed2UcVWzbD2vmJIHgmYEZY6HN1jxJUcjd8YQJBAPYntptQKJ5wZ6FVbfGUuVwt6fXBjP6PFL_jxPIM0duHMwDXdfLveHh9XWJd4t_kdO6per2fIS9r_4RyGZV5BS0CQQDO5dy7bRM6OPVA4XFamr5hFLkIms0Vpts6h_sJQIW3UD59SYvT8T7m8VgSm8dRizho9AYMKniUO4v0K5NejukbAkBzFT4afu9-o67PjtFIEPBYWF75tvPkT6Cz1hlN0RCMQjlmO1W5rpv0OShfxOU9J-JDcpkf7jXlpehgU7gCWgJBAkBwfsdAGZSkyaeAeZQawZzWSGA7b4AnT6xP7PPwGecav0Ta9oxS1w9unrdWluEPU3V-i4BmSQl6_82fG7prZaUVAkBUpJtX8oc576zU4OMnNm_mbOKvsyihjVJiKZha9_8NCQk-OW99Vgzffpqh3fN4bp9GkHFhzH6Vra7u-xZHW5wz";
	private static final Logger log = LoggerFactory.getLogger(RSAUtils.class);

    public static Map<String, String> createKeys(int keySize) {
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try {
            kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
        }

        //初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(keySize);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        Map<String, String> keyPairMap = new HashMap<String, String>();
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);

        return keyPairMap;
    }

    /**
     * 得到公钥
     *
     * @param publicKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }

    /**
     * 得到私钥
     *
     * @param privateKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }

    /**
     * 公钥加密
     *
     * @param data
     * @param publicKey
     * @return
     */
    public static String publicEncrypt(String data, RSAPublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), publicKey.getModulus().bitLength()));
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * 私钥解密
     *
     * @param data
     * @param privateKey
     * @return
     */

    public static String privateDecrypt(String data, RSAPrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), privateKey.getModulus().bitLength()), CHARSET);
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }


    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize) {
        int maxBlock = 0;
        if (opmode == Cipher.DECRYPT_MODE) {
            maxBlock = keySize / 8;
        } else {
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try {
            while (datas.length > offSet) {
                if (datas.length - offSet > maxBlock) {
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                } else {
                    buff = cipher.doFinal(datas, offSet, datas.length - offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        } catch (Exception e) {
            throw new RuntimeException("加解密阀值为[" + maxBlock + "]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        IOUtils.closeQuietly(out);
        return resultDatas;
    }


    /**
     * 私钥生成签名
     *
     * @param data
     * @param priKeyStr
     * @return
     */
    public static String priKeyGenSign(String data, String priKeyStr) {
        byte[] dataByte = data.getBytes();
        PrivateKey priKey = null;
        try {
            priKey = getPrivateKey(priKeyStr);
        } catch (Exception e) {
        	log.error("", e);
        }
        // 用私钥生成签名
        byte[] dataSign = null;
        try {
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(priKey);
            signature.update(dataByte);
            dataSign = signature.sign();
        } catch (Exception e) {
        	 log.error("", e);
        }
        return Base64.encodeBase64String(dataSign);
    }


    /**
     * 公钥验证签名
     *
     * @param data
     * @param sign
     * @param pubKeyStr
     * @return
     */
    public static boolean pubKeyVerSign(String data, String sign, String pubKeyStr) {
        byte[] signArr = null;
        PublicKey pubKey = null;
        byte[] dataByte = data.getBytes();
        try {
            pubKey = getPublicKey(pubKeyStr);
            signArr = new BASE64Decoder().decodeBuffer(sign);
        } catch (Exception e) {
        	log.error("", e);
        }
        Signature signature = null;
        boolean flag = false;
        try {
            signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(dataByte);
            flag = signature.verify(signArr);
        } catch (Exception e) {
        	 log.error("", e);
        }
        // 验证签名是否正常
        return flag;
    }


    /**
     * 私钥生成签名
     *
     * @param object
     * @param priKeyStr
     * @return
     */
    public static String objectPriKeyGenSign(Object object, String priKeyStr) {
        String data = getStringFromObject(object);
        byte[] dataByte = data.getBytes();
        PrivateKey priKey = null;
        try {
            priKey = getPrivateKey(priKeyStr);
        } catch (Exception e) {
        	log.error("", e);
        }
        // 用私钥生成签名
        byte[] dataSign = null;
        try {
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(priKey);
            signature.update(dataByte);
            dataSign = signature.sign();
        } catch (Exception e) {
           log.error("", e);
        }
        return Base64.encodeBase64String(dataSign);
    }


    /**
     * 公钥验证签名
     *
     * @param object
     * @param sign
     * @param pubKeyStr
     * @return
     */
    public static boolean objectpubKeyVerSigns(Object object, String sign, String pubKeyStr) {

        String data = getStringFromObject(object);

        byte[] signArr = null;
        PublicKey pubKey = null;
        byte[] dataByte = data.getBytes();
        try {
            pubKey = getPublicKey(pubKeyStr);
            signArr = new BASE64Decoder().decodeBuffer(sign);
        } catch (Exception e) {
        	log.error("", e);
        }
        Signature signature = null;
        boolean flag = false;
        try {
            signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(dataByte);
            flag = signature.verify(signArr);
        } catch (Exception e) {
        	 log.error("", e);
        }
        // 验证签名是否正常
        return flag;
    }

    private static String getStringFromObject(Object object) {
        StringBuilder sbParam = new StringBuilder();
        try {
            //使用sortmap排序
            Map<String, String> sortMap = new TreeMap<String, String>();

            List<Field> fields = new ArrayList<>();
            Class<?> clazz = object.getClass();
            while (clazz != null && clazz != Object.class) {
                fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
                clazz = clazz.getSuperclass();
            }

            for (Field field : fields) {
                if (field.getName().equals("serialVersionUID") || field.isAnnotationPresent(NoSignParam.class)) {
                    continue;
                }
                field.setAccessible(true);
                Object value = field.get(object);
                sortMap.put(field.getName(), value == null ? "" : String.valueOf(value));
            }



            //拼接成k1=v1&k2=v2，如果value为空则不参与拼接
            for (Map.Entry<String, String> item : sortMap.entrySet()) {
                if (!StringUtils.isBlank(item.getKey())) {
                    if (0 < sbParam.length()) {
                        sbParam.append("&");
                    }
                    if (!StringUtils.isBlank(item.getValue())) {
                        sbParam.append(item.getKey()).append("=").append(item.getValue());
                    }
                }
            }
        } catch (Exception e) {
        	log.error("", e);
            return "error";
        }
        return sbParam.toString();
    }


    public static void main(String[] args) throws Exception {
        /*Map<String,String> a1=createKeys(1024);
        System.out.println(a1);
        System.out.println("公钥: \n\r" + RSAUtils.getPublicKey(publicKeys));
        System.out.println("私钥： \n\r" + RSAUtils.getPrivateKey(privateKeys));

        System.out.println("公钥加密——私钥解密");
        String str = "hello";
        System.out.println("\r明文：\r\n" + str);
        System.out.println("\r明文大小：\r\n" + str.getBytes().length);
        String encodedData = RSAUtils.publicEncrypt(str, RSAUtils.getPublicKey(publicKeys));
        System.out.println("密文：\r\n" + encodedData);
        String decodedData = RSAUtils.privateDecrypt(encodedData, RSAUtils.getPrivateKey(privateKeys));
        System.out.println("解密后文字: \r\n" + decodedData);*/
        String str = "hello";
        String a = priKeyGenSign(str, privateKeys);
        System.out.println(a);

      /*  boolean v = pubKeyVerSign(str,a,publicKeys);
        System.out.println(v);*/


    }
}
