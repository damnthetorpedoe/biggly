package org.app.service;

import org.app.exception.BusinessException;
import org.app.model.user.User;

public interface LoginService {

	public boolean isValidUserCredentials(User user) throws BusinessException;
	
}
