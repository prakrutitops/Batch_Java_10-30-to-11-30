package com.a223;

public class String1 
{
	public static void main(String[] args) {
		
		//literal string
		String s1="sachin";
		
		//object string
		String s2 =new String("sachin");
		
		//character array string
		char ch[]= {'s','a','c','h','i','n'};
		String s3 =new String(ch);
		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
