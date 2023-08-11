package com.bytecode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//logout servlet
public class ServletController_3 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession(false);

		if (session != null) {
			session.invalidate();
			req.getRequestDispatcher("header.jsp").include(req, res);
			pw.print("<hr><center><h3>You have successfully logged out!</center></h3>");
			//req.getRequestDispatcher("homebutton.jsp").include(req, res);
		    
			
			
		} else {
            req.getRequestDispatcher("Welcome.jsp").include(req, res);
		}
		

	}
}
