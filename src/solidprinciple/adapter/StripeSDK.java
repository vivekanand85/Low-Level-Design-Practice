package solidprinciple.adapter;

//Stripe SDK — external, untouchable
public class StripeSDK {
 public void makePayment(String currency, double amount) {
     System.out.println("Stripe: " + currency + " " + amount);
 }
}
