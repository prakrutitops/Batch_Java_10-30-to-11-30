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
			
			List<Model>list = MyDao.viewdata();
			
			out.print("<table border='1' cellpadding='5' cellspacing='5'>");
			out.print("<tr><th>Id</th><th>Name</th><th>Surname</th><th>Email</th></tr>");
			for(Model m :list)
			{
				
				out.print("<tr><td>"+m.getId()+"</td><td>"+m.getName()+"</td><td>"+m.getSurname()+"</td><td>"+m.getEmail()+"</td></tr>");

				
			}
			
			out.print("</table>");
			out.print("<a href='index.html'>Add Data</a>");
		}
}
