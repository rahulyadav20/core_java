package com.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorPerformance {
	
	public static void main(String args[]) {

		List<Future<? extends Object>> resultList = new ArrayList<>();
		//ExecutorService executor = Executors.newCachedThreadPool();
		ExecutorService executor = Executors.newFixedThreadPool(10);  //starts 10,000 threads
		//ExecutorService executor = Executors.newSingleThreadExecutor();  //starts 1 thread
		
		/**
		 * Noticed major performance difference with fixed ThreadPool of 100 and cached thread pool.
		 * cached thread pool is similar to fixed thread pool with 10,000 threads and created 9999 threads.
		 * JVisualVM
		 */

		// Demo Future Timeout
		System.out.println("********************** Executor Performance Demo ******************");
		
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {

			resultList.add(executor.submit(new PerformanceThread()));
		}


		/*for (Future result : resultList) {
			try {
				result.get();
				// result.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// Exception thrown by a worker thread(ManagerThread.Java), when
				// we try to do future.get() we get ExecutionException.
				System.out.println("Worker thread has execpetion.");
				e.printStackTrace();
			} 
		}*/

		System.out.println("All thread completed.");
		long totalTime= System.currentTimeMillis() - startTime;
		System.out.println("Total time take to execute all threads ::" + totalTime);

		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Resubmitting the Tasks.");
		for (int i = 0; i < 10; i++) {

			resultList.add(executor.submit(new PerformanceThread()));
		}
		
		executor.shutdown();
	}
	
	
}

class PerformanceThread implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("Starting Task");
		Thread.sleep(100000);
		System.out.println("Task Completed");
		return "Performance Thread";
	}
	
	
}
