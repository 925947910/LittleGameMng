package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IExchangeService   {

	Object charge(String param)throws Exception;


	Object orderInfo(String param)throws Exception;

	
}
