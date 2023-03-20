package com.a203;

class P
{
	void p()
	{
		System.out.println("P executed");
	}
}
class Q extends P
{
	void q()
	{
		System.out.println("Q Executed");
	}
}
interface R
{
	void r();
}
class S extends Q implements R
{
	void s()
	{
		System.out.println("S Executed");
	}

	@Override
	public void r() 
	{
		// TODO Auto-generated method stub
		System.out.println("R Executed");
	}
}

public class HybridEx 
{
	public static void main(String[] args) {
		
		S s =new S();
		
		s.p();
		s.q();
		s.r();
		s.s();
		
	}
}
