package com.a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameEx1 implements ActionListener
{
		JFrame frame;
		JTextField tf1,tf2,tf3;
		JLabel l1;
		
		JButton btn1,btn2;
		
		public FrameEx1() 
		{
			// TODO Auto-generated constructor stub
			frame =new JFrame();
			btn1 =new JButton("+");
			btn1.setBounds(58, 150, 89, 39);
			
			btn2 =new JButton("-");
			btn2.setBounds(153, 150, 89, 39);
			
			tf1=new JTextField();
			
			l1 =new JLabel("xyz");
			l1.setBounds(x, y, width, height);
			tf1.setBounds(58, 40, 186, 20);
			
			tf2=new JTextField();
			tf2.setBounds(58, 73, 186, 20);
			
			tf3=new JTextField();
			tf3.setBounds(58, 104, 186, 20);
			
			frame.add(btn1);
			frame.add(btn2);
			frame.add(tf1);
			frame.add(tf2);
			frame.add(tf3);
			frame.add(l1);
			frame.setSize(500,500);
			frame.setLayout(null);
			frame.setVisible(true);
			
			
			/*btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					
					String a = tf1.getText().toString();
					String b = tf2.getText().toString();
					
					int c = Integer.parseInt(a)+Integer.parseInt(b);
					tf3.setText(String.valueOf(c));					
					
				}
			});
			
			btn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String a = tf1.getText().toString();
					String b = tf2.getText().toString();
					
					int c = Integer.parseInt(a)-Integer.parseInt(b);
					tf3.setText(String.valueOf(c));			
				}
			});
			*/
			
			btn1.addActionListener(this);
			btn2.addActionListener(this);
			
			
		
		}
		
	public static void main(String[] args) 
	{
		new FrameEx1();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		// TODO Auto-generated method stub
		String a = tf1.getText().toString();
		String b = tf2.getText().toString();
		int c=0;
		if(e.getSource()==btn1)
		{
			c = Integer.parseInt(a)+Integer.parseInt(b);
		}
		if(e.getSource()==btn2)
		{
			c = Integer.parseInt(a)-Integer.parseInt(b);
		}
		tf3.setText(String.valueOf(c));				
	}
}
