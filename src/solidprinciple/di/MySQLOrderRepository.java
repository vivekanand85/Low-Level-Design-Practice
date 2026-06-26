package solidprinciple.di;

public class MySQLOrderRepository implements OrderRepository {

	public void save(Order order) {
        System.out.println("Saving to MYSQL: " + order.getId());
    }

}
