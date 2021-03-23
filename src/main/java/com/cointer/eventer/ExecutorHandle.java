package com.cointer.eventer;

import org.springframework.stereotype.Component;

@Component
public interface ExecutorHandle {
	public void handle(int group);
	public long getS();
	public void setS(long s);

}
