package com.b;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class DropDownEx implements ItemListener
{
	JFrame frame;
	String city[]= {"Rajkot","Baroda","Surat"};
	JComboBox<String> combo;
	
	public DropDownEx() 
	{
		// TODO Auto-generated constructor stub
		frame =new JFrame();
		
		combo =new JComboBox<String>(city);
		combo.setBounds(122, 44, 128, 20);
		combo.addItemListener(this);
		frame.add(combo);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	
	}
	
	public static void main(String[] args) 
	{
		new DropDownEx();
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==combo)
		{
			
			System.out.println("City is :"+combo.getItemAt(combo.getSelectedIndex()));
		}
	}
}
