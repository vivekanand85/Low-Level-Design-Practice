package solidprinciple.adapter;

public class StripeAdapter implements PaymentProcessor {
	StripeSDK sdk;
	public StripeAdapter(StripeSDK sdk) {
		this.sdk=sdk;
	}
	@Override
	public void processPayment(double amount) {
		String currency="USD";
		double convertedAmount = amount / 83.0; // ₹ to $
        sdk.makePayment(currency, convertedAmount);
	}

}
