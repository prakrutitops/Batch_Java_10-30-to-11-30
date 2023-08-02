package com.controller;

import java.util.Scanner;

import com.dao.MyDao;
import com.model.Person;

public class Select 
{
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Person p = new Person();
		System.out.println("Enter id:");
		p.setId(sc.nextInt());
		Person per = new MyDao().getsingle(p);
		
		System.out.println(per.getId()+" "+per.getName()+" "+per.getCity());
	}
}
