package com.a34;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JFrameEx2 
{
	
	JFrame frame;
	JPasswordField p1,p2;
	JLabel l1,l2,l3,l4,l5,l;
	JTextField t1,t2,t3;
	JButton b1;
	
	
	
	public JFrameEx2()
	{
		frame = new JFrame();
		
		
		l = new JLabel("   REGISTER A NEW STUDENT");
		l.setBounds(165, 21, 348, 13);
		l.setFont(new Font("Tahoma",Font.BOLD, 15));
		
		l1 = new JLabel("Name");
		l1.setBounds(74, 58, 114, 22);
		l1.setFont(new Font("Tahoma",Font.BOLD, 15));
		t1 = new  JTextField("");
		t1.setBounds(198, 59, 265, 22);
				

		l2 = new JLabel("Mail id");
		l2.setBounds(74, 122, 114, 22);
		l2.setFont(new Font("Tahoma",Font.BOLD, 15));
		t2 = new JTextField("");
		t2.setBounds(198, 91, 265, 22);
		
		
		l3 = new JLabel("Mobile no");
		l3.setBounds(74, 90, 114, 22);
		l3.setFont(new Font("Tahoma",Font.BOLD, 15));
		t3 = new JTextField("");
		t3.setBounds(198, 123, 265, 22);
		
		
		l4 = new JLabel("Password");
		l4.setBounds(74, 154, 114, 22);
		l4.setFont(new Font("Tahoma",Font.BOLD, 15));
		p1 = new JPasswordField("");
		p1.setBounds(198, 155, 265, 22);
		
		
		l5 = new JLabel("Re-Password");
		l5.setBounds(74, 186, 114, 22);
		l5.setFont(new Font("Tahoma",Font.BOLD, 15));
		p2 = new JPasswordField("");
		p2.setBounds(198, 187, 265, 22);
		
		b1 = new JButton("Register");
		b1.setBounds(243, 238, 157, 32);
		b1.setFont(new Font("Tahoma",Font.BOLD, 15));
		
		frame.add(l);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(t1);
		frame.add(t2);
		frame.add(t3);
		frame.add(p1);
		frame.add(p2);
		frame.add(b1);
		
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				try 
				{
					
					String name=t1.getText().toString();
					String mob=t2.getText().toString();
					String mail=t3.getText().toString();
					String pass=p1.getText().toString();
					String repass=p2.getText().toString();
					

					String name1="\n Your Name is :";
					String mob1="\n Your Mobile is: ";
					String mail1="\n Your Mail is :";
					String pass1="\n Your Pass is : ";
					String repass1="\n Your Repass is: ";
					
					
					
					if(pass.equals(repass))
					{
						FileOutputStream fout =new FileOutputStream("E://sujal.txt");
						fout.write(name1.getBytes());
						fout.write(name.getBytes());
						fout.write(mob1.getBytes());
						fout.write(mob.getBytes());
						fout.write(mail1.getBytes());
						fout.write(mail.getBytes());
						fout.write(pass1.getBytes());
						fout.write(pass.getBytes());
						fout.write(repass1.getBytes());
						fout.write(repass.getBytes());
						System.out.println("Success");
					}
					else
					{
						System.out.println("Password and repassword are not same");
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

	
	public static void main(String[] args) 
	{
		new JFrameEx2();
	}

	
	


}


	
