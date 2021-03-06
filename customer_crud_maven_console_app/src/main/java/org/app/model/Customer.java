package org.app.model;

public class Customer {

	private int id;
	private String name;
	private String city;
	private long contact;
	private String gender;
	private int age;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int id, String name, String city, long contact, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.contact = contact;
		this.gender = gender;
		this.age = age;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cutsomer [id=" + id + ", name=" + name + ", city=" + city + ", contact=" + contact + ", gender="
				+ gender + ", age=" + age + "]";
	}

}
