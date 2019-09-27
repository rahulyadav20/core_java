package com.raceconditionCounter;

public class Runnable1 implements Runnable{
	private SynchronizedCounter counter;
	
	public Runnable1(SynchronizedCounter counter){
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.increment();
		System.out.println("Runnable1 counter value :: "+counter.value());		
	}

}
