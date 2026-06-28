package solidprinciple.strategy;

public class SwiggyApp {
	public static void main(String[] args) {
		DeliveryFeeCalculatorStr calculatorStr
		=new DeliveryFeeCalculatorStr(new NormalFeeStrategy());
		
		System.out.println(calculatorStr.getFee(40));
		
		calculatorStr.setStrategy(new RainyFeeStrategy());
		System.out.println(calculatorStr.getFee(40));
				
		calculatorStr.setStrategy(new PeakFeeStrategy());
        System.out.println(calculatorStr.getFee(40)); 
	}
}
