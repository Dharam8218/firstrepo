<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% System.out.println("hello bro"); 
    String url      = "jdbc:postgresql://localhost:5432/alrs";
   String U     = "postgres" ;
   String  P       = "admin" ;
   String Q="select * from fschedule";
   Connection conn=null;
   PreparedStatement ps=null;
   try {
	conn=DriverManager.getConnection(url, U, P);
	ps=conn.prepareStatement(Q);
	ResultSet rs= ps.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"    "+rs.getString(3)+"    "+
	rs.getString(4)+"    "+rs.getString(5)+"    "+rs.getString(6)+"    "+rs.getString(7)
	+"    "+rs.getInt(8)+"    "+rs.getInt(9));
	}
	// fetching value from DB..
	       int fsno=rs.getInt(1);
	       String fno =rs.getString(2);
	       String source =rs.getString(3);
	       String dest =rs.getString(4);
	       String sonames =rs.getString(5);
	       String dt =rs.getString(6);
	       String dd =rs.getString(7);
	       int bcsc=rs.getInt(8);
	       int ecsc=rs.getInt(9);
} catch (SQLException e) {
	e.printStackTrace();
}

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     
</body>
</html>