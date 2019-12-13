package com.cointer.pojo.dto;

import com.cointer.pojo.po.gameUser;

public class loginUserDto extends gameUser {
	private Integer presenterId;
	private String  token;
	private String  platName;
	public Integer getPresenterId() {
		return presenterId;
	}

	public void setPresenterId(Integer presenterId) {
		this.presenterId = presenterId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPlatName() {
		return platName;
	}

	public void setPlatName(String platName) {
		this.platName = platName;
	}
	

}
