package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IGameTaskService {

	Object taskInfo(String RequestJsonData) throws Exception;

	Object getRewards(String RequestJsonData) throws Exception;

}
