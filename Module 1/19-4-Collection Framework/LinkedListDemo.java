import java.util.LinkedList;

public class LinkedListDemo 
{
	public static void main(String[] args) {
		
		
		LinkedList li =new LinkedList<>();
		
		li.add("1");
		li.add("2");
		li.add("3");
		
		li.addFirst("5");
		li.addLast("7");
		li.add(1, "8");
		
		System.out.println(li);
		
	}
}
