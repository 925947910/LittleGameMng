package com.cointer.service;



import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cointer.pojo.dto.chargeCallBack1Dto;



@Service
public interface IExchangeService   {


	

	Object chargeOrder(String RequestJsonData) throws Exception;

	Object extractOrder(String RequestJsonData) throws Exception;

	void chargeCallBack(JSONObject reqData)throws Exception;
	void extractCallBack(JSONObject reqData) throws Exception;

	Object verifyExtract(String RequestJsonData) throws Exception;

	
	

	
}
