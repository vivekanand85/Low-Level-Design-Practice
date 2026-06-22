package solidprinciple;


 interface Notificationyes {
    void send(String message);
}

 class PushNotificationyes implements Notificationyes {
    public void send(String message) {
        System.out.println("PUSH: " + message);
    }
}
 class EmailNotificationyes implements Notificationyes {
    public void send(String message) {
        System.out.println("EMAIL: " + message);
    }
}

 class SMSNotificationyes implements Notificationyes {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
 abstract class NotificationServiceyes {
	abstract Notificationyes created();
	public void sendNotification(String msg) {
		Notificationyes notification=created();
		notification.send(msg);
	}
}
class PushNotificationserviceyes extends NotificationServiceyes{
	@Override
	Notificationyes created() {
		return new PushNotificationyes();
	}
	
}
 class SMSNotificationServiceyes extends NotificationServiceyes {
    @Override
    public Notificationyes created() {
        return new SMSNotificationyes();
    }
}
public class NotificationAbs {
	public static void main(String[] args) {
		NotificationServiceyes ns=new PushNotificationserviceyes();
		ns.sendNotification("sending");
		System.out.println(ns.created());
	}
}
