package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_02 extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String income;
		String tax;
		String value = null;

		income = req.getParameter("income");
		tax = req.getParameter("tax");
		Cookie[] ck = req.getCookies();
		for (Cookie cks : ck) {

			value = cks.getValue();

			pw.println("Name:" + value + "<br>");

		}

		pw.println("Your inocme::" + income + "<br>");
		pw.println("Taxable amount::" + tax + "<br>");

	}
}
