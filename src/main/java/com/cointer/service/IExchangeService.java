package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IExchangeService   {

	Object chargeOrder(String param)throws Exception;

	Object extract(String param)throws Exception;

	Object orderInfo(String param)throws Exception;

	Object checkFreeze(String param)throws Exception;
	
}
