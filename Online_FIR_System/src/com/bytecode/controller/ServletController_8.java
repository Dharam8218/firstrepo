package com.bytecode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletController_8 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession(false);

		if (session != null) {
			String name = (String) session.getAttribute("name");
			pw.print("<center><h5>"+ name+" You have already logged in!</center></h5><hr>");
			req.getRequestDispatcher("Welcome.jsp").include(req, res);
		} else {

			req.getRequestDispatcher("login.jsp").include(req, res);
		}
	}
}
