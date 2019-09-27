package com.interthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterThreadWithLocks {
	/**
	 * InterThread communication using await/signal and locks, condition
	 * variable.
	 * Resource does not have threadsafe methods.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Lock lock = new ReentrantLock();
		Condition cv = lock.newCondition();

		sharedResource resource = new sharedResource();
		ThreadProducer b = new ThreadProducer(resource, lock, cv);
		ThreadConsumer d = new ThreadConsumer(resource, lock, cv);
		b.start();
		d.start();

		System.out.println("total is :: " + resource.total);
	}
}

class ThreadProducer extends Thread {
	int total = 0;
	sharedResource resource;
	Lock lock;
	Condition cv;

	public ThreadProducer(sharedResource resource) {
		this.resource = resource;
	}

	public ThreadProducer(sharedResource resource, Lock lock, Condition cv) {
		this.resource = resource;
		this.lock = lock;
		this.cv = cv;
	}

	public void run() {
		lock.lock();
		try {
			System.out.println("increment total");
			while (true) {
				System.out.println("increment total while true");
				if (resource.total >= 1) {
					try {
						System.out.println("increment waiting");
						cv.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					resource.total += 1;
					System.out.println("incremented resource value::"
							+ resource.total);
					cv.signal();
				}
			}
		} finally {
			lock.unlock();
		}
	}

}

class ThreadConsumer extends Thread {

	sharedResource resource;
	Lock lock;
	Condition cv;

	public ThreadConsumer(sharedResource resource) {
		this.resource = resource;
	}

	public ThreadConsumer(sharedResource resource, Lock lock, Condition cv) {
		this.resource = resource;
		this.lock = lock;
		this.cv = cv;
	}

	public void run() {
		lock.lock();
		try {
			System.out.println("decerement total");

			while (true) {
				System.out.println("decerement total while true");
				if (resource.total >= 1) {
					resource.total -= 1;
					System.out.println("deceremented resource value::"
							+ resource.total);
					cv.signal();
				} else {
					try {
						System.out.println("decerement waiting");
						cv.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} finally {
			lock.unlock();
		}
	}
}
