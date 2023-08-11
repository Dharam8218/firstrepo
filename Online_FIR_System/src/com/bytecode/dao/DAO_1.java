package com.bytecode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bytecode.bo.BO_1;

public class DAO_1 {
	int result = 0;
	Connection conn = null;
	PreparedStatement ps = null;
	String QUERY = "insert into registration values(?,?,?,?,?,?)";

	public int insert(BO_1 bo) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dharam2", "dharam2");
			ps = conn.prepareStatement(QUERY);

			// set bo class object values to ps

			ps.setString(1, bo.getName());
			ps.setString(2, bo.getFatherName());
			ps.setString(3, bo.getEmail());
			ps.setInt(4, bo.getAge());
			ps.setString(5, bo.getAddress());
			ps.setString(6, bo.getPassword());

			// execute the query and get the result

			result = ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
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
