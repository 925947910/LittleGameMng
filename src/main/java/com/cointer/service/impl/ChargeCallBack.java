package com.cointer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class ChargeCallBack extends Thread{  
	
	String jsonData;
	@Autowired
	ExchangeService ExchangeService;
	
    public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}


	public void run() {  
		ExchangeService.Charge(jsonData);
    }  
}  