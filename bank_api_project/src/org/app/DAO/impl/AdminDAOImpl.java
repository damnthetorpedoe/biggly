package org.app.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.app.DAO.AdminDAO;
import org.app.exception.BusinessException;
import org.app.model.user.User;
import org.app.utilities.DAOUtilities;
import org.app.model.user.Role;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public List<User> getAllUsers() throws BusinessException {
		
		List<User> users = new ArrayList<>();
		
		try {
			Connection ctn = DAOUtilities.getConnection(); //initializes connection session with DB
			String sql = "SELECT * FROM Users"; //preparing a variable with the SQL statement 
			PreparedStatement stmt = ctn.prepareStatement(sql); //representing the precompiled SQL statement to send to the DB
			
			ResultSet rs = stmt.executeQuery(); //table for representing data
			
			while (rs.next()) {
				User user = new User(); // generate new User object to populate with data
			
				user.setUserId(rs.getString("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setContact(rs.getLong("contact"));
				
				users.add(user); //adds the user to the list
			}
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e + "Sorry, there was a problem processing your request.");
		}
		
		return users;
	}

	
	
}
