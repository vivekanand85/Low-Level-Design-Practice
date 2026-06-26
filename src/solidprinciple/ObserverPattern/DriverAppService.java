package solidprinciple.ObserverPattern;

public class DriverAppService implements OrderObserver {
	@Override
	public void onStatusChange(String status) {
        System.out.println("Driver App: Order is " + status);
	}
}
