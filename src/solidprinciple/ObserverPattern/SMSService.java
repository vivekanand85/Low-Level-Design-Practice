package solidprinciple.ObserverPattern;

public class SMSService implements OrderObserver {
	@Override
	public void onStatusChange(String status) {
        System.out.println("SMS: Order is " + status);

	}

}
