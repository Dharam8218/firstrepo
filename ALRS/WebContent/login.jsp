<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<title>Login</title>
<style>
.bg-image {
	background-image: url('./images/airline1.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100vh;
	background-attachment: fixed;
	overflow: scroll;
}
</style>
</head>
<body>
	<div class="bg-image border">
		<div class="container border  mx-auto mt-2 rounded"">
			<form action="loginServlet" method="post">
				<div class="text-center">
					<h1>Sign In Form</h1>
					<p><b>Please fill this form to login an account.</b></p>
				</div>
				<hr>

				<!-- 
			<label><b>User Id</b></label> <input type="text"
				placeholder="Enter User Id" name="usid"> <label><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="pwd">





			<label><b>User Type</b></label> <input type="text"
				placeholder="Enteruser Type" name="utype">





			<div class="clearfix">
				<input type="reset" value="Clear" class="resetbtn">
				<button type="submit" class="loginbtn">Log In</button>

			</div>
			 -->
				<div class=" border border-dark rounded w-50 mx-auto mb-2">
					<div class="form-group container ">
						<div class="text-center ">
							<label class="control-label" for="exampleInputUserID"><b>User
								ID</b></label>
						</div>
						<input type="text" class="form-control w-50 mx-auto"
							id="exampleInputUserID" name="usid" required>
						<div class="text-center">
							<small id="IDHelp" class="form-text text-danger"><b>We'll
								never share your user id with anyone else.</b></small>
						</div>
					</div>
					<div class="form-group container">
						<div class="text-center">
							<label class="control-label" for="exampleInputPassword1"><b>Password</b></label>
						</div>
						<input type="password" class="form-control w-50 mx-auto"
							id="exampleInputPassword1" name="pwd" required>
					</div>

					<div class="form-group container">
						<div class="text-center">
							<label class="control-label" for="validationCustom"><b>User
								Type</b></label>
						</div>
						<div class="text-center">
							<select class=" mx-auto custom-select w-50" id="validationCustom"
								name="utype" required>

								<option selected disabled value="">Choose...</option>
								<option value="End-User">End-User</option>
								<option value="Admin">Admin</option>
							</select>
						</div>
					</div>
					<div class="form-group form-check container">
						<div class="text-center">
							<button type="submit" class="btn btn-primary w-25 mr-1">Submit</button>
							<button type="reset" class="btn btn-primary w-25 ml-1">Reset</button>
						</div>
					</div>
				</div>
			</form>
		</div>
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