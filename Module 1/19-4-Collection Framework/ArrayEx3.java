import java.util.ArrayList;
import java.util.Iterator;

public class ArrayEx3 
{
	public static void main(String[] args) 
	{
		
			ArrayList<String> arrayList1 = new ArrayList<>();
			
			arrayList1.add("Java");
			arrayList1.add("Php");
			arrayList1.add("Python");
			arrayList1.add("Java");
			
			
			ArrayList<String> arrayList2 = new ArrayList<>();
			arrayList2.add("Android");
			arrayList2.add("Ios");
			arrayList2.add("Flutter");
			arrayList2.add("Java");
			
			  
			  arrayList1.addAll(arrayList2);
			  //arrayList1.remove(2); 
			 // arrayList1.removeAll(arrayList2);
			 
			 
			
			 //arrayList1.retainAll(arrayList2);
			
			
			
			
			/*
			  System.out.println(arrayList1);
			   System.out.println(arrayList2);
			 */
			
			//Interface - Iterator 
			
			Iterator i = arrayList1.iterator();
			
			while(i.hasNext())
			{
				System.out.println(i.next());
			}
			
			
			
	
	}
		
		
		
		
		
	}

