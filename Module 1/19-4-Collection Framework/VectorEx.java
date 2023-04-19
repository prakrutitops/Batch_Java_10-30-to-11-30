import java.util.Vector;

public class VectorEx 
{
	public static void main(String[] args) 
	{
		
		Vector v = new Vector<>(5);
		
		v.add("1");
		v.add("2");
		v.add("3");
		v.add("2");
		v.add("3");
		v.add("3");
		v.add("3");
		v.add("2");
		v.add("3");
		v.add("3");
		v.add("3");
		
		System.out.println(v.capacity());
		System.out.println(v.size());
		
		if(v.contains("3"))
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("Error");
		}
		
		System.out.println(v.firstElement());
		System.out.println(v.lastElement());
	}
}
