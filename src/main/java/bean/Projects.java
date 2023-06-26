package bean;

public class Projects {
	private int id;
	private String name;
	private String department;
	private int salary;
	
	public Projects(int id,String name, String department, int salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public Projects(String name, String department, int salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public Projects() {

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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
