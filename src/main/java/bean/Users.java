package bean;

public class Users {
	private int id;
	private String name;
	private String phone;
	private String email;
	private int age;
	private String gender;
	private int roleId;
	private String password;
	private String category;
	
//	public Users(int id, String name, String phone, String email, int age, String gender, int roleId, String password) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.phone = phone;
//		this.email = email;
//		this.age = age;
//		this.gender = gender;
//		this.roleId = roleId;
//		this.password = password;
//	}
	
	public Users(int id, String name, String phone, String email, int age, String gender, int roleId) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.roleId = roleId;
	}
	
	public Users(int id, String name, String phone, String email, int age, String gender, int roleId, String category) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.roleId = roleId;
		this.category = category;
	}

	
	public Users(int id, String name, String phone, String email, int age, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.gender = gender;
	}
	
	
	public Users() {
		// TODO Auto-generated constructor stub
	}


	public Users(String name, String phone, String email, int age, String gender, int roleId) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.roleId = roleId;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
