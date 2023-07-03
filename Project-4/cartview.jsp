<%@page import="com.model.SignupModel"%>
<%@page import="com.model.WishlistModel"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
			
		<%
			 SignupModel m2 =new SignupModel();
			String email = (String)request.getSession().getAttribute("myemail");
			m2.setEmail(email);
			 
			
			List<WishlistModel> list = UserDao.getallcartdetail(m2);
			request.setAttribute("i",list);
			
			
			
		%>
		
	<c:forEach items="${i}" var="m">
			<center>
			
			
				<br>
				<br>
				
				<p>
					<h2>${m.getP_name()}</h2>
				</p>
				
				<br>
				
				<p>
					<h2>${m.getP_price()}</h2>
				</p>
				
				<br>
				<p>
					<h2>${m.getP_description()}</h2>
				</p>
				<p>
					<img width="500px" height="200px" src="${m.getP_image()}">
				</p> 
				
				<p>
					<a class="swd-button" href="cart2.jsp">Add to cart</a>
				</p>
			</center>
			
			
		</c:forEach>
			
		<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>