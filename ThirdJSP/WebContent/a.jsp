<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is start of a.jsp</h1>
<%@ include file="b.jsp" %>
<jsp:include page="b.jsp"></jsp:include>
<jsp:directive.include file="b.jsp" />
<h1>This is end of a.jsp</h1>
</body>
</html>