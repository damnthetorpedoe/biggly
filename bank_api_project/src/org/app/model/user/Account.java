package org.app.model.user;

public class Account {

	private int accountId; // primary key
	private double balance;  // not null
	private AccountStatus status;
	private AccountType type;
	private String userId;
	
	public Account(int accountId, double balance, AccountStatus status, AccountType type, String userId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.type = type;
		this.userId = userId;
	}

	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	
	
}
