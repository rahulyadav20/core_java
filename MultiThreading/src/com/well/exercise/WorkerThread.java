package com.well.exercise;

import java.util.concurrent.Callable;

public class WorkerThread implements Callable<Integer>{
	
	int a;
	int b;
	String threadName;
	
	public WorkerThread(int a, int b, String threadName){
		this.a = a;
		this.b = b;
		this.threadName = threadName;
	}

	@Override
	public Integer call() throws Exception {
		
		Thread.currentThread().setName(threadName);
		
		if(a%2 != 0){
			Thread.sleep(9999);
		}
			
		Integer result = a+b;
		//System.out.println(Thread.currentThread().getName() + "::" + result);
		return result;
	}
	
}
