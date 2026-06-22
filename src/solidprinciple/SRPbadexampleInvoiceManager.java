package solidprinciple;

public class SRPbadexampleInvoiceManager {

	private Order order;
	public double calcTotal() {
		return order.getPrice() * order.getQuantity();
	}
	public void sendMail() {
		System.out.println("mails");
	}
	public void printInvoice() {
		System.out.println("print invoice");
	}
	public void saveToDb() {
		System.out.println("save to db");
	}
	
}
