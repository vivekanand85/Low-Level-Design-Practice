package solidprinciple.adapter;

public class RazorpayApp {
	 public void checkout(PaymentProcessor processor, double amount) {
	        processor.processPayment(amount);
	    }
	 
	 public static void main(String[] args) {
	        RazorpayApp app = new RazorpayApp();
	        PaymentProcessor razorpay = new RazorpayPayment();
	        app.checkout(razorpay, 1234);
	        
	        PaymentProcessor stripe =new StripeAdapter(new StripeSDK());
	        app.checkout(stripe,10000);

	}
}
