package com.learn.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamClassDemo {
	
	public static void main(String args[]){
		
		int[] arr = {10,20,30};
		Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("BOB", 0);
		resultMap.put("TOM", 0);
		
		List<Integer> ll = new ArrayList<Integer>(resultMap.values());
		
		System.out.println(ll);
	}
	
	
}
