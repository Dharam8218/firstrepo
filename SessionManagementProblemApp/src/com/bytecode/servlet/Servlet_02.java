package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_02 extends HttpServlet {

	Connection conn;
	String QUERY;
	PreparedStatement ps;
	String name;
	String sage;
	String fname;
	String mStatus;
	String stb1;
	String stb2;
	int result = 0;
	PrintWriter pw;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		pw = res.getWriter();

		name = req.getParameter("name");
		sage = req.getParameter("sage");
		fname = req.getParameter("fname");
		mStatus = req.getParameter("mStatus");
		stb1 = req.getParameter("stb1");
		stb2 = req.getParameter("stb2");

		pw.println("Person Name::" + name + "<br>");
		pw.println("Person Age::" + sage + "<br>");
		pw.println("Person Father'sName::" + fname + "<br>");
		pw.println("Marital Status::" + mStatus + "<br>");
		if (mStatus.equalsIgnoreCase("married")) {
			pw.println("Spouse Name::" + stb1 + "<br>");
			pw.println("No of children::" + stb2 + "<br>");
		} else {
			pw.println("When to marry::" + stb1 + "<br>");
			pw.println("Why to marry::" + stb2 + "<br>");
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dharam", "dharam");
			if (mStatus.equalsIgnoreCase("married")) {
				QUERY = "insert into persondetail values(?,?,?,?,?,?)";
			} else {
				QUERY = "insert into persondetail1 values(?,?,?,?,?,?)";
			}
			ps = conn.prepareStatement(QUERY);
			ps.setString(1, name);
			ps.setString(2, sage);
			ps.setString(3, fname);
			ps.setString(4, mStatus);
			ps.setString(5, stb1);
			ps.setString(6, stb2);

			result = ps.executeUpdate();

			if (result == 0) {
				pw.println("RECORD NOT INSERTED");
			} else {
				pw.println("RECORD INSERTED SUCCESSFULLY");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
