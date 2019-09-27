package com.anonymous;

public class PerfTestHelper {
	
	public void takeSomeTime(){
		
		for(int i =0; i<9999999 ; i++){
			System.out.println("take some time ::"+i);
		}
		
		PerfTestHelper2 perfObj = new PerfTestHelper2();
		perfObj.takeLotOfTime();
	}

}