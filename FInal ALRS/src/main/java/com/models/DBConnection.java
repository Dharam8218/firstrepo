package com.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {
    public Connection makeConnection() {
    	 String url      = "jdbc:postgresql://localhost:5432/alrs";
	        String U     = "postgres" ;
	        String  P       = "admin" ;
	        Connection conn=null;
	        PreparedStatement ps=null;
	     
	        
	       
	        
	       
	      try {
			conn=  DriverManager.getConnection(url, U, P);
	      }
	      catch (Exception e) {
		
		}
	      return  conn;     
    }
}
