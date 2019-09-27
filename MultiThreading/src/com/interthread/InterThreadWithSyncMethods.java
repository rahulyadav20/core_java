package com.interthread;

class ThreadSafeResource {
	int i=0;

	public synchronized int incrementI() {
		
		if(i >= 1){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		i += 1;
		notify();
		return i;
	}

	public synchronized int decrementI() {
		if(i <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		i -= 1;
		notify();
		return i;
	}
	
	public synchronized int getResourceValue(){
		return i;
	}
	
	
}

class ProducerThread extends Thread {
	ThreadSafeResource resource;

	public ProducerThread(ThreadSafeResource resource) {
		this.resource = resource;
	}

	public void run() {
		while (true) {
			System.out.println("Produced value ::" + resource.incrementI());
		}

	}
}

class ConsumerThread extends Thread {
	ThreadSafeResource resource;

	public ConsumerThread(ThreadSafeResource resource) {
		this.resource = resource;
	}

	public void run() {
		while (true) {
			System.out.println("Consumed value :: " + resource.decrementI());
		}
	}
}

public class InterThreadWithSyncMethods {
	/**
	 * InterThread communication with ThreadSafe resource i.e. synchronised
	 * methods.
	 */

	public static void main(String args[]) {
		ThreadSafeResource sharedResource = new ThreadSafeResource();
		ProducerThread producer = new ProducerThread(sharedResource);
		ConsumerThread consumer = new ConsumerThread(sharedResource);
		producer.start();
		consumer.start();

	}

}
