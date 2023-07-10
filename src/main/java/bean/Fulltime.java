package bean;

import java.sql.Date;

public class Fulltime extends Users{
	private int annualLeave;
	private int sickLeave;
	private String insurance;
	private int unpaidLeave;
	
	public Fulltime(int id, String name, String phone, String email, int age, String gender, String password,
			int roleId, int annualLeave, int sickLeave, String insurance, int unpaidLeave) {
		super(id, name, phone, email, age, gender, roleId);
		this.annualLeave = annualLeave;
		this.sickLeave = sickLeave;
		this.insurance = insurance;
		this.unpaidLeave = unpaidLeave;
	}
	public Fulltime(String name, String phone, String email, int age, String gender, int roleId , 
			int annualLeave, int sickLeave, String insurance, int unpaidLeave) {
		super(name, phone, email, age, gender, roleId);
		this.annualLeave = annualLeave;
		this.sickLeave = sickLeave;
		this.insurance = insurance;
		this.unpaidLeave = unpaidLeave;
	}
	
	public Fulltime() {
		// TODO Auto-generated constructor stub
	}
	
	public Fulltime(int id,String name, String phone, String email, int age, String gender, int roleId , 
			int annualLeave, int sickLeave, String insurance, int unpaidLeave) {
		// TODO Auto-generated constructor stub
		super(id, name, phone, email, age, gender, roleId);
		this.annualLeave = annualLeave;
		this.sickLeave = sickLeave;
		this.insurance = insurance;
		this.unpaidLeave = unpaidLeave;
	}
	
	public Fulltime(int id, String name, String phone, String email, int age, String gender, int annualLeave,
			int sickLeave, String insurance, int unpaidLeave) {
		// TODO Auto-generated constructor stub
		super(id, name, phone, email, age, gender);
		this.annualLeave = annualLeave;
		this.sickLeave = sickLeave;
		this.insurance = insurance;
		this.unpaidLeave = unpaidLeave;
	}
	
	public int getAnnualLeave() {
		return annualLeave;
	}
	public void setAnnualLeave(int annualLeave) {
		this.annualLeave = annualLeave;
	}
	public int getSickLeave() {
		return sickLeave;
	}
	public void setSickLeave(int sickLeave) {
		this.sickLeave = sickLeave;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public int getUnpaidLeave() {
		return unpaidLeave;
	}
	public void setUnpaidLeave(int unpaidLeave) {
		this.unpaidLeave = unpaidLeave;
	}
	
}
