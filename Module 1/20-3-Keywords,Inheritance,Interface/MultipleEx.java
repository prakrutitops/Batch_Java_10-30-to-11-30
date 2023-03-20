package com.a203;

interface A2
{
	void a2();
	
}
interface B2
{
	void b2();
}
class C2 implements A2,B2
{

	@Override
	public void b2() 
	{
		// TODO Auto-generated method stub
		System.out.println("B2");
	}

	@Override
	public void a2() 
	{
		// TODO Auto-generated method stub
		System.out.println("A2");
	}

	
	
}

public class MultipleEx
{
	public static void main(String[] args) {
		
		C2 c= new C2();
		c.a2();
		c.b2();
		
	}

}
