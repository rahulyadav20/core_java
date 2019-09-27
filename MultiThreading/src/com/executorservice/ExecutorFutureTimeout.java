package com.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorFutureTimeout {

	public static void main(String args[]) {

		List<Future<? extends Object>> resultList = new ArrayList<>();
		ExecutorService executor = Executors.newCachedThreadPool();

		// Demo Future Timeout
		System.out.println("********************** Future Timeout Demo ******************");

		for (int i = 0; i < 10; i++) {

			resultList.add(executor.submit(new WorkerThread()));
		}

		resultList.add(executor.submit(new TimeoutThread()));

		for (Future result : resultList) {
			try {
				result.get(6666, TimeUnit.MILLISECONDS);
				// result.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// Exception thrown by a worker thread(ManagerThread.Java), when
				// we try to do future.get() we get ExecutionException.
				System.out.println("Worker thread has execpetion.");
				e.printStackTrace();
			} catch (TimeoutException e) {
				// Timeout by a worker thread(TimeoutThread.Java), when we try
				// to do future.get(timeout) we get TimeoutException.
				System.out.println("Worker thread timeout.");
				e.printStackTrace();
			}
		}

		System.out.println("All thread completed.");

		executor.shutdown();
	}

}

class TimeoutThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(9999);
		return 9999;
	}

}

