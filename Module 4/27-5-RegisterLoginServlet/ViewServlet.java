import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<center>");
		out.print("<table border='1'cellpadding='5px' cellspacing='5px' style='border-color: blue;'>");
		out.print("<thead>");
		out.print("<tr style='background-color: blue; color: white;'><th>Id</th><th>Name</th><th>Email</th><th>Address</th><th>Phone</th></tr>");
		
		List<Model>list = Dao.viewdata();
		
		for(Model m :list)
		{
			out.print("<tr><td>"+m.getId()+"</td><td>"+m.getName()+"</td><td>"+m.getEmail()+"</td><td>"+m.getAddress()+"</td><td>"+m.getPhone()+"</td></tr>");
		}
		
		
		out.print("</thead>");
		out.print("</table>");
		out.print("</center>");
		
	}
}
