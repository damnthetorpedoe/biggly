package org.app.DAO;

import java.util.List;

import org.app.exception.BusinessException;
import org.app.model.user.Account;
import org.app.model.user.User;

public interface UserDAO {

	//Create
	public boolean addUser(User user) throws BusinessException;
	
	//Read
	public User getUserById(String userId) throws BusinessException;
	public User getUserByUsernamePassword(String username, String password) throws BusinessException;
	public Account getAccountById(String userId) throws BusinessException;
	

	//Update
	public boolean updateUser(User user) throws BusinessException;
	
	//Delete
	public boolean deleteUserByUsernamePassword(String username, int password) throws BusinessException;
	public boolean deleteAccountByUserId(String userId) throws BusinessException;
}