package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ImmutableCollection {
	
	
	List<String> mutableList = new LinkedList<String>();
	
	public ImmutableCollection(){
		mutableList.add("Rahul");
		mutableList.add("JACK");
	}
	
	public List<String> getMyList(){
		
		return mutableList;
	}
	
	public List<String> getUnmodifiableList(){
		
		return Collections.unmodifiableList(mutableList);
	}
	
	public static void main(String args[]){
		
		ImmutableCollection myCollection = new ImmutableCollection();
		
		List<String> localList = myCollection.getMyList();
		localList.add("JOHN");
		
		System.out.println("Local List::"+ localList);
		System.out.println("Global List::"+myCollection.getMyList()); //Object gets added to both Local and Global lists.
		
		List<String> immutableList = myCollection.getUnmodifiableList();
		
		//immutableList.add("John"); // Exception UnsupportedOperationException.
		
		Address add1 = new Address("hills road", "Gurgaon");
		Address add2 = new Address("golf road", "Delhi");
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(add1);
		addressList.add(add2);
		
		List<Address> immutableAddressList = Collections.unmodifiableList(addressList);
		immutableAddressList.get(0).setCity("Mumbai");
		System.out.println(immutableAddressList);	
		System.out.println(immutableAddressList.get(0).getCity());
	}
}

class Address{
	
	String street;
	String city;
	
	
	public Address(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
