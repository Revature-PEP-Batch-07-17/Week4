package com.revature.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
	/*
	 * DriverManager - Generate Connection Objects
	 * Connection - Create Statement Objects in your program & Send queries to your DB
	 */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "joe";
		String password = "password";
		
		// Driver Manager will return a connection object if supplied with a URL, username, password
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void main(String[] args) {
		try {
			getConnection();
			System.out.println("Connection Was successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection Was NOT successful");
		}
	}
}
