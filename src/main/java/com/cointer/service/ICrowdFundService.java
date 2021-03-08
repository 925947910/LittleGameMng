package com.cointer.service;

import org.springframework.stereotype.Service;

@Service
public interface ICrowdFundService {

	Object currIssue(String RequestJsonData) throws Exception;

	Object historyIssue(String RequestJsonData) throws Exception;

	Object laid(String RequestJsonData) throws Exception;

	Object currBuy(String RequestJsonData) throws Exception;

}
