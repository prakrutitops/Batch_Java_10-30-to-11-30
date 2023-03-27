package com.a273;

public class ThrowEx 
{
	//static method validate it will accept user's age
	static void validate(int age)
	{
		if(age>=18)
		{
			System.out.println("Eligible to vote");
		}
		else
		{
			throw new ArithmeticException("Not Eligible to vote");
		}
	}
	
	public static void main(String[] args) 
	{
		
		//call static method
		
		validate(15);
		
	}
	
}
