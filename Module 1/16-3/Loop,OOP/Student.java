package com.a163;

public class Student 
{
	int id;
	String name;
	
	public static void main(String[] args) 
	{
		
		//classname objname = new classname();
		//object creation
		Student s1 = new Student();
		Student s2 =new Student();
		Student s3 =new Student();
		
		
		//assign value to object using variable
		s1.id=101;
		s1.name="Ajay";
		
		s2.id=102;
		s2.name="Vijay";
		
		s3.id=103;
		s3.name="Sachin";
		
		//print value from object
		System.out.println(s1.id+" "+s1.name);
		System.out.println(s2.id+" "+s2.name);
		System.out.println(s3.id+" "+s3.name);
		
	}
}
