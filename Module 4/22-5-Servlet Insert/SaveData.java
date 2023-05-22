import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveData extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name1 = req.getParameter("name");
		String pass1 = req.getParameter("pass");
		
		Model m =new Model();
		m.setName(name1);
		m.setPass(pass1);
		
		int status = Dao.savedata(m);
		
		if(status>0)
		{
			out.print("success");
		}
		else
		{
			out.print("Fail");
		}
	}
}
