package com.singleton;

public class BasicSingleton {
	
	private static BasicSingleton uniqueInstance;
	
	private BasicSingleton(){
		
	}
	
	public static BasicSingleton getInstance(){		
		if(null == uniqueInstance){
			uniqueInstance = new BasicSingleton();
		}
		return uniqueInstance;
	}
}





