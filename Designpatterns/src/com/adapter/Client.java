package com.adapter;

public class Client {
	
	public static void main(String args[]){
		Turkey turkey = new TurkeyImpl();
		turkey.gobble();
		turkey.fly();
		
		Duck duck =new DuckImpl();
		duck.quack();
		duck.fly();
		
		Duck adaptiveTurkey = new TurkeyAdapter(turkey);
		adaptiveTurkey.quack();
		adaptiveTurkey.fly();
	
	}
	
}
