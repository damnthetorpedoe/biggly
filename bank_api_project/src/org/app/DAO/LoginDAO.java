package org.app.DAO;

import org.app.exception.BusinessException;
import org.app.model.user.User;

public interface LoginDAO {

	
	public boolean isValidUserCredentials(User user) throws BusinessException;
}
