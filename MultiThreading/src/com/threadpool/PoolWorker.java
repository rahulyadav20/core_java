package com.threadpool;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PoolWorker extends Thread {

	LinkedBlockingQueue<PoolWorker> queue;

	public PoolWorker(LinkedBlockingQueue<PoolWorker> queue) {
		this.queue = queue;
	}

	public void run() {
		Runnable task;
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {

					try {
						queue.wait();
					} catch (InterruptedException ex) {
						System.out.println("Error with Thread");
					}
				}
				task = queue.poll();
			}			

		try{
			task.run();
		}catch(RuntimeException ex){

			System.out.println("Thread pool is intterupted.");
		}
	}
 }
}
