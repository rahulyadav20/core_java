package com.threadpool;

public class Tasks implements Runnable {

	private int num;

	public Tasks(int n) {
	        num = n;
    }

	public void run() {
		System.out.println("Task " + num + " is running.");
	}
}
