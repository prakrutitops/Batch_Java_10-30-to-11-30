package com.a74;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FlowLayoutEx 
{
	JFrame frame;
	JButton b1,b2,b3,b4;
	JTextField tf1;
	public FlowLayoutEx() 
	{
		// TODO Auto-generated constructor stub
		frame =new JFrame();
		
		b1 = new JButton("INSERT");
		b2 = new JButton("VIEW");
		b3 = new JButton("UPDATE");
		b4 = new JButton("DELETE");
		tf1 =new JTextField(10);
		
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(tf1);
		frame.setSize(500,500);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
	
	}
	
	
	public static void main(String[] args) 
	{
		
		new FlowLayoutEx();
		
	}
}
