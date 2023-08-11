<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
	<%
		HttpSession session6 = request.getSession(false);
	%>
	<%!List<String> list = new ArrayList<>();%>
	<%
		if (session6 == null) {
			 /* if (list != null) {
				list.removeAll(list);
			}  */
	%>
	[LOGIN]
	<%
		} else {

			/* if (list != null) {
				list.removeAll(list);
			} */

			List<String> name = (List) session6.getAttribute("name");
			out.println("Welcome");
			 if (name != null) {
				for (String msg : name) {

					list.add(msg);

				}
			} 
			out.println(list);

		}
	
	%>
</body>
</html>