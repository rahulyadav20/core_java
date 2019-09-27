package com.raceconditionCounter;

public class Runnable2 implements Runnable{

	private SynchronizedCounter counter;
	
	public Runnable2(SynchronizedCounter counter){
		this.counter = counter;
	}
	
	public void run() {
		counter.decrement();
		System.out.println("Runnable2 counter value :: "+counter.value());		
	}

}
