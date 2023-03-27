package com.a273;

import java.io.IOException;

//Throws keyword will use to handle exception

class P
{
	void p1() throws IOException
	{
		System.out.println("P Executed");
	}
}
class Q extends P
{
	void q1() throws IOException
	{
		System.out.println("Q Executed");
	}
}
class R extends Q
{
	void r1() 
	{
		System.out.println("R Executed");
	}
}


public class ThrowsEx 
{
	public static void main(String[] args) throws IOException 
	{
		R r =new R();
		
		r.p1();
		r.q1();
		r.r1();
	}
}
