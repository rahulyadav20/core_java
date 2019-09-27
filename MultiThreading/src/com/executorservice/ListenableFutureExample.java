package com.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.well.exercise.WorkerThread;

public class ListenableFutureExample {
	
	public static void main(String args[]){
		
		
		ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
		
		
		List<ListenableFuture<Integer>> resultList = new ArrayList<>();
		AdditionFutureCallback futureCallBack = new AdditionFutureCallback(new StatusBar());
		Executor executor = Executors.newCachedThreadPool();
		
		for(int i=0; i < 3 ; i++){
			
			Callable<Integer> callable;
			if(i%2 == 0){
				callable =  new WorkerThread(2,2, "threadName :"+ i);	
			}else{
				callable =  new WorkerThread(3,2, "threadName :"+ i);
			}
			 
			final ListenableFuture<Integer> future = pool.submit(callable);
			resultList.add(future);	
			
			
			
			Futures.addCallback(future, futureCallBack, executor);
		}
		
		pool.shutdown();
	}

}


class AdditionFutureCallback implements FutureCallback<Integer>{
	
	StatusBar statusBar;
	
	public AdditionFutureCallback(StatusBar statusBar){
		this.statusBar = statusBar;
	}

	@Override
	public void onFailure(Throwable arg0) {
		System.out.println("failed");
		statusBar.cancelTask();
		
	}

	@Override
	public void onSuccess(Integer content) {
	     System.out.println("Success result ::"+ content);
	     statusBar.updateStatus();
		
	}
	
	
}

class StatusBar{
	 Integer status;
	 
	 public StatusBar(){
		 status = 0;
	 }
	 
	 public void updateStatus(){
		 status++;
	     System.out.println("Status bar completed % "+ status);
	 }
	 
	 public void cancelTask(){
		 status= 0;
		 System.out.println("Status Bar Task cancelled.");
	 }
	
	
	
}

