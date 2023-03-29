package com.a293;

import java.io.Serializable;

public class Student implements Serializable
{
	
	//Serializable is an interface
	
	int id;

	String name;
	
	Student(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
}
