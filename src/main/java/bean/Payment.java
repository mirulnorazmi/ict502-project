package bean;

import java.sql.Date;

public class Payment {
	private int id;
	private double amount;
	private Date date;
	
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
	
	public Payment() {
		
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
