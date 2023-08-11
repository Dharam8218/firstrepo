package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        	res.setContentType("text/html");
        	// read data from req
        	String name = req.getParameter("pname");
        	String sage = req.getParameter("age");
        	int age = Integer.parseInt(sage);
        	String mNo = req.getParameter("mno");
        	int mobile = Integer.parseInt(mNo);
        	String email= req.getParameter("email");
        	
        	//get printWriter object
        	
        	PrintWriter pw = res.getWriter();
        	
        	if(age<18) {
        		pw.println("<h1 style='color:red'>" +name+ "Not eligible for Voting</h1>");
        	}else {
        		pw.println("<h1 style='color:red'>" +name+ " Eligible for Voting</h1>");
        	}
        	pw.println("<a href='http://localhost:8082/VoterApp/voter.html'>Click Here for back</a>");
        }
}
