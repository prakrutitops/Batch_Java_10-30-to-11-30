<%@page import="com.dao.*"%>
<%@page import="com.model.AdminModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




	<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	AdminModel m2 =new AdminModel();
	m2.setEmail(email);
	m2.setPassword(password);
	
	
	
	


	
	
	
	
	//System.out.println(m2.getName());
	

	WebDao w = new WebDao();
	AdminModel m = w.adminlogincheck(m2);

	if (m != null) {
		session.setAttribute("webwing", true);
		session.setAttribute("myemail", email);
		response.sendRedirect("admindashboard.jsp");

	} else {

		request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
	}
	%>

</body>
</html>