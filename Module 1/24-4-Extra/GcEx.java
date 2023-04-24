package com.b;

public class GcEx 
{

	@Override
	protected void finalize() throws Throwable 
	{
		// TODO Auto-generated method stub
		//super.finalize();
		System.out.println("Garbage Collection Called");
	}
	
	public static void main(String[] args) 
	{
	
		
		GcEx g1 = new GcEx();
		GcEx g2 = new GcEx();
		GcEx g3 = new GcEx();
		
		g1=null;
		g2=null;
		
		System.gc();
		
	}
}
