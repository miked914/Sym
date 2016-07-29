package com.symphony.resources.services;

//STEP 1. Import required packages
import java.sql.*;

public class Database {
	
	public Connection getConnection() throws Exception {
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		// static final String DB_URL = "jdbc:mysql://rds-ip:3306/mytestdb";
		final String DB_URL = "jdbc:mysql://mytestdb.cap8tjcjoquc.us-west-2.rds.amazonaws.com:3306/mytestdb?user=admin&password=12345678";

		//  Database credentials
//		final String USER = "admin";
//		final String PASS = "12345678";
		
		Connection conn = null;
//		Statement stmt = null;
		
		try{
						
			//STEP 2: Register JDBC driver
		 //   Class.forName("com.mysql.jdbc.Driver");
			Class.forName(JDBC_DRIVER);
			
		    //STEP 3: Open a connection
		    System.out.println("Connecting to database...");
		    // conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    conn = DriverManager.getConnection(DB_URL);
		      
			return conn;
			
		}catch(SQLException se){
		    //Handle errors for JDBC
			throw se;
		}catch(Exception e){
		    //Handle errors for Class.forName
			throw e;
}/*		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
//		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
//		            conn.close();
		      }catch(SQLException se){
		         throw se;
		      }//end finally try
		   }//end try		   
*/		
	}
}
