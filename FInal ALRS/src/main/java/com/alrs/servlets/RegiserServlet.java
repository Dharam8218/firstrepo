package com.alrs.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.DBConnection;
import com.models.Model;

@WebServlet("/registerservlet")
public class RegiserServlet extends HttpServlet {
	   
	   List<String> list=new ArrayList();
	   
	   boolean check(String name,String usid,String pwd,String email,String phone,String utype) {
    	   if(name.length()<5) {
	    	   list.add("name is less than 5 chars please enter valid name.");
	    	   
	       }
	       
	       if(usid.length()<7) {
	    	   list.add("usid is less than 7 chars please enter valid usid.");
	    	  
	       }
	       if(pwd.length()<8) {
	    	   list.add("pwd is less than 8 chars please enter valid pwd.");
	    
	       }
	       if(email.equals("")) {
	    	   list.add("email is null please enter valid email.");
	    	  
	       }
	       if(phone.length()!=10) {
	    	   list.add("phone is of 10 digit "
	    	   		+ " please enter valid phone.");
	    	  
	       }
	       if(utype.equals("")) {
	    	   list.add("utype is null please enter valid utype.");
	    	   
	       }
	       if(list.size()==0) {
	    	   return true;
	       }
	       else {
	    	   return false;
	       }
	      
       }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        resp.setContentType("text/html");
	       PrintWriter out= resp.getWriter();
	       String name=req.getParameter("name");
	       String dob=req.getParameter("dob");
	       String usid=req.getParameter("usid");
	       String pwd=req.getParameter("pwd");
	       String email=req.getParameter("email");
	       String phone=req.getParameter("phone");
	       String utype=req.getParameter("utype");
	      
	       
	       //validation of user input 
	      boolean cv=check(name, usid, pwd, email, phone, utype);
	      if(cv) {
	    	  out.println("Hello cv is true");
	    	  Model model=new Model();
				model.setName(name);
				model.setDob(dob);
				model.setUsid(usid);
				model.setPwd(pwd);
				model.setEmail(email);
				model.setPhone(Long.parseLong(phone));
				model.setUtype(utype);
			boolean ris=false;
			try {
				ris=storeIntoDB(model);
				if(ris) {
					req.getRequestDispatcher("RegSuccess.html").include(req, resp);
				}
				else {
					  HttpSession session1=req.getSession();
			    	  list.add("Some technical issue...");
			    	  session1.setAttribute("RegisterErrors", list);
			    	 RequestDispatcher RD= req.getRequestDispatcher("register.jsp");
			    	               RD.include(req, resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	      }
	      else {
	    	HttpSession session1=req.getSession();
	    	session1.setAttribute("RegisterError", list);
	                 	RequestDispatcher RD= req.getRequestDispatcher("register.jsp");
	                 	 RD.include(req, resp);
	      }
	              
	}
	boolean storeIntoDB(Model model) throws SQLException {
		DBConnection obj=new DBConnection();
		Connection conn= obj.makeConnection();
		 String INSERT_QUERY="insert into register(name,usid,pwd,email,"
	        		+ "phone,usertype) values(?,?,?,?,?,?)";
			if(conn!=null) {
				
				
		    	  PreparedStatement ps =  conn.prepareStatement(INSERT_QUERY);
		    	   ps.setString(1, model.getName());
		    	   ps.setString(2, model.getUsid());
		    	   ps.setString(3, model.getPwd());
		    	   ps.setString(4, model.getEmail());
		    	   ps.setLong(5, model.getPhone());
		    	   ps.setString(6, model.getUtype()); 
		    	    
		    	  int result= ps.executeUpdate();
		    	  if(result!=0) 
		    		  return true;
		    	  else 
		    		  return false;
		    	 
		      }
			return false;
	}
	
  
}
