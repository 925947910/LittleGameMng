package com.cointer.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cointer.service.impl.RouletteService;
@Service
@Scope("prototype")
public class RouletteDraw extends Thread{  
	@Autowired
	RouletteService RouletteService;
	private int uid=0;
	

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}




	public void run() {  
		RouletteService.draw(this.uid);
		
    }  
}  