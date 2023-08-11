package com.alrs.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.alrs.models.Model;


public class DBConnection {
	
	int result=0;
	Connection conn = null;
	PreparedStatement ps = null;
	String QUERY = "insert into  register values(?,?,?,?,?,?)";
    
	public int insert(Model model) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dharam2","dharam2");
			ps = conn.prepareStatement(QUERY);
			ps.setString(1, model.getName());
			ps.setString(2, model.getUserId());
			ps.setString(3, model.getEmail());
			ps.setLong(4, model.getPhone());
			ps.setString(5, model.getUserType());
			ps.setString(6, model.getPassword());
			
			result = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
