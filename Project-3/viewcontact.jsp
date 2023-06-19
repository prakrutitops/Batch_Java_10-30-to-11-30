 <%@page import="com.model.ContactModel"%>
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
	
//List<ContactModel> list = WebDao.getContact();
//request.setAttribute("i", list);

%>
<%-- 
	
		<c:forEach items="${i}" var="m">
		<table class="table table-striped">
            <thead>
            <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
            </tr>
            </thead>
       <tbody>
           <tr>
           <th scope="row">${m.getId()}</th>
           <td>${m.getName()}</td>
           <td>${m.getEmail()}</td>
           <td>${m.getSubject()}</td>
           <td>${m.getMessage()}</td>
           </tr>
   
       </tbody>
       </table>				
		</c:forEach>
	
	
 --%>
 
 <h1>this is contact admin page</h1>
</body>
<jsp:include page="footer1.jsp"></jsp:include>
</html>