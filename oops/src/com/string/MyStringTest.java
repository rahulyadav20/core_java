package com.string;

public class MyStringTest {

	
	
	public void modifyString(String str){
		
		for(int i=0;i<10;i++){
			if(i==7){
				System.out.println(str);
			}
		}
		str.concat("NewString");
	}

	public static void main(String args[]) {
		String name = "Rahul";
		MyStringTest obj = new MyStringTest();
		obj.modifyString(name);
		System.out.println(name);
		
	}
}
