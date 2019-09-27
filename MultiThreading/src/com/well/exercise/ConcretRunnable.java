package com.well.exercise;

import org.springframework.core.task.support.ConcurrentExecutorAdapter;

public class ConcretRunnable {
	
	public static void main(String args[]){
		
		AbstractRunnable task = new ConcreatRunnable();
		task.start();
		
	}

}
