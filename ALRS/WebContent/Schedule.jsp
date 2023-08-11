<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%!Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int fsno;
	String fno;
	String source;
	String dest;
	String sonames;
	String dt;
	String dd;
	int bcsc;
	int ecsc;%>
<%
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String U = "dharam2";
	String P = "dharam2";
	String Q = "select * from fschedule";
%>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<title>Schedule</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">FSNO</th>
					<th scope="col">FNO</th>
					<th scope="col">SOURCE</th>
					<th scope="col">DESTINATION</th>
					<th scope="col">SONAMES</th>
					<th scope="col">DT</th>
					<th scope="col">DD</th>
					<th scope="col">BCSC</th>
					<th scope="col">ECSC</th>
				</tr>
			</thead>


			<%
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, U, P);
					ps = conn.prepareStatement(Q);
					rs = ps.executeQuery();
					while (rs.next()) {
			%>

			<%
				fsno = rs.getInt(1);
						fno = rs.getString(2);
						source = rs.getString(3);
						dest = rs.getString(4);
						sonames = rs.getString(5);
						dt = rs.getString(6);
						dd = rs.getString(7);
						bcsc = rs.getInt(8);
						ecsc = rs.getInt(9);
			%>
			<tbody>
				<tr>
					<th scope="row"><%=fsno%></th>
					<td><%=fno%></td>
					<td><%=source%></td>
					<td><%=dest%></td>
					<td><%=sonames%></td>
					<td><%=dt%></td>
					<td><%=dd%></td>
					<td><%=bcsc%></td>
					<td><%=ecsc%></td>
				</tr>

				<%
					}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						try {
							ps.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				%>

			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>
</body>
</html>