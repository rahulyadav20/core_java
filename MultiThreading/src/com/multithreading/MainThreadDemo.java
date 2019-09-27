package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainThreadDemo {
	
	public static void main(String args[]){
		
		System.out.println("Starting main Thread");
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
				
		/*If we dont use join main thread will continue and 
		 * come to end irrespective of child thread state.*/
		/* 
		  try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Thread callableThread = new Thread(new MyCallableAndRunnable());
		callableThread.start();//Runnable run() will be called. 
		//Callable can not be passed to Thread constructor.
		
		System.out.println("Starting FutureTask demo");
		FutureTask<String>  futureTask = new FutureTask(new MyCallable());
		Thread t3 = new Thread(futureTask);
		t3.start();
		String result="";
		try {
			result = futureTask.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Future Task Result:: "+ result);
		
		System.out.println("End main Thread");
	}
}


class MyRunnable implements Runnable{
	
	public void run(){
		
		System.out.println("Starting child thread");
		
		try {
			System.out.println("Thread going to sleep");
			Thread.sleep(1000);
			System.out.println("Thread awake");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End child thread");
	}
}

class MyCallableAndRunnable implements Callable, Runnable{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting child thread with Callable");
		Thread.sleep(1000);
		System.out.println("End child thread with Callable");
		return "Rahul";
	}

	@Override
	public void run() {
		System.out.println("Calling run");
		
	}
}

class MyCallable implements Callable{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting child thread with Callable");
		Thread.sleep(1000);
		System.out.println("End child thread with Callable");
		return "Rahul";
	}
}

