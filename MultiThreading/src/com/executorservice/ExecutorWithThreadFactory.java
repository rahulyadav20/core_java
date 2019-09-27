package com.executorservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ExecutorWithThreadFactory {
	
	/**
	 * ThreadFactory method is executed while creating a new Thread.
	 * @param args
	 */

	
	public static void main(String args[]) {

		List<Future<? extends Object>> resultList = new ArrayList<>();
		
		CustomThreadFactory threadFactory = new CustomThreadFactory("myThread");
		ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
		//ExecutorService executor = Executors.newFixedThreadPool(10000);  //starts 10,000 threads
		//ExecutorService executor = Executors.newSingleThreadExecutor();  //starts 1 thread
		
		/**
		 * Noticed major performance difference with fixed ThreadPool of 100 and cached thread pool.
		 * cached thread pool is similar to fixed thread pool with 10,000 threads and created 9999 threads.
		 * JVisualVM
		 */

		// Demo Future Timeout
		System.out.println("********************** Executor Performance Demo ******************");
		
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			resultList.add(executor.submit(new PerformanceThread()));
		}

		System.out.println(threadFactory.getStats());
		System.out.println(threadFactory.getThreadState());
		
		for (Future result : resultList) {
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
		}

		System.out.println("All thread completed.");
		long totalTime= System.currentTimeMillis() - startTime;
		System.out.println("Total time take to execute all threads ::" + totalTime);

		executor.shutdown();
	}

}

class CustomThreadFactory implements ThreadFactory
{
   private int          counter;
   private String       name;
   private List<String> stats;
   private List<Thread> threads;
 
   public CustomThreadFactory(String name)
   {
      counter = 1;
      this.name = name;
      stats = new ArrayList<String>();
      threads = new ArrayList<Thread>();
      
   }
 
   @Override
   public Thread newThread(Runnable runnable)
   {
      Thread t = new Thread(runnable, name + "-Thread_" + counter);
      counter++;
      
      stats.add(String.format("Created thread %d with name %s on %s is in state %s \n", t.getId(), t.getName(), new Date(), t.getState()));
      System.out.println("custom thread created.");
      threads.add(t);
      return t;
   }
 
   public String getStats()
   {
      StringBuffer buffer = new StringBuffer();
      Iterator<String> it = stats.iterator();
      while (it.hasNext())
      {
         buffer.append(it.next());
      }
      return buffer.toString();
   }
   
   public String getThreadState(){
	      StringBuffer buffer = new StringBuffer();
	      Iterator<Thread> it = threads.iterator();
	      while (it.hasNext())
	      {
	         buffer.append(it.next().getState());
	      }
	      return buffer.toString();
	   
   }
   
}
