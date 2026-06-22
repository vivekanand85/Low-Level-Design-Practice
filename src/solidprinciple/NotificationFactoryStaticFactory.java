package solidprinciple;

//only for example

public class NotificationFactoryStaticFactory {
    public static Notification create(String type) {
        switch (type) {
            case "PUSH": return new PushNotification();
            case "SMS": return new SMSNotification();
            case "EMAIL": return new EmailNotification();
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
    
    public static void main(String[] args) {
    	Notification n = NotificationFactoryStaticFactory.create("SMS");
    	n.send("Order confirmed!");
	}
}
//
//// Usage
//Notification n = NotificationFactoryStaticFactory.create("SMS");
//n.send("Order confirmed!");