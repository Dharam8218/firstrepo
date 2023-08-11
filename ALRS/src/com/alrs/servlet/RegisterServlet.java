package com.alrs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alrs.connection.DBConnection;
import com.alrs.models.Model;



public class RegisterServlet extends HttpServlet {
	
	String name;
	String userId;
	String email;
	String phone;
	String password;
	String userType;
	String DOB;
	PrintWriter pw = null;
	Model model = null;
	DBConnection db = null;
	
	

	List<String> list1 = new ArrayList<>();
	List<String> list2 = new ArrayList<>();
	List<String> list3 = new ArrayList<>();
	List<String> list4 = new ArrayList<>();

	boolean checkInputs(String name, String userId, String password, String phone) {
		if (name.length() < 5) {
			list1.add("Length of name must be greater than or equal to 5 characters. Please enter valid name.");

		}

		if (userId.length() < 7) {
			list2.add("Length of userId must be greater than or equal to 7 characters. Please enter valid UserId.");

		}
		if (password.length() < 8) {
			list3.add("Length of password is too short");

		}
		if (phone.length() != 10) {
			list4.add("Length of phone number of less than 10. please enter valid phone number.");

		}
		if (list1.size() == 0 && list2.size()==0 && list3.size()==0 && list4.size()==0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		pw = res.getWriter();
		
		name=req.getParameter("name");
		userId=req.getParameter("usid");
		email=req.getParameter("email");
		DOB=req.getParameter("dob");
		phone=req.getParameter("phone");
		password=req.getParameter("pwd");
		userType=req.getParameter("utype");
		
		if(checkInputs(name, userId, password, phone)) {
			model = new Model();
			model.setName(name);
			model.setUserId(userId);
			model.setDOB(DOB);
			model.setEmail(email);
			model.setPhone(Long.parseLong(phone));
			model.setUserType(userType);
			model.setPassword(password);
		}else {
			   HttpSession session1=req.getSession();
			   session1.setAttribute("registerError1", list1);
			   session1.setAttribute("registerError2", list2);
			   session1.setAttribute("registerError3", list3);
			   session1.setAttribute("registerError4", list4);
	    	   req.getRequestDispatcher("register.jsp").include(req, res);
			  
		} 
		
		db = new DBConnection();
		if(db.insert(model)!=0) {
			req.getRequestDispatcher("RegSuccess.html").include(req, res);
		}
	   
		
	}
}
