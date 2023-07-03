<%@page import="com.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:useBean id="m" class="com.model.CartModel"/>
<jsp:setProperty property="*" name="m"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"/>
	
		
		<%
		
	
	
		int staus = UserDao.addtocart(m);
		
		if(staus>0)
		{
			//out.print("Success");
			response.sendRedirect("cartview.jsp");
		}
		else
		{
			out.print("Fail");
		}
	
	
	

%>
		
	
	
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>