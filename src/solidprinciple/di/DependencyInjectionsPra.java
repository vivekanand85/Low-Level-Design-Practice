package solidprinciple.di;

public class DependencyInjectionsPra {
	public static void main(String[] args) {
		Order order=new Order(124);
		OrderService prod=new OrderService(new MySQLOrderRepository(), new SmtpNotificationService());
		prod.placeOrder(order);
		
		Order order1=new Order(1242);
		OrderService v1=new OrderService(new MongoOrderRepository(), new SendGridNotificationService());
		v1.placeOrder(order1);
	}
}