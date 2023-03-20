package com.a203;

class A
{
	void a()
	{
		System.out.println("A Executed");
	}
}
class B extends A
{
	void b()
	{
		System.out.println("B Executed");
	}
}
public class SingleInEx 
{
	public static void main(String[] args)
	{
		B b =new B();
		
		b.a();
		b.b();
	}
}
