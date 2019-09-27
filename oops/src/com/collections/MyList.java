package com.collections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyList {
	
	public static void main( String args[]){
		
		List<String> myArrayList =new ArrayList<String>();
		List<String> myLinkedList =new LinkedList<String>();
		
		myArrayList.add("JAMES");
		myArrayList.add("ANDREW");
		myArrayList.add(0,"JOHN");
		myArrayList.add(1,"JOSE");
		
		//Collections.sort(myArrayList);
		//myArrayList.sort(null);
		System.out.println(myArrayList); //ArrayList maintians the insertion order. 
		//also it is possible to add at particular index value.
		
		/*List<String> myCustomarrayList = new MyArrayList<String>();
		
		myCustomarrayList.add("JAMES");
		myCustomarrayList.add("ANDREW");
		
		
		System.out.println(myCustomarrayList);*/
		
	}

}


class MyArrayList<E> extends AbstractList<E> implements Cloneable, java.io.Serializable{
	
	transient Object[] elementData;
	
	private final int DEFAULT_SIZE =16;

	private int size=0; 
	
	public MyArrayList(){
		elementData = new Object[DEFAULT_SIZE];
	}
	
	public boolean contains(Object o) {
	        return indexOf(o) >= 0;
	}
	 

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return (E) elementData[index];
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	 public E set(int index, E element) {
	        E oldValue = (E) elementData[index];
	        elementData[index] = element;
	        return oldValue;
	 }
	 
	 public boolean add(E e) {
	        elementData[size++] = e;
	        return true;
	    }
	
	
}