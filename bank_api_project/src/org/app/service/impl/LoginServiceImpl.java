package org.app.service.impl;

import org.app.DAO.LoginDAO;
import org.app.DAO.impl.LoginDAOImpl;
import org.app.exception.BusinessException;
import org.app.model.user.User;
import org.app.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDAO dao = new LoginDAOImpl();
	
	
	@Override
	public boolean isValidUserCredentials(User user) throws BusinessException {
		
		boolean b = false;
		
		if((user!=null) && (user.getUsername() != null) && (user.getUsername().matches("[a-z]{4,6}[0-9]{4}")) && user.getPassword().matches("[a-z]{3,6}[*#$@]{1}[0-9]{4}")) {
			b=dao.isValidUserCredentials(user);
		}else {
			throw new BusinessException("Username and/or password invalid");
		}
		return b;
	}

}