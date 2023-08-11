package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw;
		String name;
		String eMail;
		String password;
		Connection conn = null;
		Statement st = null;
		int result;
		res.setContentType("text/html");
		pw = res.getWriter();
		name = req.getParameter("username");
		eMail = req.getParameter("email");
		password = req.getParameter("pass");
		name = "'" + name + "'";
		eMail = "'" + eMail + "'";
		password = "'" + password + "'";
		pw.println("Name:" + name + "<br>");
		pw.println("Email: " + eMail + "<br>");

		try {
			// load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// get the connection object
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dharam", "dharam");
			// create the connection object
			st = conn.createStatement();
			// prepare the sql query
			String query = "insert into signup values(" + name + "," + eMail + "," + password + ")";
			// execute the query
			result = st.executeUpdate(query);
			if (result == 1) {
				pw.println("Record insert successfully<br>");
			} else {
				pw.println("Record not inserted<br>");
			}
			pw.println("<a href='login.html'>Click here for SignUp Page</a>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st.close();
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
