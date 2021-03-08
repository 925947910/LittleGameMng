package com.cointer.pojo.dto;

import com.cointer.pojo.po.gameUser;

public class loginUserDto extends gameUser {
	
	private String  token;
	
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

}
