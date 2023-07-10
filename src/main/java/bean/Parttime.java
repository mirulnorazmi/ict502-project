package bean;

import java.sql.Date;

public class Parttime extends Users {
	private double hourlyrate;
	private Date startdate;
	private Date enddate;
	
	public Parttime(int id, String name, String phone, String email, int age, String gender, int roleId,
			String password, double hourlyrate, Date startdate, Date enddate) {
		super(id, name, phone, email, age, gender, roleId, password);
		this.hourlyrate = hourlyrate;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	
	public Parttime(int id, String name, String phone, String email, int age, String gender, double hourlyrate, Date startdate, Date enddate) {
		super(id, name, phone, email, age, gender);
		this.hourlyrate = hourlyrate;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	
	public Parttime(String name, String phone, String email, int age, String gender, int roleId, Date startdate,
			Date enddate, Double hourlyrate) {
		// TODO Auto-generated constructor stub
		super(name, phone, email, age, gender,roleId);
		this.hourlyrate = hourlyrate;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	
	public Parttime() {

	}
	
	public double getHourlyrate() {
		return hourlyrate;
	}
	public void setHourlyrate(double hourlyrate) {
		this.hourlyrate = hourlyrate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	
}
