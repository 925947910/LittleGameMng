package com.cointer.service;

import org.springframework.stereotype.Service;



@Service
public interface ICoinInfoService   {


	Object freezeList(String RequestJsonData) throws Exception;

	Object billsList(String RequestJsonData) throws Exception;

	Object personalInfo(String RequestJsonData) throws Exception;

	Object currCoin(String RequestJsonData) throws Exception;



	
}
