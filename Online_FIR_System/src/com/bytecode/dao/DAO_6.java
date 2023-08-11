package com.bytecode.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bytecode.bo.BO_6;

public class DAO_6 {
    
	 int result = 0;
	 Connection conn = null;
	 PreparedStatement ps = null;
	 String QUERY = "insert into complain values(?,?,?,?,?,?,?,?,?,?)";
	 Date utilDate=null;
	 long ms;
	public int insert(BO_6 bo)  {
		 
		utilDate = new Date();
		ms = utilDate.getTime();
		java.sql.Date sqlDate= new java.sql.Date(ms);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dharam2","dharam2");
			ps=conn.prepareStatement(QUERY);
			ps.setString(1, bo.getName());
			ps.setLong(2, bo.getMobileNumber());
			ps.setString(3, bo.getAddress());
			ps.setInt(4, bo.getZipCode());
			ps.setString(5, bo.getNearestPoliceStationName());
			ps.setString(6, bo.getComplainType());
			ps.setString(7, bo.getWhereDidTheIncidentOccurs());
			ps.setString(8, bo.getAdditionalInformation());
			ps.setString(9, bo.getUniqueId());
			ps.setDate(10, sqlDate);
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
			}try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
