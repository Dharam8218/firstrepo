package com.bytecode.servlet;
import javax.servlet.*;
import java.io.*;
import java.util.*;
public class ExcelServlet extends GenericServlet{
       public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException{
              //business logic
              //set response content type
              res.setContentType("application/vnd.ms-excel");
              //get PrintWriter object
              //System.out.println("");//console--->server
              PrintWriter pw = res.getWriter();
              pw.println("<table border='1'>");
        		pw.println("<tr><th>Employee Name</th><th>Designation</th></tr>");
        		pw.println("<tr><td>Raja</td><td>Director</td></tr>");
        		pw.println("<tr><td>Rani</td><td>Peon</td></tr>");
        		pw.println("<tr><td>radhe</td><td>Actor</td></tr>");
        		pw.println("<tr><td>Ajay</td><td>Producer</td></tr>");
        		pw.println("<tr><td>Raja</td><td>Director</td></tr>");
        		pw.println("<tr><td>Rani</td><td>Peon</td></tr>");
        		pw.println("<tr><td>radhe</td><td>Actor</td></tr>");
        		pw.println("<tr><td>Ajay</td><td>Producer</td></tr>");
        		pw.println("</table>");
              pw.println("<a href='http://localhost:8082/MIMEApp/welcome.html'>Click here for back</a>");
              pw.close();

       }//service(-,-)
}//classes