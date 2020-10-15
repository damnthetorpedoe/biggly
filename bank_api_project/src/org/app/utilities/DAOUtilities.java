package org.app.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.app.DAO.UserDAO;
import org.app.DAO.impl.UserDAOImpl;

public class DAOUtilities {

	private static Connection connection;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		
		String url = "jdbc:postgresql://localhost:5432/HelloBank";
		String username = "postgres";
		String password = "_SanDiego20";
		
		connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}
	
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}

}
