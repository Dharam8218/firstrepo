package com.bytecode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bytecode.dao.DAO_2;
import com.bytecode.dto.DTO_2;
import com.bytecode.service.Service_2;
import com.bytecode.vo.VO_2;

//login servlet
public class ServletController_2 extends HttpServlet {

	PrintWriter pw = null;
	String name;
	VO_2 vo = null;
	DTO_2 dto = null;
	Service_2 service = null;
	boolean result;
	DAO_2 dao = null;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		pw = res.getWriter();
		// req.getRequestDispatcher("Welcome.html").include(req, res);

		vo = new VO_2();
		vo.setEmail(req.getParameter("email"));
		vo.setPassword(req.getParameter("password"));

		dto = new DTO_2();
		dto.setEmail(vo.getEmail());
		dto.setPassword(vo.getPassword());

		service = new Service_2();

		try {
			result = service.isCredentialCorrect(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> list = new ArrayList<>();

		name = service.getName();
		if (result == true) {
			HttpSession session = req.getSession();
			list.add(name);
			session.setAttribute("name", list);
			req.getRequestDispatcher("Welcome.jsp").include(req, res);

		} else {

			pw.println("<center><h5>Incorrect email or password</h5></center><hr>");
			req.getRequestDispatcher("login.jsp").include(req, res);
		}

	}
}
