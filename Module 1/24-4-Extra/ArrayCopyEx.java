package com.b;

public class ArrayCopyEx 
{
	public static void main(String[] args) 
	{
		
		int arr[] =new int[5];
		int arr2[]=new int[10];
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		arr[4]=50;
		
		System.arraycopy(arr, 2, arr2, 2, 3);
		
		for(int i=0;i<10;i++)
		{
			System.out.println(arr2[i]);
		}
		
		
	}
}
