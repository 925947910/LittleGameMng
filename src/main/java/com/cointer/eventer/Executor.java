package com.cointer.eventer;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cointer.interceptor.LoginInterceptor;





@Component
@Scope("prototype")
public class Executor implements Runnable{
	private Thread thread;
	private int _id;
//	private final Queue<Runnable>		updateHandleList		= new LinkedList<Runnable>();
	private final ArrayList<ExecutorHandle>		HandleList		= new ArrayList<ExecutorHandle>();

	
	private int  handleIndex=0; 
	
	volatile boolean			_active			= false;


	private Logger logger=LoggerFactory.getLogger(Executor.class);
	
//	public Executor(int id) {
//		this._id = id;
//	}
	public void setId(int id) {
		this._id = id;
	}

	public synchronized void start() {
		if (_active) return;
		thread = new Thread(this, this._id + "");
		thread.start();
		_active = true;
	}
	
	private void handleTask() {
		if (HandleList.size() > 0) {
			ExecutorHandle tem = null;
			synchronized (HandleList) {
				tem = HandleList.get(handleIndex);
			}
			if (tem == null){
				return;
			}
			tem.handle(_id);	
			if(handleIndex+1>=HandleList.size()){
				handleIndex=0;
			}else{
				handleIndex+=1;	
			}
		}
		
	}
	
	public void run() {
		while (_active) {
			try { 
				 handleTask();
			} catch (Throwable t) {
				logger.error("",t);
				this.logger.warn("[" + this._id + "] ******************************* thread exception!");
			}
		}
	}
	
	
	public void enqueueHandle(ExecutorHandle handle) {
		if (!_active)return;
		if (handle == null)return;
		synchronized (HandleList) {
			HandleList.add(handle);
		}
	}
}
