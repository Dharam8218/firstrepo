package com.bytecode.servlet;
import javax.servlet.*;
import java.io.*;
import java.util.*;
public class WordServlet extends GenericServlet{
       public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException{
              //business logic
              //set response content type
              res.setContentType("application/msword");
              //get PrintWriter object
              //System.out.println("");//console--->server
              PrintWriter pw = res.getWriter();
              Date date = new Date();
              pw.println("<b><center>Current date and time in word format is "+date+"</center></b>");//console----->server
              pw.println("<a href='http://localhost:8082/MIMEApp/welcome.html'>Click here for back</a>");
              pw.close();

       }//service(-,-)
}//classes
