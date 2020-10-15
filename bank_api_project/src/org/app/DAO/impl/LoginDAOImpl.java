package org.app.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.app.utilities.*;
import org.app.DAO.LoginDAO;
import org.app.exception.BusinessException;
import org.app.model.user.User;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isValidUserCredentials(User user) throws BusinessException {
		boolean b = false;
		
		try(Connection ctn = DAOUtilities.getConnection()){
			String sql="SELECT username FROM Users WHERE username=? and password=?";
			PreparedStatement preparedStatement=ctn.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				b = true;
			} else {
				throw new BusinessException("Sorry, invalid login username and/or password. Please try again.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured... Kindly contact system admin.....");
		}
		return b;
	}

}
