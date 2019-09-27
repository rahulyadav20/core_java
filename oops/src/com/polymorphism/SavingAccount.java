package com.polymorphism;

public class SavingAccount extends Account{
	
	@Override
	public void openAccount(){
		System.out.println("child open account");
	}
	
	public void closeAccount(){
		System.out.println("child close account");
	}

}
