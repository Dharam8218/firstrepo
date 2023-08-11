package com.alrs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Model;

public class LoginServlet extends HttpServlet {
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");
	      PrintWriter out= resp.getWriter();
	      String usid=req.getParameter("usid");
	       String pwd=req.getParameter("pwd");
	       String utype=req.getParameter("utype");
            List<String> list=new ArrayList();
	       
	       //validation of user input 
	       if(usid.equals("")) {
	    	   list.add("usid is null please enter valid usid.");
	       }
	       if(pwd.equals("")) {
	    	   list.add("pwd is null please enter valid pwd.");
	       }
	       if(utype.equals("")) {
	    	   list.add("utype is null please enter valid utype.");
	       }
	       if(list.size()==0) {
	    	   //JDBC
	    	   String url      = "jdbc:postgresql://localhost:5432/alrs";
		        String U     = "postgres" ;
		        String  P       = "admin" ;
		        Connection conn=null;
		        PreparedStatement ps=null;
		     
		        
		       
		        
		        String SELECT_QUERY="select * from register where usid=? and pwd=?"
		        		+ " and usertype=? ";
		        
		      try {
				conn=  DriverManager.getConnection(url, U, P);
				if(conn!=null) {
					
					
			    	   ps =  conn.prepareStatement(SELECT_QUERY);
			    	 
			    	  out.println("<h1>You have successfully registered "
			    	  		+ "kindly wait for the confirmation</h1>");	   
			    	  out.println("<a href="+"register.jsp"+">Click here to go on Register page</a>"+"<br><br>");
			    	  out.println("<a href="+"index.html"+">Click here to go on Home page</a>");
			      }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       }
	    
	}
}
