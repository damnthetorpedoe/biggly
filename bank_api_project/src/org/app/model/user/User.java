package org.app.model.user;

public class User {

	private String userId;
	private String username;
	private String password;
	private long contact;
	private String role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String username, String password, long contact, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.contact = contact;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + this.hashCode() + ", username=" + username + ", password=" + password + ", contact=" + contact + "]";
	}
	
	
}