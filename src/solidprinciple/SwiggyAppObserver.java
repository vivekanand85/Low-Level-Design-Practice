package solidprinciple;

import java.util.*;

interface OrderObserver {
    void onStatusUpdate(String status);
}
interface OrderSubject {
    void subscribe(OrderObserver observer);
    void unsubscribe(OrderObserver observer);
    void notifyObservers(String status);
}
class OrderSevice implements OrderSubject{
	List<OrderObserver> observers=new ArrayList<>();
	@Override
	public void subscribe(OrderObserver observer) {	
		observers.add(observer);
	}
	@Override
	public void unsubscribe(OrderObserver observer) {	
		observers.remove(observer);
	}
	@Override
	public void notifyObservers(String status) {
		for(OrderObserver observer:observers) {
			observer.onStatusUpdate(status);
		}
	}
	public void updateStatus(String status) {
		System.out.println("Order status updated to: " + status);
		notifyObservers(status);
	}
}

 class PushNotificationServices implements OrderObserver {
	 public void onStatusUpdate(String status) {
		 System.out.println("Push: Order is " + status);
	 }
}
 class SMSNotificationServices implements OrderObserver {
	 public void onStatusUpdate(String status) {
		 System.out.println("SMS: Order is " + status);
	 }
}
 class AnalyticsService  implements OrderObserver {
	 public void onStatusUpdate(String status) {
		 System.out.println("Analytics loggin is " + status);
	 }
}
 
 class DriverAppService  implements OrderObserver{
	 public void onStatusUpdate(String status) {
		 System.out.println("Driver App: Order is " + status);
	 }
 }
public class SwiggyAppObserver {
	public static void main(String[] args) {
		OrderSevice orderSevice=new OrderSevice();
		PushNotificationServices services=new PushNotificationServices();
		SMSNotificationServices sms = new SMSNotificationServices();
	    AnalyticsService analytics = new AnalyticsService();
	    orderSevice.subscribe(services);
	    orderSevice.subscribe(sms);
	    orderSevice.subscribe(analytics);
	    orderSevice.updateStatus("OUT_FOR_DELIVERY");
	    
	    System.out.println("over driver service is back");
	    DriverAppService driver=new DriverAppService();
	    orderSevice.subscribe(driver);
	    orderSevice.updateStatus("over driver service is back");
	    
	    
	    System.out.println("customer is irrated by so many notification at time with same message");
	    orderSevice.unsubscribe(analytics);
	    orderSevice.unsubscribe(sms);
	    
	    orderSevice.updateStatus("feedback is receved");
	}
}


//Java Swing/AWT     → ActionListener, MouseListener
//Kafka              → Consumer subscribes to Topic (Producer = Subject)
//Spring Events      → @EventListener, ApplicationEvent
//RxJava             → Observable.subscribe()
