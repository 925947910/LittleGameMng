package com.cointer.service;

import org.springframework.stereotype.Service;



@Service
public interface ICoinInfoService   {

	Object unFreeze(String RequestJsonData) throws Exception;

	Object freezeList(String RequestJsonData) throws Exception;

	Object billsList(String RequestJsonData) throws Exception;



	
}
