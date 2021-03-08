package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IRedGreenBallService {
	Object  laidList(String RequestJsonData) throws Exception;
	Object  laid(String paramJson) throws Exception;
	Object notice(String RequestJsonData) throws Exception;
}
