package com.singleton;

public class Client {
	public static void main(String args[]){
		//calling BasicSingleton
		BasicSingleton instance = BasicSingleton.getInstance();
		
		//calling StaticSingleton		
		StaticSingleton staticInstance = StaticSingleton.getInstance();
		
		//calling DClSingleton
		DCLSingleton dclInstance = DCLSingleton.getInstance();
	}

}
