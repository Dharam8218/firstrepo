package com.bytecode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//profile Servlet
public class ServletController_4 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		//req.getRequestDispatcher("Welcome.html").include(req, res);

		HttpSession session = req.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("name");
			
			pw.print("<center><h5>Hello, " + name + " Welcome to Profile</center></h5><hr>");
			req.getRequestDispatcher("Welcome.jsp").include(req, res);
	
		} else {
			 
			pw.print("<br><center><h5>Please login first</center></h5><hr>");
			req.getRequestDispatcher("login.jsp").include(req, res);
		}
		
	}
}