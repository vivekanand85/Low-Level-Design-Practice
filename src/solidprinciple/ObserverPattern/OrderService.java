package solidprinciple.ObserverPattern;

import java.util.*;

public class OrderService implements OrderSubject {
	List<OrderObserver> observers=new ArrayList<>();
	@Override
	public void subscribe(OrderObserver observer) {
		observers.add(observer);
	}

	@Override
	public void unSubscribe(OrderObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String status) {
		for(OrderObserver ob:observers) {
			ob.onStatusChange(status);
		}
	}
	
	 public void updateStatus(String status) {
		 System.out.println("Order status updated to: " + status);
		 notifyObservers(status); 
	 
	 }
}
