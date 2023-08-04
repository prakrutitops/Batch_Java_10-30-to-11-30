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
		
		Address a =new Address();
		Address a2 =new Address();
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Your Name");
		String name = sc.next();
		p.setName(name);
		
		System.out.println("Enter Your City");
		String city = sc.next();
		a.setAddress(city);
		
		System.out.println("Enter Your City2");
		String city2 = sc.next();
		a2.setAddress(city2);

		List<Address> list =  new ArrayList<>();
		list.add(a);
		list.add(a2);
		
		p.setAddress(list);
		
		sess.save(p);
		sess.save(a);
		sess.save(a2);
		tr.commit();
		sess.close();
	}
}
