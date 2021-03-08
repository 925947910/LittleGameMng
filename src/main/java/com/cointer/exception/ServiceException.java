package com.cointer.exception;

import java.util.Map;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int code;
	private Map<String, Object> paraMap;
	private String msg;
	
	public ServiceException(int code,String msg, Map<String, Object> paraMap) {
		super();
		this.code = code;
		this.paraMap = paraMap;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Map<String, Object> getParaMap() {
		return paraMap;
	}
	public void setParaMap(Map<String, Object> paraMap) {
		this.paraMap = paraMap;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
