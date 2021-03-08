package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IUserService {
	Object  addPhoto(String paramJson) throws Exception;
	Object  regist(String RequestJsonData) throws Exception;
	Object  login(String RequestJsonData) throws Exception;
	Object write(String RequestJsonData) throws Exception;
}
