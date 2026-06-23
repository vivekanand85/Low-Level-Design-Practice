package solidprinciple;

class Burger{
	
}
interface MenuVisitor {
 void visit(Pizza pizza);
 void visit(Burger burger);
}

//Items accept a visitor
 interface MenuItem {
 void accept(MenuVisitor visitor);
}

 class Pizza implements MenuItem {
 public void accept(MenuVisitor visitor) {
     visitor.visit(this); // double dispatch!
 }
}

//New operation = new Visitor, ZERO changes to Pizza/Burger!
 class TaxCalculatorVisitor implements MenuVisitor {
 public void visit(Pizza pizza) {
     System.out.println("Calculating tax for pizza");
 }
 public void visit(Burger burger) {
     System.out.println("Calculating tax for burger");
 }
}
public class VisitorPattern {

	public static void main(String[] args) {
		
	}
}
