<%@page import="com.dao.UserDao"%>
<%@page import="com.model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<%
		
	
	String id=request.getParameter("id");
	int id2=Integer.parseInt(id);
	ProductModel m2=UserDao.getproductsingledetail(id2);
	
	
	%>
	
	
	
	<center>
			
		<br>
		<br>
		
		<form action="mywishlist.jsp">
		
		
		<p>
			<input type="hidden" name="id" value="<%=m2.getP_id() %>">
		</p>
		
		<p>
			<h2 style="align-content: center;"><input type="text" name="p_name" value="<%=m2.getP_name() %>"></h2>
		</p>
		
		<p>
			<h2 style="align-content: center;"><input type="text" name="p_price" value="<%=m2.getP_price() %>"></h2>
		</p>
		
		<p>
			<h2 style="align-content: center;"><input type="text" name="p_description" value="<%=m2.getP_description() %>"></h2>
		</p>
		
		<p>
			<h2 style="align-content: center;"><input type="hidden" name="email" value="<%= session.getAttribute("myemail") %>"></h2>
		</p>
		
		<p>
				
			 <input type="text" name="p_image" value="<%=m2.getP_image() %>"> 
		
		</p>
		
		
		
		<p>
			
			<input class="swd-button" type="submit" value="submit">
			
		 </p>
		</form>
	
	
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	
	


</body>
</html>