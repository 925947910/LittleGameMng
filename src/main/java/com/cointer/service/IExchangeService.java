package com.cointer.service;



import org.springframework.stereotype.Service;

import com.cointer.pojo.dto.chargeCallBack1Dto;



@Service
public interface IExchangeService   {


	

	Object chargeOrder(String RequestJsonData) throws Exception;

	Object extractOrder(String RequestJsonData) throws Exception;

	void chargeCallBack(chargeCallBack1Dto chargeCallBack1Dto)throws Exception;
	void extractCallBack(int status, String resultData, String remoteSign) throws Exception;

	Object verifyExtract(String RequestJsonData) throws Exception;

	
	

	
}
