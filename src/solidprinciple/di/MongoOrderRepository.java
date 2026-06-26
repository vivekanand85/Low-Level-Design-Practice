package solidprinciple.di;

public class MongoOrderRepository implements OrderRepository{

	public void save(Order order) {
        System.out.println("Saving to MongoDB: " + order.getId());
    }

}
