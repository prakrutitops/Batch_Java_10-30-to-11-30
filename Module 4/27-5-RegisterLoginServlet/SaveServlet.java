import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name1 = req.getParameter("name");
		String email1 = req.getParameter("email");
		String address1 = req.getParameter("address");
		String phone1 = req.getParameter("phone");
		
		
		Model m =new Model();
		m.setName(name1);
		m.setEmail(email1);
		m.setAddress(address1);
		m.setPhone(phone1);
		
		int status = Dao.savedata(m);
		
		if(status>0)
		{
			resp.sendRedirect("ViewServlet");
		}
		else
		{
			out.print("Fail");
		}
	}
}
