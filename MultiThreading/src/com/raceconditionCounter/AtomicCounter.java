package com.raceconditionCounter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
	
	private AtomicInteger c = new AtomicInteger(0);

	    public int increment() {
	        return c.incrementAndGet();
	    }

	    public int decrement() {
	       return c.decrementAndGet();
	    }

	    public int value() {
	        return c.get();
	    }

}
