package com.well.exercise;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadWait {

	public void makeMeWait(){
		
		try {
			wait();
			System.out.println("done waiting");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		
		ThreadWait obj = new ThreadWait();
		
		obj.makeMeWait();
		
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.submit(new MyCallableWorker());
		executor.submit(new MyRunnableWorker());
		System.out.println("Execution finish");
		
	}
	
	
	
	
}

class MyRunnableWorker implements Runnable{

	@Override
	public void run() {
		throw new NullPointerException();
		
	}
	
}

class MyCallableWorker implements Callable{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		throw new NullPointerException();
	}

	
	
}
