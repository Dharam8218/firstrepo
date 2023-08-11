package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUserServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw;
	    String eMail;
	    String password;
	    Connection conn=null;
	    Statement st=null;
	    String QUERY;
	    ResultSet rs=null;
		
		res.setContentType("text/html");
		pw = res.getWriter();
		
		eMail = req.getParameter("email");
		password = req.getParameter("pass");
		
		pw.println("Email:"+eMail+"<br>");
		
		password = "'"+password+"'";
		eMail = "'"+eMail+"'";
		
		//JDBC 
		 
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dharam","dharam");
			st= conn.createStatement();
			QUERY = "select * from signup where email="+eMail+"and password="+password+" ";
			rs= st.executeQuery(QUERY);
			if(rs.next()==true) {
				pw.println("Login Succesfully<br>");
			}
			else {
				pw.println("Incorrect email or password <br>");
			}
			pw.println("<a href='user.html'>Click here for SignUp Page</a>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	   finally {
		   try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
	   }
	    	
	    
		
		
	}

}
