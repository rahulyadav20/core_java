package com.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String args[]){
		
		Account obj = new SavingAccount();
		obj.openAccount();
		
		//AbstractAccount objAbstract = new AbstractAccount();
		
		List l = new ArrayList<Integer>();
		System.out.println(l.hashCode());
		l.add(12);
		
		List l1 = new ArrayList<Integer>();
		l1.add(100);
		
		App obj1 = new App();
		
		System.out.println("Before swap");
		System.out.println(l);
		System.out.println(l1);
		
		obj1.swapList(l, l1);
		
		System.out.println("after swap");
		System.out.println(l);
		System.out.println(l1);
		
		obj1.modifyList(Collections.unmodifiableList(l));
		System.out.println("l after modify list");
		System.out.println(l);
		
		Stu stu = new Stu();
		stu.setName("Rahul");
		
		obj1.manipulateStudent(stu);
		
		System.out.println("after manipulate Student ::"+stu.getName());
	}
	
	
	public void swapList(List l, List l1){
		
		List l3;
		
		l3 = l;
		l = l1;
		l1 = l3;
		
		System.out.println("In Method");
		System.out.println(l);
		System.out.println(l1);
	}
	
public void modifyList(List l){
		
	List myList = new ArrayList(l);
		myList.add(200);
		
		System.out.println("In Method after add");
		System.out.println(myList);		
	}	

 public void manipulateStudent(Stu stu){
	 
	 stu.setName("Yadav");
 }
}



class Stu{
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}