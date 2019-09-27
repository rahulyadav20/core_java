package com.collections;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
	
	public static void main(String args[]){
		
		
		Map<String, Integer> myMap = new TreeMap<String, Integer>();
		
		myMap.put("First", 1);
		myMap.put("Second", 2);
		myMap.put("Binary", 12);
		
		System.out.println(myMap);
		
	}

}
