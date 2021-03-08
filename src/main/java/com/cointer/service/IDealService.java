package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IDealService {
	public   Object coinDeal(String  RequestJsonData) throws Exception ;
	public   Object extractPwd(String  RequestJsonData) throws Exception ;
	public   Object coinRecover(String RequestJsonData) throws Exception;
}
