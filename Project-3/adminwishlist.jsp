<%@page import="com.model.SignupModel"%>
<%@page import="com.dao.WebDao"%>
<%@page import="com.model.WishModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	
	<%
	List<WishModel> list = WebDao.getWishAdmin();
	request.setAttribute("i2", list);
	%>
	

		<c:forEach items="${i2}" var="m2">
			<center>
			
			
				<br>
				<br>
				
				<p>
					<h2>${m2.getProduct_name()}</h2>
				</p>
				
				<p>
					<h2>${m2.getEmail()}</h2>
				</p>
						
				<p>
					<img width="500px" height="200px" src="${m2.getProduct_image()}">
				</p>
				
				<%-- <p>
					<h2>${m.getEmail()}</h2>
				</p> --%>
			
				
			</center>
			
			
		</c:forEach>
	

		

</body>
<jsp:include page="footer1.jsp"></jsp:include>
</html>