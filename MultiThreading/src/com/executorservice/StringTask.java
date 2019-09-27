package com.executorservice;

import java.util.concurrent.Callable;

public class StringTask implements Callable<String>{
	
	int waitTime = 0;
	String threadName;
	public StringTask(int waitTime, String threadName){
		this.waitTime = waitTime;
		this.threadName = threadName;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
		return "Worker Thread:" + threadName;
	}
}	
