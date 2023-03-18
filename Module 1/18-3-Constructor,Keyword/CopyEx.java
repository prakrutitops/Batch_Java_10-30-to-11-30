package com.a183;

public class CopyEx 
{
	String name;
	
	public CopyEx(String name) 
	{
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	CopyEx(CopyEx c)
	{
		System.out.println(c.name);
	}
	
	
	public static void main(String[] args) 
	{
		CopyEx c1 =new CopyEx("Tops");
		CopyEx c2 =new CopyEx(c1);
		
	}
}
