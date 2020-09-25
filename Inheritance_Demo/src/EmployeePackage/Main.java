package EmployeePackage;

public class Main {
	public static void main(String[] args) {
	Person person=new Person(100, "Sachin");
	System.out.println(person);
	
	Address a=new Address(188888, "XYZ Street Name", "San Fan", "Kansas", 1222222);
	Address b=new Address(0, "Under the I=5", null, null, 0);
	Project p = new Project("Team lead", 12, 200000.20, 5, "Marketing","NewMobile");
	Employee employee=new Employee(102, "Raj", "Manager", 123344.44d);
	employee.setPermenantAddress(a);
	employee.setPresentAddress(b);
	employee.setProject(p);
	System.out.println(employee);
	
//	private String role;
//	private int duration;
//	private double budget;
//	private int members;
//	private String function;
//	private String product;
	
	Player player=new Player(900, "Chris Morris", 100, "Cricket");
	System.out.println(player);

}

}
