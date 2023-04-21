import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student
{
	int id;
	String name;
	int salary;
	
	public Student(int id,String name,int salary) 
	{
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	
}

class StudentCompare implements Comparator<Student>
{
	
	
	

	@Override
	public int compare(Student o1, Student o2) 
	{
		
		int value = 0;
		
		if(o1.salary>o2.salary) 
		{
			return 1;
		}
		else if(o1.salary<o2.salary)
		{
			return -1;
		}
		else if(o1.salary==o2.salary) 
		{
			return 0;
		}
		return value;
		
		
	
	}

	
}
public class GenericsEx1 
{
	
	public static void main(String[] args) 
	{
		
		Student s1 =new Student(101, "A", 1000);
		Student s2 =new Student(102, "B", 4000);
		Student s3 =new Student(103, "C", 3000);
		Student s4 =new Student(104, "D", 2000);
		
		ArrayList<Student> al = new ArrayList<Student>();
		
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		
		
		Collections.sort(al, new StudentCompare());
		
		for(Student e:al)
		{
			System.out.println(e.salary+"   "+e.name);
		}
		
		
	}
	
}
