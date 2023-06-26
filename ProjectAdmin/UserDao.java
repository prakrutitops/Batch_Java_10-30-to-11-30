package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.model.AdminLoginModel;
import com.model.ConatctModel;
import com.model.ProductModel;
import com.model.SignupModel;
import com.model.WishlistModel;



public class UserDao 
{
	
	public static Connection getconnect()
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webwing","root","");
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
	}
	
	public static int savedata(SignupModel m)
	{
		Connection con = UserDao.getconnect();
		int status =0;
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into signup(name,email,phone,password) values(?,?,?,?)");
			ps.setString(1,m.getName());
			ps.setString(2,m.getEmail());
			ps.setString(3,m.getPhone());
			ps.setString(4,m.getPassword());
			
			status = ps.executeUpdate();
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	//login
	
	public SignupModel LoginCoustomer(SignupModel model) {
		boolean flag = false;

		SignupModel obj = null;

		try {
			Connection con = UserDao.getconnect();
			PreparedStatement ps = con.prepareStatement("select * from signup where email=? and password=?");
			ps.setString(1, model.getEmail());
			ps.setString(2, model.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) 
			{
				obj = new SignupModel();
				obj.setName(rs.getString("name"));
				obj.setEmail(rs.getString("email"));
				obj.setPhone(rs.getString("phone"));
				obj.setPassword(rs.getString("password"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}
	
	public static int submitdata(ConatctModel m )
	{
		Connection con = UserDao.getconnect();
		int status =0;
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into contact(name,email,phone,message) values(?,?,?,?)");
			ps.setString(1,m.getName());
			ps.setString(2,m.getEmail());
			ps.setString(3,m.getPhone());
			ps.setString(4,m.getMessage());
			
			status = ps.executeUpdate();
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		}
	public static List<ProductModel> getAll()
	{
		List<ProductModel> i = new ArrayList<ProductModel>();
		try {
			
			Connection con = UserDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from products");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				ProductModel d1 = new ProductModel();
				//d1 = new ImageModel();
				d1.setP_id(rs.getInt(1));
				d1.setP_name(rs.getString(2));
				d1.setP_price(rs.getInt(3));
				d1.setP_description(rs.getString(4));
				d1.setP_image(rs.getString(5));
				i.add(d1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
	
	
	public static int addtowishlist(WishlistModel m)
	{
		Connection con = UserDao.getconnect();
		int status =0;
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into wishlist(p_name,p_price,p_description,p_image,email) values(?,?,?,?,?)");

			ps.setString(1,m.getP_name());
			ps.setString(2,m.getP_price());
			ps.setString(3,m.getP_description());
			ps.setString(4,m.getP_image());
			ps.setString(5, m.getEmail());
			
			status = ps.executeUpdate();
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static ProductModel getproductsingledetail(int id)
	{
		
		ProductModel m =new ProductModel();
		
			Connection con =UserDao.getconnect();
			
			try 
			{
				PreparedStatement ps =(PreparedStatement) con.prepareStatement("select * from products where p_id=?");
				ps.setInt(1,id);
				ResultSet set=ps.executeQuery();
				
				if(set.next())
				{
					
					m.setP_id(set.getInt(1));
					m.setP_name(set.getString(2));
					m.setP_price(set.getInt(3));
					m.setP_description(set.getString(4));
					m.setP_image(set.getString(5));
					
					
					
					
					
					
				}
				
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return m;
		
	}
	
	public static List<WishlistModel> getallwishdetail(SignupModel m2)
	{
		List<WishlistModel> i2 = new ArrayList<WishlistModel>();
		
		HttpServletRequest request = null;
		
		try {
			
			
			SignupModel s=new SignupModel();
			Connection con = UserDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from wishlist where email=?");
			System.out.println(m2.getEmail());
			ps.setString(1, m2.getEmail());
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				WishlistModel d1 = new WishlistModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setP_name(rs.getString(2));
				d1.setP_price(rs.getString(3));
				d1.setP_description(rs.getString(4));
				d1.setP_image(rs.getString(5));
				i2.add(d1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i2;
	}
	
	
	public AdminLoginModel adminlogin(AdminLoginModel model) {
		boolean flag = false;

		AdminLoginModel obj = null;

		try {
			Connection con = UserDao.getconnect();
			PreparedStatement ps = con.prepareStatement("select * from adminlogin where email=? and pass=?");
			ps.setString(1, model.getEmail());
			ps.setString(2, model.getPass());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) 
			{
				obj = new AdminLoginModel();
				
				obj.setEmail(rs.getString("email"));
				obj.setPass(rs.getString("pass"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}
	
	public static List<ConatctModel> getcontact()
	{
		List<ConatctModel> i = new ArrayList<ConatctModel>();
		try {
			
			Connection con = UserDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from contact");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				ConatctModel d1 = new ConatctModel();
				//d1 = new ImageModel();
				
				d1.setId(rs.getInt(1));
				d1.setName(rs.getString(2));
				d1.setEmail(rs.getString(3));
				d1.setPhone(rs.getString(4));
				d1.setMessage(rs.getString(5));
				
				i.add(d1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
	
	
	
}
