package com.cointer.util;  
  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cointer.controller.base.BaseController;

import sun.misc.BASE64Encoder;  
  
/**  
 * 生成Token的工具类  
 *  
 */  
public class TokenMaker {  
      
     private TokenMaker(){};  
     private static final TokenMaker instance = new TokenMaker();  
 	private static final Logger log = LoggerFactory.getLogger(TokenMaker.class);   
    public static TokenMaker getInstance() {  
        return instance;  
    }  
  
    /**  
     * 生成Token  
     * @return  
     */  
    public String makeToken() {  
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";  
         try {  
            MessageDigest md = MessageDigest.getInstance("md5");  
            byte md5[] =  md.digest(token.getBytes());  
            BASE64Encoder encoder = new BASE64Encoder();  
            return encoder.encode(md5);  
        } catch (NoSuchAlgorithmException e) {  
            // TODO Auto-generated catch block  
        	log.error("", e);
        }  
         return null;  
    }  
}  