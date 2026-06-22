package solidprinciple;

// PUSH 
// SMS
// java
// Step 1 — Product interface
 interface Notification {
    void send(String message);
}

// Step 2 — Concrete products
 class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("PUSH: " + message);
    }
}

 class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

 class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("EMAIL: " + message);
    }
}


abstract class NotificationService1{
	 abstract Notification createNotification();
	 
	 public void sendNotification(String messege) {
		 Notification notification=createNotification();
		 notification.send(messege);
	 }
}

 class PushNotificationService extends NotificationService1 {
	@Override
	Notification createNotification() {
		return new PushNotification();
	}
}
class SMSNotificationService extends NotificationService1{
	@Override
	Notification createNotification() {
		return new SMSNotification();
	}
}
class EmailNotificationService extends NotificationService1{
	@Override
	Notification createNotification() {
		return new EmailNotification();
	}
}

public class FactoryClasObj {
	
	public static void main(String[] args) {
		NotificationService1 ns=new EmailNotificationService();
		ns.sendNotification("email sms done");
		
		
	}
}
