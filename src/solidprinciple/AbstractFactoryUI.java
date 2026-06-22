package solidprinciple;

 interface Button{
	 void render();
 }
 interface Checkbox{
	 void render();
 }
 
 class AndroidButton implements Button {
	    public void render() { System.out.println("Rendering Android Button"); }
}
class AndroidCheckBox implements Checkbox{
	public void render() { System.out.println("Rendering Android Checkbox");}
}
class IOSButton implements Button {
    public void render() { System.out.println("Rendering IOS Button"); }
}
class IOSCheckBox implements Checkbox{
public void render() { System.out.println("Rendering IOS Checkbox");}
}
interface UIFactory{
	Button createButton();
	Checkbox createCheckbox();
}
class AndroidFactory implements UIFactory {
	@Override
	public Button createButton() {
		return new AndroidButton();
	}
	@Override
	public Checkbox createCheckbox() {
		return new AndroidCheckBox();
	}

}
class IOSFactory implements UIFactory {
	@Override
	public Button createButton() {
		return new IOSButton();
	}
	@Override
	public Checkbox createCheckbox() {
		return new IOSCheckBox();
	}

}

public class AbstractFactoryUI {
    private final Button button;
    private final Checkbox checkbox;
    public AbstractFactoryUI(UIFactory factory) {
    	this.button=factory.createButton();
    	this.checkbox=factory.createCheckbox();
    }
    public void render() {
    	button.render();
    	checkbox.render();
    }
	public static void main(String[] args) {
		AbstractFactoryUI af=new AbstractFactoryUI(new AndroidFactory());
		af.render();
	}
}
