package com.racecondition;

public class Client {
	public static void main(String args[]) {
		RGB rgb = new RGB(233,2,4);
		
		MyRunnable runnable1  = new MyRunnable(rgb);
		MyRunnable2 runnable2  = new MyRunnable2(rgb);
		
		new Thread(runnable1).start();
		new Thread(runnable2).start();
	}
}

