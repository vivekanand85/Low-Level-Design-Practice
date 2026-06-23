package solidprinciple;

import java.util.*;

interface ChatMediator {
    void sendMessage(String message, User sender);
    void addUser(User user);
}
 abstract class User {
	    protected ChatMediator mediator; // only knows the MEDIATOR, nobody else!
	    protected String name;

	    public User(ChatMediator mediator, String name) {
	        this.mediator = mediator;
	        this.name = name;
	    }
	    public abstract void send(String message);
	    public abstract void receive(String message);
	}
 class SwiggyChatMediator implements ChatMediator{

	private List<User>users=new ArrayList<>();
	@Override
	public void sendMessage(String message, User sender) {
		for(User user:users) {
			if(user!=sender) {
				user.receive(sender.name+" : "+message);
			}
		}
	}
	@Override
	public void addUser(User user) {
		users.add(user);
	}
	 
 }
 
 class Customer extends User {
	    public Customer(ChatMediator mediator, String name) {
	        super(mediator, name);
	    }

	    public void send(String message) {
	        System.out.println(name + " sends: " + message);
	        mediator.sendMessage(message, this); // talks to MEDIATOR only!
	    }

	    public void receive(String message) {
	        System.out.println(name + " received: " + message);
	    }
	}
 
  class DeliveryPartner extends User {
	    public DeliveryPartner(ChatMediator mediator, String name) {
	        super(mediator, name);
	    }

	    public void send(String message) {
	        System.out.println(name + " sends: " + message);
	        mediator.sendMessage(message, this);
	    }

	    public void receive(String message) {
	        System.out.println(name + " received: " + message);
	    }
	}
  class SupportAgent extends User {
	    public SupportAgent(ChatMediator mediator, String name) {
	        super(mediator, name);
	    }

	    public void send(String message) {
	        System.out.println(name + " sends: " + message);
	        mediator.sendMessage(message, this);
	    }

	    public void receive(String message) {
	        System.out.println(name + " received: " + message);
	    }
	}
public class SwiggyAppMediator {
	public static void main(String[] args) {
		    ChatMediator mediator = new SwiggyChatMediator();

	        User customer = new Customer(mediator, "Vivek");
	        User partner = new DeliveryPartner(mediator, "Raju");
	        User agent = new SupportAgent(mediator, "Support-Anita");
	        
	        mediator.addUser(customer);
	        mediator.addUser(partner);
	        mediator.addUser(agent);
	        
	        customer.send("Where is my order?");
	        
	        System.out.println("-----");
	        
	        
	        partner.send("5 mins away");

	}
}
