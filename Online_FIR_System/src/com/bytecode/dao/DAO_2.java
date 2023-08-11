package com.bytecode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bytecode.bo.BO_2;

public class DAO_2 {
	Connection conn = null;
	PreparedStatement ps = null;
	String QUERY = "select * from registration where email=? and password=?";
	ResultSet rs = null;
	public String result;

	public String checkCredential(BO_2 bo) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dharam2", "dharam2");
			ps = conn.prepareStatement(QUERY);
			ps.setString(1, bo.getEmail());
			ps.setString(2, bo.getPassword());

			rs = ps.executeQuery();

			if (rs.next() != false) {
				result = rs.getString(1);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
        
		return result;
	}
}
