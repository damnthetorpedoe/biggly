package org.app.customer.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

	private static Connection connection;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/rocp-1";
		String username = "postgres";
		String password = "_SanDiego20";
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}

