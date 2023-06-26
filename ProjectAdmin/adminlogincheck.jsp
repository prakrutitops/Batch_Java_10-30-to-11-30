<%@page import="com.dao.UserDao"%>
<%@page import="com.model.AdminLoginModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<%
	
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		AdminLoginModel m = new AdminLoginModel();
		m.setEmail(email);
		m.setPass(pass);
		
		UserDao u =new UserDao();
		
		AdminLoginModel m2 =u.adminlogin(m);
		
		if(m2!=null)
		{
			session.setAttribute("webwingadmin", true);
			session.setAttribute("myemail", email);
			
			
			response.sendRedirect("adminhome.jsp");
			
			
		}
		else
		{
			response.sendRedirect("adminlogin.jsp");
		}
		
	
	%>


</body>
</html>