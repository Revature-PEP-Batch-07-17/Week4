package util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtility {
	public static Connection getConnection() throws SQLException {
		// url, username, password
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "joe", "password");
	}
	
	public static void main(String[] args) {
		try {
			getConnection();
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
