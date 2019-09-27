package com.string;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample {
	
	public static void main(String args[]){
		
		AtomicInteger i = new AtomicInteger();
		System.out.println(i.incrementAndGet());
		
		
		AtomicReference<Double> partPrice = new AtomicReference<Double>(12.4d);
		partPrice.compareAndSet(12.4d, 14d);
		System.out.println(partPrice);
		
		
	}

}
