package com.callable;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {
	private String myName;

	CallableImpl(String name) {
		myName = name;
	}

	public String call() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread : " + getMyName() + " I is : " + i);
		}
		return new String(getMyName());
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}
}