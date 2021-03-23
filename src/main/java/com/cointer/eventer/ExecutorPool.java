package com.cointer.eventer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("ExecutorPool")
public class ExecutorPool {
	public Map<Integer,Executor> _poolMap=new HashMap<Integer,Executor>();
	
	public void addExecutor(int Key,Executor executor){
		this._poolMap.put(Key, executor);
	}
	
	public void enqueueHandle(int id,ExecutorHandle handle) {
		Executor executor =  this._poolMap.get(id);
		if(executor==null)return;
		if(!executor._active) {
			executor.start();
		}
		executor.enqueueHandle(handle);
	}
	
	public synchronized void stop() {
		Collection<Executor> list = this._poolMap.values();
		for(Executor executor : list) {
			executor._active = false;
		}
		this._poolMap.clear();
	}
}
