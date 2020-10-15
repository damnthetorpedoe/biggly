package org.app.DAO;

import java.util.List;

import org.app.exception.BusinessException;
import org.app.model.user.Account;
import org.app.model.user.User;

public interface AdminDAO {
	
	//Read
	
	public List<User> getAllUsers() throws BusinessException;

}
