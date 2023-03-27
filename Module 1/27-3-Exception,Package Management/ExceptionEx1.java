package com.a273;

public class ExceptionEx1 
{
	
	
	/* 
	Exception-Errors

	Keywords:
	1)Try
	2)Catch
	3)Throw
	4)Throws
	5)Finally */

	
	public static void main(String[] args) 
	{
		
		
		
		
		try
		{
			//It will accept Logical Part
			int data = 10/0;
			System.out.println(data);
		}
		catch(Exception e)
		{
			//If Any Exception is Occured it will be reflected Here
			System.out.println(e);
		}
		finally
		{
			//Finally block will execute compulsory
			System.out.println("executed");
		}
		
	}
}
