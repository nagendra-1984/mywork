package com.neoteric.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticDBConnection {
	
	public static void main (String args[]){
		
		System.out.println("^%^ Testing Static DB Connection ^%^");
		
		getMSSQLConnection();
			
	}
	
	public static Connection getSimpleConnection() {
	    //See your driver documentation for the proper format of this string :
	    String DB_CONN_STRING = "jdbc:mysql://BOSSSWETH38748\\NEODB";
	    //Provided by your driver documentation. In this case, a MySql driver is used : 
	    String DRIVER_CLASS_NAME = "org.gjt.mm.mysql.Driver";
	    String USER_NAME = "nagendra";
	    String PASSWORD = "2009Krish";
	    
	    Connection result = null;
	    try {
	      Class.forName(DRIVER_CLASS_NAME).newInstance();
	    }
	    catch (Exception ex){
	      System.out.println("Check classpath. Cannot load db driver: " + DRIVER_CLASS_NAME);
	    }

	    try {
	      //result = DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
	    	result = DriverManager.getConnection("jdbc:mysql://BosSsweth38748/NEODB?"+"user=nagendra&password=2009Krish");
	      
	    }
	    catch (SQLException e){
	      System.out.println("Driver loaded, but cannot connect to db: " + DB_CONN_STRING);
	      System.out.println("Driver loaded, but cannot connect to db: " + e.toString());
	      e.printStackTrace();
	      
	    }
	    return result;
	  }
	
	public static Connection getMSSQLConnection(){
		
	      // Create a variable for the connection string.
	      String connectionUrl = "jdbc:sqlserver://BosSsweth38748:1433;" +
	         "databaseName=neoteric;user=nagendra;password=2009Krish";

	      // Declare the JDBC objects.
	      Connection con = null;
	      try {
	         // Establish the connection.
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);
	         
	         Statement selectStatement = con.createStatement();
	         ResultSet userRS= selectStatement.executeQuery("select * from dbo.USER_MASTER");
	         
	         
	         
	         while(userRS.next()){
	        	 
	        	 System.out.println("^%^ User Id^%^"+userRS.getInt("USER_ID"));
	        	 System.out.println("^%^ User Name^%^"+userRS.getString("USER_NAME"));
	        	 System.out.println("^%^ User email^%^"+userRS.getString("EMAIL_ID"));
	 	        
	         }
	         
	       }

	      // Handle any errors that may have occurred.
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }
		return con;
	   }


}
