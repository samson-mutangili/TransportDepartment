package com.samson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * This class helps to check if the user credentials are already in the 
 * database, after signing up
 */
public class LogInDao {
	
	//the database details
	private String url="jdbc:mysql://localhost:3306/group_project";
	private String dbname = "root";
	private String pass = "";
	
	//a method that returns a boolean value depending to the user details entered
	
	public boolean check(String username, String password){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//create a connection
			Connection con = DriverManager.getConnection(url, dbname, pass);
			//create a statement
			
			//database query
			String query1 = "select * from users where username=? and password=?";
			//load the mysql database drivers
			PreparedStatement st = con.prepareStatement(query1);
			//bind the values
			st.setString(1,username);
			st.setString(2,password);
			
			ResultSet rs = st.executeQuery();
			//check if there are any results
			if(rs.next()){
				return true;
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return false;
		

	}
	
	public void insertData(String firstname, String lastname, String uname,
			String password, String password_confirm, String email){
		
		//check if the two passwords are equal
		if(password.equals(password_confirm)){
			
			//check if there is a user with that username
			Connection con;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, dbname, pass);
				String query2 = "select * from users where username=?";
				
				PreparedStatement st = con.prepareStatement(query2);
				st.setString(1,uname);
				ResultSet rs = st.executeQuery();
				if(rs.next()){
					System.out.println("There is a user with that username");
				}
				else{
					//insert the user details into the database
					con = DriverManager.getConnection(url, dbname, pass);
					String query3 = "insert into users values(?,?,?,?,?)";
					//prepare a statement
					PreparedStatement st1 = con.prepareStatement(query3);
					st1.setString(1, firstname);
					st1.setString(2, lastname);
					st1.setString(3, uname);
					st1.setString(4, password);
					st1.setString(5, email);
					
					//run the update and insert the data to the database
					int rows = st1.executeUpdate();
					
					System.out.println(rows + "affected");
					
					st1.close();
					con.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			
			
		} else {
			System.out.println("The entered passwords are not the same!!");
		}
	}
	
	
}
