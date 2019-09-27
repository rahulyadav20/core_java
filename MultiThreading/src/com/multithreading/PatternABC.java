package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PatternABC {
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {

	    ExecutorService service = Executors.newFixedThreadPool(3);
	    int x = 0;
	    while (x < 100) {
	        service.submit(() -> {
	            System.out.print("A ");
	            return "A";
	        }).get();

	        service.submit(() -> {
	            System.out.print("B ");
	            return "B";
	        }).get();

	        service.submit(() -> {
	            System.out.print("C ");
	            return "C";
	        }).get();

	        x++;
	    }
	    service.shutdown();
	    
	    System.out.println("Approach 2 using lambda::");
	    ExecutorService approach2Service = Executors.newFixedThreadPool(3);
        int y = 0;
        while (y < 100) {
        	approach2Service.submit(getTask("A ")).get();
        	approach2Service.submit(getTask("B ")).get();
        	approach2Service.submit(getTask("C ")).get();
            x++;
        }
        approach2Service.shutdown();	   
	}

	private static Callable<String> getTask(String task) {
		return () -> {
            System.out.print(task);
            return task;
        };
	}	

}
