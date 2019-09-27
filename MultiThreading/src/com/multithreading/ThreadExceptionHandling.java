package com.multithreading;

public class ThreadExceptionHandling {
	
	
	public static void main(String args[]){
		
		final MyHandler handler = new MyHandler();
		
		Thread t = new Thread(new Runnable() {
			
			
			
			@Override
			public void run() {
				try {
					System.out.println("Thread start.");
					
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try{
					int result = 200/0;	
				}catch(ArithmeticException ex){
					handler.callback(ex);
				}
				
				System.out.println("Thread end.");
				
			}
		});
		
		t.setName("RunnbaleThread");
		t.start();
		
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main end");
		

		
	}

}


class MyHandler{
	
	String msg;
	
	public void callback(ArithmeticException ex){
		System.out.println("Exception in thread. Callback called from thread.  "+ ex);
	}
	
}