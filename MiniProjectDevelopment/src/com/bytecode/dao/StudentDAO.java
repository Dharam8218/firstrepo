package com.bytecode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bytecode.bo.StudentBO;

public class StudentDAO {
     
     int result = 0;
     Connection conn = null;
     
     PreparedStatement ps = null;
     public static final String QUERY = "insert into studentdetails values(?,?,?,?,?)";
       
     public int insert(StudentBO bo) {
     try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dharam","dharam");
         ps = conn.prepareStatement(QUERY);
         //set bo class object values to ps
         ps.setString(1,bo.getName());
         ps.setString(2,bo.getSid());
         ps.setInt(3,bo.getTotal());
         ps.setFloat(4,bo.getAvg());
         ps.setString(5,bo.getResult());
         
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
