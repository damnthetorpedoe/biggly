package org.app.service;

import java.util.List;

import org.app.exception.BusinessException;
import org.app.model.user.Account;
import org.app.model.user.User;

public interface UserService {

	//Create
	public boolean addUser(User user) throws BusinessException;
	
	//Read
	public User getUserById(String userId) throws BusinessException;
	public User getUserByUsernamePassword(int password) throws BusinessException;
	public Account getAccountById(String userId) throws BusinessException;
	
	public List<User> getAllUsers() throws BusinessException;

	
	//Update
	public boolean updateUser(User user) throws BusinessException;
	
	//Delete
	public boolean deleteUserByPassword(int password) throws BusinessException;
	public boolean deleteUserById(String userId) throws BusinessException;
	
}
