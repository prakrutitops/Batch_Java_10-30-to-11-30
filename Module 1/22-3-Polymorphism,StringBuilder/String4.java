package com.a223;

public class String4 
{
	public static void main(String[] args) 
	{
		
		String s1 =new String("RATAN");
		String s2 ="sachin";
		String s3 ="php is best. php is a programming language. php is a open source";
		String s4="  tops  ";
		System.out.println(s2.toUpperCase());
		System.out.println(s1.toLowerCase());
		System.out.println(s1.startsWith("R"));
		System.out.println(s1.endsWith("AN"));
		
		System.out.println(s3.replaceAll("php","java"));
		
		System.out.println(s3.charAt(0));
		
		System.out.println(s4.trim());
		
		
		
	}
}
