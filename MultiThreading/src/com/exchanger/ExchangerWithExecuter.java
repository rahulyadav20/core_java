package com.exchanger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerWithExecuter {
	
	public static void main(String args[]){
	
		CyclicBarrier barrier = new CyclicBarrier(3);
		List<String> nameList = new LinkedList<String>();
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(new Task1(barrier, nameList));
		service.submit(new Task2(barrier, nameList));
		service.submit(new Task3(barrier, nameList));
		
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		myMap.put("Name", 12);
		
		try {
			barrier.await();
			System.out.println("main thread cross barrier");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main barrier reached :: "+ nameList );
		service.shutdown();
		
	}

}


class Task1 implements Callable{
	
	CyclicBarrier barrier;
	List<String> nameList = new LinkedList<String>();
	
	public Task1(CyclicBarrier barrier, List<String> nameList){
		this.barrier = barrier;
		this.nameList = nameList;
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Task 1 running.");
		barrier.await();
		nameList.add("Task 1");
		System.out.println("Task 1 crossed barrier");
		return "DONE";
	}
	
}

class Task2 implements Callable{
	
	CyclicBarrier barrier;
	List<String> nameList = new LinkedList<String>();
	
	public Task2(CyclicBarrier barrier, List<String> nameList){
		this.barrier = barrier;
		this.nameList = nameList;
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Task 2 running.");
		Thread.sleep(10000);
		System.out.println("Task 2 awake.");
		barrier.await();
		nameList.add("Task 2");
		System.out.println("Task 2 crossed barrier");
		return "DONE";
	}
	
}


class Task3 implements Callable{
	
	CyclicBarrier barrier;
	List<String> nameList = new LinkedList<String>();
	
	public Task3(CyclicBarrier barrier, List<String> nameList){
		this.barrier = barrier;
		this.nameList = nameList;
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Task 3 running.");
		nameList.add("Task 3");
		System.out.println("Task 3 complete.");
		return "DONE";
	}
	
}