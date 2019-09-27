package com.learn.optional;

import java.util.Optional;

//https://dzone.com/articles/understanding-accepting-and-leveraging-optional-in?edition=326501&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=Daily%20Digest%202017-09-19
public class OptionalBasics {

	public static void main(String args[]) {

		// ------------------------------------------Create Optional Object ----
		Bank bank = null;
		Optional<Bank> optionalBank;
		// optionalBank = Optional.of(bank); // Throw NPE, use only when sure
		// bank is not null.

		optionalBank = Optional.ofNullable(bank); // Optional initialized with
													// null value and won't
													// throw exception.

		System.out.println("--------------------- Optional empty Scenario----------------------");

		Optional<Bank> emptyOptionalBank = Optional.empty();
		// myBank.get().getBankAddress(); NoSuchElementException as myBank is
		// not initialized.

		Bank boaBank = emptyOptionalBank.orElse(Bank.createNewBank("BOA", "MD"));
		System.out.println(boaBank.getBankAddress());

		Bank ftBank = emptyOptionalBank.orElseGet(() -> Bank.createNewBank("FT", "NY"));
		System.out.println(ftBank.getBankAddress());

		System.out.println("--------------------- Optional Non-Empty Scenario----------------------");
		Bank abnBank = Bank.createNewBank("ABN", "SCOTLAND");
		Optional<Bank> nonEmptyOptionalBank = Optional.of(abnBank);

		boaBank = nonEmptyOptionalBank.orElse(Bank.createNewBank("BOA", "MD")); // return existing Bank object i.e. Scotland but also executes createNewBank method.
																				
		System.out.println(boaBank.getBankAddress());

		ftBank = nonEmptyOptionalBank.orElseGet(() -> Bank.createNewBank("FT", "NY")); // return existing Bank object i.e. Scotland and don't execute createNewBank method.
		System.out.println(ftBank.getBankAddress());
		
		System.out.println("-------------------- Exception Handling-----------------");
		nonEmptyOptionalBank.orElseThrow( () -> new IllegalArgumentException()); // no exception
		emptyOptionalBank.orElseThrow( () -> new IllegalArgumentException()); // will throw exception
	}

}

class Bank {

	String bankName;
	String bankAddress;
	
	Address address;

	Bank(String bankName, String address) {

		this.bankName = bankName;
		this.bankAddress = address;
	}

	public static Bank createNewBank(String bankName, String address) {
		System.out.println("Creating new Bank.");
		Bank newBank = new Bank(bankName, address);
		return newBank;

	}
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

}

class Address{
	
	Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
}


class Country{
	
	String isoCode;

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	
}