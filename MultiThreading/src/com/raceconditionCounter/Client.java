package com.raceconditionCounter;

public class Client {
	

	public static void main(String args[]){
		SynchronizedCounter counter = new SynchronizedCounter();
		Runnable1 runnable1 = new Runnable1(counter);
		Runnable2 runnable2 = new Runnable2(counter);
		
		Thread myThread1 = new Thread(runnable1);
		Thread myThread2 = new Thread(runnable2);
		Thread myThread3 = new Thread(runnable1);
		
		myThread1.start();		
		myThread2.start();
		myThread3.start();
		
			
	}

}
