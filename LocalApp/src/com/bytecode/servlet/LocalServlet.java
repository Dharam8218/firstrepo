package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocalServlet extends HttpServlet {
      
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 res.setContentType("text/html");
		 PrintWriter pw = res.getWriter();
		 Locale[] locales = null;
		 //read s1 request param value to know the which hyperlinked is clicked
		 
		 String link = req.getParameter("s1");
		 if(link.equalsIgnoreCase("link1")) {
			  locales =Locale.getAvailableLocales();
			  for (Locale locale : locales) {
				pw.println(locale.getDisplayCountry()+"<br>");
				
			}//for
		 }//if
		 else if (link.equalsIgnoreCase("link2")) {
			 locales=Locale.getAvailableLocales();
			 for(Locale locale : locales) {
				 pw.println(locale.getDisplayLanguage()+"<br>");
			 }//for
		 }//else if
		 else {
			 pw.println("Current date and time ::"+new Date()+"<br>");
		 }
		 pw.println("<a href='links.html'>Click here for back to home page</a>");
	}
}
