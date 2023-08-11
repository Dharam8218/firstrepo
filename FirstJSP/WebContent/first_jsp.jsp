<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>Welcome to JSP</b><br> 
Current Date and Time is::
<% java.util.Date d = new java.util.Date();
   out.println(d);
%>
<br>End of JSP
</body>
</html>