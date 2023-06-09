<%@page import="com.dao.UserDao"%>
<%@page import="com.model.SignupModel"%>
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
		String pass = request.getParameter("password");
		
		SignupModel m = new SignupModel();
		m.setEmail(email);
		m.setPassword(pass);
		
		UserDao u =new UserDao();
		
		SignupModel m2 =u.LoginCoustomer(m);
		
		if(m2!=null)
		{
			session.setAttribute("webwing", true);
			session.setAttribute("myemail", email);
			session.setAttribute("myname", m2.getName());
			session.setAttribute("mymobile", m2.getPhone());
			
			response.sendRedirect("home.jsp");
			
			
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
	
	%>


</body>
</html>