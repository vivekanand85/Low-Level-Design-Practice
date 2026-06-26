package solidprinciple.ObserverPattern;

public interface OrderSubject {

	void subscribe(OrderObserver observer);
	void unSubscribe(OrderObserver observer);
	void notifyObservers(String status);
}
