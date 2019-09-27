package com.raceconditionCounter;

public class AtomicRunnable1 implements Runnable{
private AtomicCounter counter;
	
	public AtomicRunnable1(AtomicCounter counter){
		this.counter = counter;
	}

	@Override
	public void run() {		
		System.out.println("Runnable1 increment counter value :: "+counter.increment());		
	}
}
