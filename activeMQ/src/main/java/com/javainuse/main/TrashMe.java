package com.javainuse.main;

public class TrashMe {
	
	public static void main(String args[]){
		System.out.println("Demo");
		String s1 = "str";
		String s2 = "str";
		String s3 = new String("str");
		String s4 = new String(s1);
		
		s3.intern();
		
		boolean flag = s1==s2;
		System.out.println("s1 == s2 ::"+ flag);
		
		flag = s1==s3;
		System.out.println("s1 == s3 ::"+ flag);
		
		flag = s1==s4;
		System.out.println("s1 == s4 ::"+ flag);
		
		flag = s3==s4;
		System.out.println("s3 == s4 ::"+ flag);
	}

}
