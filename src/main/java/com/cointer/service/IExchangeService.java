package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IExchangeService   {


	

	Object chargeOrder(String RequestJsonData) throws Exception;

	Object extractOrder(String RequestJsonData) throws Exception;

	void chargeCallBack(int status,String result,String sign)throws Exception;
	void extractCallBack(int status, String resultData, String remoteSign) throws Exception;

	Object verifyExtract(String RequestJsonData) throws Exception;

	
	

	
}
