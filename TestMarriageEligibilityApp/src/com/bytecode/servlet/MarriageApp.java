package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageApp extends HttpServlet {
        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        	res.setContentType("text/html");
        	// read data from req
        	String name = req.getParameter("pname");
        	String sage = req.getParameter("age");
        	int age = Integer.parseInt(sage);
        	String mNo = req.getParameter("mno");
        	long mobile = Long.parseLong(mNo);
        	String email= req.getParameter("email");
        	String gender1=req.getParameter("male");
        	String gender2=req.getParameter("female");
        	//get printWriter object
        	
        	PrintWriter pw = res.getWriter();
        	
        	if(age<21) {
        		pw.println("<h1 style='color:red'>" +name+ " Not eligible for Marriage</h1>");
        	}else {
        		pw.println("<h1 style='color:red'>" +name+ " Eligible for Marriage</h1>");
        	}
        	pw.println("<a href='marriage.html'>Click Here for back</a>");
        }
        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doPost(req,res);
        }
}
