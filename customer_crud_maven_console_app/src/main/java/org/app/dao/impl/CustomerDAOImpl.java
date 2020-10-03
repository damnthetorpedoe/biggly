package org.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.app.exception.BusinessException;
import org.app.model.Customer;

import org.app.customer.dbutil.PostgresConnection;
import org.app.dao.CustomerDAO;

public class CustomerDAOImpl implements CustomerDAO {
	
	@Override
	public int addCustomer(Customer customer) throws BusinessException {
		int c=0;
		try(Connection connection = PostgresConnection.getConnection()){
			String sql = "INSERT into customer(id,name,age,gender,city,contact) values(?,?,?,?,?,?)";
			PreparedStatement prepStmt = connection.prepareStatement(sql);
			prepStmt.setInt(1, customer.getId());
			prepStmt.setString(2, customer.getName());
			prepStmt.setInt(3, customer.getAge());
			prepStmt.setString(4, customer.getGender());
			prepStmt.setString(5, customer.getCity());
			prepStmt.setLong(6, customer.getContact());
			
			c=prepStmt.executeUpdate();
			if(c==0) {
				throw new BusinessException("Customer Registration failed ... Please try again");
				} 
		} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
				throw new BusinessException("Internal error occured... Kindly contact System Admin");
			}
			return c;
		}
	
	@Override
	public boolean updateCustomer(Customer customer) throws BusinessException {
		
		try {
			Connection connection = PostgresConnection.getConnection();
			String sql = "UPDATE Customer SET name = ?, age = ?, gender = ?, city =?, contact = ?  WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, customer.getName());
			stmt.setInt(2, customer.getAge());
			stmt.setString(3, customer.getGender());
			stmt.setString(4, customer.getCity());
			stmt.setLong(5, customer.getContact());
			stmt.setInt(6, customer.getId());
			
			System.out.println(stmt);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;}
		}
	
	@Override
	public boolean deleteCustomer(int id) throws BusinessException {
	
		try(Connection connection = PostgresConnection.getConnection()){
			String sql="DELETE FROM customer WHERE id=?";
			PreparedStatement prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setInt(1, id);
			
			if (prepStmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred...kindly contact system admin");
		}
	}
	
	@Override
	public boolean deleteCustomer(long contact) throws BusinessException {
		try(Connection connection = PostgresConnection.getConnection()){
			String sql="DELETE FROM customer WHERE contact=?";
			PreparedStatement prepStmt = connection.prepareStatement(sql);
			
			prepStmt.setLong(1, contact);
			
			if (prepStmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred...kindly contact system admin");
		}
	}

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		List<Customer> custList=new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql ="SELECT id,name,gender,city,age,contact from customer";
			PreparedStatement prepStmt = connection.prepareStatement(sql);
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCity(rs.getString("city"));
				customer.setAge(rs.getInt("age"));
				customer.setContact(rs.getLong("contact"));
				custList.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred...kindly contact system admin");
		}
		if(custList.size()==0) {
		throw new BusinessException("No customers logged in the DB");
	}
		return custList;
}

	@Override
	public Customer getCustomerById(int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresConnection.getConnection()){
			String sql = "SELECT id,name,gender,city,age,contact FROM customer WHERE id = ?";
			PreparedStatement prepStmt=connection.prepareStatement(sql);
			prepStmt.setLong(1, id);
			
			ResultSet rs=prepStmt.executeQuery();
			if(rs.next()) {
				customer = new Customer();
				customer.setId(id);
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCity(rs.getString("city"));
				customer.setAge(rs.getInt("age"));
				customer.setContact(rs.getLong("contact"));
			} else {
				throw new BusinessException("No customers with ID " + id + " in the DB");
			}
		} catch (ClassNotFoundException| SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred...kindly contact system admin");
		}
		return customer;
	}

	@Override
	public Customer getCustomerByContact(long contact) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresConnection.getConnection()){
			String sql = "SELECT id,name,gender,city,age FROM customer WHERE contact = ?";
			PreparedStatement prepStmt=connection.prepareStatement(sql);
			prepStmt.setLong(1, contact);
			
			ResultSet rs=prepStmt.executeQuery();
			if(rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCity(rs.getString("city"));
				customer.setAge(rs.getInt("age"));
				customer.setContact(contact);
			} else {
				throw new BusinessException("No customers with contact " + contact + " in the DB");
			}
		} catch (ClassNotFoundException| SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred...kindly contact system admin");
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomersByAge(int age) throws BusinessException {
		List<Customer> custList=new ArrayList<>();
		try(Connection conn = PostgresConnection.getConnection()){
			String sql = "SELECT id,name,gender,city,age,contact from customer WHERE age = ?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(1, age);
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCity(rs.getString("city"));
				customer.setAge(age);
				customer.setContact(rs.getLong("contact"));
				custList.add(customer);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred... kindly contact System Admin");
		}
		if(custList.size()==0) {
			throw new BusinessException("No customers listed in the database for age: "+ age);
		}
		return custList;
	}

	@Override
	public List<Customer> getCustomersByName(String name) throws BusinessException {
		List<Customer> custList=new ArrayList<>();
		try(Connection conn = PostgresConnection.getConnection()){
			String sql = "SELECT id,name,gender,city,age,contact from customer WHERE name = ?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, name);
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(name);
				customer.setGender(rs.getString("gender"));
				customer.setCity(rs.getString("city"));
				customer.setAge(rs.getInt("age"));
				customer.setContact(rs.getLong("contact"));
				custList.add(customer);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred... kindly contact System Admin");
		}
		if(custList.size()==0) {
			throw new BusinessException("No customers listed in the database for name: "+ name);
		}
		return custList;
	}
	

	@Override
	public List<Customer> getCustomersByCity(String city) throws BusinessException {
		List<Customer> custList=new ArrayList<>();
		try(Connection conn = PostgresConnection.getConnection()){
			String sql = "SELECT id,name,gender,city,age,contact FROM customer WHERE city = ?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, city);
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCity(city);
				customer.setAge(rs.getInt("age"));
				customer.setContact(rs.getLong("contact"));
				custList.add(customer);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred... kindly contact System Admin");
		}
		if(custList.size()==0) {
			throw new BusinessException("No customers listed in the database for city: "+ city);
		}
		return custList;
	}


	@Override
	public List<Customer> getCustomersByGender(String gender) throws BusinessException {
		List<Customer> custList=new ArrayList<>();
		try(Connection conn = PostgresConnection.getConnection()){
			String sql = "SELECT id,name,gender,city,age,contact FROM customer WHERE gender = ?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, gender.toLowerCase());
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(gender);
				customer.setCity(rs.getString("city"));
				customer.setAge(rs.getInt("age"));
				customer.setContact(rs.getLong("contact"));
				custList.add(customer);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred... kindly contact System Admin");
		}
		if(custList.size()==0) {
			throw new BusinessException("No customers listed in the database for gender: "+ gender);
		}
		return custList;
	}

}
