package solidprinciple;

interface PaymentService{
	void makepayement(String msg);
}
class UPI implements PaymentService{

	@Override
	public void makepayement(String msg) {
		System.out.println("make payment thorough upi");
	}
	
}
class NetBanking implements PaymentService{

	@Override
	public void makepayement(String msg) {
		System.out.println("make payment thorough netbanking");
	}
	
}
class Checks implements PaymentService{

	@Override
	public void makepayement(String msg) {
		System.out.println("make payment thorough checkinh");
	}
	
}
public class PaymentProcessor1{
	PaymentService service;
	public PaymentProcessor1(PaymentService service) {
		this.service=service;
	}
	public void makeCall(String msg) {
		service.makepayement(msg);
	}
	public static void main(String[] args) {
		PaymentProcessor1 ps=new PaymentProcessor1(new UPI());
		ps.makeCall("make call thogu upi");
		
		PaymentProcessor1 ps1=new PaymentProcessor1(new Checks());
		ps1.makeCall("make call thogu Checks");
	}
}
