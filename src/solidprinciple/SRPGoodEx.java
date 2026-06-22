package solidprinciple;

public class SRPGoodEx {
	
	
	
	private static class Invoice{
	private Order order;
	public double calcTotal() {
		return order.getPrice() * order.getQuantity();
	}
  }
	
	private static class InvoicePrinter{
		public void inprint() {
			System.out.println("invoice printer");
		}
	}
	
	private static class invoiceRepo{
		public void save() {
			System.out.println("invoice repo");
		}
	}
	
	private static class Invoicemaik {
		public void send() {
			System.out.println("sending mail");
		}
	}
	
}
