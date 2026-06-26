package solidprinciple.ObserverPattern;

public class PushNotificationService implements OrderObserver{
	@Override
	public void onStatusChange(String status) {
        System.out.println("Push: Order is " + status);

	}

}
