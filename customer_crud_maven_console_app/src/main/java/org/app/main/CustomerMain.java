package org.app.main;

import org.app.dao.impl.CustomerDAOImpl;
import org.app.exception.BusinessException;
import org.app.model.Customer;

import java.util.List;


public class CustomerMain {

	public static void main(String[] args) {
		
		CustomerDAOImpl dao = new CustomerDAOImpl();
//		Customer cust = new Customer(4, "Ronald Borowitz", "Trenton", 4445556677l, "x", 87);
//		try {
//			int c = dao.addCustomer(cust);
//			System.out.println(cust);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Customer cust2 = new Customer(1, "Jimmy Caluzzo", "Miami", 9877652937l, "m", 46);
		try {
			dao.updateCustomer(cust2);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<Customer> custList = dao.getAllCustomers();
			System.out.println("\n\nThere are "+custList.size()+" no of customers registered with us... Below are the details");
			for(Customer c:custList) {
				System.out.println(c);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(dao.getCustomerById(3));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			try {
				System.out.println(dao.getCustomerByContact(5556669988l));
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				System.out.println(dao.getCustomersByGender("m"));
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				List<Customer> custList = dao.getCustomersByGender("m");
				for(Customer c:custList) {
					System.out.println(c);
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				List<Customer> custList = dao.getCustomersByCity("Miami");
				for(Customer c:custList) {
					System.out.println(c);
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			List<Customer> custList = dao.getCustomersByName("Jimmy Caluzzo");
			for(Customer c:custList) {
				System.out.println(c);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Customer> custList = dao.getCustomersByAge(33);
			for(Customer c:custList) {
				System.out.println(c);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
