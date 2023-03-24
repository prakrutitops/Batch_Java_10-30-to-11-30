package com.a243;

import java.util.Scanner;

public class CharEx 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter Any Character");
		Scanner sc =new Scanner(System.in);
		String ch = sc.next();
		char ch1 = ch.charAt(0);
		
		if(ch.length()>1)
		{
			System.out.println("Error");
		}
		else
		{
			System.out.println(ch1);
		}
		
		
				
		
	}
}
