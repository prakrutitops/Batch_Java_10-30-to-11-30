package com.controller;

import java.util.Scanner;

import com.dao.MyDao;
import com.model.Person;

public class Insert 
{
	public static void main(String[] args) 
	{
		
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Name");
		String name = sc.next();
		
		System.out.println("Enter City");
		String city = sc.next();
		
		Person p=new Person();
		p.setName(name);
		p.setCity(city);
		
		new MyDao().insert(p);
		
		
	}
}
