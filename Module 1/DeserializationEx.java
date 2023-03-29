package com.a293;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationEx 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		//inputstream will read data
		ObjectInputStream in =new ObjectInputStream(new FileInputStream("E://Shruti.txt"));
		Student s1 = (Student) in.readObject();
		System.out.println(s1.id+" "+s1.name);
	}
}
