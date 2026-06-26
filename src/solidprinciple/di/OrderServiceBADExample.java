package solidprinciple.di;

class MySQLDatabase{
	public void save(Order order) {
		
	}
}
class SmtpEmailSender{
public void send(String msg) {
		
	}
}
public class OrderServiceBADExample {
    private MySQLDatabase database = new MySQLDatabase(); // direct instantiation
    private SmtpEmailSender emailSender = new SmtpEmailSender(); // direct instantiation

    public void placeOrder(Order order) {
        database.save(order);
        emailSender.send("Order confirmed!");
    }
}
