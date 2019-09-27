package com.learn.optional;

import java.util.Optional;

//https://dzone.com/articles/understanding-accepting-and-leveraging-optional-in?edition=326501&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=Daily%20Digest%202017-09-19
public class OptionalAdvance {
	
	public static void main(String args[]){
		
		System.out.println("-----------------------Transforming values-------------------");
		Bank boaBank = new Bank("BOA", "NC");
	    String bankAddress = Optional.ofNullable(boaBank)
	      .map(u -> u.getBankAddress()).orElse("USA");
	    System.out.println("Bank address after transformation :"+bankAddress);

	    //Syntax error below.
	   /* bankAddress = Optional.ofNullable(boaBank)               
	  	      .flatMap(b -> b.getBankAddress()).orElse("USA");*/
	    
	    System.out.println("-------------------------------------------Filtering ------------");
	    Bank newBank = null;
	    Optional<Bank> bankOptional = Optional.ofNullable(boaBank)
	    	      .filter(b -> b.getBankAddress() != null && b.getBankAddress().contains("NC"));
	    
	    System.out.println("Bank Address ::"+bankOptional.get().getBankAddress());
	    
	    Bank rbsBank = Bank.createNewBank("RBS", null);
	    bankOptional = Optional.ofNullable(rbsBank)
	    	      .filter(b -> b.getBankAddress() != null && b.getBankAddress().contains("NC"));
	    
	    
	    System.out.println("------------------Chaning ----------------------");
	    String result = Optional.ofNullable(rbsBank)
	    	      .map(u -> u.getAddress())
	    	      .map(c -> c.getCountry())
	    	      .map(i -> i.getIsoCode())
	    	      .orElse(null);
	    
	    System.out.println("chaining result ISO code:"+ result);
	    
	    
	    Address rbsBankAdd = new Address();
	    Country country = new Country();
	    country.setIsoCode("USA");
	    rbsBankAdd.setCountry(country);
	    rbsBank.setAddress(rbsBankAdd);
	    	    
	    
	    /* Re-write the code using Optional
	     if (user != null) {
           Address address = user.getAddress();
    	     if (address != null) {
               Country country = address.getCountry();
               if (country != null) {
                 String isocode = country.getIsocode();
                 if (isocode != null) {
                   isocode = isocode.toUpperCase();
                 }
               }
            }
         }	      
	      
	     */
	    String nonDefaultresult = Optional.ofNullable(rbsBank)
	    	      .map(u -> u.getAddress())
	    	      .map(c -> c.getCountry())
	    	      .map(i -> i.getIsoCode())
	    	      .orElse("default");
	    
	    System.out.println("chaining result ISO code:"+ nonDefaultresult);
	    
	    
	}

}
