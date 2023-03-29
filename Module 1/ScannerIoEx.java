package com.a293;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScannerIoEx 
{
	public static void main(String[] args) throws IOException 
	{
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Your Id");
		int id = sc.nextInt();
		
		String id2 = String.valueOf(id);
		
		System.out.println("Enter Your Name");
		String name = sc.next();
		
		System.out.println("Enter Your Email");
		String email = sc.next();
		
		String myid ="\n Your Id is: ";
		String myname ="\n Your Name is: ";
		String myemail ="\n Your Email is: ";
		
		FileOutputStream fout =new FileOutputStream("E://prakruti.txt");
		
		fout.write(myid.getBytes());
		fout.write(id2.getBytes());
		
		fout.write(myname.getBytes());
		fout.write(name.getBytes());
		
		fout.write(myemail.getBytes());
		fout.write(email.getBytes());
	}
}
