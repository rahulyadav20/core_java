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

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
     
    	int result = 0;
    
    	List<Integer> inputList = new LinkedList<Integer>();
    	inputList.iterator();
    	for(int i=0; i< arr.size(); i++){
    		int j = 0;
    		for(j=0;j < arr.get(0).size();j++){
    			
    		}    		
    	}
    	
    	return result;
    }
}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        /*
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

        */
        
        List<Integer> list1 = Arrays.asList(11,2,4);
        List<Integer> list2 = Arrays.asList(4,5, 6);
        List<Integer> list3 = Arrays.asList(10,8,-12);

        List<List<Integer>> arr = new ArrayList<>();
        arr = Arrays.asList(list1, list2, list3);
        int result = Result.diagonalDifference(arr);
        System.out.println(result);
    }
}
