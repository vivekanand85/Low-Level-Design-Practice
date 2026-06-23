package solidprinciple;

import java.time.LocalDateTime;
import java.util.*;

interface Command {
    void execute();
    void undo();
}
class PaymentServices {
    public void processPayment(String paymentId) {
        System.out.println("Processing payment: " + paymentId);
    }

    public void cancelPayment(String paymentId) {
        System.out.println("Cancelling payment: " + paymentId);
    }
}
class RetryPaymentCommand implements Command {
	private PaymentServices paymentServices;
	private String paymentId;
	private LocalDateTime timeStamp;
	public RetryPaymentCommand(PaymentServices paymentServices,String paymentId) {
		this.paymentServices=paymentServices;
		this.paymentId=paymentId;
		this.timeStamp=LocalDateTime.now();
	}
	@Override
	public void execute() {
        System.out.println("[" + timeStamp + "] Executing retry for: " + paymentId);
        paymentServices.processPayment(paymentId);
	}
	@Override
	public void undo() {
        System.out.println("Undoing retry for: " + paymentId);
        paymentServices.cancelPayment(paymentId);
	}	
}
class PaymentRetryQueue {
	private Queue<Command>  retryQueue=new LinkedList<>(); 
	private Stack<Command> executeHistory=new Stack<>(); // this one for undo
	
	public void scheduleRetry(Command command) {
	      retryQueue.add(command);
	        System.out.println("Retry scheduled in queue");
	}
	public void processsQueue() {
		while(!retryQueue.isEmpty()) {
			Command command=retryQueue.poll();
			command.execute();
			executeHistory.push(command);
		}
	}
	
	public void undoLast() {
		if(!executeHistory.isEmpty()) {
			Command lastCommand=executeHistory.pop();
			lastCommand.undo();
		}
	}
}
public class RazorpayAppCommand {
	public static void main(String[] args) {
		PaymentServices paymentService=new PaymentServices();
		PaymentRetryQueue retryQueue=new PaymentRetryQueue();
		Command retr1=new RetryPaymentCommand(paymentService, "pay123");
		Command retr2=new RetryPaymentCommand(paymentService, "pay456");
		retryQueue.scheduleRetry(retr1);
		retryQueue.scheduleRetry(retr2);
        System.out.println("--- Processing queue now ---");
        retryQueue.processsQueue();

        System.out.println("--- Undo last retry ---");
        retryQueue.undoLast();
	}
}
