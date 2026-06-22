package solidprinciple;

interface OrderRepo{
	public void save(int id);
}
interface Notificationone{
	public void send(String msg);
}
class SendGrid implements Notificationone{
	@Override
	public void send(String msg) {
	}
}
class SMTP implements Notificationone{
	@Override
	public void send(String msg) {
		
	}
	
}
class MySQLOrderRepositoryone implements OrderRepo{
	@Override
	public void save(int id) {
		System.out.println(id+" mysql");
	}
}
class MongoDbRepo implements OrderRepo{
	@Override
	public void save(int id) {
		System.out.println(id + " mongodb");
	}
	
}

public class OrderServicene {
private final OrderRepo repo;
private final Notificationone notificationone;
public OrderServicene(OrderRepo repo,Notificationone notificationone) {
	this.repo=repo;
	this.notificationone=notificationone;
}
public void placeOrder(int id,String msg) {
	repo.save(id);
	notificationone.send(msg);
}
public static void main(String[] args) {
	OrderServicene os=new OrderServicene(new MySQLOrderRepositoryone(), new SMTP());
	os.placeOrder(20,"sql");
}
}
