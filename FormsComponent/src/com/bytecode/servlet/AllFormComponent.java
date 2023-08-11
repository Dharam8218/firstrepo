package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllFormComponent extends HttpServlet {
	
	     @Override
	    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	 PrintWriter pw;
	    	 String name;
	    	 String sAge;
	    	 int age;
	    	 String gender;
	    	 String address;
	    	 String maritalStatus;
	    	 String qualification;
	    	 String[] courses;
	    	 String[] hobbies;
	    	 
	    	 res.setContentType("text/html");
	    	  pw = res.getWriter();
	    	  
	    	  
	    	  name = req.getParameter("pname");
	    	  sAge = req.getParameter("pass");
	    	  age = Integer.parseInt(sAge);
	    	  gender = req.getParameter("gen");
	    	  address = req.getParameter("paddress");
	    	  maritalStatus = req.getParameter("ms");
	    	  qualification = req.getParameter("qlfy");
	    	  courses = req.getParameterValues("courses");
	    	  hobbies = req.getParameterValues("hb");
	    	  
	    	  pw.println("Name           :"+name+"<br>");
	    	  pw.println("Age            :"+age+"<br>");
	    	  pw.println("Gender         :"+gender+"<br>");
	    	  pw.println("Address        :"+address+"<br>");
	    	  pw.println("Marital Status :"+maritalStatus+"<br>");
	    	  pw.println("Qualification  :"+qualification+"<br>");
	    	  pw.println("Courses        :"+Arrays.toString(courses)+"<br>");
	    	  pw.println("Hobbies        :"+Arrays.toString(hobbies)+"<br><br>");
	    	  
	    	  pw.println("<a href='form1.html'>Click Here for Home Page</a>");
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    }
	     @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	       doPost(req,res);
	    }

}
