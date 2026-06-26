package solidprinciple.di;

public class OrderService {

	private final NotificationService notificationService;
	private final OrderRepository orderRepository;
	public OrderService(OrderRepository orderRepository,NotificationService notificationService) {
		this.orderRepository=orderRepository;
		this.notificationService=notificationService;
	}
	
	public void placeOrder(Order order) {
		orderRepository.save(order);
		notificationService.send("order confirmed");
	}
}
