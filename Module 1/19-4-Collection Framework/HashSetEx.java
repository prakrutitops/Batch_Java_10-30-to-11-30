import java.util.ArrayList;
import java.util.HashSet;

public class HashSetEx 
{
	
	public static void main(String[] args) 
	{
		
		HashSet<String> h1 = new HashSet<>();
		
		h1.add("Java");
		h1.add("Php");
		h1.add("Python");
		h1.add("Java");
		
		
		HashSet<String> h2 = new HashSet<>();
		h2.add("Android");
		h2.add("Ios");
		h2.add("Flutter");
		h2.add("Java");
		
		System.out.println(h1);
		
		
		
	}
	
}
