 <%@page import="com.dao.WebDao"%>

<%@page import="com.model.ImageModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header1.jsp"></jsp:include>
</head>
<body>
<%
	
List<ImageModel> list = WebDao.getAll();
request.setAttribute("i", list);

%>

	
		<c:forEach items="${i}" var="m">
			<center>
			
			
				<br>
				<br>
				<p>
					<h2>${m.getName()}</h2>
				</p>
				
				
				<p>
					<h2>${m.getEmail()}</h2>
				</p>
				
				
		
				<p>
					<img width="500px" height="200px" src="${m.getImage()}">
				</p>
			
			</center>
			
			
		</c:forEach>
	
	</table>

</body>
<jsp:include page="footer1.jsp"></jsp:include>
</html>