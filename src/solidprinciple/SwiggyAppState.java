package solidprinciple;

 interface OrderState {
    void next(Orders order);   // move forward
    void cancel(Orders order); // try to cancel
    String getStatus();
}
 class PlacedOrder implements OrderState{
	 public void next(Orders order) {
		 System.out.println("Order out for delivery!");
		 order.setState(new ConfirmedState());
	 }
	 public void cancel (Orders orders) {
		 System.out.println("Order cancelled from CONFIRMED");
	        orders.setState(new CancelledState());
	 }
	 public String getStatus() {
		 return "PLACED"; 
	 }
 }
 class ConfirmedState implements OrderState{
	 public void next(Orders order) {
		 System.out.println("Order out for delivery!");
		 order.setState(new OutForDeliveryState());
	 }
	 public void cancel(Orders order) {
		 System.out.println("Order cancelled from CONFIRMED");
	        order.setState(new CancelledState());
	 }
	 public String getStatus() {
		 return "CONFIRMED"; 
	 }
 }
 class OutForDeliveryState  implements OrderState{

	@Override
	public void next(Orders order) {
		 System.out.println("Order delivered!");
	     order.setState(new DeliveredState());
	}

	@Override
	public void cancel(Orders order) {
        throw new RuntimeException("Cannot cancel — already out for delivery!");

	}

	@Override
	public String getStatus() {
		return "OUT_FOR_DELIVERY";
	}
	 
 }
 class DeliveredState implements OrderState{

	@Override
	public void next(Orders orders) {
		throw new RuntimeException("Order already delivered — no next step!");
	}
	@Override
	 public void cancel(Orders orders) {
	        throw new RuntimeException("Cannot cancel — already delivered!");
	    }
	@Override
	 public String getStatus() { return "DELIVERED"; }

	 
 }
 class CancelledState  implements OrderState{

	@Override
	public void next(Orders order) {	
		throw new RuntimeException("Cancelled order cannot proceed!");
	}

	@Override
	public void cancel(Orders order) {
		 throw new RuntimeException("Already cancelled!");
	}

	@Override
	public String getStatus() {
		return "CANCELLED";
	}
	 
 }
class Orders {
	private OrderState state =new PlacedOrder();
	public void setState(OrderState state ) {
		this.state =state ;
	}
	public void next() {
		state.next(this);
	}
	public void cancel() {
		state.cancel(this);
	}
	public String getCurrentStatus() {
		return state.getStatus();
	}
}
public class SwiggyAppState {

	public static void main(String[] args) {
		Orders order=new Orders();
		System.out.println(order.getCurrentStatus());
		 order.cancel();
		System.out.println(order.getCurrentStatus());

		 
	}
}

 class RefundedState implements OrderState {
    public void next(Orders order) {
        throw new RuntimeException("Refunded order — terminal state!");
    }
    public void cancel(Orders order) {
        throw new RuntimeException("Already refunded!");
    }
    public String getStatus() { return "REFUNDED"; }
}
