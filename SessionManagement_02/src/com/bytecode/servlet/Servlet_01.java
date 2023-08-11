package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_01 extends  HttpServlet {
    
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw;
		String name;
		String fName;
		          res.setContentType("text/html");
		          pw = res.getWriter();
		          
		          name=req.getParameter("name");
		          fName=req.getParameter("fname");
		          
		          pw.println("<h1>Welcome</h1>");
		          pw.println("Name::"+name+"<br>");
		          pw.println("Father's Name::"+fName+"<br>");
		          
		         Cookie ck = new Cookie("name",name);
		         Cookie ck1 = new Cookie("fName",fName);
		         
		         res.addCookie(ck);
		         res.addCookie(ck1);
		         
		         pw.println("<form action='surl' method='post'>");
		         pw.println("Income::<input type='text' name='income'><br>");
		         pw.println("Tax::<input type='text' name='tax'><br>");
		         pw.println("<input type='submit' value='Continue'>");
		         pw.println("</form>");

	}
}
