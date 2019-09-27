package com.singleton;

public class StaticSingleton {
	private static final StaticSingleton uniqueInstance = new StaticSingleton();
	
	private StaticSingleton(){
		
	}
	
	public static StaticSingleton getInstance(){
		return uniqueInstance;
	}
	
}
