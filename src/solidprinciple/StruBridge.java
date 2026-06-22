package solidprinciple;

//Implementation hierarchy — varies independently
 interface NotificationSender {
 void sendMessage(String message, String userId);
}

 class EmailSender implements NotificationSender {
 public void sendMessage(String message, String userId) {
     System.out.println("EMAIL to " + userId + ": " + message);
 }
}

 class SMSSender implements NotificationSender {
 public void sendMessage(String message, String userId) {
     System.out.println("SMS to " + userId + ": " + message);
 }
}

 class PushSender implements NotificationSender {
 public void sendMessage(String message, String userId) {
     System.out.println("PUSH to " + userId + ": " + message);
 }
}

//Abstraction hierarchy — varies independently
 abstract class NotificationPlatform {
 // BRIDGE — holds reference to implementation
 protected NotificationSender sender;

 public NotificationPlatform(NotificationSender sender) {
     this.sender = sender;
 }

 public abstract void notify(String message, String userId);
}

 class AndroidPlatform extends NotificationPlatform {
   public AndroidPlatform(NotificationSender sender) {
     super(sender);
 }
  public void notify(String message, String userId) {
     System.out.print("Android → ");
     sender.sendMessage(message, userId);
 }
}

 class IOSPlatform extends NotificationPlatform {
 public IOSPlatform(NotificationSender sender) {
     super(sender);
 }

  public void notify(String message, String userId) {
     System.out.print("iOS → ");
     sender.sendMessage(message, userId);
 }
}
public class StruBridge {

	public static void main(String[] args) {
		NotificationPlatform androidEmail = 
	            new AndroidPlatform(new EmailSender());
	        androidEmail.notify("Order placed!", "user123");
	        // Output: Android → EMAIL to user123: Order placed!

	        // iOS + SMS
	        NotificationPlatform iosSMS = 
	            new IOSPlatform(new SMSSender());
	        iosSMS.notify("Driver arriving!", "user456");
	        // Output: iOS → SMS to user456: Driver arriving!

	        // Android + Push — new combo, zero new class!
	        NotificationPlatform androidPush = 
	            new AndroidPlatform(new PushSender());
	        androidPush.notify("Rate your order!", "user789");
	        // Output: Android → PUSH to user789: Rate your order
	}
}
