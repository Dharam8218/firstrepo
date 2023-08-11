<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HTML to JSP to Database</title>
</head>
<body>
	<%
		//read form data
		String empName = request.getParameter("empName");
		String empId = request.getParameter("empId");
		String fatherName = request.getParameter("empFatherName");
		String address = request.getParameter("empAddress");
		String sSal = request.getParameter("empSal");
		String designation = request.getParameter("empDesignation");
		String location = request.getParameter("empLocation");

		int salary = Integer.parseInt(sSal);
		int intId = Integer.parseInt(empId);
	%>
	<br>
	<h1>Employee Details</h1>
	<br>
	<h2>
		Employee Name:
		<%=empName%>
	</h2>

	<h2>
		Employee ID:
		<%=empId%>
	</h2>
	<h2>
		Employee Father's Name:
		<%=fatherName%>
	</h2>
	<h2>
		Employee Address:
		<%=address%>
	</h2>
	<h2>
		Employee Salary:
		<%=salary%>
	</h2>
	<h2>
		Employee Designation:
		<%=designation%>
	</h2>
	<h2>
		Employee Location:
		<%=location%>
	</h2>

	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dharam", "dharam");
		String QUERY = "insert into employeedetails values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(QUERY);
		ps.setString(1, empName);
		ps.setInt(2, intId);
		ps.setString(3, fatherName);
		ps.setString(4, address);
		ps.setInt(5, salary);
		ps.setString(6, designation);
		ps.setString(7, location);

		int result = ps.executeUpdate();
		if (result == 0) {
	%>
	<h2 style="color: red">Record not inserted</h2>
	<%
		} else {
	%>
	<h2 style="color: green">Record inserted successfully</h2>
	<%
		}
	%>


</body>
</html>