package org.app.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.app.DAO.UserDAO;
import org.app.exception.BusinessException;
import org.app.model.user.Account;
import org.app.model.user.User;

import org.app.utilities.DAOUtilities;


public class UserDAOImpl implements UserDAO {

	//CREATE
	
	@Override
	public boolean addUser(User user) throws BusinessException {
		
		try {
			Connection ctn = DAOUtilities.getConnection();
			
			String sql = "INSERT INTO Users VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = ctn.prepareStatement(sql);
			
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setLong(4, user.getContact());
			stmt.setString(5, user.getRole());
		
		
		if (stmt.executeUpdate() != 0)
			return true;
		else
		return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//READ 
	
	
	
	@Override
	public User getUserById(String userId) throws BusinessException {
		
		User user = null;
		
		try(Connection ctn = DAOUtilities.getConnection()){
			
			String sql = "SELECT userId, username, password, contact FROM Users WHERE userId = ?";
			PreparedStatement stmt = ctn.prepareStatement(sql);
			
			stmt.setString(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setUserId(userId);
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setContact(rs.getLong("contact"));	
			} else {
				throw new BusinessException("User not found");
			}
		} catch (ClassNotFoundException| SQLException e) {
				System.out.println(e);
				throw new BusinessException("Internal error occurred...kindly contact system admin");
			}
			return user;
			
		}

	@Override
	public User getUserByUsernamePassword(String username, String password) throws BusinessException {

		
		try(Connection ctn = DAOUtilities.getConnection()){
			
			String sql = "SELECT userId, username, password, contact FROM Users WHERE username = ? AND password = ?";
			PreparedStatement stmt = ctn.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setUserId(rs.getString("userId"));
				user.setContact(rs.getLong("contact"));	
				return user;
			} else {
				throw new BusinessException("User not found");
			}
		} catch (ClassNotFoundException| SQLException e) {
				System.out.println(e);
				throw new BusinessException("Internal error occurred...kindly contact system admin");
			}
			
			
		
	}
	
	@Override
	public Account getAccountById(String userId) throws BusinessException {
		try(Connection ctn = DAOUtilities.getConnection()){
			
			String sql = "SELECT accountId, balance FROM Account WHERE userId = ?";
			PreparedStatement stmt = ctn.prepareStatement(sql);
			
			stmt.setString(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt("accountId"));
				account.setBalance(rs.getDouble("balance"));
				return account;
			} else {
				throw new BusinessException("Account not found");
			} 
		} catch (ClassNotFoundException| SQLException | BusinessException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred...kindly contact system admin");
		}
	
	}
	
	//UPDATE
	
	@Override
	public boolean updateUser(User user) throws BusinessException {

		try(Connection ctn = DAOUtilities.getConnection()){
			
			String sql = "UPDATE Users SET username = ?, password = ?, contact = ?, role = ? WHERE username = ?, password = ?";
			PreparedStatement stmt = ctn.prepareStatement(sql);
			
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setLong(3, user.getContact());
			stmt.setString(4, user.getRole());
			
			System.out.println(stmt);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}

	
	//DELETE
	
	@Override
	public boolean deleteUserByUsernamePassword(String username, int password) throws BusinessException {
		try (Connection connection = DAOUtilities.getConnection()){
			
			String sql = "DELETE FROM Users WHERE username=? AND password=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setInt(2, password);
			
			if(stmt.executeUpdate() != 0) 
				return true;
			else
				return false;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAccountByUserId(String userId) throws BusinessException {
		try (Connection ctn = DAOUtilities.getConnection()) {
			
			String sql = "DELETE FROM Accounts WHERE userId=?";
			PreparedStatement stmt = ctn.prepareStatement(sql);
			
			stmt.setString(1, userId);
			
			if(stmt.executeUpdate() != 0)
				return true;
			else 
				return false;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
