package com.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCompletionServiceDemo {

	public static void main(String args[]) {

		List<Future<String>> futures = new ArrayList<Future<String>>(10);
		
		/*ExecutorService pool = Executors.newFixedThreadPool(4);
		futures.add(pool.submit(new StringTask(10000, "One")));
		futures.add(pool.submit(new StringTask(0, "Two")));

		for (Future<String> future : futures) {
			try {
				String result = future.get();
				System.out.println(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/


		System.out.println("CompletionService Demo");
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		CompletionService<String> completionServicePool = new ExecutorCompletionService<String>(threadPool);
		
		futures.add(completionServicePool.submit(new StringTask(1000, "One")));
		futures.add(completionServicePool.submit(new StringTask(0, "Two")));


		for (int i = 0; i < 2; i++) {
			try {
				String result = completionServicePool.take().get();
				System.out.println(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
