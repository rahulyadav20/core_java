package com.templateMethod;

public class Tea extends CaffeineBevrage{

	@Override
	public void brew() {
		System.out.println("steeping the tea");
		
		
	}

	@Override
	public void addCondiments() {
		System.out.println("adding lemon");
		
	}

}
