package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Model;

public class UserDao 
{
	
	public static Connection getconnect()
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz","root","");
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
	}
	
	public static int savedata(Model m)
	{
		Connection con = UserDao.getconnect();
		int status =0;
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into info(name,email,address,phone) values(?,?,?,?)");
			ps.setString(1,m.getName());
			ps.setString(2,m.getEmail());
			ps.setString(3,m.getAddress());
			ps.setString(4,m.getPhone());
			
			status = ps.executeUpdate();
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Model>viewdata()
	{
		List<Model>list =new ArrayList();
		Connection con = UserDao.getconnect();
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from info");
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				Model m =new Model();
				m.setId(set.getInt(1));
				m.setName(set.getString(2));
				m.setEmail(set.getString(3));
				m.setAddress(set.getString(4));
				m.setPhone(set.getString(5));
				list.add(m);
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		return list;
	}
	
	public static int Deletedata(int id)
	{
		
		int status=0;
		
		Connection con= UserDao.getconnect();
		
		try 
		{
			PreparedStatement ps =con.prepareStatement("delete from info where id =? ");
			ps.setInt(1,id);
			
			status = ps.executeUpdate();
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static Model getemployeebyid(int id)
	{
		Model m=new Model();
		Connection con= UserDao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from info where id =?");
			ps.setInt(1, id);
			ResultSet set=ps.executeQuery();
			
			if(set.next()) 
			{
				int id2=set.getInt(1);
				String name=set.getString(2);
				String email=set.getString(3);
				String address =set.getString(4);
				String phone = set.getString(5);
				
				
				m.setId(id2);
				m.setName(name);
				m.setEmail(email);
				m.setAddress(address);
				m.setPhone(phone);
			
			}
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public static int updatedata(Model m)
	{
		Connection con = UserDao.getconnect();
		int status =0;
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("update info set name=?,email=? , address=? , phone=?  where id =?");
			
			ps.setString(1,m.getName());
			ps.setString(2,m.getEmail());
			ps.setString(3,m.getAddress());
			ps.setString(4,m.getPhone());
			ps.setInt(5,m.getId());
			
			status = ps.executeUpdate();
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
}
