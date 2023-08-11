package com.bytecode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bytecode.dto.DTO_6;
import com.bytecode.service.Service_6;
import com.bytecode.vo.VO_6;

//complain form to database
public class ServletController_6 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;

	VO_6 vo = null;
	DTO_6 dto = null;
	Service_6 service = null;

	String capitalChars;
	String smallChars;
	String numbers;
	String symbols;
	String values;
	Random random;
	char[] uniqueNumber;
	String stringUniqueNumber;

	boolean result;
	boolean b = false;
	HttpSession session;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");

		pw = res.getWriter();

		// generating random number
		capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		smallChars = "abcdefghijklmnopqrstuvwxyz";
		numbers = "0123456789";
		symbols = "!@#$%^&*_=+-/.?<>)";
		values = capitalChars + smallChars + numbers + symbols;
		random = new Random();
		uniqueNumber = new char[6];
		for (int i = 0; i < 6; i++) {
			uniqueNumber[i] = values.charAt(random.nextInt(values.length()));
		}

		stringUniqueNumber = new String(uniqueNumber);

		vo = new VO_6();
		vo.setFirstName(req.getParameter("firstname"));
		vo.setLastName(req.getParameter("lastname"));
		vo.setMobileNumber(req.getParameter("mnumber"));
		vo.setAddress1(req.getParameter("address1"));
		vo.setAddress2(req.getParameter("address2"));
		vo.setCity(req.getParameter("city"));
		vo.setState(req.getParameter("state"));
		vo.setZipCode(req.getParameter("zip"));
		vo.setNearestPoliceStationName(req.getParameter("pname"));
		vo.setComplainType(req.getParameter("cname"));
		vo.setWhereDidTheIncidentOccurs(req.getParameter("where"));
		vo.setAdditionalInformation(req.getParameter("description"));
		vo.setUniqueId(stringUniqueNumber);
		
		session=req.getSession(false);
		List<String> list = new  ArrayList<>();
		List<String> list1 = new  ArrayList<>();

		dto = new DTO_6();
		dto.setFirstName(vo.getFirstName());
		dto.setLastName(vo.getLastName());
		try {
			dto.setMobileNumber(Long.parseLong(vo.getMobileNumber()));
		} catch (NumberFormatException nfe) {
			 list.add("Invalid Mobile Number. Please enter valid mobile number.");
			 session.setAttribute("error1",list);
			 //req.getRequestDispatcher("complaint.jsp").include(req, res);
			 b = true;
		}
		dto.setAddress1(vo.getAddress1());
		dto.setAddress2(vo.getAddress2());
		dto.setCity(vo.getCity());
		dto.setState(vo.getState());
		try {
			dto.setZipCode(Integer.parseInt(vo.getZipCode()));
		} catch (NumberFormatException nfe) {
			list1.add("Invalid Zipcode. Please enter valid zip code.");
			session.setAttribute("error2",list1);
			//pw.println("<center><h5>Invalid Zipcode. Please enter valid zip code.</h5></center><hr>");
			req.getRequestDispatcher("complaint.jsp").include(req, res);
			b = true;
		}
		dto.setNearestPoliceStationName(vo.getNearestPoliceStationName());
		dto.setComplainType(vo.getComplainType());
		dto.setWhereDidTheIncidentOccurs(vo.getWhereDidTheIncidentOccurs());
		dto.setAdditionalInformation(vo.getAdditionalInformation());
		dto.setUniqueId(vo.getUniqueId());

		if (b == false) {
			service = new Service_6();
			try {
				result = service.setAccurateData(dto);
			} catch (Exception ae) {
				ae.printStackTrace();
			}

			if (result == false) {

				pw.println("<center><h5>Complian not registered<center><h5><hr>");
				req.getRequestDispatcher("complain.jsp").include(req, res);
			} else {
				req.getRequestDispatcher("header.jsp").include(req, res);
                pw.println("<hr><center><h3>");
				pw.print("Complain Registered Succesfully !!<br>");
				pw.print("Your complaint refrence ID is " + stringUniqueNumber);
				pw.print("<br>Please keep it for future use");
				pw.println("</center></h3>");
				//req.getRequestDispatcher("homebutton.jsp").include(req, res);
				

			}
			
		}

	}
}
