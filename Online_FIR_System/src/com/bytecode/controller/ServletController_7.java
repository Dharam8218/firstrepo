package com.bytecode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//track servlet
public class ServletController_7 extends HttpServlet {

	String referenceNumber;
	Connection conn = null;
	PreparedStatement ps = null;
	String QUERY = "select name,address,dateofcomplain,complaintype from complain where uniqueid=?";
	ResultSet rs = null;
	java.sql.Date sqlDate;
	java.util.Date uDate;
	SimpleDateFormat simpleDateFormat;
	String stringDate;
	String name;
	String address;
	String complainType;
	PrintWriter pw = null;
	HttpSession session;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		pw = res.getWriter();
		referenceNumber = req.getParameter("track");
		session=req.getSession(false);
		List<String> list = new  ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dharam2", "dharam2");
			ps = conn.prepareStatement(QUERY);
			ps.setString(1, referenceNumber);
			rs = ps.executeQuery();
			if (rs.next() != false) {
				sqlDate = rs.getDate(3);
				uDate = (java.util.Date) sqlDate;
				simpleDateFormat = new SimpleDateFormat("EEE ddMMMYYYY");
				stringDate = simpleDateFormat.format(uDate);

				name = rs.getString(1);
				address = rs.getString(2);
				complainType = rs.getString(4);
				pw.println("<center><h1><b>Complain Status</b></h1></center>");
				pw.println("<center>");
				pw.println("<table border='1' cellspacing='0'>");
				pw.println("<tr>");
				pw.println("<td><b>Name:</b></td>");
				pw.println("<td>" + name + "</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td><b>Address:</b></td>");
				pw.println("<td>" + address + "</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td><b>Date of Complaint:</b></td>");
				pw.println("<td>" + stringDate + "</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td><b>Complaint Type:</b></td>");
				pw.println("<td>" + complainType + "</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td><b>Approved:</b></td>");
				pw.println("<td>No</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td><b>Status:</b></td>");
				pw.println("<td>  </td>");
				pw.println("</tr>");
				pw.println("</table>");
				pw.println("</center>");

			} else {
				list.add("Refrence number not found. Please enter valid refrence number.");
				session.setAttribute("error3", list);
				req.getRequestDispatcher("track.jsp").include(req, res);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
