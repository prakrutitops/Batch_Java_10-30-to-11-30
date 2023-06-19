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
	<jsp:include page="header.jsp"></jsp:include>
	<%

	/* String email = request.getParameter("email");
	String password = request.getParameter("password"); */
	
	SignupModel m2 =new SignupModel();
	String email = (String)request.getSession().getAttribute("myemail");
	m2.setEmail(email);
	
	List<WishModel> list=WebDao.getallwishdetail(m2);
	request.setAttribute("i",list);
	
	
	%>
	

		<c:forEach items="${i}" var="m">
			<center>
			
			
				<br>
				<br>
				
				<p>
					<h2>${m.getProduct_name()}</h2>
				</p>
				
				<p>
					<h2>${m.getEmail()}</h2>
				</p>
						
				<p>
					<img width="500px" height="200px" src="${m.getProduct_image()}">
				</p>
				
				<%-- <p>
					<h2>${m.getEmail()}</h2>
				</p> --%>
			
				
			</center>
			
			
		</c:forEach>
	
<jsp:include page="footer.jsp"></jsp:include>
		

</body>
</html>