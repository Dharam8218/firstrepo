package com.bytecode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bytecode.dto.DTO_1;
import com.bytecode.service.Service_1;
import com.bytecode.vo.VO_1;

//registration Servlet
public class ServletController_1 extends HttpServlet {

	VO_1 vo = null;
	DTO_1 dto = null;
	Service_1 service = null;
	
	PrintWriter pw = null;
	boolean result;
	boolean b = false;
 
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// set Mime type

		res.setContentType("text/html");

		// get PrintWriter object

		pw = res.getWriter();

		// create VO_1 class object and read input form data 

		vo = new VO_1();
		vo.setName(req.getParameter("name"));
		vo.setFatherName(req.getParameter("fname"));
		vo.setEmail(req.getParameter("email"));
		vo.setAddress(req.getParameter("address"));
		vo.setAge(req.getParameter("age"));
		vo.setPassword(req.getParameter("password"));
		vo.setConfirmPassword(req.getParameter("confirmpassword"));

		// create DTO_1 class object and covert vo_1 object into dto_1 object

		dto = new DTO_1();
		dto.setName(vo.getName());
		dto.setFatherName(vo.getFatherName());
		dto.setEmail(vo.getEmail());
		try {
			dto.setAge(Integer.parseInt(vo.getAge()));
		} catch (NumberFormatException nfe) {
			pw.println("<center><h5>Invalid age. Please enter valid age</h5></center><hr>");
			req.getRequestDispatcher("registration.jsp").include(req, res);
			b = true;
		}
		dto.setAddress(vo.getAddress());
		dto.setPassword(vo.getPassword());
		dto.setConfirmPassword(vo.getConfirmPassword());
       
		if (b == false) {
			service = new Service_1();
			try {
				result = service.isPasswordSame(dto);

			} catch (Exception ae) {
				pw.println(ae.toString());
			}
			if (result == false) {
                
				pw.println("<center><h5>Password must be same</h5></center><hr>");
				req.getRequestDispatcher("registration.jsp").include(req, res);
			} else {
				req.getRequestDispatcher("header.jsp").include(req, res);
                pw.println("<hr><center><h3>Registration Succesfully !!</h3></center>");
				

			}
		}

	}
}
