import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao 
{
	
	
	public static Connection getconnect()
	{
		Connection con = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	//Insert
	public static int savedata(Model m)
	{
		
		int status =0;
		
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into data (name,email,address,phone) values (?,?,?,?)");
			ps.setString(1,m.getName());
			ps.setString(2,m.getEmail());
			ps.setString(3,m.getAddress());
			ps.setString(4,m.getPhone());
			
			status = ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status;
		
	}
	
	public static List<Model> viewdata() 
	{
		Connection con = Dao.getconnect();
		List<Model>list =new ArrayList<>(); 
		try { 
			PreparedStatement ps = con.prepareStatement("select * from data");
			ResultSet set =ps.executeQuery();
			  
			  while(set.next()) 
			  {
				  int id = set.getInt(1); 
				  String name = set.getString(2);
				  String email = set.getString(3);
				  String address = set.getString(4);
				  String phone = set.getString(5);
			  
				  Model m =new Model(); 
				  
				  m.setId(id);
				  m.setName(name);
				  m.setEmail(email);
				  m.setAddress(address);
				  m.setPhone(phone);
			  
			  list.add(m); 
			  
			  }
			  
			  }
				catch (Exception e) { // TODO Auto-generated catch block
			 e.printStackTrace(); }
			  
			  return list;
			 
			  
			 
			  }
	
	/*
	 * //View public static List<Model> viewdata() { Connection con =
	 * Dao.getconnect(); List<Model>list =new ArrayList<>(); try { PreparedStatement
	 * ps = con.prepareStatement("select * from info"); ResultSet set =
	 * ps.executeQuery();
	 * 
	 * while(set.next()) { int id = set.getInt(1); String name = set.getString(2);
	 * String pass = set.getString(3);
	 * 
	 * Model m =new Model(); m.setId(id); m.setName(name); m.setPass(pass);
	 * 
	 * list.add(m); }
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return list;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * //Delete public static void deltedata(int id) {
	 * 
	 * int delete=0;
	 * 
	 * Connection con = Dao.getconnect();
	 * 
	 * try { PreparedStatement ps =
	 * con.prepareStatement("delete from info where id=?"); ps.setInt(1,id);
	 * 
	 * delete = ps.executeUpdate();
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * //Edit Fetch public static Model getemployeebyid(int id) { Model m=new
	 * Model(); Connection con= Dao.getconnect();
	 * 
	 * try { PreparedStatement ps =
	 * con.prepareStatement("select * from info where id =?"); ps.setInt(1, id);
	 * ResultSet set=ps.executeQuery();
	 * 
	 * if(set.next()) { int id2=set.getInt(1); String name=set.getString(2); String
	 * pass=set.getString(3);
	 * 
	 * 
	 * m.setId(id2); m.setName(name); m.setPass(pass);
	 * 
	 * }
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return m; }
	 * 
	 * //Update public static int updatedata(Model m) { Connection con =
	 * Dao.getconnect(); int status =0;
	 * 
	 * try { PreparedStatement ps =
	 * con.prepareStatement("update info set name=?,pass=? where id =?");
	 * 
	 * ps.setString(1,m.getName()); ps.setString(2,m.getPass());
	 * ps.setInt(3,m.getId());
	 * 
	 * status = ps.executeUpdate();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return status; }
	 */
}
