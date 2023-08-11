<%@page import="java.util.List"%>
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
<title>Register</title>
<style>
.bg-image {
	background-image: url('./images/airline4.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100vh;
	background-attachment: fixed;
	overflow: scroll;
}
</style>
</head>
<body>
	<%
		HttpSession session1 = request.getSession(false);

		List<String> list1 = (List) session1.getAttribute("registerError1");
		List<String> list2 = (List) session1.getAttribute("registerError2");
		List<String> list3 = (List) session1.getAttribute("registerError3");
		List<String> list4 = (List) session1.getAttribute("registerError4");
		session.invalidate();
	%>
	<%-- 	<%
		HttpSession session1 = request.getSession(false);
		List<String> EL = null;
		try {
			EL = (List) session.getAttribute("registerErrors");
			//out is Predefined in JSP
		} catch (Exception e) {
			out.println("Exception Occuured" + e); //out is Predefined in JSP
		}

		if (EL != null) {
			out.println("<ul style=color:'red'>");
			for (String E : EL) {
	%>
	<li><%=E%></li>
	<%
		}
			out.println("</ul>");
		}
	%>
 --%>
	<div class="bg-image border">
		<div class="container border rounded">

			<div class="container text-center text-danger">
				<h1>Sign Up</h1>
				<p>
					<b>Please fill this form to create an account.</b>
				</p>
			</div>
			<hr>
			<form action="registerServlet" class="needs-validation" novalidate
				id="form" method="post">
				<div class=" border border-dark rounded w-50 mx-auto mb-2">
					<div class="form-group container">
						<div class="text-center font-weight-bolder">
							<label class="control-label" for="exampleInputName"><b>Name
									(Minimum 5 chars)</b></label>
						</div>

						<input type="text" class="form-control w-50 mx-auto"
							id="exampleInputName" name="name" placeholder="Enter Name"
							required>
						<div class="text-center text-danger">
							<b> <%
 	if (list1 != null) {
 		for (String error : list1) {
 			out.println("*" + error);
 		}
 		list1.removeAll(list1);
 	}
 %>
							</b>
						</div>

					</div>
					<!-- <label><b>Name (Minimum 5 chars)</b></label> <input type="text"
				placeholder="Enter Name" name="name" required="required"> -->
					<div class="form-group container">
						<div class="text-center font-weight-bolder">
							<label class="control-label" for="exampleDate"><b>Date
									of Birth</b></label>
						</div>
						<input type="date" class="form-control w-50 mx-auto"
							id="exampleDate" name="dob" placeholder="Enter DOB" required>
					</div>
					<!-- <label><b>Date of Birth</b></label> <input type="date"
				placeholder="Enter dob" name="dob" required="required"> -->
					<div class="form-group container">
						<div class="text-center font-weight-bolder">
							<label class="control-label" for="exampleUserID"><b>User
									Id (Minimum 7 chars)</b></label>
						</div>
						<input type="text" class="form-control w-50 mx-auto"
							id="exampleUserID" name="usid" placeholder="Enter User Id"
							required>
						<div class="text-center text-danger">
							<b> <%
 	if (list2 != null) {
 		for (String error : list2) {
 			out.println("*" + error);
 		}
 		list2.removeAll(list2);
 	}
 %></b>
						</div>
					</div>
					<!-- <label><b>User
					Id (Minimum7 chars)</b></label> <input type="text" placeholder="Enter User Id"
				name="usid" required="required"> -->

					<!-- <label><b>Password
					(Minimum 8 chars)</b></label> <input type="password"
				placeholder="Enter Password" name="pwd" required="required"> -->
					<div class="form-group container">
						<div class="text-center font-weight-bolder">
							<label class="control-label" for="exampleUserEmail"><b>Email
									(Contains @ )</b></label>
						</div>
						<input type="email" class="form-control w-50 mx-auto"
							id="exampleUserEmail" name="email" placeholder="Enter Email"
							required>
						<div class="text-center text-danger invalid-feedback">
							<b>*Please provide valid email.</b>
						</div>
					</div>
					<!-- <label><b>Email (Contains @ )</b></label> <input type="email"
				placeholder="Enter Email" name="email" required="required"> -->
					<div class="form-group container">
						<div class="text-center font-weight-bolder">
							<label class="control-label" for="exampleUserPhone"><b>Phone
									No. (Must be 10 digit only)</b></label>
						</div>
						<input type="tel" class="form-control w-50 mx-auto"
							id="exampleUserPhone" name="phone" placeholder="Enter Phone No."
							required>
						<div class="text-center text-danger">
							<b> <%
 	if (list4 != null) {
 		for (String error : list4) {
 			out.println("*" + error);
 		}
 		list4.removeAll(list4);
 	}
 %></b>
						</div>
					</div>
					<div class="form-group container">
						<div class="text-center font-weight-bolder">
							<label class="control-label" for="exampleUserPassword"><b>Password
									(Minimum 8 chars)</b></label>
						</div>
						<input type="password" class="form-control w-50 mx-auto"
							id="exampleUserPassword" name="pwd" placeholder="Enter Password"
							required>
						<div class="text-center text-danger">
							<b> <%
 	if (list3 != null) {
 		for (String error : list3) {
 			out.println("*" + error);
 		}
 		list3.removeAll(list3);
 	}
 %></b>
						</div>
					</div>
					<!-- <label><b>Phone No. (Must be 10 digit only)</b></label> <input
				type="tel" placeholder="Enter Phone No." name="phone"
				required="required"> -->
					<div class="form-group container">
						<div class="text-center font-weight-bolder">
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
					<!-- <label><b>User Type</b></label> <input type="text"
				placeholder="Enteruser Type" name="utype" required="required"> -->

					<div class="form-group container">
						<div class="text-center">
							<label class="control-label" for="validationCustom"><input
								type="checkbox" checked="checked" name="remember">
								Remember me</label>
						</div>

					</div>
					<!-- <label> <input type="checkbox" checked="checked"
				name="remember" style="margin-bottom: 15px"> Remember me
			</label> -->
					<div class="form-group container">
						<div class="text-center">
							<p>
								<b>By creating an account you agree to our</b><a href="#"
									style="color: dodgerblue"><b>Terms & Privacy</b></a>.
							</p>
						</div>

					</div>
					<div class="form-group form-check container">
						<div class="text-center">
							<button type="submit" class="btn btn-primary w-25 mr-1">Submit</button>
							<button type="reset" class="btn btn-primary w-25 ml-1">Reset</button>
						</div>
					</div>

					<!-- <div class="clearfix">
				<input type="reset" value="Clear" class="resetbtn">
				<button type="submit" class="signupbtn">Sign Up</button>

			</div> -->
				</div>
			</form>

			<div class="form-group form-check container">
				<div class="text-center">
					<a href="index.html"><button type="submit"
							class="btn btn-primary">Click here to go on home page</button></a>

				</div>
			</div>
		</div>

	</div>
	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Fetch all the forms we want to apply custom Bootstrap validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');
						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();

		/*  function setError(id, error) {
			element = document.getElementById(id);
			element.getElementsByClassName('invalid-feedback')[0].innerHTML = error;
		}
		function validateForm() {
			var returnval = true;
			var name = document.forms['myform']["name"].value;
			if (name.length < 5) {
				setError("name", "Length of name is too short");
				returnval = false;

				return returnval;
			}
		} 
		
		const form = document.getElementById('form');
		const userName = document.getElementById('ExampleInputName');
		const form = document.getElementById('form');
		const form = document.getElementById('form');
		const form = document.getElementById('form');
		
		var b = false;
		
		form.addEventListener('submit',(e)=> {
			e.preventDefault();
			checkInputs();
		});
		
		function checkInputs(){
			const userName = userName.value.trim();
			
			if(userName.length<5){
				setErrorFor(userName,'Length of name is too short.');
			}else{
				b=true;
				setSuccessFor(userName);
			}
		}
		function setErrorFor(input,message) {
			const formControl = input.parseElement;
			const small = formControl.querySelector('small');
			small.innerText=message;
			
			formControl.className='form-control error';
			
		}
		
		function setSuccessFor(input) {
			const formControl = input.parseElement;
			formControl.className='form-control success';
			if(b==true){
				alert("all set");
			}
		}
		 */
	</script>


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