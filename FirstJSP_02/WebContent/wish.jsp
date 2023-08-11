<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generate Wish Message</title>
</head>
<body>
<%! 
       public String generateWishMsg(String userName){
	   Calendar calendar=null;
	   int hours;
	   calendar = Calendar.getInstance();
	   hours = calendar.get(Calendar.HOUR_OF_DAY);
	   if(hours<12){
		  return "Good Morning "+userName; 
	   }else if(hours>=12 && hours<16){
		  return "Good Afternoon "+userName;
	   }else if(hours>=16 && hours<22){
		  return "Good Evening "+userName; 
	   }else{
	     return "Good Night "+userName;
	   }
	   
       }
%>
<h1>Welcome to JSP</h1><br>
<%
    String user = "Neha";
%>
<br>
<h2>Wish Message::</h2>
<%= 
 generateWishMsg(user)
%>

</body>
</html>