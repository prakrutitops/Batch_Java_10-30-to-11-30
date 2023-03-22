package com.a223;
public class MethodOverloadingEx 
{
	
	static int add(int a,int b)
	{
		return a+b;
	}
	static double add(float a,float b)
	{
		return a*b;
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println(add(1,2));
		System.out.println(add(1.0F,2.0F));
	}
}
