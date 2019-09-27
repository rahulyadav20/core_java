package com.raceconditionCounter;

public class AtomicClient {
	public static void main(String args[]) {
		AtomicCounter counter = new AtomicCounter();
		AtomicRunnable1 runnable1 = new AtomicRunnable1(counter);
		AtomicRunnable2 runnable2 = new AtomicRunnable2(counter);

		Thread myThread1 = new Thread(runnable1);
		Thread myThread2 = new Thread(runnable2);
		Thread myThread3 = new Thread(runnable1);

		myThread1.start();
		myThread3.start();
		myThread2.start();
		
		

	}

}
