package solidprinciple.ObserverPattern;

public class AnalyticsService implements OrderObserver{
	@Override
	public void onStatusChange(String status) {
        System.out.println("Analytics: logging status " + status);

	}

}
