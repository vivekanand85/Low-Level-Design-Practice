package solidprinciple.di;

public class Order {
	int id;
	public Order(int id) {
		this.id=id;
	}
	public String getId() {
		return "our id is "+id;
	}

}
