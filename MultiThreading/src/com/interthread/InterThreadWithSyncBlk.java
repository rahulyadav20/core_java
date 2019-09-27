package com.interthread;

class sharedResource {
	/*
	 * Resource does not have threadsafe methods.
	 */
	int total = 0;
}

public class InterThreadWithSyncBlk {
	/**
	 * InterThread communication using wait/notify and synchronised block.
	 * Resource does not have threadsafe methods.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		sharedResource resource = new sharedResource();
		ThreadB b = new ThreadB(resource);
		ThreadD d = new ThreadD(resource);
		b.start();
		d.start();

		System.out.println("total is :: " + resource.total);
	}
}

class ThreadB extends Thread {
	int total = 0;
	sharedResource resource;

	public ThreadB(sharedResource resource) {
		this.resource = resource;
	}

	public void run() {
		synchronized (resource) {
			System.out.println("increment total");
			while (true) {
				System.out.println("increment total while true");
				if (resource.total >= 1) {
					try {
						System.out.println("increment waiting");
						resource.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					resource.total += 1;
					System.out.println("incremented resource value::"
							+ resource.total);
					resource.notify();
				}
			}
		}
	}

}

class ThreadD extends Thread {

	sharedResource resource;

	public ThreadD(sharedResource resource) {
		this.resource = resource;
	}

	public void run() {

		synchronized (resource) {
			System.out.println("decerement total");

			while (true) {
				System.out.println("decerement total while true");
				if (resource.total >= 1) {
					resource.total -= 1;
					System.out.println("deceremented resource value::"
							+ resource.total);
					resource.notify();
				} else {
					try {
						System.out.println("decerement waiting");
						resource.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
