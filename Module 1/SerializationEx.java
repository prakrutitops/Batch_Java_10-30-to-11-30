package com.a293;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx 
{
	public static void main(String[] args) throws IOException 
	{
		
		Student s1 =new Student(101,"Tops");
		//Create new File
		FileOutputStream fout =new FileOutputStream("E://Shruti.txt");
		
		//object will pass value i file
		ObjectOutputStream out = new ObjectOutputStream(fout);
		
		//write data in object
		out.writeObject(s1);
		
		System.out.println("Success");
	}
}
