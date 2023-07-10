package bean;

public class Assigned {
	private int empId;
	private int projectId;
	private int paymentId;
	private Double annual;
	private Double commission;
	
	public Assigned(int empId, int projectId, int paymentId, Double annual, Double commission) {
		super();
		this.empId = empId;
		this.projectId = projectId;
		this.paymentId = paymentId;
		this.annual = annual;
		this.commission = commission;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Double getAnnual() {
		return annual;
	}
	public void setAnnual(Double annual) {
		this.annual = annual;
	}
	public Double getCommission() {
		return commission;
	}
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	
	

}
