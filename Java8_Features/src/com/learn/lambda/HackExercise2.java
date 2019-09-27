package com.learn.lambda;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HackExercise2 {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> alice, List<Integer> bob) {

        Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>()
        ;        
        resultMap.put("Alice", 0);
        resultMap.put("Bob", 0);
        int index = 0;
        for(Integer val : alice){

            if(val > bob.get(index)){            	
                resultMap.put("Alice", resultMap.get("Alice")+1);
            }
            if(val < bob.get(index)){
                resultMap.put("Bob", resultMap.get("Bob")+1);
            }
        index++;
        }
        System.out.println(resultMap);
        return new ArrayList<Integer>(resultMap.values());
    }

    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
    	
    	List<Integer> alice = Arrays.asList(17,28,30);
    	List<Integer> bob = Arrays.asList(99, 16, 8);
    	List<Integer> result = compareTriplets(alice, bob);
    	System.out.println(result);
    }
}
