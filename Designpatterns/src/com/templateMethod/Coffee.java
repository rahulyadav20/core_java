package com.templateMethod;

public class Coffee extends CaffeineBevrage {

	@Override
	public void brew() {
		System.out.println("dripping coffee through filter");
		
	}

	@Override
	public void addCondiments() {
		System.out.println("adding sugar and milk");
		
	}

}
