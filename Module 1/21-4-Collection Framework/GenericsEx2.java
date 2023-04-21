import java.util.ArrayList;
import java.util.Collections;

class Student2 implements Comparable<Student2>
{
	
	int sid;
	String sname;
	
	public Student2(int id,String name) 
	{
		sid=id;
		sname=name;
	}
	
	
	@Override
	public int compareTo(Student2 o) 
	{
		int value=0;
		
		if(this.sid>o.sid) 
		{
			return 1;
		}
		else if (this.sid<o.sid) 
		{
			return -1;
		}
		else if(this.sid==o.sid) 
		{
			return 0;
		}
		
		return value;
	}
	
}
public class GenericsEx2 
{
	public static void main(String[] args) 
	{
		
		Student2 s =new Student2(101, "A");
		Student2 s2 =new Student2(104, "D");
		Student2 s3 =new Student2(103, "C");
		Student2 s4 =new Student2(102, "B");
		
		
		ArrayList<Student2> al =new ArrayList<Student2>();
		al.add(s);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		
		Collections.sort(al);
		
		for(Student2 s1:al)
		{
			System.out.println(s1.sid+" "+s1.sname);
		}
	}
}
