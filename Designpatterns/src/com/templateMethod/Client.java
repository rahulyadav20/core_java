package com.templateMethod;

public class Client {
	public static void main(String args[]){
		CaffeineBevrage bevrage = new Tea();
		bevrage.prepareReciepe();
		
		CaffeineBevrage bevrageCoffee = new Coffee();
		bevrageCoffee.prepareReciepe();
		
		Coffee bevrageCoffee1 = new Coffee();
		bevrageCoffee1.prepareReciepe();
	}

}
