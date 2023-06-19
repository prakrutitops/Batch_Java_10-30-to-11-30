<%@page import="com.model.ImageModel"%>
<%@page import="com.dao.WebDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<%
			
	
		String id=request.getParameter("id");
		int id2=Integer.parseInt(id);
		ImageModel m2=WebDao.getproductdetail(id2);
		session.getAttribute("myemail");
	
	
	%>
	
	
	
	
	
	
	<center>
		
		
		<br>
		<br>
		
		<form action="mycart.jsp">
		
		
		
		<p>
			<input type="hidden" name="id" value="<%=m2.getId() %>">
		</p>
		
		<p>
			<h2 style="align-content: center;"><input type="text" name="product_name" value="<%=m2.getName() %>"></h2>
		</p>
		
		<p>
			<h2 style="align-content: center;"><input type="text" name="email" value="<%=m2.getEmail() %>"></h2>
		</p>
		
		<p>	
			 <input type="text" name="product_image" value="<%=m2.getImage() %>"> 	
		</p>
		
		
		
		
	<%-- 	<p>	
			 <input type="text" name="email" value="<%=m2.getEmail() %>"> 	
		</p> --%>
		
		
		
		<p>
			
			<input class="swd-button" type="submit" value="submit">
			
		 </p>
		</form>
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>


<%-- 
extra
			<a class="swd-button"  href="cart.jsp">Add To Cart</a>
			<a class="swd-button"  href="wishlist.jsp?id=${m.getId()}">Add To WishList</a> 
		</p>
		
		
		<p>
			 

		</p>
		
		

		<p>
			<img width="500px" height="200px" alt="error" name="image" src="<%= m2.getImage()%>">
		</p>
		
	
		
		<p>
			
		</p> --%>