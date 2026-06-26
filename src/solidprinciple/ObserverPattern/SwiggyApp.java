package solidprinciple.ObserverPattern;


public class SwiggyApp {

	public static void main(String[] args) {
		
        OrderService orderService = new OrderService();

        PushNotificationService push = new PushNotificationService();
        SMSService sms = new SMSService();
        AnalyticsService analytics = new AnalyticsService();

        // Subscribe observers
        orderService.subscribe(push);
        orderService.subscribe(sms);
        orderService.subscribe(analytics);

        orderService.updateStatus("OUT_FOR_DELIVERY");
        
        DriverAppService driver=new DriverAppService();
        orderService.subscribe(driver);
        
        orderService.updateStatus("Deliveried");
        orderService.updateStatus("FEEDBACK_REQUESTED");

	
	}
}
