package com.b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MenuEx implements ActionListener
{
	JFrame frame;
	JMenuBar mb;
	JMenu m1,m2,m3;
	JMenuItem i1,i2,i3,i4,i5;
	JTextArea ta;
	
	public MenuEx() 
	{
		// TODO Auto-generated constructor stub
		
		frame =new JFrame();
		
		mb =new JMenuBar();
		
		m1 =new JMenu("File");
		m2 =new JMenu("Edit");
		m3 =new JMenu("Help");
		
		i1 =new JMenuItem("Cut");
		i2 =new JMenuItem("Copy");
		i3 =new JMenuItem("Paste");
		i4 =new JMenuItem("SelectAll");
		
		ta =new JTextArea();
		ta.setBounds(40, 100, 300, 100);
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		
		m2.add(i1);
		m2.add(i2);
		m2.add(i3);
		m2.add(i4);
		
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		
		frame.add(ta);
		frame.setSize(400,400);
		frame.setJMenuBar(mb);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new MenuEx();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==i1)
		{
			ta.cut();
		}
		if(e.getSource()==i2)
		{
			ta.copy();
		}
		if(e.getSource()==i3)
		{
			ta.paste();
		}
		if(e.getSource()==i4)
		{
			ta.selectAll();
		}
	}
	
}
