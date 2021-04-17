package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IBenzBmwService {
	

	Object initRoom(String paramJson) throws Exception;

	Object bet(String paramJson) throws Exception;

	Object draw(String paramJson) throws Exception;

	Object beBanker(String paramJson) throws Exception;

	Object fallBanker(String paramJson) throws Exception;



}
