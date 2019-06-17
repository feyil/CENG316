package dataaccess;

import java.sql.*;

public class DBBase {
	
	// JDBC driver name and database URL
	private static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/cengdb";
	
	// Database credentials they should be in env variable
	private static final String USER="root";
	private static final String PASS="feyil";
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static Statement createStatement() {
		Statement statement = null;
		try {
			statement = getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return statement;
	}
}
