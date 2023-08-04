package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connect.Util;
import com.model.Address;
import com.model.Person;

public class MainClass 
{
	public static void main(String[] args) {
		
		Session sess =  new Util().getconnect();
		Transaction tr = sess.beginTransaction();
		
		Person p =new Person();
		Person p2 =new Person();
		
		Address a =new Address();
		
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Your Name");
		String name = sc.next();
		p.setName(name);
		
		
		System.out.println("Enter Your Name 2");
		String name2 = sc.next();
		p2.setName(name2);
		
		System.out.println("Enter Your City");
		String city = sc.next();
		a.setAddress(city);
		
		List<Person> list =  new ArrayList<>();
		list.add(p);
		list.add(p2);
		
		a.setPerson(list);
		
		sess.save(p);
		sess.save(a);
		sess.save(p2);
		tr.commit();
		sess.close();
	}
}
