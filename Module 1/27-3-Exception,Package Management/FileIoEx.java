package com.a273;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 
Write - FileOutputStream
Read - FileInputStream

*/
public class FileIoEx 
{
	public static void main(String[] args) 
	{
		
		 
		try 
		{
			String s = "Welcome to Tops";
			FileOutputStream fout = new FileOutputStream("E://Deep.txt");
			fout.write(s.getBytes());
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			//e.printStackTrace();
		}
		
		
		//Multiple Catch Block
		/*catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("File Issues");
		}
		catch (IOException e2) 
		{
			// TODO Auto-generated catch block
			System.out.println("Input Output Issues");
		}*/
		
		
		System.out.println("Success");
	}
}
