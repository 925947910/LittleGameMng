package com.cointer.controller.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.cointer.constant.StatusCode;
import com.cointer.exception.ServiceException;
import com.cointer.exception.TransException;
import com.cointer.service.impl.UserService;




public abstract class BaseController {
	@Autowired
	protected  HttpServletRequest  request;
	@Autowired
	protected  HttpServletResponse response;
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);
	
	public  String serviceRun(Object Service,String func,String param) {
		try {
			 Method method = null;
			 method = Service.getClass().getMethod(func,String.class);
			 Object resultParam = method.invoke(Service, param);
			return succ(StatusCode.SUCC, "", resultParam);
		}catch (InvocationTargetException e) {
			Throwable excpetion=e.getTargetException();
			Class<? extends Throwable> exceptionClass=excpetion.getClass();
			if(exceptionClass.equals(ServiceException.class)) {
				return failed(((ServiceException) excpetion).getCode(), ((ServiceException) excpetion).getMsg(), ((ServiceException) excpetion).getParaMap());
			}else if(exceptionClass.equals(TransException.class)){
				return failed(StatusCode.TRANS_ERROR, ((TransException) excpetion).getMsg(), null);
			}else {
				log.error("Error in Service:"+Service.getClass().getName()+"func:"+func, e);
				return failed(StatusCode.FAILED, "SystemException", null);
			}
		}catch (Exception e) {
			log.error("Error in Service:"+Service.getClass().getName()+"func:"+func, e);
			return failed(StatusCode.FAILED, "SystemException", null);
		}
		
	}
	
    public static String succ(int Code,String message,Object param ){
    	Map<String, Object>  result= new HashMap<String, Object>();
    	result.put("status", Code+"");
    	result.put("message", message);
    	result.put("param", param);
    	result.put("succ", true);
    	return JSON.toJSONString(result);
    }
    public static String failed(int Code,String message,Object param ){
    	Map<String, Object>  result= new HashMap<String, Object>();
    	result.put("status", Code+"");
    	result.put("message", message);
    	result.put("param", param);
    	result.put("succ", false);
    	return JSON.toJSONString(result);
    }
    
    
    
}