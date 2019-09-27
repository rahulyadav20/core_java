package com.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	private final int nThreads;
	private final PoolWorker[] threads;
	private final LinkedBlockingQueue queue;

	public ThreadPool(int poolSize) {

		nThreads = poolSize;
		queue = new LinkedBlockingQueue();
		threads = new PoolWorker[nThreads];
		for (int i = 0; i < nThreads; i++) {

			threads[i] = new PoolWorker(queue);
			threads[i].start();
		}

	}

	public void submit(Runnable task) {

		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}

	public void shutDown() {

		for (int i = 0; i < nThreads; i++) {

			threads[i].interrupt();			
		}
	}

}
