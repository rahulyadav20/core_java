package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class CallableTester {
	public static void main(String[] args) {
		Callable<String> callable = new CallableImpl("Test Callable");
		ExecutorService executor = new ScheduledThreadPoolExecutor(5);
		Future<String> future = executor.submit(callable);
		try {
			System.out.println("Future value: " + future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}