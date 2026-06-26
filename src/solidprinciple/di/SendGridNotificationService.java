package solidprinciple.di;

public class SendGridNotificationService implements NotificationService {
    public void send(String message) {
        System.out.println("SendGrid: " + message);
    }
}
