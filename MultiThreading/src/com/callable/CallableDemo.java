package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class CallableDemo {
 
	public static void main(String[] args){

		ExecutorService executorService = new ScheduledThreadPoolExecutor(5);

		Future future = executorService.submit(new Callable(){
		    public Object call() throws Exception {
		        System.out.println("Asynchronous Callable");
		        Thread.sleep(9999);
		        return "Callable Result";
		    }
		});

		try {
			System.out.println("future.get() = " + future.get());
			System.out.println("get executed");
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
