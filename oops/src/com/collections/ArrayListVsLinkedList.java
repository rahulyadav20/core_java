package com.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
	
	public static void main(String args[]){
		
		/**
		 * maintains insertion order. Allows index based addition and read.
		 * Since ArrayList is based on Array, index based access is fast in ArrayList.
		 */
		List<String> arrayList = new ArrayList<>();
		arrayList.add("Rahul");
		arrayList.add("JACK");
		arrayList.add(0, "ZEBY");
		arrayList.add(3, "JOHN"); // Works
		//arrayList.add(5, "JOHN"); // IndexOutOfBoundException
		System.out.println(arrayList.get(3));
		System.out.println("Print without sorting :: "+ arrayList);
		
		
		/**
		 * maintains insertion order. Allows index based addition and read.
		 * Add at the end and front.availble only in LinkedList and not in List
		 * Addition and Removal of elements from middle of the LinkedList is
		 * faster than the same operation on ArrayList
		 * Addition/Removal at any place in ArrayList is expensive compared to LinkedList.
		 * ArrayList are fast for accessing a specific element. 
		 * For Index base access LinkedList iterate through entire list.
		 * It will start iteration from front or from the end depending upon the element index
		 * being requested.
		 */
		LinkedList<String> linkList = new LinkedList<>();
		linkList.add("Rahul"); // same as addLast
		linkList.add("JACK");
		linkList.add("JEFF");
		linkList.add(0, "ZEBY");
		linkList.addLast("Last"); //Method available only in LinkedList and not in List
		linkList.addFirst("FIRST");
		linkList.add(3, "JOHN"); // Works
		//linkList.add(8, "JOHN"); // IndexOutOfBoundException
		System.out.println(linkList.get(3)); //Slower than ArrayList
		System.out.println("Print without sorting :: "+ linkList);
		
	}

}
