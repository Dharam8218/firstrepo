<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
<title>Track Complaint</title>
<style>
.form-group .control-label:after {
	content: "*";
	color: red;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<%
		HttpSession session3 = request.getSession(false);
	%>
	<br>
	<hr>
	<div class="container">
		<form action="track" method="post">
			<div class="text-center">
				<h3>
					<b>Track Your Complaint</b>
				</h3>
			</div>
			<div class="form-group container">
				<label class="control-label" for="exampleRefrenceNumber">Reference
					Number</label> <input type="text" class="form-control"
					id="exampleReferenceNumber" name="track">
			</div>
			<%
						if (session3 != null) {
							List<String> error3 = (List) session3.getAttribute("error3");
							if (error3 != null) {
								for (String error : error3) {
									if (error != "null") {
					%>
					<div class="text-danger mx-auto mb-2">
						<%
							out.println("*" + error);
										}
						%>
					</div>
					<%
						}
								error3.removeAll(error3);
							}

						}
					%>
			<div class="form-group form-check container">

				<button type="submit" class="btn btn-primary">Track</button>

			</div>
		</form>
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