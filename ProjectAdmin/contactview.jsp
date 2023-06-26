<%@page import="com.dao.UserDao"%>
<%@page import="com.model.ConatctModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
		
			th, td 
			{
 				 padding: 15px;
				 spacing: 15px;
			}
		
	</style>
</head>
<body>

<jsp:include page="header1.jsp"></jsp:include>

<%
	
List<ConatctModel> list = UserDao.getcontact();
request.setAttribute("i", list);

%>

	<table border="2" style="margin-left: 250px;" >
			
				<tr>
					<th>Id</th><th>Name</th><th>Email</th><th>Phone</th><th>Message</th>
				</tr>
	
	
	
	
		<c:forEach items="${i}" var="m">
		
			
			<br>
			<br>
			
			
				<tr>
					
					<td>${m.getId()}</td><td>${m.getName()}</td><td>${m.getEmail()}</td>
					<td>${m.getPhone()}</td><td>${m.getMessage()}</td>
				</tr>
				
				
			
			
				
				
			
			
			
		</c:forEach>
		
		</table>
	
	


<jsp:include page="footer1.jsp"></jsp:include>



</body>
</html>