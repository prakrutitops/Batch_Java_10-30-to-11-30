import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterLoginEx implements ActionListener
{
	JFrame frame;
	JButton signupbtn,loginbtn;

	
	public RegisterLoginEx() 
	{
		// TODO Auto-generated constructor stub
		
		frame =new JFrame();
		
		signupbtn =new JButton("Signup");
		loginbtn = new JButton("Login");
		
		
		signupbtn.addActionListener(this);
		loginbtn.addActionListener(this);
		
		
		frame.add(signupbtn);
		frame.add(loginbtn);
		frame.setSize(400,400);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
	}
	public static void main(String[] args) 
	{
		
		new RegisterLoginEx();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		AllOperations2 a =new AllOperations2();
		if(e.getSource()==signupbtn)
		{
			a.signup();
		}
		if(e.getSource()==loginbtn)
		{
			a.login();
		}
	}
}
class AllOperations2
{
	JFrame signupframe,loginframe;
	JTextField tfusername,tfname,tfemail;
	JPasswordField tfpass;
	JButton btnsignup,btnlogin;
	JLabel luname,lname,lemail,lpass;
	String iemail,ipass;
	
	
	public void signup()
	{
		signupframe =new JFrame();
		
		tfusername = new JTextField(20);
		tfusername.setBounds(115, 22, 195, 20);
		
		tfname =new JTextField(20);
		tfname.setBounds(115, 64, 195, 20);

		tfemail=new JTextField(20);
		tfemail.setBounds(115, 104, 195, 20);
		
		tfpass =new JPasswordField(20);
		tfpass.setBounds(115, 142, 195, 20);
		
		btnsignup =new JButton("Sign up");
		btnsignup.setBounds(115, 188, 89, 23);
		
		luname =new JLabel("Username: ");
		luname.setBounds(44, 25, 70, 17);
		
		lname =new JLabel("Name: ");
		lname.setBounds(44, 67, 70, 17);
		
		lemail =new JLabel("Email: ");
		lemail.setBounds(44, 107, 70, 17);
		
		lpass =new JLabel("Password: ");
		lpass.setBounds(44, 145, 70, 17);
		
		signupframe.add(luname);
		signupframe.add(lname);
		signupframe.add(lemail);
		signupframe.add(lpass);
		signupframe.add(tfusername);
		signupframe.add(tfname);
		signupframe.add(tfemail);
		signupframe.add(tfpass);
		signupframe.add(btnsignup);
		signupframe.setSize(500,500);
		signupframe.setLayout(null);
		signupframe.setVisible(true);
		
		btnsignup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				String host="jdbc:mysql://localhost:3306/";
				String db="regsys";
				String url = host+db;
				
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,"root","");
					
					String uname = tfusername.getText().toString();
					String name = tfname.getText().toString();
					String email= tfemail.getText().toString();
					String pass = tfpass.getText().toString();
					
					String sql ="insert into signup value (null,'"+uname+"','"+name+"','"+email+"','"+pass+"')";
					Statement stmt = con.createStatement();
					int status = stmt.executeUpdate(sql);
					
					if(status>0)
					{
						signupframe.setVisible(false);
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
	}
	public void login()
	{
		loginframe =new JFrame();
	
		tfemail = new JTextField(20);
		tfemail.setBounds(115, 22, 195, 20);
		
		tfpass =new JPasswordField(20);
		tfpass.setBounds(115, 64, 195, 20);
		
		lemail =new JLabel("Email: ");
		lemail.setBounds(44, 25, 70, 17);
		
		lpass =new JLabel("Password: ");
		lpass.setBounds(44, 67, 70, 17);
		
		
		btnlogin =new JButton("Login");
		btnlogin.setBounds(115, 188, 89, 23);
		
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String host="jdbc:mysql://localhost:3306/";
				String db="regsys";
				String url = host+db;
				
				String email= tfemail.getText().toString();
				String pass = tfpass.getText().toString();
				
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,"root","");
				
					String sql ="select email,password from signup where email ='"+email+"'";
					Statement stmt = con.createStatement();
					ResultSet set= stmt.executeQuery(sql);
					
					if(set.next())
					{
						
						iemail=set.getString(1);
						ipass=set.getString(2);
						
						if(ipass.equals(pass))
						{
							JOptionPane.showMessageDialog(loginframe,"Login Succesful");
						}
						else
						{
							JOptionPane.showMessageDialog(loginframe,"Password is invalid");
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(loginframe,"No user found, Email id is  invalid");
					}
					
					
				}
				catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		loginframe.add(lemail);
		loginframe.add(lpass);
		loginframe.add(tfemail);
		loginframe.add(tfpass);
		loginframe.add(btnlogin);
		loginframe.setSize(500,500);
		loginframe.setLayout(null);
		loginframe.setVisible(true);
	}
}