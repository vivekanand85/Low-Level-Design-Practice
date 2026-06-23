package solidprinciple;

import java.util.Stack;

class AddressMemento {
    private final String address; // immutable snapshot

    public AddressMemento(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
 class AddressForm {
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public AddressMemento save() {
        return new AddressMemento(address); // snapshot taken
    }

    public void restore(AddressMemento memento) {
        this.address = memento.getAddress(); // rollback!
    }
}
public class MementoAddressHistory {
	   private Stack<AddressMemento> history = new Stack<>();

	    public void save(AddressMemento m) { history.push(m); }
	    public AddressMemento undo() { return history.pop(); }
}
