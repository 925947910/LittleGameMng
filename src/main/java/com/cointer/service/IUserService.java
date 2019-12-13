package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IUserService {
	Object  registOrLogin(String paramJson) throws Exception;
	Object  addPhoto(String paramJson) throws Exception;
}
