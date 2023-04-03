package com.a34;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FoodOrderEx implements ActionListener
{	
	
	//Global Declaration
	JFrame frame;
	JLabel l1;
	JCheckBox chk1,chk2,chk3;
	JButton btn1;
	
	
	public FoodOrderEx() 
	{
		
		frame =new JFrame("Cafe Example");
		
		l1 =new JLabel("Food Ordering System");
		l1.setBounds(199, 11, 146, 14);
		
		chk1=new JCheckBox("Pizza @ Rs. 100");
		chk1.setBounds(64, 40, 197, 23);
		
		chk2=new JCheckBox("Burger @ Rs. 70");
		chk2.setBounds(64, 80, 197, 23);
		
		chk3=new JCheckBox("Coffee @ Rs.120");
		chk3.setBounds(64, 120, 197, 23);
		
		btn1 =new JButton("Order");
		btn1.setBounds(174, 159, 89, 23);
		
		btn1.addActionListener(this);
			
		
		
		frame.add(l1);
		frame.add(chk1);
		frame.add(chk2);
		frame.add(chk3);
		frame.add(btn1);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new FoodOrderEx();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==btn1)
		{
			StringBuffer b =new StringBuffer();
			b.append("\n selected Items");
			int total =0;
			
			if(chk1.isSelected())
			{
				b.append("\n Pizza - Rs.100");
				total+=100;
			}
			if(chk2.isSelected())
			{
				b.append("\n Burger - Rs.70");
				total+=70;
			}
			if(chk3.isSelected())
			{
				b.append("\n Coffee - Rs.120");
				total+=120;
			}
			StringBuffer total2 =new StringBuffer("");
			total2.append(b);
			total2.append("\n Total: "+total);
			
			JOptionPane.showMessageDialog(frame,total2.toString());
			
		}
	}
}
