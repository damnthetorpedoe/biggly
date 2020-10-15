package org.app.model.user;

public class AccountStatus {
	
	private int statusId; // primary key
	private String accountStatus; // not null, unique
	
	public AccountStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.accountStatus = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return accountStatus;
	}

	public void setStatus(String status) {
		this.accountStatus = status;
	}
	
	
	
}
