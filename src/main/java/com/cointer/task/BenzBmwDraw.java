package com.cointer.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service
@Scope("prototype")
public class BenzBmwDraw extends Thread{  
	
	String jsonData;
	@Autowired
	SchedulingBenzBmw SchedulingBenzBmw;
	
    public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public void run() {  
		SchedulingBenzBmw.draw();
		
    }  
}  