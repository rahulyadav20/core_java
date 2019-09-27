package com.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
	
	public static void main(String args[]){
		
	           ExecutorService executorService = Executors.newFixedThreadPool(5);

		        for( int i = 0; i < 3; i++ )
		        {
		            executorService.submit(new Task(i+1));
		        }
		        executorService.shutdown();                     

		    }

		  
	
	

}

class Task implements Runnable
{
    private int taskId;

    public Task(int id)
    {
        taskId = id;
    }

    @Override
    public void run() {
        System.out.println("Executing task " + taskId + " performed by " + Thread.currentThread().getName() );
        try
        {
            Thread.sleep(30000);
        }
        catch(InterruptedException interruptEx)
        {
            System.out.println(Thread.currentThread().getName() + " got interrupted ");
        }
        System.out.println("Finished executing task " + taskId );
    }
}
