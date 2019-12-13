package com.cointer.service;

public interface IMineralService {

	Object getMineral(String RequestJsonData) throws Exception;
	
	Object mineralBillsList(String RequestJsonData) throws Exception;


	Object useMineralCode(String RequestJsonData) throws Exception;

	Object presenterMembers(String RequestJsonData) throws Exception;

	Object digMineral(String RequestJsonData) throws Exception;

}
