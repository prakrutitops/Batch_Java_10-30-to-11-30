import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test implements ActionListener //7.Implement ActionListener
{
	//1. Declare
	JFrame frame;
	JButton btn1,btn2,btn3,btn4;
	
	
	public Test() 
	{
		//2. Initialize
		frame =new JFrame();
		
		btn1 = new JButton("INSERT");
		btn2 = new JButton("VIEW");
		btn3 = new JButton("UPDATE");
		btn4 = new JButton("DELETE");

		
		//6.Set click event of button
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		
		//3. Add Buttons in Frame
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		
		//4. Show Frame
		frame.setSize(400,400);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
	}
	public static void main(String[] args) 
	{
		//5. Call Constructor
		new Test();
	}

//8.Override ActionListener
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//13. Call AllOperations class here
		AllOperations a =new AllOperations();
		//14. call insertmethod
		if(e.getSource()==btn1)
		{
			a.insertdata();
		}
		//22. Call View Method
		if(e.getSource()==btn2)
		{
			a.viewdata();
		}
		//29.Call Delete Method
		if(e.getSource()==btn4)
		{
			a.deletedata();
		}
		//37.Call Update Method
		if(e.getSource()==btn3)
		{
			a.updatedata();
		}
		
	}
}
//9. Create a class  
class AllOperations
{
	
	//10.Decalre Data in  new frame
	JFrame insertframe,deleteframe,updateframe;
	JTextField tf1,tf2,tf3;
	JPanel jp,jp2;
	JButton btninsert,btndelete,btnedit,btnupdate;
	int did =0;
	
	//11.Create insert method and Initialize data
	public void insertdata()
	{
		
		insertframe = new JFrame();
		tf1 =new JTextField(20);
		tf2=new JTextField(20);
		btninsert=new JButton("ADD");
		
		//12. set button click event
		btninsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
			
				
				//15. Give database Configuration
				String host="jdbc:mysql://localhost:3306/";
				String db="vivo";
				String url = host+db;
				
				//16. get data from frame
				String name = tf1.getText().toString();
				String surname = tf2.getText().toString();
				
				
				try 
				{
					//17. Drivermanager Connection
					
					/*
					 * username -root 
					 * passsword -
					 */
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,"root","");
					//18. SQL Query
					String sql="insert into register value(null,'"+name+"','"+surname+"')";
					
					//19. Query Execute
					Statement stmt = con.createStatement();
					int status = stmt.executeUpdate(sql);
					
					//20. Query Result
					if(status>0)
					{
						insertframe.setVisible(false);
					}
					else
					{
						System.out.println("Error");
					}
				} 
				catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
		});
		
		insertframe.add(tf1);
		insertframe.add(tf2);
		insertframe.add(btninsert);
		insertframe.setSize(500,500);
		insertframe.setLayout(new FlowLayout());
		insertframe.setVisible(true);
	}
	
	//21.Create View Method
	public void viewdata()
	{
		//22. Db Configuration
		String host="jdbc:mysql://localhost:3306/";
		String db="vivo";
		String url = host+db;
		
		try
		{
			//23. DriverManager Connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","");
			
			//24. Sql Query
			String sql ="select * from register";
			Statement stmt = con.createStatement();
			
			//25. Execute Query
			ResultSet set = stmt.executeQuery(sql);
			System.out.println("ID   NAME   SURNAME");
			
			//26. Data retrive in Loop
			while(set.next())
			{
				
				int id = set.getInt(1);
				String name = set.getString(2);
				String surname = set.getString(3);
				
				//27. Print Data
				System.out.println(id+" "+name+" "+surname);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}
	//28.Create Delete method
	public void deletedata()
	{
		//29.Declare data
		deleteframe =new JFrame();
		tf3 =new JTextField(20);
		btndelete =new JButton("DELETE");
		
		//31. Delete Click event
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				
				
				//32. Db Configuration
				String host="jdbc:mysql://localhost:3306/";
				String db="vivo";
				String url = host+db;

				//33. Get Data From TextField
				String id = tf3.getText().toString();
				
				//34. DriverManager Connection
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,"root","");
				
					//35. Delete Query
					String sql ="Delete from register where id='"+id+"'";
					
					//36. Query Execution - Statement
					Statement stmt = con.createStatement();
					int status = stmt.executeUpdate(sql);
					
					if(status>0)
					{
						deleteframe.setVisible(false);
					}
					else
					{
						System.out.println("Error");
					}
					
					
				
				}
				catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		
		//30. Initialize Data
		deleteframe.add(tf3);
		deleteframe.add(btndelete);
		deleteframe.setSize(400,400);
		deleteframe.setLayout(new FlowLayout());
		deleteframe.setVisible(true);
	}
	public void updatedata()
	{
		//38.declare and initialize data and frame
		updateframe =new JFrame();
		
		jp =new JPanel();
		jp2 =new JPanel();

		tf1 =new JTextField(20);
		tf2 =new JTextField(20);
		tf3 =new JTextField(10);
		
		btnedit =new JButton("Edit");
		btnupdate =new JButton("Update");
		
		jp.add(tf3);
		jp.add(btnedit);
		
		//39.
		btnedit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
				
			did = Integer.parseInt(tf3.getText().toString());
				
			//40.
			String host="jdbc:mysql://localhost:3306/";
			String db="vivo";
			String url = host+db;
			
			//41.
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,"root","");
				
				//42.
				String sql ="select * from register where id ='"+did+"'";
				
				//43.
				Statement stmt= con.createStatement();
				ResultSet set =stmt.executeQuery(sql);
				
				
				//44.
				if(set.next())
				{
					int i1 = set.getInt(1);
					String n1 = set.getString(2);
					String s1 = set.getString(3);
					
					jp2.setVisible(true);
					jp.setVisible(false);
					
					tf1.setText(n1);
					tf2.setText(s1);
					
				}
				
				//45.
				btnupdate.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						//46.
						String myname = tf1.getText().toString();
						String mysurname = tf2.getText().toString();
						
						//47.
						String host="jdbc:mysql://localhost:3306/";
						String db="vivo";
						String url = host+db;
						
						//48.
						try 
						{
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection(url,"root","");
							
							//49.
							String sql ="update register set name='"+myname+"',surname ='"+mysurname+"' where id ='"+did+"'";
							Statement stmt = con.createStatement();
							int status = stmt.executeUpdate(sql);
							//50.
							if(status>0)
							{
								updateframe.setVisible(false);
							}
							else
							{
								System.out.println("Error");
							}
							
							
						}
						catch (Exception e1) 
						{
							// TODO: handle exception
							e1.printStackTrace();
						}
					}
				});
				
				
				
			}
			catch (Exception e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				
			}
		});
		
		
		
		
		
		jp2.add(tf1);
		jp2.add(tf2);
		jp2.add(btnupdate);
		jp.setVisible(true);
		jp2.setVisible(false);
		
		updateframe.add(jp);
		updateframe.add(jp2);
		updateframe.setSize(400,400);
		updateframe.setLayout(new FlowLayout());
		updateframe.setVisible(true);
		
	}
	
}
