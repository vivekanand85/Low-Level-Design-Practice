package solidprinciple;

//Your existing interface — used everywhere in codebase
 interface PaymentProcessor {
 void processPayment(double amount);
}

//Your existing implementation
 class RazorpayPayment implements PaymentProcessor {
    public void processPayment(double amount) {
     System.out.println("Processing ₹" + amount + " via Razorpay");
 }
}
//External Stripe SDK — you CANNOT change this code
 class StripeSDK {
 public void makePayment(String currency, double amount) {
     System.out.println("Stripe: " + currency + " " + amount);
 }
}
class StripeAdapter implements PaymentProcessor{
	 StripeSDK sdk;
	public StripeAdapter(StripeSDK sdk) {
		this.sdk=sdk;
	}
	@Override
	public void processPayment(double amount) {
		String currency="USD";
		double convertAmt=amount/83;
		sdk.makePayment(currency, convertAmt);
	}
}
public class AdapatorRazaorPay {
	public void checkout(PaymentProcessor paymentProcessor,double amount) {
		paymentProcessor.processPayment(amount);
	}
	public static void main(String[] args) {
		AdapatorRazaorPay ap =new AdapatorRazaorPay();
		PaymentProcessor ps=new RazorpayPayment();
		ap.checkout(ps,3000);
		PaymentProcessor ps1=new StripeAdapter(new StripeSDK());
		ap.checkout(ps1, 1000000);
	}
}
