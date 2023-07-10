package bean;

import java.sql.Date;

public class Payment {
	private int id;
	private double amount;
	private Date date;
	private String name;
	private String projectname;
	private int rowCount;
	
	public Payment(int id, double amount, Date date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
	}
	
	public Payment(double amount, Date date) {
		this.amount = amount;
		this.date = date;
	}
	
	public Payment(int id, double amount, Date date, String name, String projectname) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.name = name;
		this.projectname = projectname;
	}
	
	public Payment() {
		
	}
	
	
	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
