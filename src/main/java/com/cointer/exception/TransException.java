package com.cointer.exception;



public class TransException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String msg;

	public TransException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}


}
