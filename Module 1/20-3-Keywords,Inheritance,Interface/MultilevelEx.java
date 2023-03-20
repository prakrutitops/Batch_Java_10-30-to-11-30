package com.a203;

class A1
{
	void a()
	{
		System.out.println("A Executed");
	}
}
class B1 extends A1
{
	void b()
	{
		System.out.println("B Executed");
	}
}
class C1 extends B1
{
	void c()
	{
		System.out.println("C Executed");
	}
}
public class MultilevelEx 
{
	public static void main(String[] args)
	{
		C1 c =new C1();
		
		c.a();
		c.b();
		c.c();
		
	}
}
