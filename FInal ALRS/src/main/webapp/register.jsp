<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>sign up form</title>
<link rel="stylesheet" href="regist.css">
</head>
<body>
<% 
	List<String> EL  = null;  
		try
		{ 
			EL = (List) session.getAttribute("RegisterErrors");		
			 //out is Predefined in JSP
		}
		catch(Exception e)
		{
			out.println("Exception Occuured" + e);   //out is Predefined in JSP
		}
		
		if(EL != null)
		{
			out.println("<ul style=color:'red'>");
			for(String E : EL)
			{
				out.println("<li>" + E);
			}
			out.println("</ul>");
		}
%>
	<form action="registerservlet" style="border: 1px solid #ccc"
		method="get">
		<div class="container">
			<h1>Sign Up</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>
			<label><b>Name (minimum 5 chars)</b></label> 
			<input type="text" placeholder="Enter Name" name="name" required="required"> 
			
			<label><b>Date of Birth</b></label> 
			<input type="date" placeholder="Enter dob" name="dob" required="required"> 
			
		    <label><b>User Id (minimum 7 chars)</b></label> 
			<input type="text" placeholder="Enter User Id" name="usid" required="required">
			
		    <label><b>Password (minimum 8 chars)</b></label> 
			<input type="password" placeholder="Enter Password" name="pwd" required="required">
			
			<label><b>Email (contains @ )</b></label> 
			<input type="email" placeholder="Enter Email" name="email"required="required"> 

            <label><b>Phone No. (must be 10 digit only)</b></label> 
            <input type="tel" placeholder="Enter Phone No." name="phone" required="required">
				
		    <label><b>User Type</b></label> 
		    <input type="text" placeholder="Enteruser Type" name="utype" required="required">

			<label> <input type="checkbox" checked="checked"
			name="remember" style="margin-bottom: 15px"> Remember me
			</label>

			<p>
				By creating an account you agree to our <a href="#"
					style="color: dodgerblue">Terms & Privacy</a>.
			</p>

			<div class="clearfix">
				<input type="reset" value="Clear" class="resetbtn">
				<button type="submit" class="signupbtn">Sign Up</button>

			</div>
		</div>
	</form>
	<br/><br/>
 <br/><br/>
 <li style='left:350px; top:400px; position:absolute;'>
 	<a href="index.html">Click here </a> to go back to Home Page 
 </li>
</body>
</html>

