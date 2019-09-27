package com.singleton;

public class DCLSingleton {

	private volatile static DCLSingleton uniqueInstance;

	private DCLSingleton() {
		if (null != uniqueInstance) {
			throw new IllegalStateException("Object already instantiated");
		}
	}

	public static DCLSingleton getInstance() {
		if (null == uniqueInstance) {
			synchronized (DCLSingleton.class) {
				if (null == uniqueInstance) {
					uniqueInstance = new DCLSingleton();
				}
			}
		}
		return uniqueInstance;
	}

}
