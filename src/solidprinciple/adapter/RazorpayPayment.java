package solidprinciple.adapter;



//Existing working implementation
public class RazorpayPayment implements PaymentProcessor {
 public void processPayment(double amount) {
     System.out.println("Processing ₹" + amount + " via Razorpay");
 }
}