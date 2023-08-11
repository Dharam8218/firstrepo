<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
<style>
.form-group .control-label:after {
	content: "*";
	color: red;
}
</style>
<title>Complain form</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<%
		HttpSession session2 = request.getSession(false);
	%>
	<br>
	<hr>
	<div class="text-center">
		<h3>
			<b>Complaint Form</b>
		</h3>
	</div>
	<div class="container">
		<form class="needs-validation" novalidate action="complaintodb"
			method="post">
			<div class="form-row">
				<div class="form-group col-md-3 mb-3">
					<label class="control-label" for="validationCustom01">First
						name</label> <input type="text" class="form-control"
						id="validationCustom01" value="" placeholder="Dharamveer"
						name="firstname" required>
					<div class="valid-feedback">Looks good!</div>
				</div>
				<div class="form-group col-md-3 mb-3">
					<label class="control-label" for="validationCustom02">Last
						name</label> <input type="text" class="form-control"
						id="validationCustom02" value="" placeholder="Singh"
						name="lastname" required>
					<div class="valid-feedback">Looks good!</div>
				</div>
				<div class="form-group col-md-6 mb-3">
					<label class="control-label" for="validationCustom02">Mobile
						Number</label> <input type="tel" class="form-control"
						id="validationCustom03" value="" placeholder="******6897"
						maxlength="10" size="10" name="mnumber" required>
					<div class="invalid-feedback">Please Provide Valid Mobile
						Number!</div>

					<%
						if (session2 != null) {
							List<String> error1 = (List) session2.getAttribute("error1");
							if (error1 != null) {
								for (String error : error1) {
									if (error != "null") {
					%>
					<div class="text-danger">
						<%
							out.println("*" + error);
										}
						%>
					</div>
					<%
						}
								error1.removeAll(error1);
							}

						}
					%>

				</div>
			</div>
			<div class="form-group">
				<label class="control-label" for="inputAddress">Address</label> <input
					type="text" class="form-control" id="inputAddress"
					placeholder="1234 Main St" name="address1" required>
			</div>
			<div class="form-group">
				<label for="inputAddress2">Address 2(optional)</label> <input
					type="text" class="form-control" id="inputAddress2"
					placeholder="Near,landmark" name="address2">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6 mb-3">
					<label class="control-label" for="validationCustom03">City</label>
					<input type="text" class="form-control" id="validationCustom04"
						placeholder="Kanpur" name="city" required>
					<div class="invalid-feedback">Please provide a valid city.</div>
				</div>
				<div class="form-group col-md-3 mb-3">
					<label class="control-label" for="validationCustom04">State</label>
					<select class="custom-select" id="validationCustom05" required
						name="state">

						<option selected disabled value="">Choose...</option>
						<option value="Andhra Pradesh">Andhra Pradesh</option>
						<option value="Andaman and Nicobar Islands">Andaman and
							Nicobar Islands</option>
						<option value="Arunachal Pradesh">Arunachal Pradesh</option>
						<option value="Assam">Assam</option>
						<option value="Bihar">Bihar</option>
						<option value="Chandigarh">Chandigarh</option>
						<option value="Chhattisgarh">Chhattisgarh</option>
						<option value="Dadar and Nagar Haveli">Dadar and Nagar
							Haveli</option>
						<option value="Daman and Diu">Daman and Diu</option>
						<option value="Delhi">Delhi</option>
						<option value="Lakshadweep">Lakshadweep</option>
						<option value="Puducherry">Puducherry</option>
						<option value="Goa">Goa</option>
						<option value="Gujarat">Gujarat</option>
						<option value="Haryana">Haryana</option>
						<option value="Himachal Pradesh">Himachal Pradesh</option>
						<option value="Jammu and Kashmir">Jammu and Kashmir</option>
						<option value="Jharkhand">Jharkhand</option>
						<option value="Karnataka">Karnataka</option>
						<option value="Kerala">Kerala</option>
						<option value="Madhya Pradesh">Madhya Pradesh</option>
						<option value="Maharashtra">Maharashtra</option>
						<option value="Manipur">Manipur</option>
						<option value="Meghalaya">Meghalaya</option>
						<option value="Mizoram">Mizoram</option>
						<option value="Nagaland">Nagaland</option>
						<option value="Odisha">Odisha</option>
						<option value="Punjab">Punjab</option>
						<option value="Rajasthan">Rajasthan</option>
						<option value="Sikkim">Sikkim</option>
						<option value="Tamil Nadu">Tamil Nadu</option>
						<option value="Telangana">Telangana</option>
						<option value="Tripura">Tripura</option>
						<option value="Uttar Pradesh">Uttar Pradesh</option>
						<option value="Uttarakhand">Uttarakhand</option>
						<option value="West Bengal">West Bengal</option>
					</select>
					<div class="invalid-feedback">Please select a valid state.</div>
				</div>
				<div class="form-group col-md-3 mb-3">
					<label class="control-label" for="validationCustom05">Zip</label> <input
						type="text" class="form-control" id="validationCustom06"
						placeholder="208024" maxlength="6" name="zip" required>
					<div class="invalid-feedback">Please provide a valid zip.</div>
					<%
						if (session2 != null) {
							List<String> error2 = (List) session2.getAttribute("error2");
							if (error2 != null) {
								for (String error : error2) {
									if (error != "null") {
					%>
					<div class="text-danger">
						<%
							out.println("*" + error);
										}
						%>
					</div>
					<%
						}
								error2.removeAll(error2);
							}

						}
					%>

				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6 mb-3">
					<label class="control-label" for="validationCustom03">Nearest
						Police Station Name</label> <input type="text" class="form-control"
						id="validationCustom07" placeholder="Kanpur" name="pname" required>
					<div class="invalid-feedback">Please provide a nearest police
						station name.</div>
				</div>
				<div class="form-group col-md-3 mb-3">
					<label class="control-label" for="validationCustom04">Complaint
						Type</label> <select class="custom-select" id="validationCustom08"
						name="cname" required>

						<option selected disabled value="">Choose...</option>
						<option value="Domestic Voilence">Domestic Voilence</option>
						<option value="Stealing">Stealing</option>
						<option value="Snetching">Snetching</option>
						<option value="Fraud">Fraud</option>
						<option value="Attempt to Murder">Attempt to Murder</option>
						<option value="Other">Other</option>
					</select>
					<div class="invalid-feedback">Please select a valid complaint
						type.</div>
				</div>


				<div class="form-group col-md-3 mb-3">
					<label class="control-label" for="validationCustom09">Where
						did the incident occurs</label> <input type="text" class="form-control"
						id="validationCustom03" placeholder="Kanpur" name="where" required>
					<div class="invalid-feedback">Please provide a valid data.</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label" for="moreinformation">Please
					provide any additional information about the incident</label> <input
					type="text" class="form-control" id="inputAddress3"
					placeholder="Max 1500 characters allowed" maxlength="1500"
					name="description" required>
				<div class="invalid-feedback">Please provide some details
					about complain.</div>
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="invalidCheck" required> <label
						class="form-check-label" for="invalidCheck"> Agree to
						terms and conditions </label>
					<div class="invalid-feedback">You must agree before
						submitting.</div>
				</div>
			</div>
			<button class="btn btn-primary" type="submit">Submit form</button>
		</form>
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