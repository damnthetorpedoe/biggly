package EmployeePackage;

public class Project {

	private String role;
	private int duration;
	private double budget;
	private int members;
	private String function;
	private String product;
	
	public Project(){
		
	}


	public Project(String role, int duration, double budget, int members, String function, String product) {
		super();
		this.role = role;
		this.duration = duration;
		this.budget = budget;
		this.members = members;
		this.function = function;
		this.product = product;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Project [role=" + role + ", duration=" + duration + ", budget=" + budget + ", members=" + members
				+ ", function=" + function + ", product=" + product + "]";
	}
	
	
	
}
