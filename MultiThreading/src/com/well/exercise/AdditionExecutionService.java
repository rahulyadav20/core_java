package com.well.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AdditionExecutionService {
	
	public static void main(String args[]){
		
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Future<Integer>> resultList = new ArrayList<>();
		
		for(int i=0; i < 500 ; i++){
			
			Callable<Integer> callable;
			if(i%2 == 0){
				callable =  new WorkerThread(2,2, "threadName :"+ i);	
			}else{
				callable =  new WorkerThread(3,2, "threadName :"+ i);
			}
			 
			 Future<Integer> future = executor.submit(callable);
			 resultList.add(future);			
		}
		
		int  i = 0;
		for(Future<Integer> future : resultList){
			try {
				
				i++;
				int result = future.get();
				System.out.println("********** Printing the result *************");
				System.out.println("result value of "+i + ":" + result);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
		
	}

}
