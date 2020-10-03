package org.app.service;

import java.util.List;

import org.app.exception.BusinessException;
import org.app.model.Customer;

public interface CustomerService {

	public int addCustomer(Customer customer) throws BusinessException;
	public int updateCustomer(int id, long contact) throws BusinessException;
	public int deleteCustomer(int id) throws BusinessException;
	public int deleteCustomer(long contact) throws BusinessException;
	public List<Customer> getAllCustomers() throws BusinessException;
	public Customer getCustomerById(int id) throws BusinessException;
	public Customer getCustomerByContact(long contact) throws BusinessException;
	public List<Customer> getCustomersByAge(int age) throws BusinessException;
	public List<Customer> getCustomersByName(String name) throws BusinessException;
	public List<Customer> getCustomersByGender(String Gender) throws BusinessException;
	public List<Customer> getCustomersByCity(String city) throws BusinessException;
	
}
