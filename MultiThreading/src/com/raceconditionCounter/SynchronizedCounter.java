package com.raceconditionCounter;

public class SynchronizedCounter {
	/**
	 * Making methods synchronised can still print unexpected results, because
	 * T1 after calling increment() can be preemted and release lock, lock now
	 * will be aquired by T2 which will call decrement(), after this now when T1
	 * again gets lock it calls value() which will now print 0 insteed of 1. 
	 * To overcome this we will have to make call to increment() and value() atomic,
	 * this can be done by calling these methodds after taking lock on object 
	 * e.g. synchronised(object){increment();value();} 
	 * 
	 * then how syncronisation prevents raceCondition?? race condition is
	 * prevented beacause T1 and T2 both at a time can not call decrement() and
	 * increment() methods on class. So before any of these method is called
	 * state of C is guranteed to be consistent.
	 * 
	 * 
	 */

	private int c = 0;

	public synchronized void increment() {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public synchronized int value() {
		return c;
	}

}
