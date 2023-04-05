package com.b;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OptionPaneEx3 extends WindowAdapter
{
		JFrame frame;
	
	public OptionPaneEx3()
	{
		// TODO Auto-generated constructor stub
		frame =new JFrame();
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(this);
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
	
	}
	

	@Override
	public void windowClosing(WindowEvent e) 
	{
		// TODO Auto-generated method stub
		//super.windowClosing(e);
	
		int op1 = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?");
		
		if(op1==JOptionPane.YES_OPTION)
		{
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if(op1==JOptionPane.NO_OPTION)
		{
			
		}
		if(op1==JOptionPane.CANCEL_OPTION)
		{
			
		}
	
	}
	
	public static void main(String[] args) 
	{
		new OptionPaneEx3();
	}
}
