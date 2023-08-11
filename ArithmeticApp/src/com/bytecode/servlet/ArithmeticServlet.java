package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends HttpServlet  {
            
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		      res.setContentType("text/html");
		      PrintWriter pw = res.getWriter();
		      //String link = req.getParameter("s1");
		      String value1 = req.getParameter("value1");
		      int a= Integer.parseInt(value1);
		      String value2 = req.getParameter("value2");
		      int b = Integer.parseInt(value2);
		      String link = req.getParameter("s1");
		      if(link.equalsIgnoreCase("link1")) {
		    	  pw.println("Sum of value1 and value2 is "+(a+b));
		      }else if(link.equalsIgnoreCase("link2")) {
		    	  pw.println("Substraction of value1 and value2 is "+(a-b));
		      }else {
		    	  pw.println("Multiplication of value1 and value2 is "+(a*b));
		      }
		      pw.println("<a href='maths.html'>Click here for back</a>");
	}
}
