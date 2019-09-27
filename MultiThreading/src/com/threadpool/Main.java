package com.threadpool;

public class Main {
	//https://www.javacodegeeks.com/2016/12/implement-thread-pool-java.html

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(7);

		for (int i = 0; i < 5; i++) {
			Tasks task = new Tasks(i);
			pool.submit(task);
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Shutdown the pool.");
		pool.shutDown();
	}
}
