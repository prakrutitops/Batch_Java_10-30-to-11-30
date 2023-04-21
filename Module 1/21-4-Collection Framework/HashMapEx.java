import java.util.HashMap;
import java.util.Map;

public class HashMapEx 
{
	
	//put,get
	//key,value pair
	
	public static void main(String[] args) 
	{
		
		HashMap<String,String>map =new HashMap<>();
		
		//data will be put in hashmap
		map.put("A", "101");
		map.put("B", "102");
		map.put("C", "103");
		map.put("D", "104");
		
		//for each loop
		for(Map.Entry m : map.entrySet() )
		{
			//get details from Map.Entry 
			System.out.println(m.getKey() +" "+m.getValue());
			
		}
		
		
	}
	
}
