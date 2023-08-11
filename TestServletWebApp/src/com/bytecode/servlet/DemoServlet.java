package com.bytecode.servlet;
import javax.servlet.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class DemoServlet extends GenericServlet{
       public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException{
              //business logic
              //set response content type
              res.setContentType("text/html");
              //get PrintWriter object
              //System.out.println("");//console--->server
              PrintWriter pw = res.getWriter();
              Date date = new Date();
              SimpleDateFormat formatador = new SimpleDateFormat("HH");           
              int intDate =  Integer.parseInt(formatador.format(date));
              pw.println("<b><center>Current date and time is "+date+"</center></b>");//console----->server
              if(intDate<12) {
            	  pw.println("Good Morning<br>");
              }
              else if(intDate>12&&intDate<16) {
            	  pw.println("Good Afternoon<br>");
              }
              else if(intDate>16&&intDate<22) {
            	  pw.println("Good Evening<br>");
              }
              else {
            	  pw.println("Good Night<br>");
              }
              pw.println("<a href='http://localhost:8082/TestServletWebApp/welcome.html'>Click here for back</a>");
              pw.close();

       }//service(-,-)
}//classes