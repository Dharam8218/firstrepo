<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>sign up form</title>
           <link rel="stylesheet" href="log.css">
      </head>
    <body>
    
        <form action="registerservlet" style="border:1px solid #ccc" method="get">
            <div class="container" >
              <h1>Sign Up</h1>
              <p>Please fill in this form to login an account.</p>
              <hr>
             

              <label ><b>User Id</b></label>
              <input type="text" placeholder="Enter User Id" name="usid" >

              <label ><b>Password</b></label>
              <input type="password" placeholder="Enter Password" name="pwd" >

             
          
             

              <label ><b>User Type</b></label>
              <input type="text" placeholder="Enteruser Type" name="utype" >
          
             
              
          
              
              <div class="clearfix">
                <input type="reset" value="Clear" class="resetbtn">
                <button type="submit" class="loginbtn">Log In</button>
                
              </div>
            </div>
          </form> 
    </body>
</html>

