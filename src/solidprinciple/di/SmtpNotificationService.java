package solidprinciple.di;

public class SmtpNotificationService implements NotificationService {

	public void send(String message) {
		System.out.println("smtp send : "+ message);
	}
}
