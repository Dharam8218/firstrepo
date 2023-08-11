package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_01 extends HttpServlet{
    
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String name = req.getParameter("name");
		String sage = req.getParameter("age");
		String fname = req.getParameter("fname");
		String mStatus = req.getParameter("ms");
		
		//generate second dynamic form page
		if(mStatus.equalsIgnoreCase("married")) {
			pw.println("<form action='surl' method='post'>");
			pw.println("<input  type='hidden' name='name' value="+name+">");
			pw.println("<input type='hidden' name='sage' value="+sage+">");
			pw.println("<input type='hidden' name='fname' value="+fname+">");
			pw.println("<input type='hidden' name='mStatus' value="+mStatus+">");
			pw.println("Spouse Name::<input type='text' name='stb1'><br>");
			pw.println("No. of Children::<input type='text' name='stb2'><br>");
			pw.println("<input type='submit' value='Submit'><br>");
			pw.println("</form>");
			
		}else {
			pw.println("<form action='surl' method='post'>");
			pw.println("<input type='hidden' name='name' value="+name+">");
			pw.println("<input type='hidden' name='sage' value="+sage+">");
			pw.println("<input type='hidden' name='fname' value="+fname+">");
			pw.println("<input type='hidden' name='mStatus' value="+mStatus+">");
			pw.println("When to marry::<input type='text' name='stb1'><br>");
			pw.println("Why to marry::<input type='text' name='stb2'><br>");
			pw.println("<input type='submit' value='Submit'><br>");
			pw.println("</form>");
		}
	}
}
