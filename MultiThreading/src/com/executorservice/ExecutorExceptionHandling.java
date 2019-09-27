package com.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorExceptionHandling {
	
	
	public static void main(String args[]){
		
		List<Future<? extends Object>> resultList = new ArrayList<>();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		
		//Demo Exception Handling.
		System.out.println("********************** Executor Exception Handling Demo ******************");
		for(int i=0;i<10;i++){
			
			resultList.add(executor.submit(new WorkerThread()));
		}
		
		resultList.add(executor.submit(new ExceptionThread()));
		resultList.add(executor.submit(new ExceptionThread()));
		
		for(Future result : resultList){
			try {
				result.get();
				//System.out.println("Printing result  "+result.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// Exception thrown by a worker thread(ManagerThread.Java), when we try to do future.get() we get ExecutionException.
				System.out.println("Worker thread has execpetion.");
				e.printStackTrace();
			}
		}
		
		System.out.println("All thread completed.");
		
		executor.shutdown();
	}
	

}

class ExceptionThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		throw new RuntimeException("ManagerException");
	}
	
}

