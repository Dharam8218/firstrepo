package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletToDB extends HttpServlet {

	Connection conn = null;
	String QUERY = null;
	PreparedStatement ps;
	PrintWriter pw;

	String empid = null;
	int eid = 0;
	ResultSet rs = null;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dharam", "dharam");
			QUERY = "select empno,ename,sal,job from emp where empno=?";
			ps = conn.prepareStatement(QUERY);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		pw = res.getWriter();

		empid = req.getParameter("eid");
		eid = Integer.parseInt(empid);

		try {
			
			ps.setInt(1, eid);

			rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("/headerurl");
            rd.include(req, res); 
			
			if (rs.next() != false) {

				pw.println("<br> Employee number is:: " + rs.getInt(1));
				pw.println("<br> Employee name is:: " + rs.getString(2));
				pw.println("<br> Employee salary is:: " + rs.getInt(3));
				pw.println("<br> Employee designation is:: " + rs.getString(4));
			}

			else {
				pw.println("No record found for " + eid + " employee id ");
			}
			RequestDispatcher rd1 = req.getRequestDispatcher("footer.html");
			rd1.include( req, res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
		RequestDispatcher rd2 = req.getRequestDispatcher("/errorurl");
		  rd2.forward(req, res);
		}
	}

	@Override
	public void destroy() {
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
