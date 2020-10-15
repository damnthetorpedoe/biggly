package org.app.service;

import org.app.DAO.UserDAO;
import org.app.DAO.impl.UserDAOImpl;
import org.app.exception.BusinessException;
import org.app.model.user.Role;
import org.app.model.user.User;
import org.app.model.user.Account;

public class CustomerServiceMain {

	public CustomerServiceMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		//addNewUser
		UserDAO dao = new UserDAOImpl();
		User user = new User("U11", "HungryHippo","1234567", 5434567856l,"c");
		try {
			boolean c = dao.addUser(user);
			System.out.println(user);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(dao.getUserById("U6"));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(dao.getUserByUsernamePassword("TastyTortoise","1234567"));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			System.out.println(dao.getAccountById("U2"));
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}
		
		User user2 = new User("U11", "HungryHippo","1234568", 5434567856l,"c");
		try {
			dao.updateUser(user2);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

//private String userId;
//private String username;
//private String password;
//private long contact;
//private Role role;