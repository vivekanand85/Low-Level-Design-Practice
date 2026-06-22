package solidprinciple;


interface OrderRepository{
	void save(Order order);
}
interface NotificationService{
	void send(String msg);
}
class MongoOrderRepository implements OrderRepository{

	@Override
	public void save(Order order) {
		
		
	}
	
}
class MySQLOrderRepository implements OrderRepository{

	@Override
	public void save(Order order) {
		
		
	}
	
}
class SmtpNotificationService implements NotificationService {

	@Override
	public void send(String msg) {
		
		
	}
	
}
class SendGridNotificationService implements NotificationService{

	@Override
	public void send(String msg) {
		
	}
	
}
class OrderService{
	private final OrderRepository orderReporesitory;
	private final NotificationService notificationService;
	
	 OrderService(OrderRepository orderReporesitory, NotificationService notificationService) {
		this.orderReporesitory=orderReporesitory;
		this.notificationService=notificationService;
	}
	 
	 void save(Order order) {
		 orderReporesitory.save(order);
		 notificationService.send("order conformed");
	 }
}

public class DI {
	public static void main(String[] args) {
		// Production — MySQL + SMTP
		OrderService prod = new OrderService(
		    new MySQLOrderRepository(),
		    new SmtpNotificationService()
		);

		// Tomorrow — MongoDB + SendGrid, zero change to OrderService
		OrderService v2 = new OrderService(
		    new MongoOrderRepository(),
		    new SendGridNotificationService()
		);
	}

}
