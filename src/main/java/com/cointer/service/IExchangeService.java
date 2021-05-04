package com.cointer.service;



import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;



@Service
public interface IExchangeService   {


	

	Object chargeOrder(String RequestJsonData) throws Exception;

	Object extractOrder(String RequestJsonData) throws Exception;

	Object verifyExtract(String RequestJsonData) throws Exception;

	
	

	
}
