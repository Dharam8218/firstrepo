package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{
    
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw= null;
		  String sNumber;
		  int number;
		  RequestDispatcher rd;
		  
		  res.setContentType("text/html");
		   pw = res.getWriter();
		   
		   sNumber=req.getParameter("number");
		   number = Integer.parseInt(sNumber);
		   number= (number*number);
		   pw.println("<h1>The square of the number is::"+number+"</h1>");
		   rd = req.getRequestDispatcher("s2url");
		   rd.include(req, res);
		   pw.println("<a href='input.html'>Click here for back</a>");
		   
	}
	
}
