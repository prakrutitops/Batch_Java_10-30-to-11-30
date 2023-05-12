import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDao 
{
	
	public static Connection getconnect() 
	{
		Connection con =null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
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
		Connection con = MyDao.getconnect();
		int status =0;
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into contact(name,surname,email) values(?,?,?)");
			ps.setString(1,m.getName());
			ps.setString(2,m.getSurname());
			ps.setString(3,m.getEmail());
			
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
		Connection con = MyDao.getconnect();
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from contact");
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				Model m =new Model();
				m.setId(set.getInt(1));
				m.setName(set.getString(2));
				m.setSurname(set.getString(3));
				m.setEmail(set.getString(4));
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
	
	
	
	
}
