<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%
String id = request.getParameter("id");
 
String connectionURL = "jdbc:mysql://localhost:3306/webwing";
String user = "root";
String pass = "";
 
Connection con = null;
 
try{
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection(connectionURL, user, pass);
    
    PreparedStatement ps = con.prepareStatement("select image from product");
    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
    ResultSet rs = ps.executeQuery();
    OutputStream os = response.getOutputStream();
    
    while(rs.next()){
    	
       /*  Blob blob = rs.getBlob("Img_Data");
        //model m;
        /* m.setByteArray(blob.getBytes(1, (int)blob.length())); */
        /*  byte byteArray[] = blob.getBytes(1, (int)blob.length());
         
 	
        response.setContentType("image/gif");
        
        os.write(byteArray);
        
        os.flush();
        os.close(); */ 
    }
}
catch(Exception e){
    e.printStackTrace();
}   
finally{
    if(con != null){
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
%>

</body>
</html>