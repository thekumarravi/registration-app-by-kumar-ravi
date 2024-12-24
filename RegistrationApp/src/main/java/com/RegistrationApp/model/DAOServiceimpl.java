package com.RegistrationApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceimpl implements DAOService {
	//Statement stmnt;
	//  Connection con = null;
	@Override
	  public void connectDB() {
       
//        Statement stmnt = null;
//        try {
//            // Load MySQL JDBC Driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Establishing connection
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_jan_db", "root", "kravi73200");
//
//            // Check if the connection is valid (timeout of 5 seconds)
//            if (con != null && con.isValid(5)) {
//                System.out.println("Database connected successfully!");
//                // Optionally, create a Statement object to interact with the database
//                stmnt = con.createStatement();
//            } else {
//                System.out.println("Database connection failed!");
//            }
//
//        } catch (ClassNotFoundException e) {
//            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
//        } catch (SQLException e) {
//            System.err.println("SQL Exception: " + e.getMessage());
//        } finally {
        
    }

	@Override
	public boolean verifyLogin(String email, String password) {
	    System.out.println("input email: " + email);
	    System.out.println("input password: " + password);
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing connection
         Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_jan_db", "root", "kravi73200");
	        
	        String query = "SELECT * FROM login WHERE email = ? AND password = ?";
	        
	        System.out.println("query " + query);
	        PreparedStatement stmt = con.prepareStatement(query);
	        stmt.setString(1, email);
	        stmt.setString(2, password);

	        ResultSet result = stmt.executeQuery();
	        
	        // Check if the result set has any rows
	        if (result.next()) {
	            // Only access the data if there is a row in the result
	            String email2 = result.getString("email");
	            String password2 = result.getString("password");

	            System.out.println("Database email: " + email2);
	            System.out.println("Database password: " + password2);

	            return true;  // Successfully found the matching record
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;  // No matching record found
	}


	private Statement executeQuery(ResultSet executeQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRegistration(String name,  String course,String email, String mobile) {
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing connection
         Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_jan_db", "root", "kravi73200");

         Statement  stmnt=	con.createStatement();
			int executeUpdate = stmnt.executeUpdate("insert into registration values('"+name+"','"+course+"','"+email+"','"+mobile+"')");
			 

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void deleteRegistration(String email) {
		try {
			Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_jan_db", "root", "kravi73200");

	         Statement  stmnt=	con.createStatement();
	          stmnt.executeUpdate("delete from registration where email='"+email+"'");
	          
				
		} catch (Exception e) {
			
		}

	}

	@Override
	public void updateRegistration(String mobile, String email) {
		try {
	         System.out.println(email);
	         System.out.println(mobile);
			Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_jan_db", "root", "kravi73200");

	         Statement  stmnt=	con.createStatement();
	          stmnt.executeUpdate("update registration set mobile='"+mobile+"' where email='"+email+"'");
	          
				
		} catch (Exception e) {
			
		}

	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet ListRegistration() {
		
		try {
			Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_jan_db", "root", "kravi73200");

	         Statement  stmnt=	con.createStatement();
	         ResultSet executeUpdate = stmnt.executeQuery("Select * from registration");
				return executeUpdate;
		} catch (Exception e) {
			
		}
		return null;
	}

}