package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.model.AdminModel;
import com.model.CartModel;
import com.model.ContactModel;
import com.model.ImageModel;
import com.model.SignupModel;
import com.model.WishModel;

public class WebDao {

	public static Connection getconnect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webwing", "root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public static int RegisterCoustomer(SignupModel m) {
		int status = 0;

		Connection con = WebDao.getconnect();

		try {
			java.sql.PreparedStatement ps = con
					.prepareStatement("insert into signup(name,email,mobile,password) values(?,?,?,?)");

			ps.setString(1, m.getName());
			ps.setString(2, m.getEmail());
			ps.setString(3, m.getMobile());
			ps.setString(4, m.getPassword());

			status = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;
	}

	public SignupModel LoginCoustomer(SignupModel model) {
		boolean flag = false;

		SignupModel obj = null;

		try {
			Connection con = WebDao.getconnect();
			PreparedStatement ps = con.prepareStatement("select * from signup where email=? and password=?");
			ps.setString(1, model.getEmail());
			ps.setString(2, model.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				obj = new SignupModel();
				obj.setName(rs.getString("name"));
				obj.setEmail(rs.getString("email"));
				obj.setMobile(rs.getString("mobile"));
				obj.setPassword(rs.getString("password"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}
	
	
	public static int ContactForm(ContactModel m) {
		int status = 0;

		Connection con = WebDao.getconnect();

		try {
			PreparedStatement ps = con
					.prepareStatement("insert into contactus(name,email,subject,message) values(?,?,?,?)");

			ps.setString(1, m.getName());
			ps.setString(2, m.getEmail());
			ps.setString(3, m.getSubject());
			ps.setString(4, m.getMessage());

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}
	
	public static List<ImageModel> getAll()
	{
		List<ImageModel> i = new ArrayList<ImageModel>();
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from product");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				ImageModel d1 = new ImageModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setName(rs.getString(2));
				d1.setImage(rs.getString(3));
				d1.setEmail(rs.getString(4));
				i.add(d1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
	
	public static ImageModel getproductdetail(int id)
	{
		
		ImageModel m =new ImageModel();
		
			Connection con =WebDao.getconnect();
			
			try 
			{
				PreparedStatement ps =(PreparedStatement) con.prepareStatement("select * from product where id=?");
				ps.setInt(1,id);
				ResultSet set=ps.executeQuery();
				
				if(set.next())
				{
					
					m.setId(set.getInt(1));
					m.setName(set.getString(2));
					m.setImage(set.getString(3));
					m.setEmail(set.getString(4));
					
					
					
				}
				
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return m;
		
	}
	
	public static int Cart12(CartModel m) {
		int status = 0;

		Connection con = WebDao.getconnect();

		try {
			PreparedStatement ps = con.prepareStatement("insert into cart(id,product_name,product_image,email) values(?,?,?,?)");

			ps.setInt(1, m.getId());
			ps.setString(2, m.getProduct_name());
			ps.setString(3, m.getProduct_image());
			ps.setString(4, m.getEmail());
			
		

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}	
	
	public static int Wish12(CartModel m) {
		int status = 0;

		Connection con = WebDao.getconnect();

		try {
			PreparedStatement ps = con.prepareStatement("insert into wish(id,product_name,product_image,email) values(?,?,?,?)");

			ps.setInt(1, m.getId());
			ps.setString(2, m.getProduct_name());
			ps.setString(3, m.getProduct_image());
			ps.setString(4, m.getEmail());
		

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}	
	
	public static List<CartModel> getallcartdetail(SignupModel m2)
	{
		List<CartModel> i = new ArrayList<CartModel>();
		
		HttpServletRequest request = null;
		
		try {
			
			
			SignupModel s=new SignupModel();
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from cart where email=? ");
			System.out.println(m2.getEmail());
			ps.setString(1, m2.getEmail());
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				CartModel d1 = new CartModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setProduct_name(rs.getString(2));
				d1.setProduct_image(rs.getString(3));
				d1.setEmail(rs.getString(4));
				i.add(d1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
	
	
	
	
	public static List<WishModel> getallwishdetail(SignupModel m2)
	{
		List<WishModel> i2 = new ArrayList<WishModel>();
		
		HttpServletRequest request = null;
		
		try {
			
			
			SignupModel s=new SignupModel();
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from wish where email=? ");
			System.out.println(m2.getEmail());
			ps.setString(1, m2.getEmail());
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				WishModel d1 = new WishModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setProduct_name(rs.getString(2));
				d1.setProduct_image(rs.getString(3));
				d1.setEmail(rs.getString(4));
				i2.add(d1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i2;
	}
	
	
	
	
	
	public static List<CartModel> getallwishdetail()
	{
		List<CartModel> i = new ArrayList<CartModel>();
		
		
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from wish");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				CartModel d1 = new CartModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setProduct_name(rs.getString(2));
				d1.setProduct_image(rs.getString(3));
				d1.setEmail(rs.getString(4));
				i.add(d1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
	
	
	public static List<CartModel> getwishbyemail(String email)
	{//SELECT COUNT(product_name) FROM wishlist WHERE email ='darshit@gmail.com'

		List<CartModel> list = new ArrayList<CartModel>();
		CartModel d1 = new CartModel();
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from wish where email=?");
			ps.setString(1,email);
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			
			while(rs.next())
			{
				
				d1.setId(rs.getInt(1));
				d1.setProduct_name(rs.getString(2));
				d1.setProduct_image(rs.getString(3));
				list.add(d1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	/*public static SignupModel getemployeebyid(String email)
	{
		
		SignupModel m =new SignupModel();
		
			Connection con =WebDao.getconnect();
			
			try 
			{
				PreparedStatement ps =(PreparedStatement) con.prepareStatement("select * from signup where email=?");
				ps.setString(1,email);
				ResultSet set=ps.executeQuery();
				
				if(set.next())
				{
					m.setId(set.getInt(1));
					m.setName(set.getString(2));
					m.setEmail(set.getString(3));
					m.setMobile(set.getString(4));
					m.setPassword(set.getString(5));
					
					System.out.println(m.getEmail());
				}
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return m;
	}*/
	
	public AdminModel adminlogincheck(AdminModel model) {
		boolean flag = false;

		AdminModel obj = null;

		try {
			Connection con = WebDao.getconnect();
			PreparedStatement ps = con.prepareStatement("select * from admin_login where email=? and password=?");
			ps.setString(1, model.getEmail());
			ps.setString(2, model.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				obj = new AdminModel();
				
				obj.setEmail(rs.getString("email"));
				obj.setPassword(rs.getString("password"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}
	
	public static List<CartModel> getAdminAll()
	{
		List<CartModel> i = new ArrayList<CartModel>();
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from cart");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				CartModel d1 = new CartModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setProduct_name(rs.getString(2));
				d1.setProduct_image(rs.getString(3));
				d1.setEmail(rs.getString(4));
				i.add(d1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
	
	public static List<WishModel> getWishAdmin()
	{
		List<WishModel> i1 = new ArrayList<WishModel>();
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from wish");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				WishModel d1 = new WishModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setProduct_name(rs.getString(2));
				d1.setProduct_image(rs.getString(3));
				d1.setEmail(rs.getString(4));
				i1.add(d1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i1;
	}
	
	
	public static List<ContactModel> getContact()
	{
		List<ContactModel> i = new ArrayList<ContactModel>();
		try {
			
			Connection con = WebDao.getconnect();
			PreparedStatement ps= con.prepareStatement("Select * from contactus");
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next())
			{
				ContactModel d1 = new ContactModel();
				//d1 = new ImageModel();
				d1.setId(rs.getInt(1));
				d1.setName(rs.getString(2));
				d1.setEmail(rs.getString(3));
				d1.setSubject(rs.getString(4));
				d1.setMessage(rs.getString(5));
				i.add(d1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
}
