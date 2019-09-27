package com.templateMethod;

public abstract class CaffeineBevrage {
	public final void prepareReciepe(){
	 boilWater();
	 brew();
	 pourInCup();
	 addCondiments();
	}
	
	private final void boilWater(){
		System.out.println("Boiling the water");
	}
	
	private final void pourInCup(){
		System.out.println("pouring in cups");
	}
	
	protected abstract void brew();
	protected abstract void addCondiments();
}
