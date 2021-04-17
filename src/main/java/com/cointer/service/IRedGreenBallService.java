package com.cointer.service;



import org.springframework.stereotype.Service;



@Service
public interface IRedGreenBallService {

	Object winRec(String RequestJsonData) throws Exception;

	Object notice(String RequestJsonData) throws Exception;

	Object historyIssue(String RequestJsonData) throws Exception;

	Object currIssue(String RequestJsonData) throws Exception;

	Object betRec(String RequestJsonData) throws Exception;

	Object bet(String RequestJsonData) throws Exception;

}
