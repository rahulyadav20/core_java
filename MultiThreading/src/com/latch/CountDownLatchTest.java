package com.latch;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchTest {
	
	private static CountDownLatch _latch;
	private static int N = 6;

	public static void main(String[] args) {
		_latch = new CountDownLatch(N);
		List<Future<? extends Object>> resultList = new ArrayList<>();
		
		ExecutorService executor = Executors.newCachedThreadPool();
				
		
		System.out.println("Submit Worker.");
		for (int i = 0; i < N-1; i++) {			
			resultList.add(executor.submit(new MyWorker(_latch)));
			//new Thread(new MyWorker(_latch)).start();
		}
		
		System.out.println("Submit Manager.");
		resultList.add(executor.submit(new MyManager(_latch)));
		//new Thread(new MyManager(_latch)).start();
		
		try {
			System.out.println("Wait for latch.");
			_latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*** Main Thread in Action ***");
		
		for(Future futureResult : resultList){
			try {
				Object result = futureResult.get();
				
				if(result instanceof Exception) {
					System.out.println("Exception in the thread :: " + result);
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class MyManager implements Callable<Object>{
 
	private CountDownLatch _latch = null;

	public MyManager(CountDownLatch _latch) {
		this._latch = _latch;
	}

	@Override
	public Object call() {
		
		System.out.println("*** Manager Thread ****");
		
		try{
			throw new RuntimeException("foo");	
		}catch(Exception ex){
			System.out.println("Exception in Manager");
			return ex;
		}
		
	}

}

class MyWorker implements Runnable {

	private CountDownLatch _latch = null;

	public MyWorker(CountDownLatch _latch) {
		this._latch = _latch;
	}

	@Override
	public void run() {
		try {
			URL url = new URL(
					"http://google.com");
			InputStream in = new BufferedInputStream(url.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1 != (n = in.read(buf))) {
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			byte[] response = out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		_latch.countDown();
		System.out.println("*** Worker Thread ****");

	}
}
