package com.a293;


class A implements Runnable
{
	@Override
	public void run() 
	{
		
		for(int i=1;i<=10;i++)
		{
			System.out.println("Thread A: "+i);
		}
	
	}
}
class B implements Runnable
{
	@Override
	public void run() 
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("Thread B: "+i);
		}
	}
}
public class Example1 
{
	public static void main(String[] args) 
	{
		
		Thread t1 =new Thread(new A());
		Thread t2 =new Thread(new B());
		t1.start();
		t2.start();
		
	}
}
