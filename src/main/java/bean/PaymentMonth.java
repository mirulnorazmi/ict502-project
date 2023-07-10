package bean;

public class PaymentMonth {
	private int month;
	private int count;
	
	public PaymentMonth(int month, int count) {
		super();
		this.month = month;
		this.count = count;
	}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
