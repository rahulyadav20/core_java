package com.raceconditionCounter;

public class AtomicRunnable2 implements Runnable{

	private AtomicCounter counter;
	
	public AtomicRunnable2(AtomicCounter counter){
		this.counter = counter;
	}
	
	public void run() {
		
		System.out.println("Runnable2 decrement counter value :: "+counter.decrement());		
	}

}
