package solidprinciple.ObserverPattern;

public class UpdateStatusBadExample {
	public void update(String status) {
		pushnotification.notify(status);
		smsservice.send(status);
		analyticservice.log(status);
		resutrantsevice.update(status);
		
		// Tommarow driver app notify.closed for modification voilates so i,e OCP
	}
}
