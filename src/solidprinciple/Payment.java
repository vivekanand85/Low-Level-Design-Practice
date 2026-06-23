package solidprinciple;

public class Payment {
	int amount;
	boolean isSuspicious;
	public Payment(int amount,boolean isSus) {
		this.amount=amount;
		this.isSuspicious=isSus;
	}
	public int getAmount() {
	   return amount;
	}
	public void setAmount(int amount) {
		this.amount=amount;
	}
	public boolean isSuspicious() {
		return isSuspicious;
	}

}
