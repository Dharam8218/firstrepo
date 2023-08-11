package com.alrs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	String userId;
	String password;
	String userType;
	Connection conn = null;
	PreparedStatement ps = null;
	String QUERY = "select * from register where userid = ? and password = ? and usertype=?";
	ResultSet rs = null;
	PrintWriter pw = null;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		userId = req.getParameter("usid");
		password = req.getParameter("pwd");
		userType = req.getParameter("utype");

		List<String> list = new ArrayList<>();

		if (userId.equals("")) {
			list.add("usid is null please enter valid usid.");
		}
		if (password.equals("")) {
			list.add("pwd is null please enter valid pwd.");
		}
		if (userType.equals("")) {
			list.add("utype is null please enter valid utype.");
		}
         pw=res.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dharam2","dharam2");
			ps = conn.prepareStatement(QUERY);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, userType);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				pw.println("<center><h1>You have successfully registered</h1></center>");
				req.getRequestDispatcher("index.html").include(req, res);
			}else {
				pw.println("<center><h1>Login Failed</h1></center>");
				req.getRequestDispatcher("login.jsp").include(req, res);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
