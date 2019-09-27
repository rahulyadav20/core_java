package com.executorservice;

import java.util.concurrent.Callable;

class WorkerThread implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "Worker Thread";
	}	
}
