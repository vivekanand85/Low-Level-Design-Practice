package solidprinciple;


//Probelm: 
//public boolean validate(Payment payment) {
//    if (payment.getAmount() <= 0) { ... }
//    if (!hasSufficientBalance(payment)) { ... }
//    if (isFraudulent(payment)) { ... }        // ← trusted merchants want to SKIP this
//    if (exceedsDailyLimit(payment)) { ... }
//    return true;
//}

//Fixed order — can't reorder checks per merchant without rewriting the method
//All-or-nothing — can't skip fraud check for trusted merchants without if-else hell
//OCP violation — adding 3 more checks = modifying this method again and again



//Solution
abstract class PaymentValidator{
	PaymentValidator next;
	public void setNext(PaymentValidator paymentValidator) {
		this.next=paymentValidator;
	}
	abstract public boolean validate(Payment payment);
	
	protected boolean validNext(Payment payment) {
		if(next==null) {
			return true;
		}
		return next.validate(payment);
	}
	
}
class AmountValidator extends PaymentValidator{

	@Override
	public boolean validate(Payment payment) {
		if(payment.getAmount()<=0) {
			System.out.println("invalid amount");
			return false;
		}
		System.out.println("Amount check passed and greate than 0");
		return validNext(payment);
	}
	
}
class BalanceValidator extends PaymentValidator{

	@Override
	public boolean validate(Payment payment) {
		if(payment.getAmount()<=10000) {
			System.out.println("insuffient amount");
			return false;
		}
        System.out.println("✅ Balance check passed");
		return validNext(payment);
	}
	
} class FraudValidator extends PaymentValidator {
    public boolean validate(Payment payment) {
        if (payment.isSuspicious()) {
            System.out.println("❌ Fraud detected");
            return false;
        }
        System.out.println("✅ Fraud check passed");
        return validNext(payment);
    }
}
class DailyLimitValidator extends PaymentValidator{

	public boolean validate(Payment payment) {
        System.out.println("✅ Daily limit check passed");
        return validNext(payment);
    }
	
}
public class RazorpayAppCORS {
	public static void main(String[] args) {
		Payment payment=new Payment(15000, false);
		
		 PaymentValidator amounts = new AmountValidator();
	     PaymentValidator balance = new BalanceValidator();
	     PaymentValidator fraud = new FraudValidator();
	     PaymentValidator dailyLimit = new DailyLimitValidator();
	     
	     amounts.setNext(balance);
	     balance.setNext(fraud);
	     fraud.setNext(dailyLimit);
	     
	     boolean result = amounts.validate(payment);
	     System.out.println("Standard merchant result: " + result);

	      System.out.println("---");
	      
	      
	      
	      PaymentValidator amounts2 = new AmountValidator();
		     PaymentValidator balance2 = new BalanceValidator();
		     PaymentValidator dailyLimit2 = new DailyLimitValidator();
		     amounts2.setNext(balance2);
		     balance2.setNext(dailyLimit2);
		        boolean trustedResult = amounts2.validate(payment);
		        System.out.println("Trusted merchant result: " + trustedResult);
	}

}
